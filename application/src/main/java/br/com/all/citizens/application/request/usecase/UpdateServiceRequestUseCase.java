package br.com.all.citizens.application.request.usecase;

import br.com.all.citizens.application.request.command.UpdateServiceRequestCommand;

public interface UpdateServiceRequestUseCase {
    void execute(UpdateServiceRequestCommand command);
}
