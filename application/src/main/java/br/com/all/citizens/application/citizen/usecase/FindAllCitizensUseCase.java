package br.com.all.citizens.application.citizen.usecase;

import br.com.all.citizens.domain.citizen.Citizen;

import java.util.List;

public interface FindAllCitizensUseCase {
    List<Citizen> execute();
}