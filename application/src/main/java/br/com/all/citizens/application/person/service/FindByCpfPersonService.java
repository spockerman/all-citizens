package br.com.all.citizens.application.person.service;

import br.com.all.citizens.application.person.usecase.FindByCpfPersonUseCase;
import br.com.all.citizens.domain.exception.PersonCpfNotFoundException;
import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindByCpfPersonService implements FindByCpfPersonUseCase {
    private final PersonRepository repository;

    public FindByCpfPersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Person execute(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new PersonCpfNotFoundException(cpf));
    }
}
