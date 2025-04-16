package br.com.all.citizens.application.department.service;

import br.com.all.citizens.application.department.usecase.CreateDepartmentUseCase;
import br.com.all.citizens.application.department.command.CreateDepartmentCommand;
import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.domain.department.DepartmentRepository;
import br.com.all.citizens.domain.exception.DepartmentNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateDepartmentService implements CreateDepartmentUseCase {

    private final DepartmentRepository repository;

    public CreateDepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Integer execute(CreateDepartmentCommand command) {
        Department parent = null;
        if(command.parentDepartmentId() != null){
            parent = repository.findById(command.parentDepartmentId())
                    .orElseThrow(()-> new DepartmentNotFoundException(command.parentDepartmentId()));
        }
        Department department = Department.newDepartment(
                command.name(),
                command.description(),
                command.email(),
                command.phone(),
                command.active(),
                (parent != null ? parent.getId() : null) != null ? parent.getId() : null
        );
        Department saved = repository.save(department);
        return saved.getId();
    }
}
