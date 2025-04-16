package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

public record DepartmentResponse(
        Integer id,
        String name,
        String description,
        String email,
        String phone,
        boolean active,
        Integer departmentParentId

) { }
