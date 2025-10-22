package br.com.all.citizens.application.department.service;

import br.com.all.citizens.application.department.usecase.DeleteDepartmentUseCase;
import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.domain.department.DepartmentRepository;
import br.com.all.citizens.domain.exception.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeleteDepartmentService implements DeleteDepartmentUseCase {
    private final DepartmentRepository departmentRepository;

    public DeleteDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public void execute(Integer id) {

        Department department = departmentRepository.findById(id).orElseThrow(()-> new DepartmentNotFoundException(id));
        departmentRepository.deleteById(id);


        ;
    }
}
