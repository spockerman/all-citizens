package br.com.all.citizens.application.userAccount.service;

import br.com.all.citizens.application.userAccount.usecase.FindUserAccountByPersonUseCase;
import br.com.all.citizens.domain.exception.UserAccountNotFoundException;
import br.com.all.citizens.domain.userAccount.UserAccount;
import br.com.all.citizens.domain.userAccount.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindByPersonUserAccountService implements FindUserAccountByPersonUseCase {

    private final UserAccountRepository repository;

    public FindByPersonUserAccountService(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount execute(Integer personId) {
        return repository.findById(personId).orElseThrow(() ->
                new UserAccountNotFoundException(
                        String.format("User account with Personid '%s' not found.", String.valueOf(personId))
                )
        );
    }
}
