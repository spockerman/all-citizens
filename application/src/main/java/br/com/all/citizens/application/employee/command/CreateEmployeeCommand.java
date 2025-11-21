package br.com.all.citizens.application.employee.command;

import br.com.all.citizens.domain.department.Department;

import java.time.LocalDate;

public record CreateEmployeeCommand(
        String fullName,
        String cpfNumber,
        LocalDate birthDate,
        Integer departmentId,
        String documentNumber,
        String positionTitle
) {
}
