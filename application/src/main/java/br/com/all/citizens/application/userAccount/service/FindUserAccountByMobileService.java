package br.com.all.citizens.application.userAccount.service;

import br.com.all.citizens.application.userAccount.usecase.FindUserAccountByMobileUseCase;
import br.com.all.citizens.domain.exception.UserAccountNotFoundException;
import br.com.all.citizens.domain.userAccount.UserAccount;
import br.com.all.citizens.domain.userAccount.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FindUserAccountByMobileService implements FindUserAccountByMobileUseCase {

    private final UserAccountRepository repository;

    public FindUserAccountByMobileService(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserAccount execute(String mobile) {
        return repository.findByMobile(mobile)
                .orElseThrow(
                        () -> new UserAccountNotFoundException(mobile));
    }
}
