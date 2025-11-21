package br.com.all.citizens.infrastructure.adapter.inbound.rest;

import br.com.all.citizens.application.employee.usecase.CreateEmployeeUseCase;
import br.com.all.citizens.application.employee.usecase.FindByDepartmentUseCase;
import br.com.all.citizens.application.employee.usecase.FindByDocumentUseCase;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CreateEmployeeRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.EmployeeResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper.EmployeeMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final FindByDepartmentUseCase findByDepartmentUseCase;
    private final FindByDocumentUseCase findByDocumentUseCase;


    public EmployeeController(
            CreateEmployeeUseCase createEmployeeUseCase,
            FindByDepartmentUseCase findByDepartmentUseCase,
            FindByDocumentUseCase findByDocumentUseCase
    ) {
        this.createEmployeeUseCase = createEmployeeUseCase;
        this.findByDepartmentUseCase = findByDepartmentUseCase;
        this.findByDocumentUseCase = findByDocumentUseCase;
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody CreateEmployeeRequest request) {
        var command = EmployeeMapper.toCommand(request);
        Integer id = createEmployeeUseCase.execute(command);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/department")
    public ResponseEntity<EmployeeResponse> findByDepartment(@RequestParam("dept") String department) {
        var employee = findByDepartmentUseCase.execute(department);
        return ResponseEntity.ok(EmployeeMapper.toResponse(employee));
    }

    @GetMapping("/document")
    public ResponseEntity<EmployeeResponse> findByDocument(@RequestParam("document") String document) {
        var employee = findByDocumentUseCase.execute(document);
        return ResponseEntity.ok(EmployeeMapper.toResponse(employee));
    }

    @GetMapping("/ping")
    public String ping() {
        System.out.println(">>> CHEGOU NO /employee/ping");
        return "ok";
    }
}
