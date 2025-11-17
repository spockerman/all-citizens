package br.com.all.citizens.domain.exception;

public class PersonFullNameNotFoundException extends RuntimeException {
    public PersonFullNameNotFoundException(String name) {
        super("Person with name " + name + " not found.");
    }
}