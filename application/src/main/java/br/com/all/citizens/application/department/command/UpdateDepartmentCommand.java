package br.com.all.citizens.application.department.command;

public record UpdateDepartmentCommand(
        Integer id,
        String name,
        String description,
        String email,
        String phone,
        boolean active,
        Integer parentDepartmentId
) {}
