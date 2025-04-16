package br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository;

import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaDepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaDepartmentRepository extends JpaRepository<JpaDepartmentEntity, Integer> {

    @Query("SELECT d FROM JpaDepartmentEntity d LEFT JOIN FETCH d.parentDepartment")
    List<JpaDepartmentEntity> findAllWithParents();

    List<JpaDepartmentEntity> findByParentDepartment_Id(Integer parentId);

}
