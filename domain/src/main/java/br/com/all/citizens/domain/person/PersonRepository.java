package br.com.all.citizens.domain.person;

import java.util.Optional;

public interface PersonRepository {
    Person save(Person person);
    Optional<Person> findById(Integer id);
    void deleteById(Integer id);
    Optional<Person> findByCpf(String cpf);
    Optional<Person> findByFullName(String fullName);
}
