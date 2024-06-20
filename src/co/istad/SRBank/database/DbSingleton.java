package co.istad.SRBank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {
    private static DbSingleton dbSingleton;
    public static Connection connection;

    private DbSingleton() {
        try {
            // 1. Register Driver
            Class.forName("org.postgresql.Driver");
            // 2. Establish connection
            String url = "jdbc:postgresql://localhost:5432/SRBank";
            String username = "postgres";
            String password = "admin";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Register Driver failed: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Establish Connection failed: " + e.getMessage());
        }
    }

    public static DbSingleton getDbSingleton() {
        if (dbSingleton == null) {
            synchronized (DbSingleton.class) {
                if (dbSingleton == null) {
                    dbSingleton = new DbSingleton();
                }
            }
        }
        return dbSingleton;
    }

    public Connection getConnection() {
        return connection;
    }
}
