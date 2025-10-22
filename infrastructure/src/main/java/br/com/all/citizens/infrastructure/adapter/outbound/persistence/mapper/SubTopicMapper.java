package br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper;

import br.com.all.citizens.domain.subtopic.SubTopic;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaDepartmentEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaSubTopicEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaTopicEntity;

public class SubTopicMapper {

    /**
     * Converts a SubTopic (domain) to JpaSubTopicEntity.
     */
    public static JpaSubTopicEntity toEntity(SubTopic subTopic) {
        JpaSubTopicEntity entity = new JpaSubTopicEntity();

        entity.setId(subTopic.getId());
        entity.setName(subTopic.getName());
        entity.setDescription(subTopic.getDescription());
        entity.setDeadline(subTopic.getDeadline());
        entity.setUrgencyLevel(subTopic.getUrgencyLevel());
        entity.setCreatedAt(subTopic.getCreatedAt());
        entity.setUpdatedAt(subTopic.getUpdatedAt());
        entity.setDeletedAt(subTopic.getDeletedAt());

        if (subTopic.getTopicId() != null) {
            JpaTopicEntity topic = new JpaTopicEntity();
            topic.setId(subTopic.getTopicId());
            entity.setTopic(topic);
        }

        if (subTopic.getDepartmentId() != null) {
            JpaDepartmentEntity department = new JpaDepartmentEntity();
            department.setId(subTopic.getDepartmentId());
            entity.setDepartment(department);
        }

        return entity;
    }

    /**
     * Converts a JpaSubTopicEntity to SubTopic (domain).
     */
    public static SubTopic toDomain(JpaSubTopicEntity entity) {
        return SubTopic.with(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getDeadline(),
                entity.getUrgencyLevel(),
                entity.getTopic() != null ? entity.getTopic().getId() : null,
                entity.getDepartment() != null ? entity.getDepartment().getId() : null,
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getDeletedAt()
        );
    }
}