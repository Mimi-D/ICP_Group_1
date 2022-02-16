package com.assignments.writingfunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WritingFunctions {
    static ArrayList accounts = new ArrayList();
    static List admin_accounts = new ArrayList<>();
    static List faculty = new ArrayList<>();
    static List courses = new ArrayList();

    public static void main(String[] args) {}

    // creating a new account
    static void createAccount(){
        String email_format = "^(.+)@(.+)$";
        String pass_format = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter email: ");
        String email = input.nextLine();    // user types email
        System.out.println("Enter password: ");
        String password = input.nextLine();     // user types password
        ArrayList new_account = new ArrayList();

        // email and password indexes match
        // checking if the provided email matches a normal email format
        if (email.matches(email_format)) {
            if (accounts.contains(email)){
                System.out.println("Account already exists.");
            } else {
                new_account.add(email);
            }
        } else {
            System.out.println("Invalid email!");
        }

        // checking if the provided password matches the given pattern
        if (password.matches(pass_format)){
            new_account.add(password);
        } else {
            System.out.println("Password should follow this pattern: ");
            System.out.println("1. Password must contain at least one digit [0-9].");
            System.out.println("2. Password must contain at least one lowercase Latin character [a-z].");
            System.out.println("3. Password must contain at least one uppercase Latin character [A-Z].");
            System.out.println("4. Password must contain at least one special character like ! @ # & ( ).");
            System.out.println("5. Password must contain a length of at least 8 characters and a maximum of 20 characters.");

        }

        // adding provided information to the accounts list
        if (new_account.size() > 1){
            accounts.add(new_account);
            System.out.println("Account created!");
        }
    }

    // Logging an existing user in
    static boolean login(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter email: ");
        String email = input.nextLine();    // user types email
        System.out.println("Enter password: ");
        String password = input.nextLine();     // user types password

        for (ArrayList account: accounts){
            String account_email = account.get(0);
            String account_password = account.get(1);

            if (account_email.equals(email) && account_password.equals(password)){
                return true;
            }
        }
        return false;
    }

    // Updating the users profile
    static void updateProfile(){
        while (login() == true){
            System.out.println("Enter new details below: ");
            System.out.println("");
        }
    }
//
//    static void viewProfile(String email){}
//
//    static void isAdmin(){}
//
//    static void makeFaculty(){}
//
//    static void isFaculty(){}
//
//    static void createCourse(){}
//
//    static void viewCourse(){}
//
//    static void registerCourse(){}
//
//    static void viewCourseByCode(){}
//
//    static void viewCourseByEmail(){}
//
//    static void addAssignment(){}
//
//    static void viewAssignmentsbyCourse(){}
//
//    static void viewAsignmentsbyEmail(){}
//
//    static void submitAssignment(){}
//
//    static void viewSubmissions(){}
//
//    static void scoreAssignment(){}
//
//    static void viewAssignmentScore(){}
//
//    static void viewAssignmentScores(){}
//
//    static void viewAllAssignmentScores(){}
//
//    static void viewAssignmentGrade(){}
//
//    static void viewAssignmentGrades(){}
//
//    static void viewAllAssignmentScores(){}
//
//    static void setNotificationPreferences(){}

}
