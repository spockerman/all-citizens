package br.com.all.citizens.application.department.usecase;

import br.com.all.citizens.domain.department.Department;

import java.util.List;

public interface FindAllDepartmentsUseCase {
    List<Department> execute();
}
