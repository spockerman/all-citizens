package br.com.all.citizens.domain.department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository {
    Department save(Department department);
    Optional<Department> findById(Integer id);
    List<Department> findAll();
    void deleteById(Integer id);
    List<Department> findByParentDepartmentId(Integer parentId);


}