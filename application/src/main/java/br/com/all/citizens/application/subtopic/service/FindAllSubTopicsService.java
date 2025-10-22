package br.com.all.citizens.application.subtopic.service;

import br.com.all.citizens.application.subtopic.usecase.FindAllSubTopicsUseCase;
import br.com.all.citizens.domain.subtopic.SubTopic;
import br.com.all.citizens.domain.subtopic.SubTopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FindAllSubTopicsService implements FindAllSubTopicsUseCase {

    private final SubTopicRepository repository;

    public FindAllSubTopicsService(SubTopicRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubTopic> execute() {
        return repository.findAll();
    }
}