package br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "service_request")
public class JpaServiceRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private JpaTopicEntity topic;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_topic_id", nullable = false)
    private JpaSubTopicEntity subTopic;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "occurrence_address", nullable = false, length = 500)
    private String occurrenceAddress;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_person_id", nullable = false)
    private JpaPersonEntity requesterPerson;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "responsible_user_account_id", nullable = false)
    private JpaUserAccountEntity responsibleUserAccount;

    @Column(name = "occurrence_at", nullable = false)
    private Instant occurrenceAt;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JpaTopicEntity getTopic() {
        return topic;
    }

    public void setTopic(JpaTopicEntity topic) {
        this.topic = topic;
    }

    public JpaSubTopicEntity getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(JpaSubTopicEntity subTopic) {
        this.subTopic = subTopic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOccurrenceAddress() {
        return occurrenceAddress;
    }

    public void setOccurrenceAddress(String occurrenceAddress) {
        this.occurrenceAddress = occurrenceAddress;
    }

    public JpaPersonEntity getRequesterPerson() {
        return requesterPerson;
    }

    public void setRequesterPerson(JpaPersonEntity requesterPerson) {
        this.requesterPerson = requesterPerson;
    }

    public JpaUserAccountEntity getResponsibleUserAccount() {
        return responsibleUserAccount;
    }

    public void setResponsibleUserAccount(JpaUserAccountEntity responsibleUserAccount) {
        this.responsibleUserAccount = responsibleUserAccount;
    }

    public Instant getOccurrenceAt() {
        return occurrenceAt;
    }

    public void setOccurrenceAt(Instant occurrenceAt) {
        this.occurrenceAt = occurrenceAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
