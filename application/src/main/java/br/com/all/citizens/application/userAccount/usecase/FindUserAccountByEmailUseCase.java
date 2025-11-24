package br.com.all.citizens.application.userAccount.usecase;

import br.com.all.citizens.domain.userAccount.UserAccount;

public interface FindUserAccountByEmailUseCase {
    UserAccount execute(String email);
}
