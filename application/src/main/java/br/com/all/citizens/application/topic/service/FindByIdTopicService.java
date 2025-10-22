package br.com.all.citizens.application.topic.service;

import br.com.all.citizens.application.topic.usecase.FindByIdTopicUseCase;
import br.com.all.citizens.domain.exception.TopicNotFoundException;
import br.com.all.citizens.domain.topic.Topic;
import br.com.all.citizens.domain.topic.TopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindByIdTopicService implements FindByIdTopicUseCase {

    private final TopicRepository repository;

    public FindByIdTopicService(TopicRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Topic execute(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException(id));
    }
}