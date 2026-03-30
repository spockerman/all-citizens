package br.com.all.citizens.application.request.service;

import br.com.all.citizens.application.request.ServiceRequestRelationValidator;
import br.com.all.citizens.application.request.command.UpdateServiceRequestCommand;
import br.com.all.citizens.application.request.usecase.UpdateServiceRequestUseCase;
import br.com.all.citizens.domain.exception.ServiceRequestNotFoundException;
import br.com.all.citizens.domain.serviceRequest.ServiceRequest;
import br.com.all.citizens.domain.serviceRequest.ServiceRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class UpdateServiceRequestService implements UpdateServiceRequestUseCase {

    private final ServiceRequestRepository serviceRequestRepository;
    private final ServiceRequestRelationValidator relationValidator;

    public UpdateServiceRequestService(
            ServiceRequestRepository serviceRequestRepository,
            ServiceRequestRelationValidator relationValidator
    ) {
        this.serviceRequestRepository = serviceRequestRepository;
        this.relationValidator = relationValidator;
    }

    @Override
    @Transactional
    public void execute(UpdateServiceRequestCommand command) {
        ServiceRequest existing = serviceRequestRepository.findById(command.id())
                .orElseThrow(() -> new ServiceRequestNotFoundException(command.id()));

        relationValidator.validate(
                command.topicId(),
                command.subTopicId(),
                command.requesterPersonId(),
                command.responsibleUserAccountId()
        );

        ServiceRequest updated = ServiceRequest.with(
                existing.getId(),
                command.topicId(),
                command.subTopicId(),
                command.description(),
                command.occurrenceAddress(),
                command.requesterPersonId(),
                command.responsibleUserAccountId(),
                command.occurrenceAt(),
                existing.getCreatedAt(),
                Instant.now()
        );

        serviceRequestRepository.save(updated);
    }
}
