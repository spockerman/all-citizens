package br.com.all.citizens.domain;

import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.domain.citizen.CitizenType;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class CitizenTest {

    @Test
    public void testNewCitizen() {
        String name = "John Doe";
        String cpf = "123.456.789-00";
        String mobile = "+55 11 98765-4321";
        String email = "john.doe@example.com";
        CitizenType type = CitizenType.CITIZEN;


    }

    @Test
    public void testWithCitizen() {
        Integer id = 1;
        String name = "John Doe";
        String cpf = "123.456.789-00";
        String mobile = "+55 11 98765-4321";
        String email = "john.doe@example.com";
        CitizenType type = CitizenType.AUTHORITY;
        Instant createdAt = Instant.now();
        Instant updatedAt = Instant.now();
        Instant deletedAt = null;


    }
}