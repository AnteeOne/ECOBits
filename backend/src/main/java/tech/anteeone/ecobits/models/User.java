package tech.anteeone.ecobits.models;

public class User {

    private String username;
    private String email;
    private String password;
    private String password2;
    private Integer bitsCount;
    private String role;

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

    public User(String email,String username, String password, String password2) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.password2 = password2;
        this.role = RolesReposytory.volunteer;
        this.bitsCount = 0;
    }
}
