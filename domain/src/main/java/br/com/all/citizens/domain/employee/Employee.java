package br.com.all.citizens.domain.employee;

import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.domain.person.Person;

import java.time.Instant;

public class Employee {
    private final Integer personId;   // PK compartilhada com Person
    private final Person person;      // Agregado obrigatório
    private final Department department;
    private final String documentNumber;
    private final String positionTitle;
    private final Instant createdAt;

    public Employee(
            Integer personId,
            Person person,
            Department department,
            String documentNumber,
            String positionTitle,
            Instant createdAt
    ) {
        this.personId = personId;
        this.person = person;
        this.department = department;
        this.documentNumber = documentNumber;
        this.positionTitle = positionTitle;
        this.createdAt = createdAt;
    }

    public static Employee newEmployee(
            Person person,
            Department department,
            String documentNumber,
            String positionTitle
    ) {
        Instant now = Instant.now();

        return new Employee(
                person.getId(),       // personId só existe após persistência
                person,
                department,
                documentNumber,
                positionTitle,
                now
        );
    }

    public static Employee with(
            Integer personId,
            Person person,
            Department department,
            String documentNumber,
            String positionTitle,
            Instant createdAt
    ) {
        return new Employee(
                personId,
                person,
                department,
                documentNumber,
                positionTitle,
                createdAt
        );
    }

    public Integer getPersonId() {
        return personId;
    }

    public Person getPerson() {
        return person;
    }

    public Department getDepartment() { return department; }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getPositionTitle() { return positionTitle; }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
