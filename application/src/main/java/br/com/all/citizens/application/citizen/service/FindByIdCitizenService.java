package br.com.all.citizens.application.citizen.service;

import br.com.all.citizens.application.citizen.usecase.FindByIdCitizenUseCase;
import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.domain.citizen.CitizenRepository;
import br.com.all.citizens.domain.exception.CitizenNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindByIdCitizenService implements FindByIdCitizenUseCase {

    private final CitizenRepository repository;

    public FindByIdCitizenService(CitizenRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Citizen execute(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new CitizenNotFoundException(id));
    }
}