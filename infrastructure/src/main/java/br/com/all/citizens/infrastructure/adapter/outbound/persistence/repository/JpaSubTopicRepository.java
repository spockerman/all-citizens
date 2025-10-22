package br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository;

import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaSubTopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaSubTopicRepository extends JpaRepository<JpaSubTopicEntity, Integer> {
    List<JpaSubTopicEntity> findByTopic_Id(Integer topicId);
    List<JpaSubTopicEntity> findByDepartment_Id(Integer departmentId);
}