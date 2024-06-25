package co.istad.SRBank.dao;

import co.istad.SRBank.domain.LoanAccount;

import java.math.BigDecimal;
import java.util.List;

public interface LoanAccountDao {

    List<LoanAccount> findAllLoan();


    // Create LoanAccount base on CIF check

    void openLoanAccount(int CIFNumber, BigDecimal loanAmount,BigDecimal outstanding, BigDecimal interest, int Term);




}
