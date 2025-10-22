package br.com.all.citizens.application.topic.service;

import br.com.all.citizens.application.topic.command.UpdateTopicCommand;
import br.com.all.citizens.application.topic.usecase.UpdateTopicUseCase;
import br.com.all.citizens.domain.exception.TopicNotFoundException;
import br.com.all.citizens.domain.topic.Topic;
import br.com.all.citizens.domain.topic.TopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class UpdateTopicService implements UpdateTopicUseCase {

    private final TopicRepository repository;

    public UpdateTopicService(TopicRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void execute(UpdateTopicCommand command) {
        Topic existingTopic = repository.findById(command.id())
                .orElseThrow(() -> new TopicNotFoundException(command.id()));

        Topic updatedTopic = Topic.with(
                existingTopic.getId(),
                command.description(),
                command.active(),
                existingTopic.getCreatedAt(),
                Instant.now(),
                existingTopic.getDeletedAt()
        );

        repository.save(updatedTopic);
    }
}