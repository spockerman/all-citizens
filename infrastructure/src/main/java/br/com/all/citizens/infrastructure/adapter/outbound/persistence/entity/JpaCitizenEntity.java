package br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity;

import br.com.all.citizens.domain.citizen.CitizenType;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "citizen")
public class JpaCitizenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String cpf;
    private String mobile;
    private String email;
    
    @Enumerated(EnumType.STRING)
    private CitizenType type;
    
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public CitizenType getType() { return type; }
    public void setType(CitizenType type) { this.type = type; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    public Instant getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Instant deletedAt) { this.deletedAt = deletedAt; }
}