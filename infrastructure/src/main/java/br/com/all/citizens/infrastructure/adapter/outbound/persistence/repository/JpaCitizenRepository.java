package br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository;

import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaCitizenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCitizenRepository extends JpaRepository<JpaCitizenEntity, Integer> {
    Optional<JpaCitizenEntity> findBySocialId(String cpfNumber);
}