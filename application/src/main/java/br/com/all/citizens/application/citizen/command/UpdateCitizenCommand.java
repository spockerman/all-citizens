package br.com.all.citizens.application.citizen.command;

import br.com.all.citizens.domain.citizen.CitizenType;

import java.time.LocalDate;

public record UpdateCitizenCommand(
        String fullName,
        String cpfNumber,
        LocalDate birthDate,
        String socialId,
        CitizenType type
) {}