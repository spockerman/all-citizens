package br.com.all.citizens.application.department.service;

import br.com.all.citizens.application.department.usecase.DeleteDepartmentUseCase;
import br.com.all.citizens.domain.department.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteDepartmentService implements DeleteDepartmentUseCase {
    private final DepartmentRepository departmentRepository;

    public DeleteDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public void execute(Integer id) {
        departmentRepository.deleteById(id);
    }
}
