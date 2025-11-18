package br.com.all.citizens.application.employee.service;

import br.com.all.citizens.application.employee.usecase.FindByDocumentUseCase;
import br.com.all.citizens.domain.employee.Employee;
import br.com.all.citizens.domain.employee.EmployeeRepository;
import br.com.all.citizens.domain.exception.EmployeeDocumentNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class FindByDocumentService implements FindByDocumentUseCase {

    private final EmployeeRepository repository;

    public FindByDocumentService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Employee execute(String documentNumber) {
        return repository.findByDocumentNumber(documentNumber)
                        .orElseThrow(()-> new EmployeeDocumentNotFoundException(documentNumber));
    }
}
