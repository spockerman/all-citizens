package br.com.all.citizens.domain;

import br.com.all.citizens.domain.department.Department;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DepartmentTest {
    @Test
    public void givenAValidParams_whenCallNewDepartment_thenInitialANewDepartment() {
        final var expectedName = "New Department";
        final var expectedDescription = "New Department Description";
        final var expectedEmail = "departament@departament.com";
        final var expectedPhone = "123456789";
        final var expectedIsActive = true;

        final var actualDepartament = Department.newDepartment(
                expectedName,
                expectedDescription,
                expectedEmail,
                expectedPhone,
                expectedIsActive
        );

        Assertions.assertNotNull(actualDepartament);
        Assertions.assertNotNull(actualDepartament.getId());
        Assertions.assertEquals(expectedName, actualDepartament.getName());
        Assertions.assertEquals(expectedDescription, actualDepartament.getDescription());
        Assertions.assertEquals(expectedEmail, actualDepartament.getEmail());
        Assertions.assertEquals(expectedPhone, actualDepartament.getPhone());
        Assertions.assertNotNull(actualDepartament.getCreatedAt());
        Assertions.assertNotNull(actualDepartament.getUpdatedAt());
        Assertions.assertNull(actualDepartament.getDeletedAt());

    }
}
