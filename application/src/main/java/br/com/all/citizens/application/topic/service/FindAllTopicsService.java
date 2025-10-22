package br.com.all.citizens.application.topic.service;

import br.com.all.citizens.application.topic.usecase.FindAllTopicsUseCase;
import br.com.all.citizens.domain.topic.Topic;
import br.com.all.citizens.domain.topic.TopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FindAllTopicsService implements FindAllTopicsUseCase {

    private final TopicRepository repository;

    public FindAllTopicsService(TopicRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Topic> execute() {
        return repository.findAll();
    }
}