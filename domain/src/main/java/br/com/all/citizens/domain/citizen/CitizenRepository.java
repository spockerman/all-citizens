package br.com.all.citizens.domain.citizen;

import java.util.Optional;

public interface CitizenRepository {
    Citizen save(Citizen citizen);
    Optional<Citizen> findById(Integer id);
    Optional<Citizen> findBySocialId(String socialId);

}