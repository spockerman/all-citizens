package br.com.all.citizens.domain.citizen;

import java.time.Instant;

public class Citizen {

    private final Integer id;
    private final String name;
    private final String cpf;
    private final String mobile;
    private final String email;
    private final CitizenType type;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant deletedAt;

    private Citizen(Integer id, String name, String cpf, String mobile, String email, 
                   CitizenType type, Instant createdAt, Instant updatedAt, Instant deletedAt) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.mobile = mobile;
        this.email = email;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Citizen newCitizen(
            String name,
            String cpf,
            String mobile,
            String email,
            CitizenType type
    ) {
        Instant now = Instant.now();
        return new Citizen(
                null,
                name,
                cpf,
                mobile,
                email,
                type,
                now,
                now,
                null);
    }

    public static Citizen with(
            Integer id,
            String name,
            String cpf,
            String mobile,
            String email,
            CitizenType type,
            Instant createdAt,
            Instant updatedAt,
            Instant deletedAt) {
        return new Citizen(
                id,
                name,
                cpf,
                mobile,
                email,
                type,
                createdAt,
                updatedAt,
                deletedAt);
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getCpf() { return cpf; }
    public String getMobile() { return mobile; }
    public String getEmail() { return email; }
    public CitizenType getType() { return type; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public Instant getDeletedAt() { return deletedAt; }
}