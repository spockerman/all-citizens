package br.com.all.citizens.infrastructure.adapter.outbound.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "user_account",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "ux_user_account_auth_provider_subject",
                        columnNames = {"auth_provider", "auth_subject"}
                )
        }
)
public class JpaUserAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private JpaPersonEntity person;

    @Column(name = "auth_provider", nullable = false, length = 40)
    private String authProvider;

    @Column(name = "auth_subject", nullable = false, length = 120)
    private String authSubject;

    @Column(name = "mobile", nullable = false, length = 20)
    private String mobile;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JpaPersonEntity getPerson() {
        return person;
    }

    public void setPerson(JpaPersonEntity person) {
        this.person = person;
    }

    public String getAuthProvider() {
        return authProvider;
    }

    public void setAuthProvider(String authProvider) {
        this.authProvider = authProvider;
    }

    public String getAuthSubject() {
        return authSubject;
    }

    public void setAuthSubject(String authSubject) {
        this.authSubject = authSubject;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
