package br.com.all.citizens.application.department.service;

import br.com.all.citizens.application.department.usecase.FindByIdDepartmentUseCase;
import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.domain.department.DepartmentRepository;
import br.com.all.citizens.domain.exception.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FindByIdDepartmentService implements FindByIdDepartmentUseCase {

    private final DepartmentRepository departmentRepository;

    public FindByIdDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public Department execute(Integer id) {
        return departmentRepository.findById(id).orElseThrow(()-> new DepartmentNotFoundException(id));
    }
}
