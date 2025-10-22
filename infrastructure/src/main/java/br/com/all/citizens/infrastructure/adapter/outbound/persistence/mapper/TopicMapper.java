package br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper;

import br.com.all.citizens.domain.topic.Topic;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaTopicEntity;

public class TopicMapper {

    /**
     * Converts a Topic (domain) to JpaTopicEntity.
     */
    public static JpaTopicEntity toEntity(Topic topic) {
        JpaTopicEntity entity = new JpaTopicEntity();

        entity.setId(topic.getId());
        entity.setDescription(topic.getDescription());
        entity.setActive(topic.isActive());
        entity.setCreatedAt(topic.getCreatedAt());
        entity.setUpdatedAt(topic.getUpdatedAt());
        entity.setDeletedAt(topic.getDeletedAt());

        return entity;
    }

    /**
     * Converts a JpaTopicEntity to Topic (domain).
     */
    public static Topic toDomain(JpaTopicEntity entity) {
        return Topic.with(
                entity.getId(),
                entity.getDescription(),
                entity.isActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getDeletedAt()
        );
    }
}