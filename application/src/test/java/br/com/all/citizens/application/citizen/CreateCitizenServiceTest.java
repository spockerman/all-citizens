package br.com.all.citizens.application.citizen;

import br.com.all.citizens.application.citizen.command.CreateCitizenCommand;
import br.com.all.citizens.application.citizen.service.CreateCitizenService;
import br.com.all.citizens.application.utils.PersonApplicationService;
import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.domain.citizen.CitizenRepository;
import br.com.all.citizens.domain.citizen.CitizenType;
import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateCitizenServiceTest {

    @Mock
    private CitizenRepository citizenRepository;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonApplicationService personApplicationService;

    @InjectMocks
    private CreateCitizenService createCitizenService;

    @Test
    void givenCommand_whenExecute_thenUsesPersonServiceAndSavesCitizen() {
        LocalDate birth = LocalDate.of(1988, 3, 21);
        var command = new CreateCitizenCommand(
                "Marie Curie",
                "12345678901",
                birth,
                "social-xyz",
                CitizenType.CITIZEN
        );

        Person person = Person.with(
                88,
                "Marie Curie",
                "12345678901",
                birth,
                Instant.now(),
                Instant.now(),
                null
        );

        when(personApplicationService.findOrCreatePerson(
                eq("Marie Curie"),
                eq("12345678901"),
                eq(birth)
        )).thenReturn(person);

        when(citizenRepository.save(any(Citizen.class))).thenAnswer(inv -> {
            Citizen c = inv.getArgument(0);
            return Citizen.with(
                    c.getPersonId(),
                    c.getPerson(),
                    c.getSocialId(),
                    c.getType(),
                    c.getCreatedAt()
            );
        });

        Integer personId = createCitizenService.execute(command);

        assertEquals(88, personId);
        verify(personApplicationService).findOrCreatePerson("Marie Curie", "12345678901", birth);
        verify(citizenRepository).save(any(Citizen.class));
    }
}
