package br.com.all.citizens.application.department.command;

import java.util.List;

public record DepartmentTreeCommand(
        Integer id,
        String name,
        String description,
        String phone,
        String email,
        boolean active,
        List<DepartmentTreeCommand> children
) { }
