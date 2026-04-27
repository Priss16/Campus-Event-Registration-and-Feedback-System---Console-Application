package Campus.model;

import java.util.Scanner;

public class Admin {

    private final String USERNAME = "admin";
    private final String PASSWORD = "admin123";

    public boolean login() {

    // ❌ REMOVE this:
    // Scanner sc = new Scanner(System.in);

    try {
        System.out.println("===== ADMIN LOGIN =====");
        System.out.print("Enter Username: ");
        String user = Campus.util.InputOperations.sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = Campus.util.InputOperations.sc.nextLine();

        if(user.equals(USERNAME) && pass.equals(PASSWORD)) {
            System.out.println("--Login Successful-- \n");
            return true;
        } else {
            System.out.println("--Invalid Credentials--");
            return false;
        }

    } catch (Exception e) {
        return false;
    }

    // ❌ REMOVE finally block completely
    }
}
