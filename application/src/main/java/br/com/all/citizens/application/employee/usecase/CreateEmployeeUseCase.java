package br.com.all.citizens.application.employee.usecase;

import br.com.all.citizens.application.employee.command.CreateEmployeeCommand;


public interface CreateEmployeeUseCase {
    Integer execute(CreateEmployeeCommand command);
}
