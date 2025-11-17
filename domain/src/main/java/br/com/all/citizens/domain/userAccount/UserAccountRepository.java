package br.com.all.citizens.domain.userAccount;

import br.com.all.citizens.domain.person.Person;

import java.util.Optional;

public interface UserAccountRepository {
    UserAccount save(UserAccount userAccount);
    Optional<UserAccount> findByPerson(Person person);
    Optional<UserAccount> findByEmail(String email);
    Optional<UserAccount> findByMobile(String mobile);
    Optional<UserAccount> findById(Integer id);
    void InactiveUserAccount(Integer id);
}
