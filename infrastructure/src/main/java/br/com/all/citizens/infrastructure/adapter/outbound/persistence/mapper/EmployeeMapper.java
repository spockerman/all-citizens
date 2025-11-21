package br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper;

import br.com.all.citizens.domain.employee.Employee;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaEmployeeEntity;

public class EmployeeMapper {

    private EmployeeMapper() {
        // utility class
    }

    public static JpaEmployeeEntity toEntity(Employee employee) {
        if (employee == null) {
            return null;
        }

        JpaEmployeeEntity jpaEmployee = new JpaEmployeeEntity();

        jpaEmployee.setDocumentNumber(employee.getDocumentNumber());
        jpaEmployee.setPositionTitle(employee.getPositionTitle());
        jpaEmployee.setCreatedAt(employee.getCreatedAt());

        return jpaEmployee;
    }

    public static Employee toDomain(JpaEmployeeEntity entity) {
        if (entity == null) {
            return null;
        }

        return Employee.with(
                entity.getPersonId(),
                entity.getPerson() != null ? PersonMapper.toDomain(entity.getPerson()) : null,
                entity.getDepartment() != null ? DepartmentMapper.toDomain(entity.getDepartment()) : null,
                entity.getDocumentNumber(),
                entity.getPositionTitle(),
                entity.getCreatedAt()
        );
    }
}
