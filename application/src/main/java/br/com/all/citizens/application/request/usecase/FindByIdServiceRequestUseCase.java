package br.com.all.citizens.application.request.usecase;

import br.com.all.citizens.domain.serviceRequest.ServiceRequest;

public interface FindByIdServiceRequestUseCase {
    ServiceRequest execute(Integer id);
}
