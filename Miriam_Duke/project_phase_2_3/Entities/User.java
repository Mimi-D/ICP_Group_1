package Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class User implements Interfaces.User {

    // Instance variables
    protected String email;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected int notificationPref;
    /* e.g 101, one means yes, zero means no. a value of 101 means the user will be emailed,when an assignment
    is posted for a course they are registered for, the user will NOT be emailed (because of the zero) when a score is submitted for their assignment and the user will be emailed the user when they register for a course.
8     */

    // Default constructor
    public User(){
    }

    public User(String email,String password) {
        this.email = email;
        this.password = password;
    }

    public User(String Email,String Password, String fName, String lName){
        email = Email;
        password = Password;
        firstName = fName;
        lastName = lName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the notificationPref
     */
    public int getNotificationPref() {
        return notificationPref;
    }

    /**
     * @param notificationPref the notificationPref to set
     */
    public void setNotificationPref(int notificationPref) {
        this.notificationPref = notificationPref;
    }

    // Verify login details and log user in
    public boolean login(String email, String password,Database database) {
        for (User user : database.users) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                System.out.println("You have SUCCESSFULLY logged in");
                return true;
                }
            }
        return false;
    }

    public void updateProfile(Database database){
        System.out.print("\n");
        System.out.print("To UPDATE your profile, kindly login first: \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // Verify login
        if (login(Email, Password, database)) {
            System.out.println("You're logged in, you can now update your profile");

            System.out.print("Enter First Name: ");
            String fName = getDets.nextLine();

            System.out.print("Enter Last Name: ");
            String lName = getDets.nextLine();

            for (User user : database.users) {
                if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                    user.setFirstName(fName);
                    user.setLastName(lName);
                    System.out.print("Thank You, your profile has successfully been UPDATED ");
                }
            }

        }

        // Login failed
        else {
            System.out.println("INCORRECT Username or Password");
        }
    }


    // View Profile
    public void viewProfile(Database database) {
        System.out.print("\n");
        System.out.print("To VIEW your profile, kindly login first: \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // Verify login
        if (login(Email, Password, database)) {
            for (User user : database.users) {
                if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                    System.out.println("Email: " + user.getEmail());

                    if(user.getFirstName() == null){
                        System.out.println("First Name: NA");
                    }

                    else{
                        System.out.println("First Name: " + user.getFirstName());
                    }

                    if(user.getLastName() == null){
                        System.out.println("Last Name: NA");
                    }

                    else {
                        System.out.println("Last Name: " + user.getLastName());
                    }


                }
            }
        }

        // Wrong details provided
        else {
            System.out.println("INCORRECT Username or Password");
        }
    }

    // Check if user is admin
    public boolean isAdmin(String mail, Database database) {
        for (Admin admin : database.admins) {
            if (admin.getEmail().equals(mail)) {
                return true;
            }
        }
        return false;
    }

    // Check if user is a faculty
    public boolean isFaculty(String mail, Database database) {
        for (Faculty faculty : database.faculties) {
            if (faculty.getEmail().equals(mail)) {
                return true;
            }
        }
        return false;
    }

    // Check if user is student
    public boolean isStudent(String mail, Database database) {
        for (Student person : database.students) {
            if (person.getEmail().equals(mail)) {
                return true;
            }
        }
        return false;
    }

    public String grader(int score) {
        String grade = "";
        if (score >= 0 && score < 50) {
            grade = "E";

        } else if (score >= 50 && score <= 54) {
            grade = "D";

        }
        else if (score >= 55 && score <= 59) {
            grade = "D+";

        }
        else if (score >= 60 && score <= 64) {
            grade = "C";

        }
        else if (score >= 65 && score <=69) {
            grade = "C+";

        }
        else if (score >= 70 && score <= 74) {
            grade = "B";

        }
        else if (score >= 75 && score <= 79) {
            grade = "B+";

        }
        else if (score >= 80 && score <= 84){
            grade = "A";
        }
        else if (score >= 85 && score <= 100) {
            grade = "A+";

        }
        return grade;
    }

}
