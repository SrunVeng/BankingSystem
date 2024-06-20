package co.istad.SRBank.dao;

import co.istad.SRBank.domain.LoanAccount;

import java.util.List;

public interface LoanAccountDao {

    List<LoanAccount> findAllLoan();

}
