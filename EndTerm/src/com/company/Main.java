package com.company;

public class Main {
    public static void main(String[] args) {
        DB.ConnectDB();

        UserMenu menu = new UserMenu();
        menu.mainMenu();

        DB.CloseDB();
    }
}
