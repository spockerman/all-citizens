package br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper;

import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaCitizenEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaPersonEntity;
import jakarta.persistence.EntityManager;

public class CitizenMapper {
    private static EntityManager entityManager;

    public CitizenMapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Converts a Citizen (domain) to JpaCitizenEntity.
     */
    public static JpaCitizenEntity toEntity(Citizen citizen) {
        if (citizen == null) {
            return null;
        }

        JpaCitizenEntity jpaCitizen = new JpaCitizenEntity();
        jpaCitizen.setSocialId(citizen.getSocialId());
        jpaCitizen.setType(citizen.getType());
        jpaCitizen.setCreatedAt(citizen.getCreatedAt());


        return jpaCitizen;
    }


    public static Citizen toDomain(JpaCitizenEntity entity) {
        if (entity == null) {
            return null;
        }
        return Citizen.with(
                entity.getPersonId(),
                entity.getPerson() != null ? PersonMapper.toDomain(entity.getPerson()) : null,
                entity.getSocialId(),
                entity.getType(),
                entity.getCreatedAt()
        );
    }
}