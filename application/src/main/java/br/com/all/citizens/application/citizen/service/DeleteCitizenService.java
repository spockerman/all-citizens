package br.com.all.citizens.application.citizen.service;

import br.com.all.citizens.application.citizen.usecase.DeleteCitizenUseCase;
import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.domain.citizen.CitizenRepository;
import br.com.all.citizens.domain.exception.CitizenNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteCitizenService implements DeleteCitizenUseCase {

    private final CitizenRepository repository;

    public DeleteCitizenService(CitizenRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void execute(Integer id) {
        Citizen existingCitizen = repository.findById(id)
                .orElseThrow(() -> new CitizenNotFoundException(id));

        repository.deleteById(id);
    }
}