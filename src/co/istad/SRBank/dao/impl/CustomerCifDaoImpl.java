package co.istad.SRBank.dao.impl;

import co.istad.SRBank.dao.CustomerCifDao;
import co.istad.SRBank.database.DbSingleton;
import co.istad.SRBank.domain.CustomerCif;
import co.istad.SRBank.util.LoginAuth;
import co.istad.SRBank.util.MainMenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerCifDaoImpl implements CustomerCifDao {
    private final DbSingleton dbSingleton;
    private final Connection connection;

    public CustomerCifDaoImpl() {
        dbSingleton = DbSingleton.getDbSingleton();
        connection = dbSingleton.getConnection();
    }

    @Override
    public void registerCif(CustomerCif newCustomerCif) {
        String sql = "INSERT INTO customer_cif (" +
                "first_name, last_name, gender, dob, nid, employment, source_of_fund, " +
                "phone_number, district, province_city, street, house, created_on, staff_id" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newCustomerCif.getFirst_name());
            statement.setString(2, newCustomerCif.getLast_name());
            statement.setString(3, String.valueOf(newCustomerCif.getGender()));
            statement.setDate(4, newCustomerCif.getDob());
            statement.setString(5, newCustomerCif.getNid());
            statement.setString(6, newCustomerCif.getEmployment());
            statement.setString(7, newCustomerCif.getSourceOfFund());
            statement.setString(8, newCustomerCif.getPhoneNumber());
            statement.setString(9, newCustomerCif.getDistrict());
            statement.setString(10, newCustomerCif.getProvinceCity());
            statement.setString(11, newCustomerCif.getStreet());
            statement.setString(12, newCustomerCif.getHouse());
            statement.setInt(13, LoginAuth.getInstance().getStaffId());

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("CIF successfully created. " + affectedRows + " CIF(s) created by " + LoginAuth.getInstance().getUserName() + ".");
            } else {
                System.out.println("CIF creation failed: No CIF was created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Consider using a logger
        }
    }


    @Override
    public void deleteCif(int cifForDelete) {
        String sql = "DELETE FROM customer_cif WHERE cif_number = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cifForDelete);
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("CIF successfully deleted. " + affectedRows + " CIF(s) removed by " + LoginAuth.getInstance().getUserName() + ".");
            } else {
                System.out.println("CIF removed failed: No CIF was removed.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
