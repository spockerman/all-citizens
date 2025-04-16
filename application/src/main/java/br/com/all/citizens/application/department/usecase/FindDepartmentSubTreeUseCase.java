package br.com.all.citizens.application.department.usecase;

import java.util.Optional;

import br.com.all.citizens.application.department.command.DepartmentTreeCommand;

public interface FindDepartmentSubTreeUseCase {
    Optional<DepartmentTreeCommand> execute(Integer rootId);
}