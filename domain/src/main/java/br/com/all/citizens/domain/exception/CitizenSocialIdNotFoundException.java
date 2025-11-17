package br.com.all.citizens.domain.exception;

public class CitizenSocialIdNotFoundException extends RuntimeException {
    public CitizenSocialIdNotFoundException(String id) {
        super("Citizen with document " + id + " not found.");
    }
}