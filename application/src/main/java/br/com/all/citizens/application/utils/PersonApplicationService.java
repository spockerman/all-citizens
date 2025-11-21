package br.com.all.citizens.application.utils;


import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;

@Service
public class PersonApplicationService {

    private final PersonRepository personRepository;

    public PersonApplicationService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findOrCreatePerson(String fullName,
                                     String cpfNumber,
                                     LocalDate birthDate) {

        Instant now = Instant.now();

        return personRepository.findByCpf(cpfNumber)
                .orElseGet(() -> {
                    Person newPerson = Person.newPerson(
                            fullName,
                            cpfNumber,
                            birthDate,
                            now,
                            now,
                            null
                    );
                    return personRepository.save(newPerson);
                });
    }
}
