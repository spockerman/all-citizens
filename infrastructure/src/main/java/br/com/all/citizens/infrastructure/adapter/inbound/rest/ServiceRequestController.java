package br.com.all.citizens.infrastructure.adapter.inbound.rest;

import br.com.all.citizens.application.request.usecase.CreateServiceRequestUseCase;
import br.com.all.citizens.application.request.usecase.FindByIdServiceRequestUseCase;
import br.com.all.citizens.application.request.usecase.UpdateServiceRequestUseCase;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CreateServiceRequestRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.ServiceRequestResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UpdateServiceRequestRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper.ServiceRequestRestMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-request")
public class ServiceRequestController {

    private final CreateServiceRequestUseCase createServiceRequestUseCase;
    private final UpdateServiceRequestUseCase updateServiceRequestUseCase;
    private final FindByIdServiceRequestUseCase findByIdServiceRequestUseCase;

    public ServiceRequestController(
            CreateServiceRequestUseCase createServiceRequestUseCase,
            UpdateServiceRequestUseCase updateServiceRequestUseCase,
            FindByIdServiceRequestUseCase findByIdServiceRequestUseCase
    ) {
        this.createServiceRequestUseCase = createServiceRequestUseCase;
        this.updateServiceRequestUseCase = updateServiceRequestUseCase;
        this.findByIdServiceRequestUseCase = findByIdServiceRequestUseCase;
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody CreateServiceRequestRequest request) {
        var command = ServiceRequestRestMapper.toCreateCommand(request);
        Integer id = createServiceRequestUseCase.execute(command);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequestResponse> findById(@PathVariable("id") Integer id) {
        var domain = findByIdServiceRequestUseCase.execute(id);
        return ResponseEntity.ok(ServiceRequestRestMapper.toResponse(domain));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable("id") Integer id,
            @RequestBody UpdateServiceRequestRequest request
    ) {
        var command = ServiceRequestRestMapper.toUpdateCommand(id, request);
        updateServiceRequestUseCase.execute(command);
        return ResponseEntity.noContent().build();
    }
}
