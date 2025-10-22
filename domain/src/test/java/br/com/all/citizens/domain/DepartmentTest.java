package br.com.all.citizens.domain;

import br.com.all.citizens.domain.department.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;


public class DepartmentTest {

    @Test
    public void givenAValidParams_whenCallWith_thenInitializeDepartmentWithValues() {
        final var expectedId = 0;
        final var expectedName = "New Department";
        final var expectedDescription = "New Department Description";
        final var expectedEmail = "department@department.com";
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
        Assertions.assertNull(actualDepartment.getParentDepartmentId());
    }

    @Test
    public void givenAValidParams_whenCallNewDepartment_thenInstantiateDepartment() {
        final var expectedName = "New Department";
        final var expectedDescription = "New Department Description";
        final var expectedEmail = "department@department.com";
        final var expectedPhone = "123456789";
        final var expectedIsActive = true;
        final var expectedParentDepartmentId = 1;

        final var actualDepartment = Department.newDepartment(
                expectedName,
                expectedDescription,
                expectedEmail,
                expectedPhone,
                expectedIsActive,
                expectedParentDepartmentId
        );

        Assertions.assertNotNull(actualDepartment);
        Assertions.assertNull(actualDepartment.getId());
        Assertions.assertEquals(expectedName, actualDepartment.getName());
        Assertions.assertEquals(expectedDescription, actualDepartment.getDescription());
        Assertions.assertEquals(expectedEmail, actualDepartment.getEmail());
        Assertions.assertEquals(expectedPhone, actualDepartment.getPhone());
        Assertions.assertEquals(expectedIsActive, actualDepartment.isActive());
        Assertions.assertNotNull(actualDepartment.getCreatedAt());
        Assertions.assertNotNull(actualDepartment.getUpdatedAt());
        Assertions.assertNull(actualDepartment.getDeletedAt());
        Assertions.assertEquals(expectedParentDepartmentId, actualDepartment.getParentDepartmentId());
    }

    @Test
    public void givenAValidParamsWithParentDepartment_whenCallWith_thenInitializeDepartmentWithValues() {
        final var expectedId = 0;
        final var expectedName = "Sub Department";
        final var expectedDescription = "Sub Department Description";
        final var expectedEmail = "sub@department.com";
        final var expectedPhone = "987654321";
        final var expectedIsActive = true;
        final var expectedParentDepartmentId = 1;
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
                expectedParentDepartmentId
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
        Assertions.assertEquals(expectedParentDepartmentId, actualDepartment.getParentDepartmentId());
    }

    @Test
    public void givenAValidParamsWithDeletedDepartment_whenCallWith_thenInitializeDepartmentWithValues() {
        final var expectedId = 0;
        final var expectedName = "Deleted Department";
        final var expectedDescription = "Deleted Department Description";
        final var expectedEmail = "deleted@department.com";
        final var expectedPhone = "555555555";
        final var expectedIsActive = false;
        final var now = Instant.now();
        final var deletedAt = now.plusSeconds(100);

        final var actualDepartment = Department.with(
                expectedId,
                expectedName,
                expectedDescription,
                expectedEmail,
                expectedPhone,
                expectedIsActive,
                now,
                now,
                deletedAt,
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
        Assertions.assertEquals(deletedAt, actualDepartment.getDeletedAt());
        Assertions.assertNull(actualDepartment.getParentDepartmentId());
    }

}
