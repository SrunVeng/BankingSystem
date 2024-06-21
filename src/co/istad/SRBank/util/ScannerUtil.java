package co.istad.SRBank.util;

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

    public static void PressEnter() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }

}
