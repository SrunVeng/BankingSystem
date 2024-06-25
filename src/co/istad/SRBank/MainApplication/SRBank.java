package co.istad.SRBank.MainApplication;
import co.istad.SRBank.util.LoginAuth;
import co.istad.SRBank.util.MainMenu;
import co.istad.SRBank.util.ScannerUtil;

public class SRBank {
    public static void main(String[] args) {
        LoginAuth loginAuth = LoginAuth.getInstance();
        System.out.println("""
                   __             _      \s
                  / /  ___   __ _(_)_ __ \s
                 / /  / _ \\ / _` | | '_ \\\s
                / /__| (_) | (_| | | | | |
                \\____/\\___/ \\__, |_|_| |_|
                            |___/        \s""");
        while (true) {
            String Username = ScannerUtil.scanText("Enter Username:");
            String password = ScannerUtil.scanPassword("Enter Password:");
            if (loginAuth.loginAuthMainApplication(Username, password)) {
                System.out.printf("Login as %s successfully\nPress Enter to Continue", Username);
                ScannerUtil.PressEnter();
                MainMenu.menu();
                break;
            } else {
                System.out.println("Invalid User Input");
            }
        }
    }
}
