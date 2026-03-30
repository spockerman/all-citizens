package br.com.all.citizens.application.request.service;

import br.com.all.citizens.application.request.ServiceRequestRelationValidator;
import br.com.all.citizens.application.request.command.CreateServiceRequestCommand;
import br.com.all.citizens.application.request.usecase.CreateServiceRequestUseCase;
import br.com.all.citizens.domain.serviceRequest.ServiceRequest;
import br.com.all.citizens.domain.serviceRequest.ServiceRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class CreateServiceRequestService implements CreateServiceRequestUseCase {

    private final ServiceRequestRepository serviceRequestRepository;
    private final ServiceRequestRelationValidator relationValidator;

    public CreateServiceRequestService(
            ServiceRequestRepository serviceRequestRepository,
            ServiceRequestRelationValidator relationValidator
    ) {
        this.serviceRequestRepository = serviceRequestRepository;
        this.relationValidator = relationValidator;
    }

    @Override
    @Transactional
    public Integer execute(CreateServiceRequestCommand command) {
        relationValidator.validate(
                command.topicId(),
                command.subTopicId(),
                command.requesterPersonId(),
                command.responsibleUserAccountId()
        );

        Instant now = Instant.now();
        ServiceRequest created = ServiceRequest.newRequest(
                command.topicId(),
                command.subTopicId(),
                command.description(),
                command.occurrenceAddress(),
                command.requesterPersonId(),
                command.responsibleUserAccountId(),
                command.occurrenceAt(),
                now
        );

        return serviceRequestRepository.save(created).getId();
    }
}
