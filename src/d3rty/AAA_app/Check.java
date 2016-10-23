package d3rty.AAA_app;

import java.util.ArrayList;

import static d3rty.AAA_app.Security.MD5;


public class Check {

    public static Boolean CheckLogin(ArrayList<User> userList, ParsedUserData parsed_data) {
        for (User user : userList) {
            if (parsed_data.getLogin().equals(user.login)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean CheckPassword(ArrayList<User> userList, ParsedUserData parsed_data) {
        for (User user : userList) {
            String HASH = (MD5(MD5(parsed_data.getPassword()) + user.getSalt()));
            if (CheckLogin(userList, parsed_data) && (HASH.equals(user.password))) {
                return true;
            }
        }
        return false;
    }

    public static Boolean CheckRole(ArrayList<Role> roleList, ParsedUserData parsed_data) {

        ArrayList<String> aRoleList = new ArrayList<>();
        for (AvailableRoles aRole : AvailableRoles.values()) {
            aRoleList.add(aRole.name());
        }

        if (!aRoleList.contains(parsed_data.getRole())) {
            System.out.println("Unknown role");
            System.exit(3);
        } else {
            for (Role role : roleList) {
                if (parsed_data.getRole().equals(role.name)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static Boolean CheckRoleAndResource(ArrayList<Role> roleList, ParsedUserData parsed_data) {
        for (Role role : roleList) {
            if (parsed_data.getRole().equals(role.name) && isParentOf(role.resource, parsed_data.getResource())) {
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
