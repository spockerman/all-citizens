package br.com.all.citizens.application.request.command;

import java.time.Instant;

public record UpdateServiceRequestCommand(
        Integer id,
        Integer topicId,
        Integer subTopicId,
        String description,
        String occurrenceAddress,
        Integer requesterPersonId,
        Integer responsibleUserAccountId,
        Instant occurrenceAt
) {
}
