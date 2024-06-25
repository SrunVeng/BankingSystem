package co.istad.SRBank.util;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtil {
    public static int scanInt(String label) {
        Scanner scanner = new Scanner(System.in);
        int inputInt;
        System.out.print(label);
        while (true) {
            try {
                inputInt = scanner.nextInt();
                return inputInt;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter Number.");
            }
            System.out.print(label);
        }
    }

    public static BigDecimal scanBigDecimal(String label) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal inputBigDecimal;
        System.out.print(label);
        while (true) {
            try {
                inputBigDecimal = scanner.nextBigDecimal();
                return inputBigDecimal;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
            System.out.print(label);
        }
    }



    public static int scanNid(String label) {
        Scanner scanner = new Scanner(System.in);
        int inputInt;
        System.out.print(label);
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
                scanner.next(); // Clear the invalid input
            }
            System.out.print(label); // Prompt again
        }
    }

    public static Long scanAccountNumber(String label) {
        Scanner scanner = new Scanner(System.in);
        long inputInt;
        System.out.print(label);
        while (true) {
            try {
                inputInt = scanner.nextLong();
                return inputInt;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter Number.");
                scanner.next();
            }
            System.out.print(label);
        }
    }

    public static String scanText(String label) {
        Scanner scanner = new Scanner(System.in);
        String inputText;
        System.out.print(label);
        while (true) {
            inputText = scanner.nextLine();
            if (inputText.matches("[a-zA-Z]+")) {
                return inputText;  // Return the valid input
            } else {
                System.out.println("Invalid input. Please enter letters.");
                System.out.print(label);
            }
        }
    }

    public static String scanTextNum(String label) {
        Scanner scanner = new Scanner(System.in);
        String inputText;
        System.out.print(label);
        while (true) {
            inputText = scanner.nextLine();
            // Modify the condition to allow alphanumeric input
            if (inputText.matches("^[a-zA-Z0-9]+$")) {
                return inputText;  // Return the valid input
            } else {
                System.out.println("Invalid input. Please enter alphanumeric characters.");
                System.out.print(label);
            }
        }
    }



    public static String scanPassword(String label) {
        String inputPassword;
        Scanner scanner = new Scanner(System.in);
        System.out.print(label);
        while (true) {

            inputPassword = scanner.nextLine();
            if (inputPassword.matches("[a-zA-Z0-9!@#$%^&*(),.?\":{}|<>]+")) {
                return inputPassword;
            } else {
                System.out.println("Invalid Password format");
                System.out.print(label);
            }
        }
    }

    public static String scanPhoneNumber(String label) {
        Scanner scanner = new Scanner(System.in);
        String inputPhoneNumber;
        String regexPattern = "^0\\d{8,9}$"; // Regex pattern for phone number starting with 0 and having length of 9 or 10 digits
        System.out.print(label);
        while (true) {
            inputPhoneNumber = scanner.nextLine().trim(); // Trim leading/trailing whitespace

            // Validate input against regex pattern
            if (inputPhoneNumber.matches(regexPattern)) {
                return inputPhoneNumber;  // Return the valid input
            } else {
                System.out.println("Invalid phone number format. Please enter a valid phone number starting with 0 and having length of 9 or 10 digits:");
                System.out.print(label);
            }
        }
    }

    public static void PressEnter() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }

    public static char scanGender(String label) {
        Scanner scanner = new Scanner(System.in);
        char inputGender;
        System.out.print(label);
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase(); // Convert to uppercase for case-insensitivity

            if (input.length() == 1 && (input.equals("M") || input.equals("F"))) {
                inputGender = input.charAt(0);
                return inputGender;  // Return the valid input
            } else {
                System.out.println("Invalid input. Please enter 'M' or 'F'.");
                System.out.print(label);
            }
        }
    }

    public static String scanYesNo(String label) {
        Scanner scanner = new Scanner(System.in);
        String inputYN;
        System.out.print(label);
        while (true) {
            inputYN = scanner.nextLine().trim().toUpperCase(); // Convert to uppercase for case-insensitivity
            if (inputYN.length() == 1 && (inputYN.equals("Y") || inputYN.equals("N"))) {
                return inputYN;  // Return the valid input
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                System.out.print(label);
            }
        }
    }

    public static String scanDate(String label) {
        Scanner scanner = new Scanner(System.in);
        String inputDate;
        String regexPattern = "\\b\\d{4}-\\d{2}-\\d{2}\\b"; // Regex pattern for YYYY-MM-DD format
        System.out.print(label);
        while (true) {
            inputDate = scanner.nextLine().trim(); // Trim leading/trailing whitespace
            // Check if input matches YYYY-MM-DD format using regex
            if (inputDate.matches(regexPattern)) {
                return inputDate;  // Return the valid input
            } else {

                System.out.println("Invalid input format. Please enter date in YYYY-MM-DD format:");
                System.out.print(label);
            }
        }

    }
}

