package br.com.all.citizens.application.department.usecase;

import br.com.all.citizens.application.department.command.CreateDepartmentCommand;

public interface CreateDepartmentUseCase {
    Integer execute(CreateDepartmentCommand command);
}
