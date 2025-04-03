package br.com.all.citizens.domain.department;

import java.time.Instant;
import java.util.UUID;

public class Department {

    private String id;
    private String name;
    private String description;
    private String phone;
    private String email;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Department(
            final String id,
            final String name,
            final String description,
            final String phone,
            final String email,
            final boolean active,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Department newDepartment(
            final String aName,
            final String aDescription,
            final String aEmail,
            final String aPhone,
            final boolean active){

        final var id = UUID.randomUUID().toString();
        final var now = Instant.now();
        return new Department(id,aName, aDescription, aPhone, aEmail, active, now, now, null);

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
