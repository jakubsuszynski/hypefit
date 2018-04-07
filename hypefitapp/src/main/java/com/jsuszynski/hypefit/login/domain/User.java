package com.jsuszynski.hypefit.login.domain;

public class User {

    private Long id;
    private String password;
    private String login;
    private String email;
    private String role;


    public User(String password, String login, String email, String role) {
        this.password = password;
        this.login = login;
        this.email = email;
        this.role = role;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
