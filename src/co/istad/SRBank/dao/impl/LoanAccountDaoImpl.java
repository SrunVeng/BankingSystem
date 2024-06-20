package co.istad.SRBank.dao.impl;

import co.istad.SRBank.dao.LoanAccountDao;
import co.istad.SRBank.domain.LoanAccount;
import co.istad.SRBank.domain.SavingAccount;
import jdk.internal.icu.text.UnicodeSet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static co.istad.SRBank.database.DbSingleton.connection;

public class LoanAccountDaoImpl implements LoanAccountDao {


    @Override
    public List<LoanAccount> findAllLoan() {
        String sql = "SELECT * FROM loan_account";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            List<LoanAccount> LoanAccounts = new ArrayList<>();

            while (result.next()) {
                LoanAccount loanAccount = new LoanAccount();
                loanAccount.setLoanAccNum(result.getInt("saving_account_number"));
                //savingAccount.setCifNumber(result.getInt("cif_number"));
                loanAccount.setInterest(result.getBigDecimal("interest"));
                loanAccount.setAmount(result.getBigDecimal("balance"));
                //    savingAccount.setStaffId(result.getInt("staff_id"));
                loanAccount.setCreateOnl(result.getDate("created_on").toLocalDate());
                LoanAccounts.add(loanAccount);

            }
            return LoanAccounts;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}