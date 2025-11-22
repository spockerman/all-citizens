package br.com.all.citizens.application.userAccount.service;

import br.com.all.citizens.application.userAccount.command.CreateUserAccountCommand;
import br.com.all.citizens.application.userAccount.usecase.CreateUserAccountUseCase;
import br.com.all.citizens.domain.userAccount.UserAccount;
import br.com.all.citizens.domain.userAccount.UserAccountRepository;
import org.springframework.transaction.annotation.Transactional;

public class CreateUserAccountService implements CreateUserAccountUseCase {

    private final UserAccountRepository userAccountRepository;

    public CreateUserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    @Transactional
    public Integer execute(CreateUserAccountCommand command) {
        UserAccount userAccount = UserAccount.newUserAccount(
                command.personId(),
                command.authProvider(),
                command.authSubject(),
                command.mobile(),
                command.email(),
                command.isActive()

        );
        UserAccount savedUserAccount = userAccountRepository.save(userAccount);
        return savedUserAccount.getId();
    }


}
