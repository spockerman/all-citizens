package br.com.all.citizens.infrastructure.adapter.outbound.persistence;

import br.com.all.citizens.domain.serviceRequest.ServiceRequest;
import br.com.all.citizens.domain.serviceRequest.ServiceRequestRepository;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.*;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper.ServiceRequestMapper;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository.JpaServiceRequestRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServiceRequestRepositoryImpl implements ServiceRequestRepository {

    private final JpaServiceRequestRepository repository;

    @PersistenceContext
    private EntityManager em;

    public ServiceRequestRepositoryImpl(JpaServiceRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceRequest save(ServiceRequest serviceRequest) {
        JpaServiceRequestEntity entity = new JpaServiceRequestEntity();
        if (serviceRequest.getId() != null) {
            entity = repository.findById(serviceRequest.getId())
                    .orElseThrow(() -> new IllegalStateException(
                            "Service request row not found for id " + serviceRequest.getId()));
        }

        entity.setTopic(em.getReference(JpaTopicEntity.class, serviceRequest.getTopicId()));
        entity.setSubTopic(em.getReference(JpaSubTopicEntity.class, serviceRequest.getSubTopicId()));
        entity.setDescription(serviceRequest.getDescription());
        entity.setOccurrenceAddress(serviceRequest.getOccurrenceAddress());
        entity.setRequesterPerson(em.getReference(JpaPersonEntity.class, serviceRequest.getRequesterPersonId()));
        entity.setResponsibleUserAccount(
                em.getReference(JpaUserAccountEntity.class, serviceRequest.getResponsibleUserAccountId())
        );
        entity.setOccurrenceAt(serviceRequest.getOccurrenceAt());
        entity.setCreatedAt(serviceRequest.getCreatedAt());
        entity.setUpdatedAt(serviceRequest.getUpdatedAt());

        JpaServiceRequestEntity saved = repository.save(entity);
        return ServiceRequestMapper.toDomain(saved);
    }

    @Override
    public Optional<ServiceRequest> findById(Integer id) {
        return repository.findById(id).map(ServiceRequestMapper::toDomain);
    }
}
