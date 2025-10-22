package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

import br.com.all.citizens.domain.citizen.CitizenType;

import java.time.Instant;

public record CitizenResponse(
        Integer id,
        String name,
        String cpf,
        String mobile,
        String email,
        CitizenType type,
        Instant createdAt,
        Instant updatedAt
) {}