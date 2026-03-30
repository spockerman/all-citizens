package br.com.all.citizens.domain.serviceRequest;

import java.util.Optional;

public interface ServiceRequestRepository {
    ServiceRequest save(ServiceRequest serviceRequest);
    Optional<ServiceRequest> findById(Integer id);
}
