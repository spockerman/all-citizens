package br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper;

import br.com.all.citizens.domain.serviceRequest.ServiceRequest;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaServiceRequestEntity;

public final class ServiceRequestMapper {

    private ServiceRequestMapper() {
    }

    public static ServiceRequest toDomain(JpaServiceRequestEntity entity) {
        if (entity == null) {
            return null;
        }
        return ServiceRequest.with(
                entity.getId(),
                entity.getTopic().getId(),
                entity.getSubTopic().getId(),
                entity.getDescription(),
                entity.getOccurrenceAddress(),
                entity.getRequesterPerson().getId(),
                entity.getResponsibleUserAccount().getId(),
                entity.getOccurrenceAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
