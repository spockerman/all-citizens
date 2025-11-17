package br.com.all.citizens.application.person.service;

import br.com.all.citizens.application.person.usecase.FindByIdPersonUseCase;
import br.com.all.citizens.domain.exception.PersonNotFoundException;
import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindByIdPersonService implements FindByIdPersonUseCase {

    private final PersonRepository repository;

    public FindByIdPersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Person execute(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
