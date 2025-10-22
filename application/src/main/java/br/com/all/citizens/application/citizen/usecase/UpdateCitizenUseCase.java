package br.com.all.citizens.application.citizen.usecase;

import br.com.all.citizens.application.citizen.command.UpdateCitizenCommand;

public interface UpdateCitizenUseCase {
    void execute(UpdateCitizenCommand command);
}