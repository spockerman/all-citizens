package br.com.all.citizens.application.department;

import br.com.all.citizens.application.department.command.CreateDepartmentCommand;
import br.com.all.citizens.application.department.command.DepartmentTreeCommand;
import br.com.all.citizens.application.department.command.UpdateDepartmentCommand;
import br.com.all.citizens.application.department.service.*;
import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.domain.department.DepartmentRepository;
import br.com.all.citizens.domain.exception.DepartmentNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentApplicationServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private CreateDepartmentService createDepartmentService;

    @InjectMocks
    private FindByIdDepartmentService findByIdDepartmentService;

    @InjectMocks
    private DeleteDepartmentService deleteDepartmentService;

    @InjectMocks
    private UpdateDepartmentService updateDepartmentService;

    @InjectMocks
    private FindDepartmentSubTreeService findDepartmentSubTreeService;

    @Test
    public void givenValidCommand_whenCreateDepartment_thenShouldPersistDepartmentAndReturnId() {
        final var expectedId = 1;
        final var expectedName = "Department Test";
        final var expectedDescription = "Department Description";
        final var expectedEmail = "department@test.com";
        final var expectedPhone = "123456789";
        final var expectedIsActive = true;

        final var aCommand = new CreateDepartmentCommand(
                expectedName,
                expectedDescription,
                expectedEmail,
                expectedPhone,
                expectedIsActive,
                null
        );

        when(departmentRepository.save(any(Department.class)))
                .thenReturn(Department.with(
                        expectedId,
                        expectedName,
                        expectedDescription,
                        expectedEmail,
                        expectedPhone,
                        expectedIsActive,
                        Instant.now(),
                        Instant.now(),
                        null,
                        null
                ));

        final var actualId = createDepartmentService.execute(aCommand);

        assertNotNull(actualId);
        assertEquals(expectedId, actualId);
        verify(departmentRepository, times(1)).save(any());
    }

    @Test
    public void givenExistingDepartmentId_whenExecute_thenShouldReturnMatchingDepartment() {
        final var expectedId = 1;
        final var expectedName = "Department Test";
        final var expectedDescription = "Description";
        final var expectedEmail = "email@test.com";
        final var expectedPhone = "123456789";
        final var expectedIsActive = true;

        final var expectedDepartment = Department.with(
                expectedId,
                expectedName,
                expectedDescription,
                expectedEmail,
                expectedPhone,
                expectedIsActive,
                Instant.now(),
                Instant.now(),
                null,
                null
        );

        when(departmentRepository.findById(expectedId))
                .thenReturn(Optional.of(expectedDepartment));

        final var actualDepartment = findByIdDepartmentService.execute(expectedId);

        assertAll("Should return department with matching fields",
                () -> assertNotNull(actualDepartment),
                () -> assertEquals(expectedId, actualDepartment.getId()),
                () -> assertEquals(expectedName, actualDepartment.getName()),
                () -> assertEquals(expectedDescription, actualDepartment.getDescription()),
                () -> assertEquals(expectedEmail, actualDepartment.getEmail()),
                () -> assertEquals(expectedPhone, actualDepartment.getPhone()),
                () -> assertEquals(expectedIsActive, actualDepartment.isActive())
        );

        verify(departmentRepository, times(1)).findById(expectedId);
    }

    @Test
    public void givenValidCommand_whenUpdateDepartment_thenShouldUpdateDepartment() {
        final var expectedId = 1;
        final var expectedName = "Updated Department Test";
        final var expectedDescription = "Updated Description";
        final var expectedEmail = "updated@email.com";
        final var expectedPhone = "987654321";
        final var expectedIsActive = false;

        final var existingDepartment = Department.with(
                expectedId,
                "Old Department",
                "Old Description",
                "old@test.com",
                "123456789",
                false,
                Instant.now(),
                Instant.now(),
                null,
                null
        );

        // Arrange: configura o mock para findById
        when(departmentRepository.findById(expectedId)).thenReturn(Optional.of(existingDepartment));

        final var aCommand = new UpdateDepartmentCommand(
                expectedId,
                expectedName,
                expectedDescription,
                expectedEmail,
                expectedPhone,
                expectedIsActive,
                null
        );

        // Act
        updateDepartmentService.execute(aCommand);

        // Assert
        // Verifica se findById foi chamado uma vez
        verify(departmentRepository, times(1)).findById(expectedId);

        // Captura o objeto salvo no repositório
        ArgumentCaptor<Department> captor = ArgumentCaptor.forClass(Department.class);
        verify(departmentRepository, times(1)).save(captor.capture());
        Department savedDepartment = captor.getValue();

        // Faz asserções sobre os campos atualizados
        assertEquals(expectedName, savedDepartment.getName());
        assertEquals(expectedDescription, savedDepartment.getDescription());
        assertEquals(expectedEmail, savedDepartment.getEmail());
        assertEquals(expectedPhone, savedDepartment.getPhone());
        assertEquals(expectedIsActive, savedDepartment.isActive());
    }


    @Test
    public void givenValidId_whenDeleteDepartment_thenShouldDeleteDepartment() {
        final var expectedId = 1;
        final var existingDepartment = Department.with(
                expectedId,
                "Department",
                "Description",
                "test@test.com",
                "123456789",
                true,
                Instant.now(),
                Instant.now(),
                null,
                null
        );

        // Arrange: configura o mock para findById
        when(departmentRepository.findById(expectedId)).thenReturn(Optional.of(existingDepartment));

        deleteDepartmentService.execute(existingDepartment.getId());

        verify(departmentRepository, times(1)).deleteById(expectedId);
    }


    @Test
    public void givenInvalidId_whenGetDepartment_thenShouldThrowException() {
        final var invalidId = 123;

        when(departmentRepository.findById(invalidId))
                .thenReturn(Optional.empty());

        assertThrows(DepartmentNotFoundException.class, () -> findByIdDepartmentService.execute(invalidId));

        verify(departmentRepository, times(1)).findById(invalidId);
    }

    @Test
    public void givenInvalidId_whenDeleteDepartment_thenShouldThrowException() {
        final var invalidId = 99;

        when(departmentRepository.findById(invalidId)).thenReturn(Optional.empty());

        assertThrows(DepartmentNotFoundException.class, () -> {
            deleteDepartmentService.execute(invalidId);
        });

        verify(departmentRepository, never()).deleteById(any());
    }


    @Test
    public void givenValidParentId_whenGetDepartmentsByParent_thenShouldReturnDepartmentsList() {
        final var parentId = 1;

        final var parentDepartment = Department.with(parentId, "Parent Dept", "Parent Desc",
                "parent@test.com", "000", true, Instant.now(), Instant.now(), null, null);

        final var expectedDepartments = List.of(
                Department.with(2, "Child Dept 1", "Desc 1", "child1@test.com", "111", true,
                        Instant.now(), Instant.now(), null, parentId),
                Department.with(3, "Child Dept 2", "Desc 2", "child2@test.com", "222", true,
                        Instant.now(), Instant.now(), null, parentId)
        );

        when(departmentRepository.findById(parentId)).thenReturn(Optional.of(parentDepartment));
        when(departmentRepository.findByParentDepartmentId(parentId)).thenReturn(expectedDepartments);
        when(departmentRepository.findByParentDepartmentId(2)).thenReturn(List.of()); // filhos do filho 1
        when(departmentRepository.findByParentDepartmentId(3)).thenReturn(List.of()); // filhos do filho 2

        final var actualDepartments = findDepartmentSubTreeService.execute(parentId);

        assertTrue(actualDepartments.isPresent());
        DepartmentTreeCommand root = actualDepartments.get();
        assertEquals(parentId, root.id());
        assertEquals(2, root.children().size());

        verify(departmentRepository, times(1)).findById(parentId);
        verify(departmentRepository, times(1)).findByParentDepartmentId(parentId);
        verify(departmentRepository, times(1)).findByParentDepartmentId(2);
        verify(departmentRepository, times(1)).findByParentDepartmentId(3);
    }
}