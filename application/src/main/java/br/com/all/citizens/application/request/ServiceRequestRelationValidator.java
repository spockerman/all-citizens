package br.com.all.citizens.application.request;

import br.com.all.citizens.domain.exception.*;
import br.com.all.citizens.domain.person.PersonRepository;
import br.com.all.citizens.domain.subtopic.SubTopicRepository;
import br.com.all.citizens.domain.topic.TopicRepository;
import br.com.all.citizens.domain.userAccount.UserAccountRepository;
import org.springframework.stereotype.Component;

@Component
public class ServiceRequestRelationValidator {

    private final TopicRepository topicRepository;
    private final SubTopicRepository subTopicRepository;
    private final PersonRepository personRepository;
    private final UserAccountRepository userAccountRepository;

    public ServiceRequestRelationValidator(
            TopicRepository topicRepository,
            SubTopicRepository subTopicRepository,
            PersonRepository personRepository,
            UserAccountRepository userAccountRepository
    ) {
        this.topicRepository = topicRepository;
        this.subTopicRepository = subTopicRepository;
        this.personRepository = personRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public void validate(
            Integer topicId,
            Integer subTopicId,
            Integer requesterPersonId,
            Integer responsibleUserAccountId
    ) {
        topicRepository.findById(topicId)
                .orElseThrow(() -> new TopicNotFoundException(topicId));

        var subTopic = subTopicRepository.findById(subTopicId)
                .orElseThrow(() -> new SubTopicNotFoundException(subTopicId));

        if (!subTopic.getTopicId().equals(topicId)) {
            throw new SubTopicTopicMismatchException(subTopicId, topicId);
        }

        personRepository.findById(requesterPersonId)
                .orElseThrow(() -> new PersonNotFoundException(requesterPersonId));

        userAccountRepository.findById(responsibleUserAccountId)
                .orElseThrow(() -> new UserAccountNotFoundException(
                        "User account with id '" + responsibleUserAccountId + "' not found."
                ));
    }
}
