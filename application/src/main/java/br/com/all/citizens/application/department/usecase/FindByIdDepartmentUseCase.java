package br.com.all.citizens.application.department.usecase;

import br.com.all.citizens.domain.department.Department;

public interface FindByIdDepartmentUseCase {
    Department execute(Integer id);
}
