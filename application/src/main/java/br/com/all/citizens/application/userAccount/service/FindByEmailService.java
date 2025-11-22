package br.com.all.citizens.application.userAccount.service;

import br.com.all.citizens.application.userAccount.usecase.FindByEmailUseCase;
import br.com.all.citizens.domain.exception.UserAccountNotFoundException;
import br.com.all.citizens.domain.userAccount.UserAccount;
import br.com.all.citizens.domain.userAccount.UserAccountRepository;
import org.springframework.transaction.annotation.Transactional;

public class FindByEmailService implements FindByEmailUseCase {

    private final UserAccountRepository repository;

    public FindByEmailService(UserAccountRepository repository) {
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