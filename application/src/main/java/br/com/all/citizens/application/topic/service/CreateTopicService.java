package br.com.all.citizens.application.topic.service;

import br.com.all.citizens.application.topic.usecase.CreateTopicUseCase;
import br.com.all.citizens.application.topic.command.CreateTopicCommand;
import br.com.all.citizens.domain.topic.Topic;
import br.com.all.citizens.domain.topic.TopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateTopicService implements CreateTopicUseCase {

    private final TopicRepository repository;

    public CreateTopicService(TopicRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Integer execute(CreateTopicCommand command) {
        Topic topic = Topic.newTopic(
                command.description(),
                command.active()
        );
        Topic saved = repository.save(topic);
        return saved.getId();
    }
}