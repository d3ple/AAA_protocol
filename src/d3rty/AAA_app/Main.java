package d3rty.AAA_app;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        userList.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));


        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new Role(1, userList.get(0), "READ", "a"));
        roleList.add(new Role(2, userList.get(0), "WRITE", "a.b"));
        roleList.add(new Role(3, userList.get(1), "EXECUTE", "a.b.c"));
        roleList.add(new Role(4, userList.get(0), "EXECUTE", "a.bc"));


        ParsedUserData parsed_data = new Cli(args).parse();
        if (parsed_data.isEmpty()) {
            System.exit(0);
        } else {
            if (!parsed_data.isAuthenticationPossible()) {
                System.exit(0);
            } else {
                Try_AAA.tryAuthentication(userList, parsed_data);
                if (!parsed_data.isAuthorizationPossible()) {
                    System.exit(0);
                } else {
                    Try_AAA.tryAuthorization(roleList, parsed_data);
                    if (!parsed_data.isAccountingPossible()) {
                        System.exit(0);
                    } else {
                        Try_AAA.tryAccounting(parsed_data);
                    }
                }
            }
        }

    }

}