package br.com.all.citizens.infrastructure.adapter.outbound.persistence;

import br.com.all.citizens.domain.department.Department;
import br.com.all.citizens.domain.department.DepartmentRepository;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaDepartmentEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper.DepartmentMapper;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository.JpaDepartmentRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final JpaDepartmentRepository repository;

    public DepartmentRepositoryImpl(JpaDepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Department save(Department department) {
        return DepartmentMapper.toDomain(repository.save(DepartmentMapper.toEntity(department)));
    }

    @Override
    public Optional<Department> findById(Integer id) {
        return repository.findById(id).map(DepartmentMapper::toDomain);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Department> findAll() {
        List<JpaDepartmentEntity> entities = repository.findAll();

        return entities.stream()
                .map(DepartmentMapper::toDomain)
                .toList();
    }


    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Department> findByParentDepartmentId(Integer parentId) {
        return repository.findByParentDepartment_Id(parentId).stream()
                .map(DepartmentMapper::toDomain)
                .collect(Collectors.toList());
    }


}
