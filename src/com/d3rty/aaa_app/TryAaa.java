package com.d3rty.aaa_app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class TryAaa {

    public static void tryAuthentication(ArrayList<User> userList, ParsedUserData parsed) {
        if (!Checking.checkLogin(userList, parsed)) {
            System.out.println("Unknown login");
            System.exit(1);
        } else if (!Checking.checkPassword(userList, parsed)) {
            System.out.println("Unknown password");
            System.exit(2);
        } else {
            System.out.println("Authentication complete");
        }
    }


    public static void tryAuthorization(ArrayList<Role> roleList, ParsedUserData parsed) {
        if (!Checking.checkRole(roleList, parsed)) {
            System.out.println("Unknown role");
            System.exit(3);
        } else if (!Checking.checkRoleAndResource(roleList, parsed)) {
            System.out.println("No access");
            System.exit(4);
        } else {
            System.out.println("Authorization complete");
        }
    }


    public static void tryAccounting(ParsedUserData parsed) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //ISO_LOCAL_DATE "yyyy-MM-dd"
        LocalDate startDay = null;
        LocalDate endDay = null;
        long volume = 0;
        try {
            startDay = LocalDate.parse(parsed.getDateSt(), formatter);
            endDay = LocalDate.parse(parsed.getDateEnd(), formatter);
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println(e);
            System.exit(5);
        }
        try {
            volume = Long.valueOf(parsed.getVolume());
        } catch (java.lang.NumberFormatException e) {
            System.out.println(e);
            System.exit(5);
        }
        System.out.println("Accounting complete");

        ArrayList<Accounting> accountingList = new ArrayList<>();
        accountingList.add(new Accounting(parsed.getRole(), parsed.getResource(), startDay, endDay, volume));
    }


}
