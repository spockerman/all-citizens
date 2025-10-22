package br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper;

import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaCitizenEntity;

public class CitizenMapper {

    /**
     * Converts a Citizen (domain) to JpaCitizenEntity.
     */
    public static JpaCitizenEntity toEntity(Citizen citizen) {
        JpaCitizenEntity entity = new JpaCitizenEntity();

        entity.setId(citizen.getId());
        entity.setName(citizen.getName());
        entity.setCpf(citizen.getCpf());
        entity.setMobile(citizen.getMobile());
        entity.setEmail(citizen.getEmail());
        entity.setType(citizen.getType());
        entity.setCreatedAt(citizen.getCreatedAt());
        entity.setUpdatedAt(citizen.getUpdatedAt());
        entity.setDeletedAt(citizen.getDeletedAt());

        return entity;
    }

    /**
     * Converts a JpaCitizenEntity to Citizen (domain).
     */
    public static Citizen toDomain(JpaCitizenEntity entity) {
        return Citizen.with(
                entity.getId(),
                entity.getName(),
                entity.getCpf(),
                entity.getMobile(),
                entity.getEmail(),
                entity.getType(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getDeletedAt()
        );
    }
}