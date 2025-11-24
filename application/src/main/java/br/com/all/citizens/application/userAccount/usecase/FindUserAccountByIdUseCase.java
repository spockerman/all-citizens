package br.com.all.citizens.application.userAccount.usecase;

import br.com.all.citizens.domain.userAccount.UserAccount;

public interface FindUserAccountByIdUseCase {
    UserAccount execute(Integer id);
}
