package br.com.all.citizens.domain.employee;

import br.com.all.citizens.domain.person.Person;

import java.time.Instant;

public class Employee {
    private final Integer personId;   // PK compartilhada com Person
    private final Person person;      // Agregado obrigatório
    private final Integer departmentId;
    private final String documentNumber;
    private final Instant createdAt;

    public Employee(
            Integer personId,
            Person person,
            Integer departmentId,
            String documentNumber,
            Instant createdAt
    ) {
        this.personId = personId;
        this.person = person;
        this.departmentId = departmentId;
        this.documentNumber = documentNumber;
        this.createdAt = createdAt;
    }

    public static Employee newEmployee(
            Person person,
            Integer departmentId,
            String documentNumber
    ) {
        Instant now = Instant.now();

        return new Employee(
                null,      // personId só existe após persistência
                person,
                departmentId,
                documentNumber,
                now
        );
    }

    public static Employee with(
            Integer personId,
            Person person,
            Integer departmentId,
            String documentNumber,
            Instant createdAt
    ) {
        return new Employee(
                personId,
                person,
                departmentId,
                documentNumber,
                createdAt
        );
    }

    public Integer getPersonId() {
        return personId;
    }

    public Person getPerson() {
        return person;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
