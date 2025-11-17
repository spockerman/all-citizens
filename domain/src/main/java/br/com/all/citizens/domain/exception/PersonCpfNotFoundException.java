package br.com.all.citizens.domain.exception;

public class PersonCpfNotFoundException extends RuntimeException {
    public PersonCpfNotFoundException(String cpf) {
        super("Person with CPF " + cpf + " not found.");
    }
}