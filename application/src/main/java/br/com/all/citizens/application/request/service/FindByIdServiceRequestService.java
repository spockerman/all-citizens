package br.com.all.citizens.application.request.service;

import br.com.all.citizens.application.request.usecase.FindByIdServiceRequestUseCase;
import br.com.all.citizens.domain.exception.ServiceRequestNotFoundException;
import br.com.all.citizens.domain.serviceRequest.ServiceRequest;
import br.com.all.citizens.domain.serviceRequest.ServiceRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindByIdServiceRequestService implements FindByIdServiceRequestUseCase {

    private final ServiceRequestRepository serviceRequestRepository;

    public FindByIdServiceRequestService(ServiceRequestRepository serviceRequestRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ServiceRequest execute(Integer id) {
        return serviceRequestRepository.findById(id)
                .orElseThrow(() -> new ServiceRequestNotFoundException(id));
    }
}
