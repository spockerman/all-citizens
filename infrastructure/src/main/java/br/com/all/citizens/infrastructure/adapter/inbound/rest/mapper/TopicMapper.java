package br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper;

import br.com.all.citizens.domain.topic.Topic;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.TopicResponse;

public class TopicMapper {

    public static TopicResponse toResponse(Topic topic) {
        return new TopicResponse(
                topic.getId(),
                topic.getDescription(),
                topic.isActive(),
                topic.getCreatedAt(),
                topic.getUpdatedAt()
        );
    }
}