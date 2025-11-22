package br.com.all.citizens.application.userAccount.usecase;

import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UserAccountResponse;

import java.util.Optional;

public interface FindByPersonUseCase {
    Optional<UserAccountResponse> execute(Integer personId);
}
