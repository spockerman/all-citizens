package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;


import br.com.all.citizens.domain.department.Department;

import java.time.LocalDate;

public record EmployeeResponse(
        Integer id,
        String fullName,
        String cpfNumber,
        LocalDate birthDate,
        Department department,
        String documentNumber,
        String positionTitle
) {}