package br.com.all.citizens.domain.exception;

public class ServiceRequestNotFoundException extends RuntimeException {
    public ServiceRequestNotFoundException(Integer id) {
        super("Service request with id " + id + " not found.");
    }
}
