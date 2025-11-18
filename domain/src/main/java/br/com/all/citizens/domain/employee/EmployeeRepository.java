package br.com.all.citizens.domain.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee save(Employee employee);
    Optional<Employee> findByDocumentNumber(String documentNumber);
    Optional<Employee> findByDepartment(String departmentName);

}
