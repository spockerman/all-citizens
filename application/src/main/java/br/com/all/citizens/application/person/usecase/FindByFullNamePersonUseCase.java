package br.com.all.citizens.application.person.usecase;

import br.com.all.citizens.domain.person.Person;

public interface FindByFullNamePersonUseCase {
    Person execute(String fullName);
}
