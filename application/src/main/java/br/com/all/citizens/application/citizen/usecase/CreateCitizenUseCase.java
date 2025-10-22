package br.com.all.citizens.application.citizen.usecase;

import br.com.all.citizens.application.citizen.command.CreateCitizenCommand;

public interface CreateCitizenUseCase {
    Integer execute(CreateCitizenCommand command);
}