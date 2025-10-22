package br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository;

import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaDepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaDepartmentRepository extends JpaRepository<JpaDepartmentEntity, Integer> {

    List<JpaDepartmentEntity> findByParentDepartment_Id(Integer parentId);

}
