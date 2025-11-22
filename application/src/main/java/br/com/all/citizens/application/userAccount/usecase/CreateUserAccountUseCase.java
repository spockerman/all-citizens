package br.com.all.citizens.application.userAccount.usecase;

import br.com.all.citizens.application.userAccount.command.CreateUserAccountCommand;

public interface CreateUserAccountUseCase {
    Integer execute(CreateUserAccountCommand command);
}
