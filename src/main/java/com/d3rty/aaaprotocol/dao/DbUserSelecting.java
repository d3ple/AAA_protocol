package com.d3rty.aaaprotocol.dao;

import com.d3rty.aaaprotocol.domain.Accounting;
import com.d3rty.aaaprotocol.domain.Role;
import com.d3rty.aaaprotocol.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbUserSelecting {

    private static DbManager db = new DbManager();
    private static final Logger log = LogManager.getLogger(DbUserSelecting.class);

    public User getUserByLogin(String login) {
        try {
            PreparedStatement preparedStatement = db.prepareStatement("SELECT * FROM USER WHERE LOGIN = ?");
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

    public ArrayList<Role> getPermissionByUserAndRole(User user, Role role) {
        try {
            PreparedStatement preparedStatement = db.
                    prepareStatement("SELECT * FROM PERMISSION WHERE USER_ID = ? AND ROLE = ?");
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

    public void addIntoAccounting(Accounting accounting) {
        try {
            PreparedStatement preparedStatement = db.prepareStatement(
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
