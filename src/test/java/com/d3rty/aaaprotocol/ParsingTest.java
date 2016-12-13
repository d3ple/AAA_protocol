package com.d3rty.aaaprotocol;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParsingTest {

    @Test
    public void isEmptyTrue() throws Throwable {
        String args[] = {"-l", "login", "-p", "password"};
        assertFalse(new Parsing(args).parse().isEmpty());
    }

    @Test
    public void isAuthenticationPossibleTrue() throws Throwable {
        String args[] = {"-l", "login", "-p", "password"};
        assertTrue(new Parsing(args).parse().isAuthenticationPossible());
    }

    @Test
    public void isAuthorizationPossibleTrue() throws Throwable {
        String args[] = {"-l", "login", "-p", "password", "-role", "role", "-res", "res"};
        assertTrue(new Parsing(args).parse().isAuthorizationPossible());
    }

    @Test
    public void isAccountingPossibleTrue() throws Throwable {
        String args[] = {"-l", "login", "-p", "password", "-role", "role", "-res", "res",
                "-ds", "2015-05-01", "-de", "2015-05-02", "-vol", "100"};
        assertTrue(new Parsing(args).parse().isAccountingPossible());
    }

    @Test
    public void isAuthenticationPossibleFalse() throws Throwable {
        String args[] = {"-l", "login"};
        assertFalse(new Parsing(args).parse().isAuthenticationPossible());
    }

    @Test
    public void isAuthorizationPossibleFalse() throws Throwable {
        String args[] = {"-l", "login", "-p", "password", "-role", "role"};
        assertFalse(new Parsing(args).parse().isAuthorizationPossible());
    }

    @Test
    public void isAccountingPossibleFalse() throws Throwable {
        String args[] = {"-l", "login", "-p", "password", "-role", "role", "-res", "res",
                "-ds", "2015-05-01", "-de", "2015-05-02"};
        assertFalse(new Parsing(args).parse().isAccountingPossible());
    }
}
