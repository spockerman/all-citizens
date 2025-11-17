package br.com.all.citizens.application.person.usecase;

import br.com.all.citizens.application.person.command.CreatePersonCommand;

public interface CreatePersonUseCase {
     Integer execute(CreatePersonCommand command);
}
