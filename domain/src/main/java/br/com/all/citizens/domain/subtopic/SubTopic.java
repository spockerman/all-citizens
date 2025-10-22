package br.com.all.citizens.domain.subtopic;

import java.time.Instant;

public class SubTopic {

    private final Integer id;
    private final String name;
    private final String description;
    private final Instant deadline;
    private final UrgencyLevel urgencyLevel;
    private final Integer topicId;
    private final Integer departmentId;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant deletedAt;

    private SubTopic(Integer id, String name, String description, Instant deadline, 
                    UrgencyLevel urgencyLevel, Integer topicId, Integer departmentId,
                    Instant createdAt, Instant updatedAt, Instant deletedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.urgencyLevel = urgencyLevel;
        this.topicId = topicId;
        this.departmentId = departmentId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static SubTopic newSubTopic(String name, String description, Instant deadline, 
                                      UrgencyLevel urgencyLevel, Integer topicId, Integer departmentId) {
        Instant now = Instant.now();
        return new SubTopic(
                null,
                name,
                description,
                deadline,
                urgencyLevel,
                topicId,
                departmentId,
                now,
                now,
                null);
    }

    public static SubTopic with(
            Integer id,
            String name,
            String description,
            Instant deadline,
            UrgencyLevel urgencyLevel,
            Integer topicId,
            Integer departmentId,
            Instant createdAt,
            Instant updatedAt,
            Instant deletedAt) {
        return new SubTopic(
                id,
                name,
                description,
                deadline,
                urgencyLevel,
                topicId,
                departmentId,
                createdAt,
                updatedAt,
                deletedAt);
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Instant getDeadline() { return deadline; }
    public UrgencyLevel getUrgencyLevel() { return urgencyLevel; }
    public Integer getTopicId() { return topicId; }
    public Integer getDepartmentId() { return departmentId; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public Instant getDeletedAt() { return deletedAt; }
}