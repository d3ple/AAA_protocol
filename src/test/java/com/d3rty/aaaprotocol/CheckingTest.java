package com.d3rty.aaaprotocol;

import com.d3rty.aaaprotocol.dao.DbManager;
import com.d3rty.aaaprotocol.dao.DbUserSelecting;
import com.d3rty.aaaprotocol.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckingTest {
    private static User curUser;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void checkLogin() throws Exception {

//        DbManager conn = mock(DbManager.class);
//        conn.connect();

//        DbUserSelecting usersel = mock(DbUserSelecting.class);
//        when(usersel.getUserByLogin("login")).thenReturn(curUser =
//                new User(1, "name", "login", "password", "salt"));
    }

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