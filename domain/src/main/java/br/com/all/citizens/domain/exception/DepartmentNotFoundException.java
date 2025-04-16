package br.com.all.citizens.domain.exception;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(Integer id) {
        super("Department with id " + id + " not found.");
    }
}
