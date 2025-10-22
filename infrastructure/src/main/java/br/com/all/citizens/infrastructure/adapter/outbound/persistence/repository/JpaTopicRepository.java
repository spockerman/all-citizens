package br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository;

import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaTopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTopicRepository extends JpaRepository<JpaTopicEntity, Integer> {
}