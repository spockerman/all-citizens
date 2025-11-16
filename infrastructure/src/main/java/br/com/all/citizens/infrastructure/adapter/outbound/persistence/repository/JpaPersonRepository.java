package br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository;

import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JpaPersonRepository extends JpaRepository<JpaPersonEntity, Integer> {
    Optional<JpaPersonEntity> findByCpfNumber(String cpfNumber);

    Optional<JpaPersonEntity> findByFullName(String fullName);
}
