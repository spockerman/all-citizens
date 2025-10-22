package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

import br.com.all.citizens.domain.subtopic.UrgencyLevel;

import java.time.Instant;

public record SubTopicResponse(
        Integer id,
        String name,
        String description,
        Instant deadline,
        UrgencyLevel urgencyLevel,
        Integer topicId,
        Integer departmentId,
        Instant createdAt,
        Instant updatedAt
) {}