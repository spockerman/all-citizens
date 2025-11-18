package br.com.all.citizens.application.employee.service;

import br.com.all.citizens.application.employee.command.CreateEmployeeCommand;
import br.com.all.citizens.application.employee.usecase.CreateEmployeeUseCase;
import br.com.all.citizens.domain.employee.Employee;
import br.com.all.citizens.domain.employee.EmployeeRepository;
import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CreateEmployeeService implements CreateEmployeeUseCase {

    private final EmployeeRepository employeeRepository;
    private final PersonRepository personRepository;

    public CreateEmployeeService(
            EmployeeRepository employeeRepository,
            PersonRepository personRepository
    ) {
        this.employeeRepository = employeeRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Integer execute(CreateEmployeeCommand command) {
        Instant now = Instant.now();

        Person person = Person.newPerson(
                command.fullName(),
                command.cpfNumber(),
                command.birthDate(),
                now,
                now,
                null
        );

        Person savedPerson = personRepository.save(person);

        Employee employee = Employee.newEmployee(
                savedPerson,
                command.department(),
                command.documentNumber(),
                command.positionTitle()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        return savedEmployee.getPersonId();


    }
}

