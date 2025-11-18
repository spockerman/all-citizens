package br.com.all.citizens.domain.exception;

public class EmployeeDocumentNotFoundException extends RuntimeException {
    public EmployeeDocumentNotFoundException(String documento) {
        super("Employee with document " + documento + " not found.");
    }
}