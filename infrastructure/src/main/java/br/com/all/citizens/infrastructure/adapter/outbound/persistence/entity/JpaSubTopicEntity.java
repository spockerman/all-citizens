package br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity;

import br.com.all.citizens.domain.subtopic.UrgencyLevel;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "sub_topic")
public class JpaSubTopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Instant deadline;
    
    @Enumerated(EnumType.STRING)
    private UrgencyLevel urgencyLevel;
    
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private JpaTopicEntity topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private JpaDepartmentEntity department;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Instant getDeadline() { return deadline; }
    public void setDeadline(Instant deadline) { this.deadline = deadline; }

    public UrgencyLevel getUrgencyLevel() { return urgencyLevel; }
    public void setUrgencyLevel(UrgencyLevel urgencyLevel) { this.urgencyLevel = urgencyLevel; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    public Instant getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Instant deletedAt) { this.deletedAt = deletedAt; }

    public JpaTopicEntity getTopic() { return topic; }
    public void setTopic(JpaTopicEntity topic) { this.topic = topic; }

    public JpaDepartmentEntity getDepartment() { return department; }
    public void setDepartment(JpaDepartmentEntity department) { this.department = department; }
}