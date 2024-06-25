package co.istad.SRBank.dao.impl;

import co.istad.SRBank.dao.SavingAccountDao;
import co.istad.SRBank.database.DbSingleton;
import co.istad.SRBank.domain.SavingAccount;
import co.istad.SRBank.util.GenerateNumber;
import co.istad.SRBank.util.LoginAuth;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SavingAccountDaoImpl implements SavingAccountDao {

    private final DbSingleton dbSingleton;
    private final Connection connection;

    public SavingAccountDaoImpl() {
        dbSingleton = DbSingleton.getDbSingleton();
        connection = dbSingleton.getConnection();
    }

    @Override
    public List<SavingAccount> findAllSaving() {
        String sql = "SELECT * FROM saving_account";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            List<SavingAccount> savingAccounts = new ArrayList<>();

            while (result.next()) {
                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setSavingAccNum(result.getLong("saving_account_number"));
                savingAccount.setCifNumber(result.getInt("cif_number"));
                savingAccount.setInterest(result.getBigDecimal("interest"));
                savingAccount.setBalance(result.getBigDecimal("balance"));
                savingAccount.setStaffId(result.getInt("staff_id"));
                savingAccount.setCreateOnl(result.getDate("created_on").toLocalDate());
                savingAccounts.add(savingAccount);
            }
            return savingAccounts;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean verifyCIFBeforeOpening(int CIFNumber) {
        String sql = "SELECT * FROM customer_cif WHERE cif_number = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, CIFNumber);
            ResultSet resultSet = statement.executeQuery();
            boolean result = resultSet.next();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public void openSavingAccount(int CIF) {
        String sql = "INSERT INTO saving_account (" +
                "saving_account_number, cif_number, interest, balance, staff_id, created_on) " +
                "VALUES (?, ?, ?, ?, ?, CURRENT_DATE)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, GenerateNumber.generateUniqueNumber());
            statement.setInt(2, CIF);
            statement.setBigDecimal(3, BigDecimal.valueOf(2.5));
            statement.setBigDecimal(4, BigDecimal.valueOf(10.0));
            statement.setInt(5, LoginAuth.getInstance().getStaffId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("SavingAccount successfully created. " + affectedRows + " SavingAcc(s) created by " + LoginAuth.getInstance().getUserName() + ".");
            } else {
                System.out.println("creation failed: No Account was created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
