package com.d3rty.aaaprotocol;


public class ParsedData {

    private String login;
    private String password;
    private String role;
    private String resource;
    private String dateSt;
    private String dateEnd;
    private String volume;

    public ParsedData() {
        this.login = null;
        this.password = null;
        this.resource = null;
        this.role = null;
        this.dateSt = null;
        this.dateEnd = null;
        this.volume = null;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    public void setDateSt(String dateSt) {
        this.dateSt = dateSt;
    }

    public String getDateSt() {
        return dateSt;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getVolume() {
        return volume;
    }


    public Boolean isEmpty() {
        return ((role == null) && (resource == null) && (password == null) && (login == null));
    }

    public Boolean isAuthenticationPossible() {
        return ((login != null) && (password != null));
    }

    public Boolean isAuthorizationPossible() {
        return ((isAuthenticationPossible()) && (role != null) && (resource != null));
    }

    public Boolean isAccountingPossible() {
        return ((isAuthorizationPossible()) && (dateSt != null) && (dateEnd != null) && (volume != null));
    }
}
