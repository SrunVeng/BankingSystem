package co.istad.SRBank.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtil {

    public static void scanInt() {
        Scanner scanner = new Scanner(System.in);
        int inputInt;
        while (true) {
            try {
                inputInt = scanner.nextInt();
                return;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter Number.");
                scanner.next();
            }
        }
    }


    public static void scanText() {
        Scanner scanner = new Scanner(System.in);
        String inputText;

        while (true) {
            inputText = scanner.nextLine();
            if (inputText.matches("[a-zA-Z]+")) {
                return;  // Return the valid input
            } else {
                System.out.println("Invalid input. Please enter letters.");
            }
        }

    }
}
