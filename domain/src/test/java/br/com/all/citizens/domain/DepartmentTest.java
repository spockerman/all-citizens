package br.com.all.citizens.domain;

import br.com.all.citizens.domain.department.Department;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Instant;


public class DepartmentTest {

    @Test
    public void givenAValidParams_whenCallWith_thenInitializeDepartmentWithValues() {
        final var expectedId = 0;
        final var expectedName = "New Department";
        final var expectedDescription = "New Department Description";
        final var expectedEmail = "departament@departament.com";
        final var expectedPhone = "123456789";
        final var expectedIsActive = true;
        final var now = Instant.now();

        final var actualDepartment = Department.with(
                expectedId,
                expectedName,
                expectedDescription,
                expectedEmail,
                expectedPhone,
                expectedIsActive,
                now,
                now,
                null,
                null

        );

        Assertions.assertNotNull(actualDepartment);
        Assertions.assertEquals(expectedId, actualDepartment.getId());
        Assertions.assertEquals(expectedName, actualDepartment.getName());
        Assertions.assertEquals(expectedDescription, actualDepartment.getDescription());
        Assertions.assertEquals(expectedEmail, actualDepartment.getEmail());
        Assertions.assertEquals(expectedPhone, actualDepartment.getPhone());
        Assertions.assertEquals(expectedIsActive, actualDepartment.isActive());
        Assertions.assertEquals(now, actualDepartment.getCreatedAt());
        Assertions.assertEquals(now, actualDepartment.getUpdatedAt());
        Assertions.assertNull(actualDepartment.getDeletedAt());
    }
}
