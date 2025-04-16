package br.com.all.citizens.application.department.service;

import br.com.all.citizens.application.department.command.DepartmentTreeCommand;
import br.com.all.citizens.application.department.usecase.FindDepartmentSubTreeUseCase;
import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.domain.department.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FindDepartmentSubTreeService implements FindDepartmentSubTreeUseCase {

    private final DepartmentRepository departmentRepository;

    public FindDepartmentSubTreeService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public Optional<DepartmentTreeCommand> execute(Integer rootId) {
        return departmentRepository.findById(rootId).map(this::buildTree);
    }

    private DepartmentTreeCommand buildTree(Department department) {
        List<Department> children = departmentRepository.findByParentDepartmentId(department.getId());

        List<DepartmentTreeCommand> childrenResponses = children.stream()
                .map(this::buildTree)
                .collect(Collectors.toList());

        return new DepartmentTreeCommand(
                department.getId(),
                department.getName(),
                department.getDescription(),
                department.getPhone(),
                department.getEmail(),
                department.isActive(),
                childrenResponses
        );
    }
}
