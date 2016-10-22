package d3rty.AAA_app;


public class Parse {
    private String U_login;
    private String U_password;
    private String U_role;
    private String U_resurse;

    public Parse(String U_login, String U_password, String U_role, String U_resourse) {
        this.U_login = U_login;
        this.U_password = U_password;
        this.U_resurse = U_resourse;
        this.U_role = U_role;
    }

    public Parse() {
        this.U_login = null;
        this.U_password = null;
        this.U_resurse = null;
        this.U_role = null;
    }

    public String getU_login() {
        return U_login;
    }

    public void setU_login(String u_login) {
        U_login = u_login;
    }

    public String getU_password() {
        return U_password;
    }

    public void setU_password(String u_password) {
        U_password = u_password;
    }

    public String getU_role() {
        return U_role;
    }

    public void setU_role(String u_role) {
        U_role = u_role;
    }

    public String getU_resurse() {
        return U_resurse;
    }

    public void setU_resurse(String u_resurse) {
        U_resurse = u_resurse;
    }

    public Boolean isEmpty() {
        return ((U_role == null) && (U_resurse == null) && (U_password == null) && (U_login == null));
    }

    public Boolean authentication() {
        return ((U_login != null) && (U_password != null));
    }
    public Boolean authorization(){
        return ((authentication() != null)&&(U_role != null) && (U_resurse != null));
    }

}
