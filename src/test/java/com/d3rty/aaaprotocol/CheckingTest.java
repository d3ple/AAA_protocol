package com.d3rty.aaaprotocol;

import com.d3rty.aaaprotocol.dao.DbUserSelecting;
import com.d3rty.aaaprotocol.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckingTest {
    private static User thisUser;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

//    @Test
//    public void checkLogin() throws Exception {
//        DbUserSelecting dbu = mock(DbUserSelecting.class);
//        when(dbu.getUserByLogin("login")).thenReturn(thisUser =
//                new User(1, "name", "login", "password", "salt"));
//    }

    @Test
    public void checkPassword() throws Exception {

    }

    @Test
    public void checkRole() throws Exception {

    }

    @Test
    public void checkRoleAndResource() throws Exception {

    }

}