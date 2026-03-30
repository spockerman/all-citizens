package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

import java.time.Instant;

public record UpdateServiceRequestRequest(
        Integer topicId,
        Integer subTopicId,
        String description,
        String occurrenceAddress,
        Integer requesterPersonId,
        Integer responsibleUserAccountId,
        Instant occurrenceAt
) {
}
