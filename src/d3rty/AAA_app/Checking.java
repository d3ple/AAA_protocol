package d3rty.AAA_app;

import java.util.ArrayList;


public class Checking {

    public static Boolean checkLogin(ArrayList<User> userList, ParsedUserData parsedData) {
        for (User user : userList) {
            if (parsedData.getLogin().equals(user.getLogin())) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkPassword(ArrayList<User> userList, ParsedUserData parsedData) {
        for (User user : userList) {
            String hash = (Security.generateMd5(Security.generateMd5(parsedData.getPassword()) + user.getSalt()));
            if ((parsedData.getLogin().equals(user.getLogin())) && (hash.equals(user.getPassword()))) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkRole(ArrayList<Role> roleList, ParsedUserData parsedData) {
        ArrayList<String> aRoleList = new ArrayList<>();
        for (AvailableRoles aRole : AvailableRoles.values()) {
            aRoleList.add(aRole.name());
        }
        if (!aRoleList.contains(parsedData.getRole())) {
            System.out.println("Unknown role");
            System.exit(3);
        } else {
            for (Role role : roleList) {
                if (parsedData.getRole().equals(role.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean checkRoleAndResource(ArrayList<Role> roleList, ParsedUserData parsedData) {
        for (Role role : roleList) {
            if (parsedData.getRole().equals(role.getName()) && isParentOf(role.getResource(), parsedData.getResource())) {
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
        return true;
    }

}
