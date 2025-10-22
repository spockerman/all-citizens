package br.com.all.citizens.application.subtopic.service;

import br.com.all.citizens.application.subtopic.command.CreateSubTopicCommand;
import br.com.all.citizens.application.subtopic.usecase.CreateSubTopicUseCase;
import br.com.all.citizens.domain.department.DepartmentRepository;
import br.com.all.citizens.domain.exception.DepartmentNotFoundException;
import br.com.all.citizens.domain.exception.TopicNotFoundException;
import br.com.all.citizens.domain.subtopic.SubTopic;
import br.com.all.citizens.domain.subtopic.SubTopicRepository;
import br.com.all.citizens.domain.topic.TopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateSubTopicService implements CreateSubTopicUseCase {

    private final SubTopicRepository subTopicRepository;
    private final TopicRepository topicRepository;
    private final DepartmentRepository departmentRepository;

    public CreateSubTopicService(
            SubTopicRepository subTopicRepository,
            TopicRepository topicRepository,
            DepartmentRepository departmentRepository) {
        this.subTopicRepository = subTopicRepository;
        this.topicRepository = topicRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Transactional
    public Integer execute(CreateSubTopicCommand command) {
        // Verify that the topic exists
        var topic = topicRepository.findById(command.topicId())
                .orElseThrow(() -> new TopicNotFoundException(command.topicId()));

        // Verify that the department exists
        var department = departmentRepository.findById(command.departmentId())
                .orElseThrow(() -> new DepartmentNotFoundException(command.departmentId()));

        // Create the SubTopic
        SubTopic subTopic = SubTopic.newSubTopic(
                command.name(),
                command.description(),
                command.deadline(),
                command.urgencyLevel(),
                topic.getId(),
                department.getId()
        );

        // Save and return the ID
        SubTopic saved = subTopicRepository.save(subTopic);
        return saved.getId();
    }
}