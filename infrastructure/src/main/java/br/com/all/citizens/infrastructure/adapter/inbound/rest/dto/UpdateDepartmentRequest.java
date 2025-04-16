package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

public record UpdateDepartmentRequest(
        Integer id,
        String name,
        String description,
        String email,
        String phone,
        boolean active,
        Integer parentDepartmentId
) {}
