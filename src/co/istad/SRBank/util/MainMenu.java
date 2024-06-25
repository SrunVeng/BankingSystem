package co.istad.SRBank.util;

import co.istad.SRBank.dao.CustomerCifDao;
import co.istad.SRBank.dao.LoanAccountDao;
import co.istad.SRBank.dao.SavingAccountDao;
import co.istad.SRBank.dao.StaffDao;
import co.istad.SRBank.dao.impl.CustomerCifDaoImpl;
import co.istad.SRBank.dao.impl.LoanAccountDaoImpl;
import co.istad.SRBank.dao.impl.SavingAccountDaoImpl;
import co.istad.SRBank.dao.impl.StaffDaoImpl;
import co.istad.SRBank.domain.CustomerCif;
import co.istad.SRBank.domain.LoanAccount;
import co.istad.SRBank.domain.SavingAccount;
import co.istad.SRBank.domain.Staff;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;


public class MainMenu {
    private static void CifCreationMenu() {
        System.out.println("Welcome onboard New Customer");
        CustomerCif newCustomerCif = new CustomerCif();
        boolean complete = true;
        Scanner scanner = new Scanner(System.in);
        Staff staff = new Staff();
        String firstName;
        String last_Name;
        char gender;
        Date dateOfBirth;
        String nid;
        String employment;
        String incomeSource;
        String phoneNumber;
        String district;
        String provinceCity;
        String street;
        String house;

        do {
            // General Information
            System.out.println("# General Information");
            firstName = ScannerUtil.scanText("First Name: ");
            last_Name = ScannerUtil.scanText("Last Name: ");
            gender = ScannerUtil.scanGender("Gender (M/F): ");
            dateOfBirth = Date.valueOf(ScannerUtil.scanDate("Date of Birth (YYYY-MM-DD): "));
            nid = String.valueOf(ScannerUtil.scanNid("National ID: "));
            employment = ScannerUtil.scanText("Employment status: ");
            incomeSource = ScannerUtil.scanText("Income Source: ");
            phoneNumber = ScannerUtil.scanPhoneNumber("Phone Number: ");
            // End Part I

            // Address Information
            System.out.println("# Address Information");
            district = ScannerUtil.scanText("District: ");
            provinceCity = ScannerUtil.scanText("Province or City:");
            street = ScannerUtil.scanText("Street: ");
            house = ScannerUtil.scanText("House:");
            // End Part II

            //Confirmation
            System.out.println("You have completed the form.");
            String confirm = ScannerUtil.scanYesNo("Do you confirm all information is correct? (y/n): ");

            if (confirm.equalsIgnoreCase("y")) {
                complete = true;
            } else {
                complete = false;
                System.out.println("Please review and correct your information.");
            }

        } while (!complete);

        System.out.println("Thank you for completing the form.");
        newCustomerCif.setFirst_name(firstName);
        newCustomerCif.setLast_name(last_Name);
        newCustomerCif.setGender(gender);
        newCustomerCif.setDob(dateOfBirth);
        newCustomerCif.setNid(nid);
        newCustomerCif.setEmployment(employment);
        newCustomerCif.setSourceOfFund(incomeSource);
        newCustomerCif.setPhoneNumber(phoneNumber);
        newCustomerCif.setDistrict(district);
        newCustomerCif.setProvinceCity(provinceCity);
        newCustomerCif.setStreet(street);
        newCustomerCif.setHouse(house);
        newCustomerCif.setId(staff.getId());


        CustomerCifDao cifDao = new CustomerCifDaoImpl();
        cifDao.registerCif(newCustomerCif);
    }

    private static void accountCreationMenu() {
        int OptionChose;
        Information.accountCreationInfo();
        OptionChose = ScannerUtil.scanInt("Choose Option: ");
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
        System.out.printf("#Bank Officer:%s", LoginAuth.getInstance().getUserNameLogin());
        System.out.println();
        Information.mainMenuInfo();
        OptionChose = ScannerUtil.scanInt("Choose Option:");
        switch (OptionChose) {
            case 1:
                CifCreationMenu();
                break;
            case 2:
                accountCreationMenu();
                break;
            case 3: {

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
                System.out.println("#CIF Remover");
                int deleteCIF = ScannerUtil.scanInt("Enter CIF Number to delete :");
                boolean deletedCIF;
                String confirm = ScannerUtil.scanYesNo("Do you confirm to delete CIF? (y/n): ");

                if (confirm.equalsIgnoreCase("y")) {
                    deletedCIF = true;
                    CustomerCifDao cifDao = new CustomerCifDaoImpl();
                    cifDao.deleteCif(deleteCIF);
                } else {
                    deletedCIF = false;
                    System.out.println(">Enter to return to main menu");
                    ScannerUtil.PressEnter();
                    menu();
                }
                break;

            case 5:
                StaffDao staffDao = new StaffDaoImpl();
                Staff staff = staffDao.showStaffInformation();
                System.out.println(staff);
                System.out.print("Press Enter to return to Main menu");
                ScannerUtil.PressEnter();
                menu();
                break;
            case 6:
                CloseAccount closeAccount = new CloseAccount();
                System.out.println("#You have permission to close only SavingAccount Type");
                boolean deleted = false;
                do {
                    System.out.print(">Enter Closing SavingAccNumber:");
                    int accountNumber = ScannerUtil.scanAccountNumber();
                    if (accountNumber == 0) {
                        menu();
                    } else {
                        boolean success = closeAccount.closeAccount(accountNumber);
                        if (success) {
                            System.out.println("AccountNumber: " + accountNumber + " has been closed successfully");
                            System.out.println("Press Enter to return to MainMenu");
                            ScannerUtil.PressEnter();
                            deleted = true;
                            menu();
                        } else {
                            System.out.println("Invalid AccountNumber");
                            System.out.println("Press Enter to try again");
                            System.out.println("Type 0 Enter to Return to MainMenu");
                            ScannerUtil.PressEnter();
                        }
                    }
                } while (!deleted);
                break;
            case 0:
                System.exit(0);
                break;
        }


    }
}
