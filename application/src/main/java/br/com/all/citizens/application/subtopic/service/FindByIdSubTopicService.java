package br.com.all.citizens.application.subtopic.service;

import br.com.all.citizens.application.subtopic.usecase.FindByIdSubTopicUseCase;
import br.com.all.citizens.domain.exception.SubTopicNotFoundException;
import br.com.all.citizens.domain.subtopic.SubTopic;
import br.com.all.citizens.domain.subtopic.SubTopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindByIdSubTopicService implements FindByIdSubTopicUseCase {

    private final SubTopicRepository repository;

    public FindByIdSubTopicService(SubTopicRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public SubTopic execute(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new SubTopicNotFoundException(id));
    }
}