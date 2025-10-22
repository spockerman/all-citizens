package br.com.all.citizens.application.subtopic.service;

import br.com.all.citizens.application.subtopic.usecase.DeleteSubTopicUseCase;
import br.com.all.citizens.domain.exception.SubTopicNotFoundException;
import br.com.all.citizens.domain.subtopic.SubTopic;
import br.com.all.citizens.domain.subtopic.SubTopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteSubTopicService implements DeleteSubTopicUseCase {

    private final SubTopicRepository repository;

    public DeleteSubTopicService(SubTopicRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void execute(Integer id) {
        // Verify that the subtopic exists
        SubTopic existingSubTopic = repository.findById(id)
                .orElseThrow(() -> new SubTopicNotFoundException(id));

        // Delete the subtopic
        repository.deleteById(id);
    }
}