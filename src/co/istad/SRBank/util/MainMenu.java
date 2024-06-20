package co.istad.SRBank.util;

public class MainMenu {

    public void menu() {
        System.out.println("  ___ ___ ___   _   _  _ _  __    _   ___ ___ ___  _   _ _  _ _____   _____   _____ _____ ___ __  __ \n" +
                " / __| _ \\ _ ) /_\\ | \\| | |/ /   /_\\ / __/ __/ _ \\| | | | \\| |_   _| / __\\ \\ / / __|_   _| __|  \\/  |\n" +
                " \\__ \\   / _ \\/ _ \\| .` | ' <   / _ \\ (_| (_| (_) | |_| | .` | | |   \\__ \\\\ V /\\__ \\ | | | _|| |\\/| |\n" +
                " |___/_|_\\___/_/ \\_\\_|\\_|_|\\_\\ /_/ \\_\\___\\___\\___/ \\___/|_|\\_| |_|   |___/ |_| |___/ |_| |___|_|  |_|\n" +
                "                                                                                                     ");

        System.out.println("========================================================================================================");

        System.out.println("1. New Customer / Create New CIF");
        System.out.println("2. Existing Customer");

        System.out.println("3. View your information");
        System.out.println("4. Exit");

        System.out.println("===================================");
        System.out.println("#Please select Type of account opening");
        System.out.println("1. Saving Account");
        System.out.println("2. Loan Account");


        ScannerUtil.scanInt();



    }






}
