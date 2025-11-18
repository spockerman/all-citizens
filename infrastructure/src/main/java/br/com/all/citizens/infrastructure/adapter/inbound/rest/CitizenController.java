package br.com.all.citizens.infrastructure.adapter.inbound.rest;

import br.com.all.citizens.application.citizen.service.FindBySocialIdService;
import br.com.all.citizens.application.citizen.usecase.CreateCitizenUseCase;
import br.com.all.citizens.application.citizen.usecase.FindByIdCitizenUseCase;
import br.com.all.citizens.application.citizen.usecase.FindBySocialIdUseCase;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CitizenResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CreateCitizenRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper.CitizenMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    private final CreateCitizenUseCase createCitizenUseCase;
    private final FindByIdCitizenUseCase findByIdCitizenUseCase;
    private final FindBySocialIdUseCase findBySocialIdUseCase;

    public CitizenController(
            CreateCitizenUseCase createCitizenUseCase,
            FindByIdCitizenUseCase findByIdCitizenUseCase,
            FindBySocialIdUseCase findBySocialIdUseCase
    ) {
        this.createCitizenUseCase = createCitizenUseCase;
        this.findByIdCitizenUseCase = findByIdCitizenUseCase;
        this.findBySocialIdUseCase = findBySocialIdUseCase;
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody CreateCitizenRequest request) {
        var command = CitizenMapper.toCommand(request);
        Integer id = createCitizenUseCase.execute(command);
        return ResponseEntity.ok(id);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CitizenResponse> findById(@PathVariable("id") Integer id) {
        var citizen = findByIdCitizenUseCase.execute(id);
        return ResponseEntity.ok(CitizenMapper.toResponse(citizen));
    }

    @GetMapping("/{socialId}")
    public ResponseEntity<CitizenResponse> findBySocialId(@PathVariable("socialId") String id) {
        var citizen = findBySocialIdUseCase.execute(id);
        return ResponseEntity.ok(CitizenMapper.toResponse(citizen));
    }


}