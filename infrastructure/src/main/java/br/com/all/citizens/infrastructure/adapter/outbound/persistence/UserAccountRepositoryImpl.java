package br.com.all.citizens.infrastructure.adapter.outbound.persistence;

import br.com.all.citizens.domain.userAccount.UserAccount;
import br.com.all.citizens.domain.userAccount.UserAccountRepository;
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
    public Optional<UserAccount> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<UserAccount> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void InactiveUserAccount(Integer id) {

    }
}
