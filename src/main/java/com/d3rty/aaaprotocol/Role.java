package com.d3rty.aaaprotocol;

public class Role {

    private int id;
    private User user;
    private String name;
    private String resource;

    public Role(int id, User user, String name, String resource) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.resource = resource;
    }

    public Role() {
        this.id = 0;
        this.user = null;
        this.name = null;
        this.resource = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

}