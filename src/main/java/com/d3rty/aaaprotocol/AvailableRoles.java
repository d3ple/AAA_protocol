package com.d3rty.aaaprotocol;

import java.util.ArrayList;

public enum AvailableRoles {
    READ,
    WRITE,
    EXECUTE;

    public static ArrayList<String> getAvailableRoles() {
        ArrayList<String> aRoleList = new ArrayList<>();
        for (AvailableRoles aRole : AvailableRoles.values()) {
            aRoleList.add(aRole.name());
        }
        return aRoleList;
    }

}
