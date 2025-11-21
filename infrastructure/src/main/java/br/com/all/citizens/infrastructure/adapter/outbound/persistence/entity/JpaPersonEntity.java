package br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "person")
public class JpaPersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // SERIAL
    private Integer id;

    @Column(name = "full_name", nullable = false, length = 200)
    private String fullName;

    @Column(name = "cpf_number", length = 40)
    private String cpfNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "update_at", nullable = false)
    private Instant updateAt;

    @Column(name = "delete_at", nullable = true)
    private Instant deleteAt;

    // Relacionamento 1-1 com Citizen (PK compartilhada)
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private JpaCitizenEntity citizen;

    // Relacionamento 1-1 com Employee (PK compartilhada)
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private JpaEmployeeEntity employee;

    // Relacionamento 1-N com UserAccount
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<JpaUserAccountEntity> userAccounts;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpfNumber() {
        return cpfNumber;
    }

    public void setCpfNumber(String cpfNumber) {
        this.cpfNumber = cpfNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public Instant getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Instant deleteAt) {
        this.deleteAt = deleteAt;
    }

    public JpaCitizenEntity getCitizen() {
        return citizen;
    }

    public void setCitizen(JpaCitizenEntity citizen) {
        this.citizen = citizen;
    }

    public JpaEmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(JpaEmployeeEntity employee) {
        this.employee = employee;
    }

    public List<JpaUserAccountEntity> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<JpaUserAccountEntity> userAccounts) {
        this.userAccounts = userAccounts;
    }
}
