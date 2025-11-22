package br.com.all.citizens.application.userAccount.command;

public record CreateUserAccountCommand (
    Integer Id,
    Integer personId,
    String authProvider,
    String authSubject,
    String mobile,
    String email,
    Boolean isActive
){}
