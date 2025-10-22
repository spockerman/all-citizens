package br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper;

import br.com.all.citizens.application.subtopic.command.CreateSubTopicCommand;
import br.com.all.citizens.application.subtopic.command.UpdateSubTopicCommand;
import br.com.all.citizens.domain.subtopic.SubTopic;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CreateSubTopicRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.SubTopicResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UpdateSubTopicRequest;

public class SubTopicMapper {

    public static CreateSubTopicCommand toCommand(CreateSubTopicRequest request) {
        return new CreateSubTopicCommand(
                request.name(),
                request.description(),
                request.deadline(),
                request.urgencyLevel(),
                request.topicId(),
                request.departmentId()
        );
    }

    public static UpdateSubTopicCommand toCommand(Integer id, UpdateSubTopicRequest request) {
        return new UpdateSubTopicCommand(
                id,
                request.name(),
                request.description(),
                request.deadline(),
                request.urgencyLevel(),
                request.topicId(),
                request.departmentId()
        );
    }

    public static SubTopicResponse toResponse(SubTopic subTopic) {
        return new SubTopicResponse(
                subTopic.getId(),
                subTopic.getName(),
                subTopic.getDescription(),
                subTopic.getDeadline(),
                subTopic.getUrgencyLevel(),
                subTopic.getTopicId(),
                subTopic.getDepartmentId(),
                subTopic.getCreatedAt(),
                subTopic.getUpdatedAt()
        );
    }
}