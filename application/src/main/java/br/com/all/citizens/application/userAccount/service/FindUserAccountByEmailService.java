package br.com.all.citizens.application.userAccount.service;

import br.com.all.citizens.application.userAccount.usecase.FindUserAccountByEmailUseCase;
import br.com.all.citizens.domain.exception.UserAccountNotFoundException;
import br.com.all.citizens.domain.userAccount.UserAccount;
import br.com.all.citizens.domain.userAccount.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindUserAccountByEmailService implements FindUserAccountByEmailUseCase {

    private final UserAccountRepository repository;

    public FindUserAccountByEmailService(UserAccountRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional(readOnly = true)
    public UserAccount execute(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() ->
                        new UserAccountNotFoundException(
                                String.format("User account with email '%s' not found.", email)
                        )
                );
    }
}