package br.com.all.citizens.application.employee;

import br.com.all.citizens.application.employee.command.CreateEmployeeCommand;
import br.com.all.citizens.application.employee.service.CreateEmployeeService;
import br.com.all.citizens.application.utils.PersonApplicationService;
import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.domain.department.DepartmentRepository;
import br.com.all.citizens.domain.employee.Employee;
import br.com.all.citizens.domain.employee.EmployeeRepository;
import br.com.all.citizens.domain.exception.DepartmentNotFoundException;
import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateEmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private PersonApplicationService personApplicationService;

    @InjectMocks
    private CreateEmployeeService createEmployeeService;

    @Test
    void givenCommand_whenExecute_thenPersistsEmployeeAndReturnsPersonId() {
        LocalDate birth = LocalDate.of(1975, 7, 7);
        var command = new CreateEmployeeCommand(
                "Alan Kay",
                "55566677788",
                birth,
                10,
                "DOC-100",
                "Researcher"
        );

        Person person = Person.with(
                77,
                "Alan Kay",
                "55566677788",
                birth,
                Instant.now(),
                Instant.now(),
                null
        );

        Department department = Department.with(
                10,
                "R&D",
                "Lab",
                "lab@org.com",
                "0",
                true,
                Instant.now(),
                Instant.now(),
                null,
                null
        );

        when(personApplicationService.findOrCreatePerson(
                eq("Alan Kay"),
                eq("55566677788"),
                eq(birth)
        )).thenReturn(person);

        when(departmentRepository.findById(10)).thenReturn(Optional.of(department));

        when(employeeRepository.save(any(Employee.class))).thenAnswer(inv -> {
            Employee e = inv.getArgument(0);
            return Employee.with(
                    e.getPersonId(),
                    e.getPerson(),
                    e.getDepartment(),
                    e.getDocumentNumber(),
                    e.getPositionTitle(),
                    e.getCreatedAt()
            );
        });

        Integer personId = createEmployeeService.execute(command);

        assertEquals(77, personId);
        verify(employeeRepository).save(any(Employee.class));
    }

    @Test
    void givenUnknownDepartment_whenExecute_thenThrowsDepartmentNotFoundException() {
        LocalDate birth = LocalDate.of(1980, 1, 1);
        var command = new CreateEmployeeCommand(
                "Jane",
                "11122233344",
                birth,
                999,
                "DOC",
                "Role"
        );

        Person person = Person.with(
                1,
                "Jane",
                "11122233344",
                birth,
                Instant.now(),
                Instant.now(),
                null
        );

        when(personApplicationService.findOrCreatePerson(any(), any(), any())).thenReturn(person);
        when(departmentRepository.findById(999)).thenReturn(Optional.empty());

        assertThrows(DepartmentNotFoundException.class, () -> createEmployeeService.execute(command));
    }
}
