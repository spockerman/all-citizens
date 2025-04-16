package br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper;

import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaDepartmentEntity;

public class DepartmentMapper {

    /**
     * Converte um Department (domínio) em JpaDepartmentEntity simples.
     * Para uso direto em entidades planas (sem hierarquia).
     */
    public static JpaDepartmentEntity toEntity(Department department) {
        JpaDepartmentEntity entity = new JpaDepartmentEntity();

        entity.setId(department.getId());
        entity.setName(department.getName());
        entity.setDescription(department.getDescription());
        entity.setPhone(department.getPhone());
        entity.setEmail(department.getEmail());
        entity.setActive(department.isActive());
        entity.setCreatedAt(department.getCreatedAt());
        entity.setUpdatedAt(department.getUpdatedAt());
        entity.setDeletedAt(department.getDeletedAt());

        if(department.getParentDepartmentId() != null){
            JpaDepartmentEntity parent = new JpaDepartmentEntity();
            parent.setId(department.getParentDepartmentId());
            entity.setParentDepartment(parent);
        }


        return entity;
    }


    /**
     * Converte um JpaDepartmentEntity em Department (domínio).
     * Subdepartamentos são inicializados como lista vazia e preenchidos depois.
     */
    public static Department toDomain(JpaDepartmentEntity entity) {
        return Department.with(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPhone(),
                entity.getEmail(),
                entity.isActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getDeletedAt(),
                entity.getParentDepartment() != null ? entity.getParentDepartment().getId() : null
        );
    }



}
