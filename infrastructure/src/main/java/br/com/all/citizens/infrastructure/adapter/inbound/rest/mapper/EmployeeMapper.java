package br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper;

import br.com.all.citizens.application.employee.command.CreateEmployeeCommand;
import br.com.all.citizens.domain.employee.Employee;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CreateEmployeeRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.EmployeeResponse;

public class EmployeeMapper {

    public static CreateEmployeeCommand toCommand(CreateEmployeeRequest request) {
        return new CreateEmployeeCommand(
                request.fullName(),
                request.cpfNumber(),
                request.birthDate(),
                request.departmentId(),
                request.documentNumber(),
                request.positionTitle()
        );
    }

    public static EmployeeResponse toResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getPersonId(),
                employee.getPerson().getFullName(),
                employee.getPerson().getCpfNumber(),
                employee.getPerson().getBirthDate(),
                employee.getDepartment(),
                employee.getDocumentNumber(),
                employee.getPositionTitle()
        );
    }
}