package br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper;

import br.com.all.citizens.application.department.command.DepartmentTreeCommand;
import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.DepartmentResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.DepartmentTreeResponse;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentMapper {
    public static DepartmentResponse toResponse(Department d) {
        return new DepartmentResponse(
                d.getId(),
                d.getName(),
                d.getDescription(),
                d.getEmail(),
                d.getPhone(),
                d.isActive(),
                d.getParentDepartmentId()
        );
    }
    public static DepartmentTreeResponse toResponse(DepartmentTreeCommand command) {
        List<DepartmentTreeResponse> children = command.children() != null
                ? command.children().stream()
                .map(DepartmentMapper::toResponse)
                .collect(Collectors.toList())
                : List.of();

        return new DepartmentTreeResponse(
                command.id(),
                command.name(),
                command.description(),
                command.phone(),
                command.email(),
                command.active(),
                children
        );
    }
}
