package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

import br.com.all.citizens.domain.citizen.CitizenType;

public record UpdateCitizenRequest(
        String name,
        String cpf,
        String mobile,
        String email,
        CitizenType type
) {}