package ru.spbu.models;

public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(int id, String name, String password, String role) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    private int id;
    private String name;
    private String password;
    private String role;
}
