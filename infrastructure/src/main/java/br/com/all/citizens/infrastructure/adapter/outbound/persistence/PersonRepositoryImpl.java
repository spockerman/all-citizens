package br.com.all.citizens.infrastructure.adapter.outbound.persistence;

import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.person.PersonRepository;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper.PersonMapper;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository.JpaPersonRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonRepositoryImpl implements PersonRepository {

    private final JpaPersonRepository repository;

    public PersonRepositoryImpl(JpaPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person save(Person person) {

        return PersonMapper.toDomain(repository.save(PersonMapper.toEntity(person)));
    }

    @Override
    public Optional<Person> findById(Integer id) {
        return repository.findById(id).map(PersonMapper::toDomain);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Person> findByCpf(String cpf) {
        return repository
                .findByCpfNumber(cpf)
                .map(PersonMapper::toDomain);
    }

    @Override
    public Optional<Person> findByFullName(String fullName) {
        return repository
                .findByFullName(fullName)
                .map(PersonMapper::toDomain);
    }
}
