package br.com.all.citizens.application.userAccount.usecase;

import br.com.all.citizens.domain.userAccount.UserAccount;

import java.util.Optional;

public interface FindUserAccountByMobileUseCase {
    UserAccount execute(String mobile);
}
