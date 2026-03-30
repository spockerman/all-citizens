package br.com.all.citizens.domain.serviceRequest;

import java.time.Instant;

public class ServiceRequest {

    private final Integer id;
    private final Integer topicId;
    private final Integer subTopicId;
    private final String description;
    private final String occurrenceAddress;
    private final Integer requesterPersonId;
    private final Integer responsibleUserAccountId;
    private final Instant occurrenceAt;
    private final Instant createdAt;
    private final Instant updatedAt;

    private ServiceRequest(
            Integer id,
            Integer topicId,
            Integer subTopicId,
            String description,
            String occurrenceAddress,
            Integer requesterPersonId,
            Integer responsibleUserAccountId,
            Instant occurrenceAt,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = id;
        this.topicId = topicId;
        this.subTopicId = subTopicId;
        this.description = description;
        this.occurrenceAddress = occurrenceAddress;
        this.requesterPersonId = requesterPersonId;
        this.responsibleUserAccountId = responsibleUserAccountId;
        this.occurrenceAt = occurrenceAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ServiceRequest newRequest(
            Integer topicId,
            Integer subTopicId,
            String description,
            String occurrenceAddress,
            Integer requesterPersonId,
            Integer responsibleUserAccountId,
            Instant occurrenceAt,
            Instant createdAt
    ) {
        return new ServiceRequest(
                null,
                topicId,
                subTopicId,
                description,
                occurrenceAddress,
                requesterPersonId,
                responsibleUserAccountId,
                occurrenceAt,
                createdAt,
                createdAt
        );
    }

    public static ServiceRequest with(
            Integer id,
            Integer topicId,
            Integer subTopicId,
            String description,
            String occurrenceAddress,
            Integer requesterPersonId,
            Integer responsibleUserAccountId,
            Instant occurrenceAt,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new ServiceRequest(
                id,
                topicId,
                subTopicId,
                description,
                occurrenceAddress,
                requesterPersonId,
                responsibleUserAccountId,
                occurrenceAt,
                createdAt,
                updatedAt
        );
    }

    public Integer getId() {
        return id;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public Integer getSubTopicId() {
        return subTopicId;
    }

    public String getDescription() {
        return description;
    }

    public String getOccurrenceAddress() {
        return occurrenceAddress;
    }

    public Integer getRequesterPersonId() {
        return requesterPersonId;
    }

    public Integer getResponsibleUserAccountId() {
        return responsibleUserAccountId;
    }

    public Instant getOccurrenceAt() {
        return occurrenceAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
