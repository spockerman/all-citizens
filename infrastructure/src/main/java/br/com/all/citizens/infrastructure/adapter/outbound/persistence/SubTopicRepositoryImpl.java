package br.com.all.citizens.infrastructure.adapter.outbound.persistence;

import br.com.all.citizens.domain.subtopic.SubTopic;
import br.com.all.citizens.domain.subtopic.SubTopicRepository;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaSubTopicEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper.SubTopicMapper;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository.JpaSubTopicRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SubTopicRepositoryImpl implements SubTopicRepository {

    private final JpaSubTopicRepository repository;

    public SubTopicRepositoryImpl(JpaSubTopicRepository repository) {
        this.repository = repository;
    }

    @Override
    public SubTopic save(SubTopic subTopic) {
        return SubTopicMapper.toDomain(repository.save(SubTopicMapper.toEntity(subTopic)));
    }

    @Override
    public Optional<SubTopic> findById(Integer id) {
        return repository.findById(id).map(SubTopicMapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubTopic> findAll() {
        List<JpaSubTopicEntity> entities = repository.findAll();

        return entities.stream()
                .map(SubTopicMapper::toDomain)
                .toList();
    }

    @Override
    public List<SubTopic> findByTopicId(Integer topicId) {
        return repository.findByTopic_Id(topicId).stream()
                .map(SubTopicMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubTopic> findByDepartmentId(Integer departmentId) {
        return repository.findByDepartment_Id(departmentId).stream()
                .map(SubTopicMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}