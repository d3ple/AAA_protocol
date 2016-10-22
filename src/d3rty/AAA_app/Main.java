package d3rty.AAA_app;

import java.util.ArrayList;
import  static d3rty.AAA_app.Security.Salt;
import  static d3rty.AAA_app.Security.MD5;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));


        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role(1, users.get(0), "READ", "a"));
        roles.add(new Role(2, users.get(0), "WRITE", "a.b"));
        roles.add(new Role(3, users.get(1), "EXECUTE", "a.b.c"));
        roles.add(new Role(4, users.get(0), "EXECUTE", "a.bc"));

        Parse parse = new Cli(args).parse();

        if (parse.isEmpty()) {
            System.exit(0);
        } else if (parse.authentication()) {
            tryAuthentication(users, parse);
            Boolean authorization = parse.authorization();
            if (!authorization) {
                System.exit(0);
            } else {
                tryAuthorization(roles, parse);

            }

        } else {
            System.exit(0);
        }
    }


    private static void tryAuthentication(ArrayList<User> users, Parse parse) {
        Boolean resultLogin = CheckLogin(users, parse);
        if (resultLogin) {
            Boolean resultPassword = CheckPassword(users, parse);
            if (resultPassword) {
                System.out.println("Success Authent.");

            } else {
                System.out.println("Wrong password");
                System.exit(2);
            }
        } else {
            System.out.println("Unknown user");
            System.exit(1);
        }

    }

    private static void tryAuthorization(ArrayList<Role> roles, Parse parse) {
        Boolean resultRole = CheckRole(roles, parse);
        if (resultRole) {
            Boolean resultRecourse = CheckRecourse(roles, parse);
            if (resultRecourse) {
                System.out.println("Success Author.");
            } else {
                System.out.println("Doesn't exist");
                System.exit(4);
            }
        } else {
            System.out.println("Unknown Role");
            System.exit(3);
        }
    }

    private static Boolean CheckLogin(ArrayList<User> users, Parse parse) {
        for (User user : users) {
            if (parse.getU_login().equals(user.login)) {
                return true;
            }
        }
        return false;
    }

    private static Boolean CheckPassword(ArrayList<User> users, Parse parse) {
        for (User user : users) {
            String HASH = (MD5(MD5(parse.getU_password())+user.getSalt()));
            if (CheckLogin(users, parse) && (HASH.equals(user.password))) {
                return true;
            }

        }
        return false;
    }

    private static Boolean CheckRole(ArrayList<Role> roles, Parse parse) {
        for (Role role : roles) {
            if (parse.getU_role().equals(role.name)) {
                return true;
            }
        }
        return false;
    }

    private static Boolean CheckRecourse(ArrayList<Role> roles, Parse parse) {
        for (Role recourse : roles) {
            if ((CheckRole(roles, parse)) && (parse.getU_resurse().equals(recourse.resourse))) {
                return true;
            }
        }
        return false;
    }

}