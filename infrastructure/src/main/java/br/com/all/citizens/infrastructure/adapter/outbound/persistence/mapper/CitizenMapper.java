package br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper;

import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaCitizenEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaPersonEntity;

public class CitizenMapper {

    /**
     * Converts a Citizen (domain) to JpaCitizenEntity.
     */
    public static JpaCitizenEntity toEntity(Citizen citizen) {
        if (citizen == null) {
            return null;
        }

        JpaCitizenEntity jpaCitizen = new JpaCitizenEntity();

        // Mapeia a agregação Person do domínio para JPA
        JpaPersonEntity jpaPerson = PersonMapper.toEntity(citizen.getPerson());
        jpaCitizen.setPerson(jpaPerson); // @MapsId usa o id de jpaPerson

        // Se no domínio você já tiver o id da pessoa, o PersonMapper já terá chamado setId()
        // e o JPA vai copiar esse id para a coluna person_id da tabela citizen.

        jpaCitizen.setSocialId(citizen.getSocialId());
        jpaCitizen.setType(citizen.getType());
        jpaCitizen.setCreatedAt(citizen.getCreatedAt());

        // Opcional: se quiser garantir o personId explicitamente
        // (não é obrigatório por causa do @MapsId):
        // if (jpaPerson.getId() != null) {
        //     jpaCitizen.setPersonId(jpaPerson.getId());
        // }

        return jpaCitizen;
    }


    public static Citizen toDomain(JpaCitizenEntity entity) {
        return Citizen.with(
                entity.getPersonId(),
                PersonMapper.toDomain(entity.getPerson()),
                entity.getSocialId(),
                entity.getType(),
                entity.getCreatedAt()
        );
    }
}