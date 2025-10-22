package br.com.all.citizens.application.subtopic.command;

import br.com.all.citizens.domain.subtopic.UrgencyLevel;

import java.time.Instant;

public record UpdateSubTopicCommand(
        Integer id,
        String name,
        String description,
        Instant deadline,
        UrgencyLevel urgencyLevel,
        Integer topicId,
        Integer departmentId
) {}