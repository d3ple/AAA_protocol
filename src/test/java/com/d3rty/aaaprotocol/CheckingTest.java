package com.d3rty.aaaprotocol;

import com.d3rty.aaaprotocol.dao.DbUserSelecting;
import com.d3rty.aaaprotocol.domain.Role;
import com.d3rty.aaaprotocol.domain.User;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckingTest {
    private static User thisUser;

    @Test
    public void checkLoginTrue() throws Exception {
        DbUserSelecting dbu = mock(DbUserSelecting.class);
        when(dbu.getUserByLogin("login")).thenReturn(thisUser =
                new User(1, "name", "login", "password", "salt"));
        assertTrue(dbu.getUserByLogin("login") != null);
    }

    @Test
    public void checkPasswordTrue() throws Exception {
        String parspass = "sup3rpaZZ";
        DbUserSelecting dbu = mock(DbUserSelecting.class);
        when(dbu.getUserByLogin("login")).thenReturn(thisUser =
                new User(1, "name", "login", "25a484b7ce566100dad87d122553753b", "1032121645149048302153761834111909839585"));
        String hash = (Security.generateMd5(Security.generateMd5(parspass) + thisUser.getSalt()));
        assertTrue(thisUser.getPassword().equals(hash));
    }

    @Test
    public void checkRoleTrue() throws Exception {

        DbUserSelecting dbu = mock(DbUserSelecting.class);
        when(dbu.getUserByLogin("login")).thenReturn(thisUser =
                new User(1, "name", "login", "password", "salt"));

        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role(1, thisUser, "READ", "a"));
        roles.add(new Role(2, thisUser, "WRITE", "a.b"));

        Role role = new Role();
        role.setName("READ");
        when(dbu.getPermissionByUserAndRole(thisUser, role)).thenReturn(roles);

        Boolean trueRole = null;
        for (Role r : roles) {
            if (role.getName().equals(r.getName())) {
                trueRole = true;
            }
        }
        assertTrue(trueRole);
    }

    @Test
    public void checkLoginFalse() throws Exception {
        DbUserSelecting dbu = mock(DbUserSelecting.class);
        when(dbu.getUserByLogin("")).thenReturn(thisUser = new User());
        assertFalse(dbu.getUserByLogin("login") != null);
    }

    @Test
    public void checkPasswordFalse() throws Exception {
        String parspass = "password";
        DbUserSelecting dbu = mock(DbUserSelecting.class);
        when(dbu.getUserByLogin("login")).
                thenReturn(thisUser = new User(1, "name", "login",
                "25a484b7ce566100dad87d122553753b", "1032121645149048302153761834111909839585"));
        String hash = (Security.generateMd5(Security.generateMd5(parspass) + thisUser.getSalt()));
        assertFalse(thisUser.getPassword().equals(hash));
    }

    @Test
    public void checkRoleFalse() throws Exception {

        DbUserSelecting dbu = mock(DbUserSelecting.class);
        when(dbu.getUserByLogin("login")).thenReturn(thisUser =
                new User(1, "name", "login", "password", "salt"));

        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role(1, thisUser, "READ", "a"));
        roles.add(new Role(2, thisUser, "WRITE", "a.b"));

        Role role = new Role();
        role.setName("ROLE");
        when(dbu.getPermissionByUserAndRole(thisUser, role)).thenReturn(roles);

        Boolean trueRole = null;
        for (Role r : roles) {
            if (role.getName().equals(r.getName())) {
                trueRole = true;
            } else trueRole = false;
        }
        assertFalse(trueRole);
    }


}