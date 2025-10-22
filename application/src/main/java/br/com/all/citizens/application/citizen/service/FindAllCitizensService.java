package br.com.all.citizens.application.citizen.service;

import br.com.all.citizens.application.citizen.usecase.FindAllCitizensUseCase;
import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.domain.citizen.CitizenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FindAllCitizensService implements FindAllCitizensUseCase {

    private final CitizenRepository repository;

    public FindAllCitizensService(CitizenRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Citizen> execute() {
        return repository.findAll();
    }
}