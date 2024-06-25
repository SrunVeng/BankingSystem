package co.istad.SRBank.util;

import co.istad.SRBank.database.DbSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CloseAccount {

    private final DbSingleton dbSingleton;
    private final Connection connection;

    public CloseAccount() {
        dbSingleton = DbSingleton.getDbSingleton();
        connection = dbSingleton.getConnection();

    }
    public boolean closeAccount(long accountNumber) {
        String sql = "DELETE FROM saving_account WHERE saving_account_number = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,accountNumber);
            int DeletedAccount= statement.executeUpdate();
            return DeletedAccount > 0;

        } catch (SQLException e) {
            System.out.println("SQL exception "+ e.getMessage());
            return false;
        }
    }
}
