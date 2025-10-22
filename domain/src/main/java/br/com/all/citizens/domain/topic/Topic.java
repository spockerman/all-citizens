package br.com.all.citizens.domain.topic;

import java.time.Instant;

public class Topic {

    private final Integer id;
    private final String description;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant deletedAt;

    private Topic(Integer id, String description, boolean active,
                  Instant createdAt, Instant updatedAt, Instant deletedAt) {
        this.id = id;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Topic newTopic(String description, boolean active) {
        Instant now = Instant.now();
        return new Topic(
                null,
                description,
                active,
                now,
                now,
                null);
    }

    public static Topic with(
            Integer id,
            String description,
            boolean active,
            Instant createdAt,
            Instant updatedAt,
            Instant deletedAt) {
        return new Topic(
                id,
                description,
                active,
                createdAt,
                updatedAt,
                deletedAt);
    }

    public Integer getId() { return id; }
    public String getDescription() { return description; }
    public boolean isActive() { return active; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public Instant getDeletedAt() { return deletedAt; }
}