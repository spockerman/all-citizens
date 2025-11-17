package br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository;

import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaPersonEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaUserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserAccountRepository extends JpaRepository<JpaUserAccountEntity, Integer> {
    Optional<JpaUserAccountEntity> findByPerson(JpaPersonEntity person);
    Optional<JpaUserAccountEntity> findByEmail(String email);
    Optional<JpaUserAccountEntity> findByMobile(String mobile);
    void InactiveUserAccount(Integer id);
}
