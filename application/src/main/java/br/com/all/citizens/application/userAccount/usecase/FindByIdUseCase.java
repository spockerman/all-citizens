package br.com.all.citizens.application.userAccount.usecase;

import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UserAccountResponse;

public interface FindByIdUseCase {
    UserAccountResponse execute(Integer id);
}
