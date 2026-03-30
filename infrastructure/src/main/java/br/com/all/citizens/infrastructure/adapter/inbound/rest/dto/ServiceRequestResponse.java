package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

import java.time.Instant;

public record ServiceRequestResponse(
        Integer id,
        Integer topicId,
        Integer subTopicId,
        String description,
        String occurrenceAddress,
        Integer requesterPersonId,
        Integer responsibleUserAccountId,
        Instant occurrenceAt,
        Instant createdAt,
        Instant updatedAt
) {
}
