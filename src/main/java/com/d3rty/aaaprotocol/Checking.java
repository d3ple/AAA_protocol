package com.d3rty.aaaprotocol;

import com.d3rty.aaaprotocol.domain.Role;
import com.d3rty.aaaprotocol.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Checking {

    private static final Logger log = LogManager.getLogger(Checking.class);

    public static Boolean checkLogin(String username) {
        if (DbManager.getUserByLogin(username) != null) {
            log.info("Username OK");
            return true;
        }
        return false;
    }

    public static Boolean checkPassword(ParsedData parsedData) {
        User user = DbManager.getUserByLogin(parsedData.getLogin());
        assert user != null;
        String hash = (Security.generateMd5(Security.generateMd5(parsedData.getPassword()) + user.getSalt()));
        if ((hash.equals(user.getPassword()))) {
            log.info("Password OK");
            return true;
        }
        return false;
    }

    public static Boolean checkRole(ParsedData parsedData) {
        User user = DbManager.getUserByLogin(parsedData.getLogin());
        Role role = new Role();
        role.setName(parsedData.getRole());
        if (!AvailableRoles.getAvailableRoles().contains(parsedData.getRole())) {
            log.error("\"" + parsedData.getRole() + "\"  invalid role. Exit code : 3");
            System.exit(3);
        } else {
            for (Role r : DbManager.getPermissionByUserAndRole(user, role)) {
                if (parsedData.getRole().equals(r.getName())) {
                    log.info("Role OK");
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean checkRoleAndResource(ParsedData parsedData) {
        User user = DbManager.getUserByLogin(parsedData.getLogin());
        Role role = new Role();
        role.setName(parsedData.getRole());
        for (Role r : DbManager.getPermissionByUserAndRole(user, role)) {
            if (parsedData.getRole().equals(r.getName()) && isParentOf(r.getResource(), parsedData.getResource())) {
                log.info("Permission OK");
                return true;
            }
        }
        return false;
    }

    private static boolean isParentOf(String listRes, String parseRes) {
        String[] listResList = listRes.split("\\.");
        String[] parseResList = parseRes.split("\\.");

        if (parseResList.length < listResList.length) {
            return false;
        }
        for (int i = 0; i < listResList.length; i++) {
            if (!listResList[i].equals(parseResList[i])) {
                return false;
            }
        }
        log.info("Subresource checking OK");
        return true;
    }

}
