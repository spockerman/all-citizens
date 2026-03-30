package br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper;

import br.com.all.citizens.application.request.command.CreateServiceRequestCommand;
import br.com.all.citizens.application.request.command.UpdateServiceRequestCommand;
import br.com.all.citizens.domain.serviceRequest.ServiceRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.*;

public final class ServiceRequestRestMapper {

    private ServiceRequestRestMapper() {
    }

    public static CreateServiceRequestCommand toCreateCommand(CreateServiceRequestRequest request) {
        return new CreateServiceRequestCommand(
                request.topicId(),
                request.subTopicId(),
                request.description(),
                request.occurrenceAddress(),
                request.requesterPersonId(),
                request.responsibleUserAccountId(),
                request.occurrenceAt()
        );
    }

    public static UpdateServiceRequestCommand toUpdateCommand(Integer id, UpdateServiceRequestRequest request) {
        return new UpdateServiceRequestCommand(
                id,
                request.topicId(),
                request.subTopicId(),
                request.description(),
                request.occurrenceAddress(),
                request.requesterPersonId(),
                request.responsibleUserAccountId(),
                request.occurrenceAt()
        );
    }

    public static ServiceRequestResponse toResponse(ServiceRequest s) {
        return new ServiceRequestResponse(
                s.getId(),
                s.getTopicId(),
                s.getSubTopicId(),
                s.getDescription(),
                s.getOccurrenceAddress(),
                s.getRequesterPersonId(),
                s.getResponsibleUserAccountId(),
                s.getOccurrenceAt(),
                s.getCreatedAt(),
                s.getUpdatedAt()
        );
    }
}
