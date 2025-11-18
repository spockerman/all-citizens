package br.com.all.citizens.infrastructure.adapter.outbound.persistence;

import br.com.all.citizens.domain.employee.Employee;
import br.com.all.citizens.domain.employee.EmployeeRepository;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper.EmployeeMapper;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository.JpaEmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JpaEmployeeRepository repositoy;

    public EmployeeRepositoryImpl(JpaEmployeeRepository repositoy) {
        this.repositoy = repositoy;
    }

    @Override
    public Employee save(Employee employee) {
        return EmployeeMapper.toDomain(repositoy.save(EmployeeMapper.toEntity(employee)));
    }

    @Override
    public Optional<Employee> findByDocumentNumber(String documentNumber) {
        return repositoy.findByDocumentNumber(documentNumber).map(EmployeeMapper::toDomain);
    }

    @Override
    public Optional<Employee> findByDepartment(String departmentName) {
        return repositoy.findByDepartment(departmentName).map(EmployeeMapper::toDomain);
    }
}
