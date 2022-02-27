package CanvasProject;

import java.util.ArrayList;
import java.util.Scanner;

// This class is needed for inheritance
public class User  {

//    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
    public enum Role {STUDENT, FACULTY, ADMIN};

    // This is an array to store emails created
    public ArrayList<String> account = new ArrayList<>();

    //
    private String email;
    private String password;

    // This is an array to store admin emails created
    ArrayList<String> admin = new ArrayList<>();

    protected int role = 0; //0=user, 1=faculty



    //for creating accounts
    public void CreateAccount() {
        System.out.println("CREATE ACCOUNT");
        Scanner sc = new Scanner(System.in);
        // This is an array to store emails created

        //Ask the user to input their email
        System.out.print("Enter your email: ");
        this.email = sc.nextLine();
        //Ask the user to enter password
        System.out.print("Enter your password: ");
        String paswd = sc.nextLine();

        account.add(email);
    }

    //For logins
    public boolean login() {

        System.out.println();
        System.out.println("LOGIN HERE");
        System.out.println();
        Scanner sc = new Scanner(System.in);


        //Ask the user to input their email
        System.out.print("Enter your email: ");
        this.email = sc.nextLine();
        //Ask the user to enter password
        System.out.print("Enter your password: ");
        String paswd = sc.nextLine();

        if (account.contains(email)) {
            //System.out.println(" This account exist");
            return true;
        } else {

            //System.out.println("Please create an account!");
            return false;
        }

    }



    // for faculty
    public boolean isFaculty() {

        Scanner sc = new Scanner(System.in);
        //Ask the user to input their email
        System.out.print("Enter your email: ");
        this.email = sc.nextLine();

        if (this.role == 1 || account.contains(email)) {
            System.out.println("you are a faculty member");
            return true;
        } else {
            System.out.println("you are not a faculty member");
            return false;

        }
    }



}
