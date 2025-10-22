package br.com.all.citizens.domain.citizen;

import java.util.List;
import java.util.Optional;

public interface CitizenRepository {
    Citizen save(Citizen citizen);
    Optional<Citizen> findById(Integer id);
    List<Citizen> findAll();
    void deleteById(Integer id);
}