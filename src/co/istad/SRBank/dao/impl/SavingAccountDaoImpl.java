package co.istad.SRBank.dao.impl;

import co.istad.SRBank.dao.SavingAccountDao;
import co.istad.SRBank.database.DbSingleton;
import co.istad.SRBank.domain.SavingAccount;

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
                savingAccount.setSavingAccNum(result.getInt("saving_account_number"));
               // savingAccount.setCifNumber(result.getInt("cif_number"));
                savingAccount.setInterest(result.getBigDecimal("interest"));
                savingAccount.setBalance(result.getBigDecimal("balance"));
                //    savingAccount.setStaffId(result.getInt("staff_id"));
                savingAccount.setCreateOnl(result.getDate("created_on").toLocalDate());
                savingAccounts.add(savingAccount);
            }
            return savingAccounts;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
