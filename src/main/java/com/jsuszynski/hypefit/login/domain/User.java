package com.jsuszynski.hypefit.login.domain;

import javax.persistence.Entity;

@Entity
public class User {

    public User(long id, String password, String login, String email, String role) {
        this.id = id;
        this.password = password;
        this.login = login;
        this.email = email;
        this.role = role;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
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

    private long id;
    private String password;
    private String login;
    private String email;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
