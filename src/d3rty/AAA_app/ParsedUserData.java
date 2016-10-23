package d3rty.AAA_app;


public class ParsedUserData {

    private String login;
    private String password;
    private String role;
    private String resource;
    private String date_st;
    private String date_end;
    private String volume;

    public ParsedUserData(String login, String password, String role, String resource, String date_st, String date_end, String volume) {
        this.login = login;
        this.password = password;
        this.resource = resource;
        this.role = role;
        this.date_st = date_st;
        this.date_end = date_end;
        this.volume = volume;
    }

    public ParsedUserData() {
        this.login = null;
        this.password = null;
        this.resource = null;
        this.role = null;
        this.date_st = null;
        this.date_end = null;
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

    public void setDate_st(String date_st) {
        this.date_st = date_st;
    }

    public String getDate_st() {
        return date_st;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getDate_end() {
        return date_end;
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
        return ((isAuthorizationPossible()) && (date_st != null) && (date_end != null) && (volume != null));
    }
}
