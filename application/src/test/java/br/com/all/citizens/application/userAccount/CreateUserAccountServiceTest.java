package br.com.all.citizens.application.userAccount;

import br.com.all.citizens.application.userAccount.command.CreateUserAccountCommand;
import br.com.all.citizens.application.userAccount.service.CreateUserAccountService;
import br.com.all.citizens.domain.userAccount.UserAccount;
import br.com.all.citizens.domain.userAccount.UserAccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateUserAccountServiceTest {

    @Mock
    private UserAccountRepository userAccountRepository;

    @InjectMocks
    private CreateUserAccountService createUserAccountService;

    @Test
    void givenCommand_whenExecute_thenSavesAndReturnsAccountId() {
        var command = new CreateUserAccountCommand(
                15,
                "google",
                "sub-abc",
                "+5511999999999",
                "user@example.com",
                true
        );

        when(userAccountRepository.save(any(UserAccount.class))).thenAnswer(inv -> {
            UserAccount ua = inv.getArgument(0);
            return UserAccount.with(
                    200,
                    ua.getPersonId(),
                    ua.getAuthProvider(),
                    ua.getAuthSubject(),
                    ua.getMobile(),
                    ua.getEmail(),
                    ua.isActive()
            );
        });

        Integer id = createUserAccountService.execute(command);

        assertEquals(200, id);
        verify(userAccountRepository).save(any(UserAccount.class));
    }
}
