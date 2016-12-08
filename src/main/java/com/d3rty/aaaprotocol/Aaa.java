package com.d3rty.aaaprotocol;

import com.d3rty.aaaprotocol.domain.Accounting;
import com.d3rty.aaaprotocol.domain.Role;
import com.d3rty.aaaprotocol.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aaa {

    private static final Logger log = LogManager.getLogger(Aaa.class);

    public static void tryAuthentication(ParsedData parsed) {
        if (!Checking.checkLogin(parsed.getLogin())) {
            log.error("\"" + parsed.getLogin() + "\" is wrong username. Exit code : 1");
            System.exit(1);
        } else if (!Checking.checkPassword(parsed)) {
            log.error("\"" + parsed.getPassword() + "\" is wrong password. Exit code : 2");
            System.exit(2);
        } else {
            log.info("Authentication complete");
        }
    }

    public static void tryAuthorization(ParsedData parsed) {
        if (!Checking.checkRole(parsed)) {
            log.error("\"" + parsed.getRole() + "\" is wrong role. Exit code : 3");
            System.exit(3);
        } else if (!Checking.checkRoleAndResource(parsed)) {
            log.error("\"" + parsed.getRole() + "\" for " + "\"" + parsed.getResource() + "\" access denied. Exit code : 4");
            System.exit(4);
        } else {
            log.info("Authorization complete");
        }
    }

    public static void tryAccounting(ParsedData parsed) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //ISO_LOCAL_DATE "yyyy-MM-dd"
        LocalDate startDay = null;
        LocalDate endDay = null;
        long volume = 0;
        try {
            startDay = LocalDate.parse(parsed.getDateSt(), formatter);
            endDay = LocalDate.parse(parsed.getDateEnd(), formatter);
            log.info("Date OK");
        } catch (java.time.format.DateTimeParseException e) {
            log.error("\"" + parsed.getDateSt() + " - " + parsed.getDateEnd() + "\" date is wrong. Exit code: 5");
            System.exit(5);
        }
        try {
            volume = Long.valueOf(parsed.getVolume());
            log.info("Volume OK");
        } catch (java.lang.NumberFormatException e) {
            log.error("\"" + parsed.getVolume() + "\" is invalid volume. Exit code: 5");
            System.exit(5);
        }

        User user = DbManager.getUserByLogin(parsed.getLogin());
        Role curRole = new Role();
        Role role = new Role();
        role.setName(parsed.getRole());
        role.setResource(parsed.getResource());
        for (Role r : DbManager.getPermissionByUserAndRole(user, role)) {
            if (r.getName().equals(parsed.getRole())) {
                curRole.setId(r.getId());
            }
        }
        DbManager.addIntoAccounting(new Accounting(curRole, parsed.getResource(), startDay, endDay, volume));
        log.info("Accounting complete");
    }


}
