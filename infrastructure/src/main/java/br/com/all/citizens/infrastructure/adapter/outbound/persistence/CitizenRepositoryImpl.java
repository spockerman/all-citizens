package br.com.all.citizens.infrastructure.adapter.outbound.persistence;

import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.domain.citizen.CitizenRepository;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaCitizenEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaPersonEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper.CitizenMapper;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository.JpaCitizenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CitizenRepositoryImpl implements CitizenRepository {

    private final JpaCitizenRepository repository;

    @PersistenceContext
    private EntityManager em;

    public CitizenRepositoryImpl(JpaCitizenRepository repository) {
        this.repository = repository;
    }

    @Override
    public Citizen save(Citizen citizen) {
        if(citizen.getPerson() == null || citizen.getPerson().getId() == null){
            throw new IllegalStateException("Citizen.save: person or person.id is null");
        }

        JpaCitizenEntity entity = CitizenMapper.toEntity(citizen);
        JpaPersonEntity personRef = em.getReference(
                JpaPersonEntity.class,
                citizen.getPerson().getId()
        );
        entity.setPerson(personRef);
        JpaCitizenEntity saved = repository.save(entity);

        return CitizenMapper.toDomain(saved);
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