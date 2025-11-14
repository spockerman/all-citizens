package br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper;

import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaPersonEntity;

import java.time.Instant;
import java.time.LocalDate;

public class PersonMapper {

    public static JpaPersonEntity toEntity(Person entity) {
        JpaPersonEntity jpaEntity = new JpaPersonEntity();

        jpaEntity.setId(entity.getId());
        jpaEntity.setFullName(entity.getFullName());
        jpaEntity.setCpfNumber(entity.getCpfNumber());
        jpaEntity.setBirthDate(entity.getBirthDate());
        jpaEntity.setCreatedAt(entity.getCreatedAt());
        jpaEntity.setUpdateAt(entity.getUpdatedAt());
        jpaEntity.setDeleteAt(entity.getDeletedAt());

        return jpaEntity;
    }

    public static Person toDomain(JpaPersonEntity entity) {
        return Person.with(
                entity.getId(),
                entity.getFullName(),
                entity.getCpfNumber(),
                entity.getBirthDate(),
                entity.getCreatedAt(),
                entity.getUpdateAt(),
                entity.getDeleteAt()
        );
    }
}
