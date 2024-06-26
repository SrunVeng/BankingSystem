package co.istad.SRBank.dao;

import co.istad.SRBank.domain.SavingAccount;

import java.util.List;

public interface SavingAccountDao {


    // Find all SavingAccount
    // return type list of savingAccount
    List<SavingAccount> findAllSaving();


    // Create SavingAccount base on CIF check

    void openSavingAccount(int CIFNumber);

    boolean verifyCIFBeforeOpening(int CIFNumber);

}
