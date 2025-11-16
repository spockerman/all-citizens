package br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository;

import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaEmployeeRepository extends JpaRepository<JpaEmployeeEntity, Integer> {
    Optional<JpaEmployeeEntity> findByDocumentNumber(String documentNumber);
    Optional<JpaEmployeeEntity> findByDepartmentId(Integer departmentId);

}
