package br.com.all.citizens.application.userAccount.service;

import br.com.all.citizens.application.userAccount.usecase.FindUserAccountByIdUseCase;
import br.com.all.citizens.domain.exception.UserAccountNotFoundException;
import br.com.all.citizens.domain.userAccount.UserAccount;
import br.com.all.citizens.domain.userAccount.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindUserAccountByIdService implements FindUserAccountByIdUseCase {

    private final UserAccountRepository repository;

    public FindUserAccountByIdService(UserAccountRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional(readOnly = true)
    public UserAccount execute(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new UserAccountNotFoundException(
                                String.format("User account with id '%s' not found.", String.valueOf(id))
                        )
                );
    }
}
