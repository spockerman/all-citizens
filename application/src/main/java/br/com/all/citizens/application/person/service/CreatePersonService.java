package br.com.all.citizens.application.person.service;

import br.com.all.citizens.application.person.command.CreatePersonCommand;
import br.com.all.citizens.application.person.usecase.CreatePersonUseCase;
import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class CreatePersonService implements CreatePersonUseCase {

    private final PersonRepository repository;
    public CreatePersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Integer execute(CreatePersonCommand command) {
        Instant now = Instant.now();

        Person person = Person.newPerson(
                command.fullName(),
                command.cpfNumber(),
                command.birthDate(),
                now, now, null
        );
        Person saved = repository.save(person);

        return saved.getId();
    }
}
