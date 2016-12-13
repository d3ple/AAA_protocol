package com.d3rty.aaaprotocol.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbManager {

    private static final Logger log = LogManager.getLogger(DbManager.class);

    private static final String DB_URL = "jdbc:h2:file:./src/main/resources/db/aaa";
    private static final String LOGIN = "sa";
    private static final String PASSWORD = "";
    private static final String H2_DRIVER = "org.h2.Driver";
    private static Connection dbConnection;

    public static void connect() {
        try {
            Class.forName(H2_DRIVER);
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
            return;
        }
        try {
            dbConnection = DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    public static void disconnect() {
        if (dbConnection != null) {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                log.error(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public static void migrate() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(DB_URL, LOGIN, PASSWORD);
        try {
            flyway.migrate();
        } catch (FlywayException e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    public static PreparedStatement prepareStatement(String s) throws SQLException {
        return dbConnection.prepareStatement(s);
    }
}


