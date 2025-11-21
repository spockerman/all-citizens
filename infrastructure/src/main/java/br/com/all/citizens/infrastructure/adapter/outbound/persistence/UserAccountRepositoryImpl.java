package br.com.all.citizens.infrastructure.adapter.outbound.persistence;

import br.com.all.citizens.domain.person.Person;
import br.com.all.citizens.domain.userAccount.UserAccount;
import br.com.all.citizens.domain.userAccount.UserAccountRepository;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper.PersonMapper;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper.UserAccountMapper;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository.JpaUserAccountRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAccountRepositoryImpl implements UserAccountRepository {

    private final JpaUserAccountRepository repository;

    public UserAccountRepositoryImpl(JpaUserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return UserAccountMapper.toDomain(
                repository.save(
                        UserAccountMapper.toEntity(userAccount)
                )
        );

    }

    @Override
    public Optional<UserAccount> findByPerson(Person person) {

        return repository.findByPerson(PersonMapper.toEntity(person)).map(UserAccountMapper::toDomain);
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {

        return repository.findByEmail(email).map(UserAccountMapper::toDomain);
    }

    @Override
    public Optional<UserAccount> findByMobile(String mobile) {
        return repository.findByMobile(mobile).map(UserAccountMapper::toDomain);
    }

    @Override
    public Optional<UserAccount> findById(Integer id) {

        return repository.findById(id).map(UserAccountMapper::toDomain);
    }

}
