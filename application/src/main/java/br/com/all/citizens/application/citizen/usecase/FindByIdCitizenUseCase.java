package br.com.all.citizens.application.citizen.usecase;

import br.com.all.citizens.domain.citizen.Citizen;

public interface FindByIdCitizenUseCase {
    Citizen execute(Integer id);
}