package br.com.all.citizens.application.citizen.service;

import br.com.all.citizens.application.citizen.command.CreateCitizenCommand;
import br.com.all.citizens.application.citizen.usecase.CreateCitizenUseCase;
import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.domain.citizen.CitizenRepository;
import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class CreateCitizenService implements CreateCitizenUseCase {

    private final CitizenRepository citizenRepository;
    private final PersonRepository personRepository;

    public CreateCitizenService(CitizenRepository citizenRepository, PersonRepository personRepository) {
        this.citizenRepository = citizenRepository;
        this.personRepository = personRepository;
    }

    @Override
    @Transactional
    public Integer execute(CreateCitizenCommand command) {
        Instant now = Instant.now();

        Person person = Person.newPerson(
                command.fullName(), command.cpfNumber(), command.birthDate(), now, now, null);
        Person savedPerson = personRepository.save(person);

        Citizen citizen = Citizen.newCitizen(
                savedPerson,
                command.socialId(),
                command.type()
        );
        Citizen savedCitizen = citizenRepository.save(citizen);

        return savedCitizen.getPersonId();
    }
}