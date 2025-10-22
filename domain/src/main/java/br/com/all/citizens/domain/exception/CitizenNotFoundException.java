package br.com.all.citizens.domain.exception;

public class CitizenNotFoundException extends RuntimeException {
    public CitizenNotFoundException(Integer id) {
        super("Citizen with id " + id + " not found.");
    }
}