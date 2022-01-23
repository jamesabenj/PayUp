package dev.benjamin.app;
import dev.benjamin.models.User;
import dev.benjamin.service.UserService;
import dev.benjamin.repository.UserDAO;

import java.util.Scanner;


public class AppDriver extends ConsoleInteractions{
    private static Scanner scan = new Scanner(System.in);
    private static UserService serve = new UserService();
    private static UserDAO userDao = new UserDAO();


    public static void main(String[] args) {
        //Display Homepage
        home();
        //Collect input from Homepage
        int inputFromHome = scan.nextInt();
        //Display log in flow or quit
        login(inputFromHome);
        int inputFromLoginPage = scan.nextInt();
  /*      switch(scan.nextInt()) {
                    case 1:
                        print("Goodbye!");
                        System.exit(0);
                        break;
                    case 2:
                        home();
                        return null;
                }*/
        //attempt to log in
    /*    if (serve.successfulLogin(username, password)) {
            User user = userDao.getByUsername(username);
            print("Login Successful, Welcome " + user.getFirstName());
            return user;
        } else {home();}*/
        //Display user dashboard
        //dashboard();
        //Collect input from dashboard - navigation
   /*     int inputFromDash = scan.nextInt();
        switch(inputFromDash) {

        }
        requestForm();*/



    }
}
