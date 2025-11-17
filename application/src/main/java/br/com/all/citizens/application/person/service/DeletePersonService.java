package br.com.all.citizens.application.person.service;

import br.com.all.citizens.application.person.usecase.DeletePersonUseCase;
import br.com.all.citizens.domain.exception.PersonNotFoundException;
import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeletePersonService implements DeletePersonUseCase {

    private final PersonRepository repository;

    public DeletePersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void execute(Integer id) {
        Person existingPerson = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        repository.deleteById(existingPerson.getId());

    }
}
