package br.com.all.citizens.application.subtopic.service;

import br.com.all.citizens.application.subtopic.usecase.FindByTopicIdSubTopicUseCase;
import br.com.all.citizens.domain.exception.TopicNotFoundException;
import br.com.all.citizens.domain.subtopic.SubTopic;
import br.com.all.citizens.domain.subtopic.SubTopicRepository;
import br.com.all.citizens.domain.topic.TopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FindByTopicIdSubTopicService implements FindByTopicIdSubTopicUseCase {

    private final SubTopicRepository subTopicRepository;
    private final TopicRepository topicRepository;

    public FindByTopicIdSubTopicService(
            SubTopicRepository subTopicRepository,
            TopicRepository topicRepository) {
        this.subTopicRepository = subTopicRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubTopic> execute(Integer topicId) {
        // Verify that the topic exists
        topicRepository.findById(topicId)
                .orElseThrow(() -> new TopicNotFoundException(topicId));

        // Return all subtopics for the topic
        return subTopicRepository.findByTopicId(topicId);
    }
}