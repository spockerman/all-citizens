package br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository;

import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaServiceRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaServiceRequestRepository extends JpaRepository<JpaServiceRequestEntity, Integer> {
}
