package br.com.all.citizens.domain.person;

import java.time.Instant;
import java.time.LocalDate;

public class Person {

    private final Integer id;
    private final String fullName;
    private final String cpfNumber;
    private final LocalDate birthDate;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant deletedAt;

    private Person(Integer id,
                   String fullName,
                   String cpfNumber,
                   LocalDate birthDate,
                   Instant createdAt,
                   Instant updatedAt,
                   Instant deletedAt) {
        this.id = id;
        this.fullName = fullName;
        this.cpfNumber = cpfNumber;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Person newPerson (
            String fullName,
            String cpfNumber,
            LocalDate birthDate,
            Instant createdAt,
            Instant updatedAt,
            Instant deletedAt
    ){
        Instant now = Instant.now();
        return new Person(
                null,
                fullName,
                cpfNumber,
                birthDate,
                now,
                now,
                null);
    }

    public static Person with(
            Integer id,
            String fullName,
            String cpfNumber,
            LocalDate birthDate,
            Instant createdAt,
            Instant updatedAt,
            Instant deletedAt
    ){
        return new Person(
                id,
                fullName,
                cpfNumber,
                birthDate,
                createdAt,
                updatedAt,
                deletedAt);
    }

    public Integer getId() {return id;}

    public String getFullName() {return fullName;}

    public String getCpfNumber() {return cpfNumber;}

    public LocalDate getBirthDate() {return birthDate;}

    public Instant getCreatedAt() {return createdAt;}

    public Instant getUpdatedAt() {return updatedAt;}

    public Instant getDeletedAt() {return deletedAt;}
}
