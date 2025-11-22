package br.com.all.citizens.application.employee.service;

import br.com.all.citizens.application.employee.command.CreateEmployeeCommand;
import br.com.all.citizens.application.employee.usecase.CreateEmployeeUseCase;
import br.com.all.citizens.application.utils.PersonApplicationService;
import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.domain.department.DepartmentRepository;
import br.com.all.citizens.domain.employee.Employee;
import br.com.all.citizens.domain.employee.EmployeeRepository;
import br.com.all.citizens.domain.exception.DepartmentNotFoundException;
import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
public class CreateEmployeeService implements CreateEmployeeUseCase {

    private final EmployeeRepository employeeRepository;
    private final PersonRepository personRepository;
    private final DepartmentRepository departmentRepository;
    private final PersonApplicationService personService;

    public CreateEmployeeService(EmployeeRepository employeeRepository, PersonRepository personRepository, DepartmentRepository departmentRepository, PersonApplicationService personService) {
        this.employeeRepository = employeeRepository;
        this.personRepository = personRepository;
        this.departmentRepository = departmentRepository;
        this.personService = personService;
    }

    @Override
    @Transactional
    public Integer execute(CreateEmployeeCommand command) {
        Person savedPerson = personService.findOrCreatePerson(
                command.fullName(),
                command.cpfNumber(),
                command.birthDate()
        );


        Department department = departmentRepository.findById(command.departmentId())
                .orElseThrow(() -> new DepartmentNotFoundException(command.departmentId()));


        Employee employee = Employee.newEmployee(
                savedPerson,
                department,
                command.documentNumber(),
                command.positionTitle()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        return savedEmployee.getPersonId();


    }
}

