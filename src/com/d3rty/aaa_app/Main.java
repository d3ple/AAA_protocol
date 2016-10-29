package com.d3rty.aaa_app;

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

        ParsedUserData parsedData = new Cli(args).parse();
        if (parsedData.isEmpty()) {
            System.exit(0);
        } else if (parsedData.isAccountingPossible()) {
            TryAaa.tryAuthentication(userList, parsedData);
            TryAaa.tryAuthorization(roleList, parsedData);
            TryAaa.tryAccounting(parsedData);
        } else if (parsedData.isAuthorizationPossible()) {
            TryAaa.tryAuthentication(userList, parsedData);
            TryAaa.tryAuthorization(roleList, parsedData);
        } else if (parsedData.isAuthenticationPossible()) {
            TryAaa.tryAuthentication(userList, parsedData);
        } else {
            System.exit(0);
        }
    }

}