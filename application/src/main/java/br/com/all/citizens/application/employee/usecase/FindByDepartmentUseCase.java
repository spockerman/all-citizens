package br.com.all.citizens.application.employee.usecase;

import br.com.all.citizens.domain.employee.Employee;

public interface FindByDepartmentUseCase {
    Employee execute(String departmentName);
}
