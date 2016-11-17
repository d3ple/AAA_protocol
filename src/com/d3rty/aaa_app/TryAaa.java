package com.d3rty.aaa_app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import  org.apache.logging.log4j.*;

public class TryAaa {
    static final Logger log = LogManager.getLogger(TryAaa.class);

    public static void tryAuthentication(ArrayList<User> userList, ParsedUserData parsed) {
        if (!Checking.checkLogin(userList, parsed)) {
            log.error("Login:" + parsed.getLogin() + " is Unknown user. Exit code : 1");
            System.exit(1);
        } else if (!Checking.checkPassword(userList, parsed)) {
            log.error("Password:" + parsed.getPassword() + " is Wrong password. Exit code : 2");
            System.exit(2);
        } else {
            log.info("Authentication complete");
        }
    }


    public static void tryAuthorization(ArrayList<Role> roleList, ParsedUserData parsed) {
        if (!Checking.checkRole(roleList, parsed)) {
            log.error("role :" + parsed.getRole() + "  is Wrong role. Exit code : 3");
            System.exit(3);
        } else if (!Checking.checkRoleAndResource(roleList, parsed)) {
            log.error("Resource: " + parsed.getResource() + " is Wrong resource. Exit code : 4");
            System.exit(4);
        } else {
            log.info("Authorization complete");
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
            log.error("Period: " + parsed.getDateSt() + " - " + parsed.getDateEnd() +
                    " is invalid activity. Exit code: 5");
            System.exit(5);
        }
        try {
            volume = Long.valueOf(parsed.getVolume());
        } catch (java.lang.NumberFormatException e) {
            log.error("Volume: " + parsed.getVolume() + " is invalid activity. Exit code: 5");
            System.exit(5);
        }
        log.info("Accounting complete");

        ArrayList<Accounting> accountingList = new ArrayList<>();
        accountingList.add(new Accounting(parsed.getRole(), parsed.getResource(), startDay, endDay, volume));
    }


}
