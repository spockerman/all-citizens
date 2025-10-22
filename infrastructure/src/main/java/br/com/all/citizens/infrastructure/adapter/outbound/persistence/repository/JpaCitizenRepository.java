package br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository;

import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaCitizenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCitizenRepository extends JpaRepository<JpaCitizenEntity, Integer> {
}