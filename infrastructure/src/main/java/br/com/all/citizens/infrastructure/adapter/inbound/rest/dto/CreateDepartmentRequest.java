package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

public record CreateDepartmentRequest(
        String name,
        String description,
        String email,
        String phone,
        boolean active,
        Integer parentDepartmentId
) {}
