package co.istad.SRBank.util;

import co.istad.SRBank.database.DbSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAuth {

    private final DbSingleton dbSingleton;
    private final Connection connection;
    public LoginAuth() {
        dbSingleton = DbSingleton.getDbSingleton();
        connection = dbSingleton.getConnection();
    }

    public boolean loginAuthMainApplication(String username, String password) {
        String sql = "SELECT * FROM Staff WHERE username = ? AND password_hash = ? ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }


}


