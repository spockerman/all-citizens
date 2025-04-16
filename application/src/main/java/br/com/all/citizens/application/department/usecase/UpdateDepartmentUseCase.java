package br.com.all.citizens.application.department.usecase;

import br.com.all.citizens.application.department.command.UpdateDepartmentCommand;


public interface UpdateDepartmentUseCase {
    void execute(UpdateDepartmentCommand command);
}
