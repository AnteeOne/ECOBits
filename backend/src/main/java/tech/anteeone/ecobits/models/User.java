package tech.anteeone.ecobits.models;

import tech.anteeone.ecobits.configs.RolesRepository;

public class User {


    private Integer id;
    private String username;
    private String email;
    private String password;
    private String password2;
    private Integer bitsCount;
    private String role;

    public Integer getActiveQuestId() {
        return activeQuestId;
    }

    public Integer getCompletedQuestsCount() {
        return completedQuestsCount;
    }

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

    public Integer getId() { return id; }

    public User(String username,String email,String password, String password2) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.password2 = password2;
        this.role = RolesRepository.volunteer;
        this.bitsCount = 0;
        this.completedQuestsCount = 0;
    }

    public User(String username, String email, Integer bitsCount, String role, Integer activeQuestId, Integer completedQuestsCount) {
        this.username = username;
        this.email = email;
        this.bitsCount = bitsCount;
        this.role = role;
        this.activeQuestId = activeQuestId;
        this.completedQuestsCount = completedQuestsCount;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(Integer id,String username, String email, Integer bitsCount, String role, Integer activeQuestId, Integer completedQuestsCount) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.bitsCount = bitsCount;
        this.role = role;
        this.activeQuestId = activeQuestId;
        this.completedQuestsCount = completedQuestsCount;
    }

    public User(String username, String email, Integer bitsCount, String role) {
        this.username = username;
        this.email = email;
        this.bitsCount = bitsCount;
        this.role = role;
    }

    public User(Integer id,String username, Integer activeQuestId) {
        this.id = id;
        this.username = username;
        this.activeQuestId = activeQuestId;
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
