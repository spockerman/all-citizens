package br.com.all.citizens.application.topic.service;

import br.com.all.citizens.application.topic.usecase.DeleteTopicUseCase;
import br.com.all.citizens.domain.exception.TopicNotFoundException;
import br.com.all.citizens.domain.topic.Topic;
import br.com.all.citizens.domain.topic.TopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteTopicService implements DeleteTopicUseCase {

    private final TopicRepository repository;

    public DeleteTopicService(TopicRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void execute(Integer id) {
        Topic existingTopic = repository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException(id));

        repository.deleteById(id);
    }
}