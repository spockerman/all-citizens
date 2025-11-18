package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;


import br.com.all.citizens.domain.department.Department;

import java.time.LocalDate;

public record CreateEmployeeRequest(
        String fullName,
        String cpfNumber,
        LocalDate birthDate,
        Department department,
        String documentNumber
) {}