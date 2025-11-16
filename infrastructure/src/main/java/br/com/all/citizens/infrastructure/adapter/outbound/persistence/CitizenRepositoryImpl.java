package br.com.all.citizens.infrastructure.adapter.outbound.persistence;

import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.domain.citizen.CitizenRepository;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper.CitizenMapper;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository.JpaCitizenRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CitizenRepositoryImpl implements CitizenRepository {

    private final JpaCitizenRepository repository;

    public CitizenRepositoryImpl(JpaCitizenRepository repository) {
        this.repository = repository;
    }

    @Override
    public Citizen save(Citizen citizen) {
        return CitizenMapper.toDomain(repository.save(CitizenMapper.toEntity(citizen)));
    }

    @Override
    public Optional<Citizen> findById(Integer id) {
        return repository.findById(id).map(CitizenMapper::toDomain);
    }

    @Override
    public Optional<Citizen> findBySocialId(String socialId) {
        return repository.findBySocialId(socialId).map(CitizenMapper::toDomain);
    }
}