package br.com.all.citizens.application.subtopic.service;

import br.com.all.citizens.application.subtopic.command.UpdateSubTopicCommand;
import br.com.all.citizens.application.subtopic.usecase.UpdateSubTopicUseCase;
import br.com.all.citizens.domain.department.DepartmentRepository;
import br.com.all.citizens.domain.exception.DepartmentNotFoundException;
import br.com.all.citizens.domain.exception.SubTopicNotFoundException;
import br.com.all.citizens.domain.exception.TopicNotFoundException;
import br.com.all.citizens.domain.subtopic.SubTopic;
import br.com.all.citizens.domain.subtopic.SubTopicRepository;
import br.com.all.citizens.domain.topic.TopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class UpdateSubTopicService implements UpdateSubTopicUseCase {

    private final SubTopicRepository subTopicRepository;
    private final TopicRepository topicRepository;
    private final DepartmentRepository departmentRepository;

    public UpdateSubTopicService(
            SubTopicRepository subTopicRepository,
            TopicRepository topicRepository,
            DepartmentRepository departmentRepository) {
        this.subTopicRepository = subTopicRepository;
        this.topicRepository = topicRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Transactional
    public void execute(UpdateSubTopicCommand command) {
        // Verify that the subtopic exists
        SubTopic existingSubTopic = subTopicRepository.findById(command.id())
                .orElseThrow(() -> new SubTopicNotFoundException(command.id()));

        // Verify that the topic exists
        var topic = topicRepository.findById(command.topicId())
                .orElseThrow(() -> new TopicNotFoundException(command.topicId()));

        // Verify that the department exists
        var department = departmentRepository.findById(command.departmentId())
                .orElseThrow(() -> new DepartmentNotFoundException(command.departmentId()));

        // Create updated SubTopic
        SubTopic updatedSubTopic = SubTopic.with(
                existingSubTopic.getId(),
                command.name(),
                command.description(),
                command.deadline(),
                command.urgencyLevel(),
                topic.getId(),
                department.getId(),
                existingSubTopic.getCreatedAt(),
                Instant.now(),
                existingSubTopic.getDeletedAt()
        );

        // Save the updated SubTopic
        subTopicRepository.save(updatedSubTopic);
    }
}