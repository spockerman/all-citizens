package br.com.all.citizens.domain.userAccount;

import java.util.Optional;

public interface UserAccountRepository {
    UserAccount save(UserAccount userAccount);
    Optional<UserAccount> findByUsername(String username);
    Optional<UserAccount> findByEmail(String email);
    Optional<UserAccount> findById(Integer id);
    void InactiveUserAccount(Integer id);
}
