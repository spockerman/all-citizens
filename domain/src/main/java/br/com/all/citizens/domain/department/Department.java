package br.com.all.citizens.domain.department;

import java.time.Instant;

public class Department {

    private final Integer id;
    private final String name;
    private final String description;
    private final String phone;
    private final String email;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant deletedAt;
    private final Integer parentDepartmentId;



    private Department(Integer id, String name, String description, String phone, String email, boolean active,
                       Instant createdAt, Instant updatedAt, Instant deletedAt,
                       Integer parentDepartmentId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.parentDepartmentId = parentDepartmentId;

    }

    public static Department newDepartment(String name,
                                           String description,
                                           String email,
                                           String phone,
                                           boolean active,
                                           Integer parentDepartmentId) {
        Instant now = Instant.now();
        return new Department(
                null,
                name,
                description,
                phone,
                email,
                active,
                now,
                now,
                null,
                parentDepartmentId);

    }

    public static Department with(
            Integer id,
            String name,
            String description,
            String email,
            String phone,
            boolean active,
            Instant createdAt,
            Instant updatedAt,
            Instant deletedAt,
            Integer parentDepartmentId) {
        return new Department(
                id,
                name,
                description,
                phone,
                email,
                active,
                createdAt,
                updatedAt,
                deletedAt,
                parentDepartmentId);
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public boolean isActive() { return active; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public Instant getDeletedAt() { return deletedAt; }
    public Integer getParentDepartmentId() { return parentDepartmentId; }

}
