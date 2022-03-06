package com.assignments.phasetwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhaseTwo {
    static ArrayList<ArrayList<String>> accounts = new ArrayList<ArrayList<String>>();
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
        ArrayList<String> new_account = new ArrayList<String>();

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

        for (ArrayList<String> account: accounts){
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
            String email = login(email);

            Scanner input = new Scanner(System.in);

            System.out.println("Enter new details below: ");
            System.out.println("First name: ");
            String f_name = input.nextLine(); // input first name
            System.out.println("Last name: ");
            String l_name = input.nextLine(); // input last name
            System.out.println("Year group: ");
            Integer year = input.nextInt(); // input year group
            System.out.println("Current GPA: ");
            Float gpa = input.nextFloat(); // input current gpa
            System.out.println("Date of birth (DD/MM/YYY): ");
            String dob = input.nextLine(); // input date of birth

            for (ArrayList<String> account: accounts){
                String account_email = account.get(0);
                if (account_email.equals(email)){ // login email is account email
                    account.add(2,f_name); // first name
                    account.add(3, l_name); // last name
                    account.add(4, dob); // date of birth
                    account.add(5, year.toString()); // year group
                    account.add(6, gpa.toString()); // current gpa
                }
            }
        }
    }

    // Viewing a users profile
    static void viewProfile(){
        while (login() == true){
            for (ArrayList<String> account: accounts){
                String account_email = account.get(0);
                if (account_email.equals(login(email))){ // if the account email matches the login email
                    // display first name if available
                    try {
                        System.out.println("First name: " + account.get(2));
                    } catch (Exception e){
                        System.out.println("First name: NA");
                    }

                    // display last name if available
                    try {
                        System.out.println("Last name: " + account.get(3));
                    } catch (Exception e) {
                        System.out.println("Last name: NA");
                    }

                    // display dob if available
                    try {
                        System.out.println("Date of birth: " + account.get(4));
                    } catch (Exception e) {
                        System.out.println("Date of birth: NA");
                    }

                    // display year group
                    try {
                        System.out.println("Year group: " + account.get(5));
                    } catch (Exception e) {
                        System.out.println("Year group: NA");
                    }

                    // display current gpa
                    try {
                        System.out.println("Current GPA: " + account.get(6));
                    } catch (Exception e) {
                        System.out.println("Current GPA: NA");
                    }
                }
            }
        }
    }

    // finding out if user is admin
    static boolean isAdmin(String email){
        if (admin_accounts.contains(email)){
            return true;
        }
        return false;
    }

    static void makeFaculty(){}
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
