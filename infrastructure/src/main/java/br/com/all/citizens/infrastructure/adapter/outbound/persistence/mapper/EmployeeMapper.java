package br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper;

import br.com.all.citizens.domain.employee.Employee;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaDepartmentEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaEmployeeEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaPersonEntity;

public class EmployeeMapper {

    public static JpaEmployeeEntity toEntity(Employee employee) {
        if (employee == null) {
            return null;
        }

        JpaEmployeeEntity jpaEmployee = new JpaEmployeeEntity();

        // Mapeia a agregação Person do domínio para JPA
        JpaPersonEntity jpaPerson = PersonMapper.toEntity(employee.getPerson());
        jpaEmployee.setPerson(jpaPerson); // @MapsId usa o id de jpaPerson


        // Se no domínio você já tiver o id da pessoa, o PersonMapper já terá chamado setId()
        // e o JPA vai copiar esse id para a coluna person_id da tabela citizen.
        JpaDepartmentEntity department = DepartmentMapper.toEntity(employee.getDepartment());
        jpaEmployee.setDepartment(department);
        jpaEmployee.setDocumentNumber(employee.getDocumentNumber());
        jpaEmployee.setCreatedAt(employee.getCreatedAt());


        return jpaEmployee;
    }


    public static Employee toDomain(JpaEmployeeEntity entity) {
        return Employee.with(
                entity.getPersonId(),
                PersonMapper.toDomain(entity.getPerson()),
                DepartmentMapper.toDomain(entity.getDepartment()),
                entity.getDocumentNumber(),
                entity.getCreatedAt()
        );
    }
}