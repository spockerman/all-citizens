package br.com.all.citizens.application.department.service;

import br.com.all.citizens.application.department.usecase.FindAllDepartmentsUseCase;
import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.domain.department.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FindAllDepartmentService implements FindAllDepartmentsUseCase {

    private final DepartmentRepository departmentRepository;

    public FindAllDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> execute() {
        return departmentRepository.findAll();
    }
}
