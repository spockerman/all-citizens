package br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper;

import br.com.all.citizens.domain.userAccount.UserAccount;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaPersonEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaUserAccountEntity;
import jakarta.persistence.EntityManager;

public class UserAccountMapper {

    private static EntityManager entityManager;

    public UserAccountMapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static JpaUserAccountEntity toEntity(UserAccount userAccount) {
        if (userAccount == null) {
            return null;
        }

        JpaUserAccountEntity entity = new JpaUserAccountEntity();

        // Obtain a reference to existing Person (avoids SELECT)
        JpaPersonEntity personRef = entityManager.getReference(
                JpaPersonEntity.class,
                userAccount.getPersonId()
        );
        entity.setPerson(personRef);

        entity.setId(userAccount.getId());
        entity.setEmail(userAccount.getEmail());
        entity.setMobile(userAccount.getMobile());
        entity.setAuthProvider(userAccount.getAuthProvider());
        entity.setAuthSubject(userAccount.getAuthSubject());
        entity.setActive(userAccount.isActive());

        return entity;

    }

    public static UserAccount toDomain(JpaUserAccountEntity entity) {
        return UserAccount.with(
                entity.getId(),
                entity.getPerson().getId(),
                entity.getAuthProvider(),
                entity.getAuthSubject(),
                entity.getMobile(),
                entity.getEmail(),
                entity.isActive()
        );
    }
}
