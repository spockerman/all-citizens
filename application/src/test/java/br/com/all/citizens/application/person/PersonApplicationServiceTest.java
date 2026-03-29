package br.com.all.citizens.application.person;

import br.com.all.citizens.application.person.command.CreatePersonCommand;
import br.com.all.citizens.application.person.service.CreatePersonService;
import br.com.all.citizens.application.person.service.FindByIdPersonService;
import br.com.all.citizens.domain.exception.PersonNotFoundException;
import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonApplicationServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private CreatePersonService createPersonService;

    @InjectMocks
    private FindByIdPersonService findByIdPersonService;

    @Test
    void givenValidCommand_whenCreatePerson_thenReturnsPersistedId() {
        LocalDate birth = LocalDate.of(1990, 1, 15);
        var command = new CreatePersonCommand("Ada Lovelace", "11122233344", birth);

        when(personRepository.save(any(Person.class))).thenAnswer(inv -> {
            Person p = inv.getArgument(0);
            return Person.with(
                    50,
                    p.getFullName(),
                    p.getCpfNumber(),
                    p.getBirthDate(),
                    p.getCreatedAt(),
                    p.getUpdatedAt(),
                    p.getDeletedAt()
            );
        });

        Integer id = createPersonService.execute(command);

        assertEquals(50, id);
        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        verify(personRepository).save(captor.capture());
        Person saved = captor.getValue();
        assertNull(saved.getId());
        assertEquals("Ada Lovelace", saved.getFullName());
        assertEquals("11122233344", saved.getCpfNumber());
        assertEquals(birth, saved.getBirthDate());
    }

    @Test
    void givenExistingId_whenFindById_thenReturnsPerson() {
        var expected = Person.with(
                3,
                "Test User",
                "99988877766",
                LocalDate.of(2000, 5, 5),
                Instant.parse("2024-01-01T10:00:00Z"),
                Instant.parse("2024-01-02T10:00:00Z"),
                null
        );
        when(personRepository.findById(3)).thenReturn(Optional.of(expected));

        Person actual = findByIdPersonService.execute(3);

        assertEquals(expected, actual);
        verify(personRepository).findById(3);
    }

    @Test
    void givenMissingId_whenFindById_thenThrowsPersonNotFoundException() {
        when(personRepository.findById(404)).thenReturn(Optional.empty());

        var ex = assertThrows(PersonNotFoundException.class, () -> findByIdPersonService.execute(404));
        assertTrue(ex.getMessage().contains("404"));
        verify(personRepository).findById(404);
    }
}
