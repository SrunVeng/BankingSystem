package co.istad.SRBank.dao.impl;

import co.istad.SRBank.dao.LoanAccountDao;
import co.istad.SRBank.database.DbSingleton;
import co.istad.SRBank.domain.LoanAccount;
import co.istad.SRBank.util.GenerateNumber;
import co.istad.SRBank.util.LoginAuth;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanAccountDaoImpl implements LoanAccountDao {

    private final DbSingleton dbSingleton;
    private final Connection connection;

    public LoanAccountDaoImpl() {
        dbSingleton = DbSingleton.getDbSingleton();
        connection = dbSingleton.getConnection();

    }

    @Override
    public List<LoanAccount> findAllLoan() {
        String sql = "SELECT * FROM loan_account";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            List<LoanAccount> LoanAccounts = new ArrayList<>();

            while (result.next()) {
                LoanAccount loanAccount = new LoanAccount();
                loanAccount.setLoanAccNum(result.getLong("loan_account_number"));
                loanAccount.setCifNumber(result.getInt("cif_number"));
                loanAccount.setInterest(result.getBigDecimal("interest"));
                loanAccount.setAmount(result.getBigDecimal("amount"));
                loanAccount.setStaffId(result.getInt("staff_id"));
                loanAccount.setOutStanding(result.getBigDecimal("outstanding"));
                loanAccount.setTerm(result.getInt("term"));
                loanAccount.setCreateOnl(result.getDate("created_on").toLocalDate());
                LoanAccounts.add(loanAccount);
            }
            return LoanAccounts;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void openLoanAccount(int CIF, BigDecimal amount,BigDecimal outstanding, BigDecimal interest, int term) {
        String sql = "INSERT INTO loan_account (" +
                "loan_account_number, cif_number, interest, amount, outstanding, term ,staff_id, created_on) " +
                "VALUES (?, ?, ?, ?, ?, ?,?, CURRENT_DATE)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, GenerateNumber.generateUniqueNumber());
            statement.setInt(2, CIF);
            statement.setBigDecimal(3, interest);
            statement.setBigDecimal(4, amount);
            statement.setBigDecimal(5, outstanding);
            statement.setInt(6, term);
            statement.setInt(7, LoginAuth.getInstance().getStaffId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("LoanAccount successfully created. " + affectedRows + " LoanAcc(s) created by " + LoginAuth.getInstance().getUserName() + ".");
            } else {
                System.out.println("creation failed: No Account was created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
