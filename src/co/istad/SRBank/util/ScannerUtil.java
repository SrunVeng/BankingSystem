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

    public static void PressEnterToMainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to return to MainMenu");
        scanner.nextLine();
        MainMenu.menu();

    }

}
