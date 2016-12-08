package com.d3rty.aaaprotocol;

import com.d3rty.aaaprotocol.domain.Accounting;
import com.d3rty.aaaprotocol.domain.Role;
import com.d3rty.aaaprotocol.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;

import java.sql.*;
import java.util.ArrayList;

public class DbManager {

    static final Logger log = LogManager.getLogger(DbManager.class);

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

    public static User getUserByLogin(String login) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = dbConnection.prepareStatement("SELECT * FROM USER WHERE LOGIN = ?");
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("salt"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Role> getPermissionByUserAndRole(User user, Role role) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = dbConnection.prepareStatement("SELECT * FROM PERMISSION WHERE USER_ID = ? AND ROLE = ?");
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, role.getName());
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Role> roles = new ArrayList<>();
            while (rs.next()) {
                roles.add(new Role(
                        rs.getInt("id"),
                        user,
                        rs.getString("role"),
                        rs.getString("resource")));
            }
            return roles;
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void addIntoAccounting(Accounting accounting) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = dbConnection.prepareStatement(
                    "INSERT INTO accounting (PERMISSION_ID, DATE_START, DATE_END, VOLUME) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, accounting.getRole().getId());
            preparedStatement.setDate(2, Date.valueOf(accounting.getDateSt()));
            preparedStatement.setDate(3, Date.valueOf(accounting.getDateEnd()));
            preparedStatement.setLong(4, accounting.getVolume());
            preparedStatement.execute();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }


}


