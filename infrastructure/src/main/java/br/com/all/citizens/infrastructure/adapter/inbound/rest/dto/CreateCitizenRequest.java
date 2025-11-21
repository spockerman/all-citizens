package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

import br.com.all.citizens.domain.citizen.CitizenType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record CreateCitizenRequest(
        String fullName,
        String cpfNumber,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate birthDate,
        String socialId,
        CitizenType type
) {}