package br.com.all.citizens.domain;

import br.com.all.citizens.domain.topic.Topic;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class TopicTest {

    @Test
    public void testNewTopic() {
        String description = "Test Topic";
        boolean active = true;

        Topic topic = Topic.newTopic(description, active);

        assertNull(topic.getId());
        assertEquals(description, topic.getDescription());
        assertEquals(active, topic.isActive());
        assertNotNull(topic.getCreatedAt());
        assertNotNull(topic.getUpdatedAt());
        assertNull(topic.getDeletedAt());
    }

    @Test
    public void testWithTopic() {
        Integer id = 1;
        String description = "Test Topic";
        boolean active = true;
        Instant createdAt = Instant.now();
        Instant updatedAt = Instant.now();
        Instant deletedAt = null;

        Topic topic = Topic.with(id, description, active, createdAt, updatedAt, deletedAt);

        assertEquals(id, topic.getId());
        assertEquals(description, topic.getDescription());
        assertEquals(active, topic.isActive());
        assertEquals(createdAt, topic.getCreatedAt());
        assertEquals(updatedAt, topic.getUpdatedAt());
        assertEquals(deletedAt, topic.getDeletedAt());
    }
}