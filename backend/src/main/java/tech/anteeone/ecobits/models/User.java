package tech.anteeone.ecobits.models;

import tech.anteeone.ecobits.configs.RolesRepository;

public class User {

    private String username;
    private String email;
    private String password;
    private String password2;
    private Integer bitsCount;
    private String role;
    private Integer activeQuestId;
    private Integer completedQuestsCount;
    
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword2() {
        return password2;
    }

    public Integer getBitsCount() {
        return bitsCount;
    }

    public String getRole() {
        return role;
    }

    public User(String username,String email,String password, String password2) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.password2 = password2;
        this.role = RolesRepository.volunteer;
        this.bitsCount = 0;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, Integer bitsCount, String role) {
        this.username = username;
        this.email = email;
        this.bitsCount = bitsCount;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", bitsCount=" + bitsCount +
                ", role='" + role + '\'' +
                '}';
    }
}
