package br.com.all.citizens.application.department.command;

public record CreateDepartmentCommand(
        String name,
        String description,
        String email,
        String phone,
        boolean active,
        Integer parentDepartmentId
) {}
