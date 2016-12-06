package com.d3rty.aaaprotocol.domain;

import com.d3rty.aaaprotocol.Security;

public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private String salt;

    public User(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.salt = Security.generateSalt();
        this.password = Security.generateMd5(Security.generateMd5(password) + salt);
    }

    public User(int id, String name, String login, String password, String salt) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }
}
