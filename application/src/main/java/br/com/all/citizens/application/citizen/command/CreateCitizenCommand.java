package br.com.all.citizens.application.citizen.command;

import br.com.all.citizens.domain.citizen.CitizenType;

public record CreateCitizenCommand(
        String name,
        String cpf,
        String mobile,
        String email,
        CitizenType type
) {}