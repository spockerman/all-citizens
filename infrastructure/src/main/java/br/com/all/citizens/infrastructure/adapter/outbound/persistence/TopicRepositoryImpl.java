package br.com.all.citizens.infrastructure.adapter.outbound.persistence;

import br.com.all.citizens.domain.topic.Topic;
import br.com.all.citizens.domain.topic.TopicRepository;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity.JpaTopicEntity;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.mapper.TopicMapper;
import br.com.all.citizens.infrastructure.adapter.outbound.persistence.repository.JpaTopicRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TopicRepositoryImpl implements TopicRepository {

    private final JpaTopicRepository repository;

    public TopicRepositoryImpl(JpaTopicRepository repository) {
        this.repository = repository;
    }

    @Override
    public Topic save(Topic topic) {
        return TopicMapper.toDomain(repository.save(TopicMapper.toEntity(topic)));
    }

    @Override
    public Optional<Topic> findById(Integer id) {
        return repository.findById(id).map(TopicMapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Topic> findAll() {
        List<JpaTopicEntity> entities = repository.findAll();

        return entities.stream()
                .map(TopicMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}