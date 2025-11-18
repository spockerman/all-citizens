package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

import br.com.all.citizens.domain.citizen.CitizenType;

import java.time.LocalDate;

public record UpdateCitizenRequest(
        String fullName,
        String cpfNumber,
        LocalDate birthDate,
        String socialId,
        CitizenType type
) {}