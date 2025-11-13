package br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "employee")
public class JpaEmployeeEntity {

    @Id
    @Column(name = "person_id")
    private Integer personId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "person_id")
    private JpaPersonEntity person;

    @Column(name = "department_id", nullable = false)
    private Integer departmentId;

    @Column(name = "position_title", length = 100)
    private String positionTitle;

    @Column(name = "document_number", length = 40)
    private String documentNumber;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;



    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public JpaPersonEntity getPerson() {
        return person;
    }
    public void setPerson(JpaPersonEntity person) {
        this.person = person;
    }
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}




