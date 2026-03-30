package br.com.all.citizens.application.request.usecase;

import br.com.all.citizens.application.request.command.CreateServiceRequestCommand;

public interface CreateServiceRequestUseCase {
    Integer execute(CreateServiceRequestCommand command);
}
