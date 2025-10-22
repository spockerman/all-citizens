package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

import java.time.Instant;

public record TopicResponse(
        Integer id,
        String description,
        boolean active,
        Instant createdAt,
        Instant updatedAt
) {}