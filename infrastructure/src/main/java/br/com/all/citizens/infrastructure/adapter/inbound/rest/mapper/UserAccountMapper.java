package br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper;

import br.com.all.citizens.application.userAccount.command.CreateUserAccountCommand;
import br.com.all.citizens.domain.userAccount.UserAccount;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UserAccountRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UserAccountResponse;

public class UserAccountMapper {

    public static CreateUserAccountCommand toCommand (UserAccountRequest command) {
        return new CreateUserAccountCommand(
                command.personId(),
                command.authProvider(),
                command.authSubject(),
                command.mobile(),
                command.email(),
                command.isActive()
        );
    }
    public static UserAccountResponse toResponse(UserAccount user) {
        return new UserAccountResponse(
                user.getId(),
                user.getPersonId(),
                user.getAuthProvider(),
                user.getAuthSubject(),
                user.getMobile(),
                user.getEmail(),
                user.isActive()

        );
    }
}
