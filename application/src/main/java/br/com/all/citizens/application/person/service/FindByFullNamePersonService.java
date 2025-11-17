package br.com.all.citizens.application.person.service;

import br.com.all.citizens.application.person.usecase.FindByFullNamePersonUseCase;
import br.com.all.citizens.domain.exception.PersonFullNameNotFoundException;
import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindByFullNamePersonService implements FindByFullNamePersonUseCase {
    private final PersonRepository repository;

    public FindByFullNamePersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Person execute(String fullName) {
        return repository.findByFullName(fullName)
                .orElseThrow(() -> new PersonFullNameNotFoundException(fullName));
    }
}
