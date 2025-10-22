package br.com.all.citizens.domain;

import br.com.all.citizens.domain.subtopic.SubTopic;
import br.com.all.citizens.domain.subtopic.UrgencyLevel;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class SubTopicTest {

    @Test
    public void testNewSubTopic() {
        String name = "Test SubTopic";
        String description = "Test Description";
        Instant deadline = Instant.now().plusSeconds(3600); // 1 hour from now
        UrgencyLevel urgencyLevel = UrgencyLevel.MEDIUM;
        Integer topicId = 1;
        Integer departmentId = 2;

        SubTopic subTopic = SubTopic.newSubTopic(name, description, deadline, urgencyLevel, topicId, departmentId);

        assertNull(subTopic.getId());
        assertEquals(name, subTopic.getName());
        assertEquals(description, subTopic.getDescription());
        assertEquals(deadline, subTopic.getDeadline());
        assertEquals(urgencyLevel, subTopic.getUrgencyLevel());
        assertEquals(topicId, subTopic.getTopicId());
        assertEquals(departmentId, subTopic.getDepartmentId());
        assertNotNull(subTopic.getCreatedAt());
        assertNotNull(subTopic.getUpdatedAt());
        assertNull(subTopic.getDeletedAt());
    }

    @Test
    public void testWithSubTopic() {
        Integer id = 1;
        String name = "Test SubTopic";
        String description = "Test Description";
        Instant deadline = Instant.now().plusSeconds(3600); // 1 hour from now
        UrgencyLevel urgencyLevel = UrgencyLevel.HIGH;
        Integer topicId = 2;
        Integer departmentId = 3;
        Instant createdAt = Instant.now();
        Instant updatedAt = Instant.now();
        Instant deletedAt = null;

        SubTopic subTopic = SubTopic.with(id, name, description, deadline, urgencyLevel, topicId, departmentId, createdAt, updatedAt, deletedAt);

        assertEquals(id, subTopic.getId());
        assertEquals(name, subTopic.getName());
        assertEquals(description, subTopic.getDescription());
        assertEquals(deadline, subTopic.getDeadline());
        assertEquals(urgencyLevel, subTopic.getUrgencyLevel());
        assertEquals(topicId, subTopic.getTopicId());
        assertEquals(departmentId, subTopic.getDepartmentId());
        assertEquals(createdAt, subTopic.getCreatedAt());
        assertEquals(updatedAt, subTopic.getUpdatedAt());
        assertEquals(deletedAt, subTopic.getDeletedAt());
    }
}