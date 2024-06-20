package co.istad.SRBank.util;

import co.istad.SRBank.dao.SavingAccountDao;
import co.istad.SRBank.dao.impl.SavingAccountDaoImpl;
import co.istad.SRBank.domain.SavingAccount;

import java.util.List;

public class MainMenu {

        static SavingAccountDao savingAccountDao = new SavingAccountDaoImpl();

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
                List<SavingAccount> savingAccounts = savingAccountDao.findAllSaving();
                System.out.println("Accounts:");
                System.out.println("========================================================================================================");
                for (SavingAccount savingAccount : savingAccounts) {
                    System.out.println(savingAccount);
                }

            }
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
