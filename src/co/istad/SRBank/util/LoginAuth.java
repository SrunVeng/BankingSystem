package co.istad.SRBank.util;

import co.istad.SRBank.database.DbSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAuth {
    private static LoginAuth instance;
    private final DbSingleton dbSingleton;
    private final Connection connection;
    private String UserName;

    private LoginAuth() {
        dbSingleton = DbSingleton.getDbSingleton();
        connection = dbSingleton.getConnection();
    }
    public static LoginAuth getInstance() {
        if (instance == null) {
            instance = new LoginAuth();
        }
        return instance;
    }

    public String getUserName() {
        return UserName;
    }

    public boolean loginAuthMainApplication(String username, String password) {
        String sql = "SELECT * FROM Staff WHERE username = ? AND password_hash = ? ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            boolean result = resultSet.next();
            if (result) {
                this.UserName = username;
            }
            return result;
        } catch (SQLException e) {
            return false;
        }
    }

    public String getUserNameLogin() {
        return UserName;
    }
}


