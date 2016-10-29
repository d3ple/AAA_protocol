package com.d3rty.aaa_app;


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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }
}
