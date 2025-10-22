package br.com.all.citizens.application.citizen.service;

import br.com.all.citizens.application.citizen.command.CreateCitizenCommand;
import br.com.all.citizens.application.citizen.usecase.CreateCitizenUseCase;
import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.domain.citizen.CitizenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateCitizenService implements CreateCitizenUseCase {

    private final CitizenRepository repository;

    public CreateCitizenService(CitizenRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Integer execute(CreateCitizenCommand command) {
        Citizen citizen = Citizen.newCitizen(
                command.name(),
                command.cpf(),
                command.mobile(),
                command.email(),
                command.type()
        );
        Citizen saved = repository.save(citizen);
        return saved.getId();
    }
}