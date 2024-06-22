package co.istad.SRBank.util;

import co.istad.SRBank.domain.CustomerCif;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtil {

    public static int scanInt() {
        Scanner scanner = new Scanner(System.in);
        int inputInt;
        while (true) {
            try {
                inputInt = scanner.nextInt();
                return inputInt;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter Number.");
                scanner.next();
            }
        }
    }


    public static int scanNid() {
        Scanner scanner = new Scanner(System.in);
        int inputInt;

        while (true) {
            try {
                inputInt = scanner.nextInt();

                // Validate the input
                String inputStr = String.valueOf(inputInt);
                if (inputStr.length() == 9) {
                    return inputInt;
                } else {
                    System.out.println("Invalid input. Please enter a 9-digit number.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("National ID:");
                scanner.next(); // Consume invalid input
            }
        }
    }

    public static int scanAccountNumber() {
        Scanner scanner = new Scanner(System.in);
        int inputInt;
        while (true) {
            try {
                inputInt = scanner.nextInt();
                return inputInt;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter Number.");
                System.out.println("Press Enter to try again.");
                System.out.println("Type 0 Enter to Return to MainMenu");
                PressEnter();
                System.out.print(">Enter Closing SavingAccNumber:");
                scanner.next();
            }
        }
    }


    public static String scanText() {
        Scanner scanner = new Scanner(System.in);
        String inputText;

        while (true) {
            inputText = scanner.nextLine();
            if (inputText.matches("[a-zA-Z]+")) {
                return inputText;  // Return the valid input
            } else {
                System.out.println("Invalid input. Please enter letters.");
            }
        }

    }

    public static String scanPassword() {
        String inputPassword;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            inputPassword = scanner.nextLine();
            if (inputPassword.matches("[a-zA-Z0-9!@#$%^&*(),.?\":{}|<>]+")) {
                return inputPassword;
            } else {
                System.out.println("Invalid Password format");
            }
        }
    }

    public static String scanPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        String inputPhoneNumber;
        String regexPattern = "^0\\d{8,9}$"; // Regex pattern for phone number starting with 0 and having length of 9 or 10 digits

        while (true) {
            inputPhoneNumber = scanner.nextLine().trim(); // Trim leading/trailing whitespace

            // Validate input against regex pattern
            if (inputPhoneNumber.matches(regexPattern)) {
                return inputPhoneNumber;  // Return the valid input
            } else {
                System.out.println("Invalid phone number format. Please enter a valid phone number starting with 0 and having length of 9 or 10 digits:");
            }
        }
    }

    public static void PressEnter() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }

    public static char scanGender() {
        Scanner scanner = new Scanner(System.in);
        char inputGender;

        while (true) {
            String input = scanner.nextLine().trim().toUpperCase(); // Convert to uppercase for case-insensitivity

            if (input.length() == 1 && (input.equals("M") || input.equals("F"))) {
                inputGender = input.charAt(0);
                return inputGender;  // Return the valid input
            } else {
                System.out.println("Invalid input. Please enter 'M' or 'F'.");
            }
        }
    }

    public static String scanYesNo() {
        Scanner scanner = new Scanner(System.in);
        String inputYN;
        while (true) {
            inputYN = scanner.nextLine().trim().toUpperCase(); // Convert to uppercase for case-insensitivity
            if (inputYN.length() == 1 && (inputYN.equals("Y") || inputYN.equals("N"))) {
                return inputYN;  // Return the valid input
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
    }


    public static String scanDate() {
        Scanner scanner = new Scanner(System.in);
        String inputDate;
        String regexPattern = "\\b\\d{4}-\\d{2}-\\d{2}\\b"; // Regex pattern for YYYY-MM-DD format
        while (true) {
            inputDate = scanner.nextLine().trim(); // Trim leading/trailing whitespace
            // Check if input matches YYYY-MM-DD format using regex
            if (inputDate.matches(regexPattern)) {
                return inputDate;  // Return the valid input
            } else {

                System.out.println("Invalid input format. Please enter date in YYYY-MM-DD format:");
                System.out.print("Try Again:");
            }
        }

    }


    public static void fillInCifForm() {
        boolean complete = true;
        Scanner scanner = new Scanner(System.in);
        CustomerCif customerCif = new CustomerCif();
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
            System.out.println("# General Information");
            System.out.print("First Name: ");
            firstName = ScannerUtil.scanText();


            System.out.print("Last Name: ");
            last_Name = ScannerUtil.scanText();

            System.out.print("Gender (M/F): ");
            gender = ScannerUtil.scanGender();

            System.out.print("Date of Birth (YYYY-MM-DD): ");
            dateOfBirth = Date.valueOf(ScannerUtil.scanDate());

            System.out.print("National ID: ");
            nid = String.valueOf(ScannerUtil.scanNid());

            System.out.print("Employment status: ");
            employment = ScannerUtil.scanText();

            System.out.print("Income Source: ");
            incomeSource = ScannerUtil.scanText();

            System.out.print("Phone Number: ");
            phoneNumber = ScannerUtil.scanPhoneNumber();

            System.out.println("# Address Information");
            System.out.print("District: ");
            district = ScannerUtil.scanText();

            System.out.print("Province or City: ");
            provinceCity = ScannerUtil.scanText();

            System.out.print("Street: ");
            street = ScannerUtil.scanText();

            System.out.print("House: ");
            house = ScannerUtil.scanText();

            System.out.println("You have completed the form.");
            System.out.print("Do you confirm all information is correct? (y/n): ");
            String confirm = ScannerUtil.scanYesNo();

            if (confirm.equalsIgnoreCase("y")) {
                complete = true;
            } else {
                complete = false;
                System.out.println("Please review and correct your information.");
            }

        } while (!complete);

        System.out.println("Thank you for completing the form.");
        customerCif.setFirst_name(firstName);
        customerCif.setLast_name(last_Name);
        customerCif.setGender(gender);
        customerCif.setDob(dateOfBirth);
        customerCif.setNid(nid);
        customerCif.setEmployment(employment);
        customerCif.setSourceOfFund(incomeSource);
        customerCif.setPhoneNumber(phoneNumber);
        customerCif.setDistrict(district);
        customerCif.setProvinceCity(provinceCity);
        customerCif.setStreet(street);
        customerCif.setHouse(house);
        scanner.close();

    }

}

