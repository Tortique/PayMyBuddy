package com.paymybuddy.p6.Model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String email;
    private String password;
    private String name;
    private int enabled;

    public User() {
    }

    public User(int id, String email, String password, String name, int enabled) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
