package co.istad.SRBank.MainApplication;


import co.istad.SRBank.database.DbSingleton;
import co.istad.SRBank.util.MainMenu;

import java.sql.Connection;

public class SRBank {

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.menu();

    }
}
