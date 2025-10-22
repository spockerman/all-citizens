package br.com.all.citizens.infrastructure.adapter.inbound.rest;

import br.com.all.citizens.application.citizen.usecase.*;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CitizenResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CreateCitizenRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UpdateCitizenRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper.CitizenMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    private final CreateCitizenUseCase createCitizenUseCase;
    private final FindAllCitizensUseCase findAllCitizensUseCase;
    private final FindByIdCitizenUseCase findByIdCitizenUseCase;
    private final DeleteCitizenUseCase deleteCitizenUseCase;
    private final UpdateCitizenUseCase updateCitizenUseCase;

    public CitizenController(
            CreateCitizenUseCase createCitizenUseCase,
            FindAllCitizensUseCase findAllCitizensUseCase,
            FindByIdCitizenUseCase findByIdCitizenUseCase,
            DeleteCitizenUseCase deleteCitizenUseCase,
            UpdateCitizenUseCase updateCitizenUseCase
    ) {
        this.createCitizenUseCase = createCitizenUseCase;
        this.findAllCitizensUseCase = findAllCitizensUseCase;
        this.findByIdCitizenUseCase = findByIdCitizenUseCase;
        this.deleteCitizenUseCase = deleteCitizenUseCase;
        this.updateCitizenUseCase = updateCitizenUseCase;
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody CreateCitizenRequest request) {
        var command = CitizenMapper.toCommand(request);
        Integer id = createCitizenUseCase.execute(command);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<CitizenResponse>> findAll() {
        var response = findAllCitizensUseCase.execute().stream()
                .map(CitizenMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitizenResponse> findById(@PathVariable("id") Integer id) {
        var citizen = findByIdCitizenUseCase.execute(id);
        return ResponseEntity.ok(CitizenMapper.toResponse(citizen));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        deleteCitizenUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody UpdateCitizenRequest request) {
        var command = CitizenMapper.toCommand(id, request);
        updateCitizenUseCase.execute(command);
        return ResponseEntity.noContent().build();
    }
}