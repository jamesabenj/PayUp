package dev.benjamin.app;
import java.util.Scanner;

import dev.benjamin.repository.UserDAO;
import dev.benjamin.service.UserService;

public class ConsoleInteractions {
    private static Scanner scan = new Scanner(System.in);
    private static UserService serve = new UserService();
    private static UserDAO userDao = new UserDAO();

    public static void print(String str) {
        System.out.println(str);
    }

    static void home(){
        print("Welcome to the payUP reimbursement system.");
        print("\nLog in to continue, or quit to exit.");
        print("1. Log In \n2. Quit");
    }

    static String[] login(int input) {
        String[] result = new String[2];

        switch(input) {
            case 1:
                print("Please enter your username:");
                String username = scan.next();
                result[0] = username;
                print("Please enter your password");
                String password = scan.next();
                result[1] = password;
                break;
            case 2:
                print("Are you sure you want to quit?");
                print("1. Yes - Leave \n2. No - Stay");
                break;
        }
        return result;
    }

    static void userDashboard() {
        print("Your remaining disbursement: ");
        print("1. New Request \n2. Request History \3. Quit");
    }

    static void managerDashboard() {
        print("1. Your Org \n2. Pending Requests \n3. Modeling");

    }

    static void requestForm() {
        print("Select Event Type:");
                    print("1. University Course" +
                          "2. Seminar" +
                          "3. Certification Prep Class" +
                          "4. Certification Test" +
                          "5. Technical Training" +
                          "6. Other");
    }

}
