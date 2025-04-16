package br.com.all.citizens.infrastructure.adapter.inbound.rest;

import br.com.all.citizens.application.department.command.CreateDepartmentCommand;
import br.com.all.citizens.application.department.command.DepartmentTreeCommand;
import br.com.all.citizens.application.department.command.UpdateDepartmentCommand;
import br.com.all.citizens.application.department.usecase.*;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CreateDepartmentRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.DepartmentResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.DepartmentTreeResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UpdateDepartmentRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper.DepartmentMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final CreateDepartmentUseCase createDepartmentUseCase;
    private final FindAllDepartmentsUseCase findAllDepartmentsUseCase;
    private final FindByIdDepartmentUseCase findByIdDepartmentUseCase;
    private final DeleteDepartmentUseCase deleteDepartmentUseCase;
    private final UpdateDepartmentUseCase updateDepartmentUseCase;
    private final FindDepartmentSubTreeUseCase findDepartmentSubTreeUseCase;

    public DepartmentController(
            CreateDepartmentUseCase createDepartmentUseCase,
            FindAllDepartmentsUseCase findAllDepartmentsUseCase,
            FindByIdDepartmentUseCase findByIdDepartmentUseCase,
            DeleteDepartmentUseCase deleteDepartmentUseCase,
            UpdateDepartmentUseCase updateDepartmentUseCase,
            FindDepartmentSubTreeUseCase findDepartmentSubTreeUseCase
    ) {
        this.createDepartmentUseCase = createDepartmentUseCase;
        this.findAllDepartmentsUseCase = findAllDepartmentsUseCase;
        this.findByIdDepartmentUseCase = findByIdDepartmentUseCase;
        this.deleteDepartmentUseCase = deleteDepartmentUseCase;
        this.updateDepartmentUseCase = updateDepartmentUseCase;
        this.findDepartmentSubTreeUseCase = findDepartmentSubTreeUseCase;
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody CreateDepartmentRequest request) {
        var command = new CreateDepartmentCommand(
                request.name(),
                request.description(),
                request.email(),
                request.phone(),
                request.active(),
                request.parentDepartmentId()
        );
        Integer id = createDepartmentUseCase.execute(command);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> findAll() {
        var response = findAllDepartmentsUseCase.execute().stream()
                .map(DepartmentMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> findById(@PathVariable("id") Integer id) {
        var department = findByIdDepartmentUseCase.execute(id);
        return ResponseEntity.ok(DepartmentMapper.toResponse(department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        deleteDepartmentUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody UpdateDepartmentRequest request) {
        var command = new UpdateDepartmentCommand(
                id,
                request.name(),
                request.description(),
                request.email(),
                request.phone(),
                request.active(),
                request.parentDepartmentId()
        );
        updateDepartmentUseCase.execute(command);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tree/{id}")
    public ResponseEntity<DepartmentTreeResponse> findSubTree(@PathVariable("id") Integer id) {
        return findDepartmentSubTreeUseCase.execute(id)
                .map(treeCommand -> ResponseEntity.ok(DepartmentMapper.toResponse(treeCommand)))
                .orElse(ResponseEntity.notFound().build());
    }

}
