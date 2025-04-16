package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

import java.util.List;

public record DepartmentTreeResponse(
        Integer id,
        String name,
        String description,
        String phone,
        String email,
        boolean active,
        List<DepartmentTreeResponse> children
) {}
