package br.com.all.citizens.application.person.command;

import java.time.LocalDate;

public record CreatePersonCommand(
        String fullName,
        String cpfNumber,
        LocalDate birthDate
) {
}
