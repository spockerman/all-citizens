package br.com.all.citizens.application.department.service;

import br.com.all.citizens.application.department.command.UpdateDepartmentCommand;
import br.com.all.citizens.application.department.usecase.UpdateDepartmentUseCase;
import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.domain.department.DepartmentRepository;
import br.com.all.citizens.domain.exception.DepartmentNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class UpdateDepartmentService  implements UpdateDepartmentUseCase {
    private final DepartmentRepository departmentRepository;

    public UpdateDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Transactional
    public void execute(UpdateDepartmentCommand command) {
        Department existing = departmentRepository.
                findById(command.id()).orElseThrow(()-> new DepartmentNotFoundException(command.id()));

        Department parent = null;
        if (command.parentDepartmentId() != null) {
            parent = departmentRepository.findById(command.parentDepartmentId())
                    .orElseThrow(() -> new DepartmentNotFoundException(command.parentDepartmentId()));
        }
        Department update = Department.with(
                existing.getId(),
                command.name(),
                command.description(),
                command.email(),
                command.phone(),
                command.active(),
                existing.getCreatedAt(),
                Instant.now(),
                existing.getDeletedAt(),
                existing.getParentDepartmentId()
        );

        departmentRepository.save(update);
    }
}
