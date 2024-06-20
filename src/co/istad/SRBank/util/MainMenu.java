package co.istad.SRBank.util;

import co.istad.SRBank.MainApplication.SRBank;
import co.istad.SRBank.dao.LoanAccountDao;
import co.istad.SRBank.dao.SavingAccountDao;
import co.istad.SRBank.dao.impl.LoanAccountDaoImpl;
import co.istad.SRBank.dao.impl.SavingAccountDaoImpl;
import co.istad.SRBank.domain.LoanAccount;
import co.istad.SRBank.domain.SavingAccount;

import java.util.List;

public class MainMenu {


    private static void CifCreationMenu() {


    }

    private static void accountCreationMenu() {
        int OptionChose;
        Information.accountCreationInfo();
        System.out.print("Choose Option:");
        OptionChose = ScannerUtil.scanInt();
        switch (OptionChose) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 0:
                menu();
                break;
        }

    }


    public static void menu() {
        int OptionChose;
        System.out.println("  ___ ___ ___   _   _  _ _  __    _   ___ ___ ___  _   _ _  _ _____   _____   _____ _____ ___ __  __ \n" +
                " / __| _ \\ _ ) /_\\ | \\| | |/ /   /_\\ / __/ __/ _ \\| | | | \\| |_   _| / __\\ \\ / / __|_   _| __|  \\/  |\n" +
                " \\__ \\   / _ \\/ _ \\| .` | ' <   / _ \\ (_| (_| (_) | |_| | .` | | |   \\__ \\\\ V /\\__ \\ | | | _|| |\\/| |\n" +
                " |___/_|_\\___/_/ \\_\\_|\\_|_|\\_\\ /_/ \\_\\___\\___\\___/ \\___/|_|\\_| |_|   |___/ |_| |___/ |_| |___|_|  |_|\n" +
                "                                                                                                     ");

        System.out.println("========================================================================================================");
        System.out.printf("#Bank Officer:%s","Not yet functional");
        System.out.println();
        Information.mainMenuInfo();
        System.out.print("Choose Option:");
        OptionChose = ScannerUtil.scanInt();

        switch (OptionChose) {
            case 1:
                System.out.println("Create CIF");
                break;
            case 2:
                accountCreationMenu();
                break;
            case 3:
            {

                SavingAccountDao savingAccountDao = new SavingAccountDaoImpl();
                LoanAccountDao loanAccountDao = new LoanAccountDaoImpl();
                List<SavingAccount> savingAccounts = savingAccountDao.findAllSaving();
                List<LoanAccount> loanAccounts = loanAccountDao.findAllLoan();
                System.out.println("Accounts:");
                System.out.println("========================================================================================================");
                for (SavingAccount savingAccount : savingAccounts) {
                    System.out.println(savingAccount);
                }
                for (LoanAccount loanAccount : loanAccounts) {
                    System.out.println(loanAccount);
                }
            }
            System.out.println("========================================================================================================");
            System.out.println("Press Enter to return to MainMenu");
            ScannerUtil.PressEnter();
            menu();
                break;
            case 4:
                System.out.println("view staff info");
                break;
            case 5:
                System.out.println("Close Account");
                break;
            case 0:
                System.exit(0);
                break;
        }


    }
}
