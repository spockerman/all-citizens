package br.com.all.citizens.domain;

import br.com.all.citizens.domain.person.Person;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void givenValidInput_whenNewPerson_thenIdIsNullAndFieldsAreSet() {
        LocalDate birth = LocalDate.of(1991, 6, 12);
        Instant before = Instant.now();

        Person p = Person.newPerson("Alice", "12345678900", birth, before, before, null);

        assertNull(p.getId());
        assertEquals("Alice", p.getFullName());
        assertEquals("12345678900", p.getCpfNumber());
        assertEquals(birth, p.getBirthDate());
        assertNotNull(p.getCreatedAt());
        assertNotNull(p.getUpdatedAt());
        assertNull(p.getDeletedAt());
    }

    @Test
    public void givenValidInput_whenWith_thenPreservesIdAndInstantFields() {
        LocalDate birth = LocalDate.of(1985, 2, 28);
        Instant created = Instant.parse("2023-06-01T12:00:00Z");
        Instant updated = Instant.parse("2023-06-02T12:00:00Z");
        Instant deleted = Instant.parse("2023-06-03T12:00:00Z");

        Person p = Person.with(42, "Bob", "99887766554", birth, created, updated, deleted);

        assertEquals(42, p.getId());
        assertEquals("Bob", p.getFullName());
        assertEquals("99887766554", p.getCpfNumber());
        assertEquals(birth, p.getBirthDate());
        assertEquals(created, p.getCreatedAt());
        assertEquals(updated, p.getUpdatedAt());
        assertEquals(deleted, p.getDeletedAt());
    }
}
