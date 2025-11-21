package br.com.all.citizens.infrastructure.adapter.outbound.persistence;

import br.com.all.citizens.domain.employee.Employee;
import br.com.all.citizens.domain.employee.EmployeeRepository;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaDepartmentEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaEmployeeEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaPersonEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper.EmployeeMapper;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository.JpaEmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JpaEmployeeRepository repository;

    @PersistenceContext
    private EntityManager em;

    public EmployeeRepositoryImpl(JpaEmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {

        if (employee.getPerson() == null || employee.getPerson().getId() == null) {
            throw new IllegalStateException("Employee.save: person or person.id is null");
        }
        if (employee.getDepartment() == null || employee.getDepartment().getId() == null) {
            throw new IllegalStateException("Employee.save: department or department.id is null");
        }

        JpaEmployeeEntity entity = EmployeeMapper.toEntity(employee);

        // Referência gerenciada para Person (já existente)
        JpaPersonEntity personRef = em.getReference(
                JpaPersonEntity.class,
                employee.getPerson().getId()
        );
        entity.setPerson(personRef); // @MapsId -> person.id será usado como personId

        // Referência gerenciada para Department (já existente)
        JpaDepartmentEntity deptRef = em.getReference(
                JpaDepartmentEntity.class,
                employee.getDepartment().getId()
        );
        entity.setDepartment(deptRef);

        JpaEmployeeEntity saved = repository.save(entity);
        return EmployeeMapper.toDomain(saved);
    }


    @Override
    public Optional<Employee> findByDocumentNumber(String documentNumber) {
        return repository.findByDocumentNumber(documentNumber).map(EmployeeMapper::toDomain);
    }

    @Override
    public Optional<Employee> findByDepartment(String departmentName) {
        return repository.findByDepartment_Name(departmentName).map(EmployeeMapper::toDomain);
    }
}
