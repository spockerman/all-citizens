package br.com.all.citizens.domain;

import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.domain.employee.Employee;
import br.com.all.citizens.domain.person.Person;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void givenPersistedPersonAndDepartment_whenNewEmployee_thenUsesPersonIdAndLinksAggregates() {
        Instant now = Instant.now();
        LocalDate birth = LocalDate.of(1970, 1, 1);
        Person person = Person.with(5, "Staff", "11122233344", birth, now, now, null);
        Department dept = Department.with(
                9,
                "Ops",
                "Operations",
                "ops@org.com",
                "1",
                true,
                now,
                now,
                null,
                null
        );

        Employee e = Employee.newEmployee(person, dept, "RG-99", "Analyst");

        assertEquals(5, e.getPersonId());
        assertEquals(person, e.getPerson());
        assertEquals(dept, e.getDepartment());
        assertEquals("RG-99", e.getDocumentNumber());
        assertEquals("Analyst", e.getPositionTitle());
        assertNotNull(e.getCreatedAt());
    }

    @Test
    public void givenValues_whenWith_thenReturnsReconstructedEmployee() {
        Instant now = Instant.now();
        LocalDate birth = LocalDate.of(2000, 5, 5);
        Person person = Person.with(1, "X", "00000000000", birth, now, now, null);
        Department dept = Department.with(2, "D", "D", "d@d.com", "0", true, now, now, null, null);

        Employee e = Employee.with(1, person, dept, "DOC", "Role", now);

        assertEquals(1, e.getPersonId());
        assertEquals(now, e.getCreatedAt());
    }
}
