package co.istad.SRBank.dao.impl;

import co.istad.SRBank.dao.CustomerCifDao;
import co.istad.SRBank.database.DbSingleton;
import co.istad.SRBank.domain.CustomerCif;
import co.istad.SRBank.domain.Staff;

import java.sql.*;

public class CustomerCifDaoImpl implements CustomerCifDao {
    CustomerCif customerCif = new CustomerCif();
    Staff staff = new Staff();
    private final DbSingleton dbSingleton;
    private final Connection connection;

    public CustomerCifDaoImpl() {
        dbSingleton = DbSingleton.getDbSingleton();
        connection = dbSingleton.getConnection();
    }


    @Override
    public void registerCif() {
        String sql = "INSERT INTO customer_cif (" +
                "first_name, last_name, gender, dob, nid, employment, source_of_fund, " +
                "phone_number, district, province_city, street, house, created_on, staff_id" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customerCif.getFirst_name());
            statement.setString(2, customerCif.getLast_name());
            statement.setString(3, String.valueOf(customerCif.getGender()));
            statement.setDate(4, customerCif.getDob());
            statement.setString(5, customerCif.getNid());
            statement.setString(6, customerCif.getEmployment());
            statement.setString(7, customerCif.getSourceOfFund());
            statement.setString(8, customerCif.getPhoneNumber());
            statement.setString(9, customerCif.getDistrict());
            statement.setString(10, customerCif.getProvinceCity());
            statement.setString(11, customerCif.getStreet());
            statement.setString(12, customerCif.getHouse());
            statement.setInt(13, customerCif.getStaffId().getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Insert successful, " + affectedRows + " row(s) affected.");
            } else {
                System.out.println("Insert failed, no rows affected.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
