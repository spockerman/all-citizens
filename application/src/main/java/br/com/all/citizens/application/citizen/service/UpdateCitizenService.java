package br.com.all.citizens.application.citizen.service;

import br.com.all.citizens.application.citizen.command.UpdateCitizenCommand;
import br.com.all.citizens.application.citizen.usecase.UpdateCitizenUseCase;
import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.domain.citizen.CitizenRepository;
import br.com.all.citizens.domain.exception.CitizenNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class UpdateCitizenService implements UpdateCitizenUseCase {

    private final CitizenRepository repository;

    public UpdateCitizenService(CitizenRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void execute(UpdateCitizenCommand command) {
        Citizen existingCitizen = repository.findById(command.id())
                .orElseThrow(() -> new CitizenNotFoundException(command.id()));

        Citizen updatedCitizen = Citizen.with(
                existingCitizen.getId(),
                command.name(),
                command.cpf(),
                command.mobile(),
                command.email(),
                command.type(),
                existingCitizen.getCreatedAt(),
                Instant.now(),
                existingCitizen.getDeletedAt()
        );

        repository.save(updatedCitizen);
    }
}