package d3rty.AAA_app;
import  static d3rty.AAA_app.Security.Salt;
import  static d3rty.AAA_app.Security.MD5;


public class User {
    public  int id;
    public String name;
    public String login;
    public String password;
    public String Salt;

    public User(int id,String name,String login,String password){

        this.id = id;
        this.name = name;
        this.login = login;
        Salt = Salt();
        this.password =  MD5(MD5(password) + Salt);

    }
}
