package d3rty.AAA_app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Try_AAA {

    public static void tryAuthentication(ArrayList<User> userList, ParsedUserData parsed) {
        if (!Check.CheckLogin(userList, parsed)) {
            System.out.println("Unknown login");
            System.exit(1);
        } else {
            if (!Check.CheckPassword(userList, parsed)) {
                System.out.println("Unknown password");
                System.exit(2);
            } else {
                System.out.println("Authentication complete");
            }
        }
    }


    public static void tryAuthorization(ArrayList<Role> roleList, ParsedUserData parsed) {
        if (!Check.CheckRole(roleList, parsed)) {
            System.out.println("Unknown role");
            System.exit(3);
        } else {
            if (!Check.CheckRoleAndResource(roleList, parsed)) {
                System.out.println("No access");
                System.exit(4);
            } else {
                System.out.println("Authorization complete");
            }
        }
    }


    public static void tryAccounting(ParsedUserData parsed) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //ISO_LOCAL_DATE "yyyy-MM-dd"
        LocalDate startDay = null;
        LocalDate endDay = null;
        long volume = 0;
        try {
            startDay = LocalDate.parse(parsed.getDate_st(), formatter);
            endDay = LocalDate.parse(parsed.getDate_end(), formatter);
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
        //System.out.println(accountingList.get(0));
    }


}
