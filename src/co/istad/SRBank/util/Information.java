package co.istad.SRBank.util;

public class Information {
    public static void mainMenuInfo() {
        System.out.println("1. New Customer / Create New CIF");
        System.out.println("2. Existing Customer");
        System.out.println("3. View all accounts");
        System.out.println("4. Delete CIF");
        System.out.println("5. View your information");
        System.out.println("6. Close account");
        System.out.println("0. Exit");
    }

    public static void existingCustomerInfo() {
        System.out.println("===================================");
        System.out.println("#Please select Type of account opening");
        System.out.println("1. Opening Account");
        System.out.println("2. Check Customer information");
        System.out.println("0. Back to main menu");
    }

    public static void accountOpeningInfo() {
        System.out.println("===================================");
        System.out.println("#Please select Type of account opening");
        System.out.println("1. Saving Account");
        System.out.println("2. Loan Account");
        System.out.println("0. Back ");
    }


}
