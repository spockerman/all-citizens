package br.com.all.citizens.application.employee.service;

import br.com.all.citizens.application.employee.usecase.FindByDepartmentUseCase;
import br.com.all.citizens.domain.employee.Employee;
import br.com.all.citizens.domain.employee.EmployeeRepository;
import br.com.all.citizens.domain.exception.EmployeeDocumentNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FindByDepartmentService implements FindByDepartmentUseCase {

    private final EmployeeRepository repository;

    public FindByDepartmentService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Employee execute(String departmentName) {
        return repository.findByDepartment(departmentName)
                .orElseThrow(()->new EmployeeDocumentNotFoundException(departmentName));
    }
}
