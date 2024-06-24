package co.istad.SRBank.dao.impl;

import co.istad.SRBank.dao.StaffDao;
import co.istad.SRBank.database.DbSingleton;
import co.istad.SRBank.domain.Staff;
import co.istad.SRBank.util.LoginAuth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDaoImpl implements StaffDao {

    private final DbSingleton dbSingleton;
    private final Connection connection;

    public StaffDaoImpl() {
        dbSingleton = DbSingleton.getDbSingleton();
        connection = dbSingleton.getConnection();
    }
    
    @Override
    public Staff showStaffInformation() {
        Staff staff = null;
        String sql = "SELECT * FROM staff WHERE username = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, LoginAuth.getInstance().getUserNameLogin());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                staff = new Staff();
                staff.setId(result.getInt("staff_id"));
                staff.setUserName(result.getString("username"));
                staff.setFirstName(result.getString("first_name"));
                staff.setLastName(result.getString("last_name"));
                staff.setPhoneNumber(result.getString("phone_number"));
                staff.setRole(result.getString("role"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return staff;
    }
}
