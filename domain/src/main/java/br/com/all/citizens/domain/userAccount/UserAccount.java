package br.com.all.citizens.domain.userAccount;

public class UserAccount {
    private Integer id;
    private Integer personId;
    private String authProvider;
    private String authSubject;
    private String mobile;
    private String email;
    private boolean active;

    public UserAccount(Integer id, Integer personId, String authProvider, String authSubject, String mobile, String email, boolean active) {
        this.id = id;
        this.personId = personId;
        this.authProvider = authProvider;
        this.authSubject = authSubject;
        this.mobile = mobile;
        this.email = email;
        this.active = active;
    }

    public static UserAccount newUserAccount(Integer personId, String authProvider, String authSubject, String mobile, String email, boolean active) {
        return new UserAccount(null, personId, authProvider, authSubject, mobile, email, active);
    }

    public static UserAccount with(Integer id, Integer personId, String authProvider, String authSubject, String mobile, String email, boolean active) {
        return new UserAccount(id, personId, authProvider, authSubject, mobile, email, active);
    }

    public Integer getId() {
        return id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public String getAuthProvider() {
        return authProvider;
    }

    public String getAuthSubject() {
        return authSubject;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }
}
