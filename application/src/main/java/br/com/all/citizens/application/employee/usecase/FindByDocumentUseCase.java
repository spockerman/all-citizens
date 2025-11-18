package br.com.all.citizens.application.employee.usecase;

import br.com.all.citizens.domain.employee.Employee;

import java.util.Optional;

public interface FindByDocumentUseCase {
    Employee execute(String documentNumber);
}
