package CanvasProject;

import java.util.Scanner;
import java.util.ArrayList;

public class Student extends User {
    //this variable is assessible to all classes
    public String email;

    // Constructor
    public Student(String email) {
        this.email = email;
    }

    // This is an array to store profiles created
    ArrayList<String> Profile = new ArrayList<>();

    // This is an array to a user's updated profile
    ArrayList<String> updatedProfile = new ArrayList<>();

    // This is an array to store assignments created
    ArrayList<String> assI = new ArrayList<>();

    // This is an array to store submitted assignments
    ArrayList<String> submit = new ArrayList<>();

    // This is an array to store submissions
    ArrayList<String> submission = new ArrayList<>();

    // This is an array to store scores
    ArrayList<String> ScoreBoard = new ArrayList<>();



    public void updateProfile() {
        System.out.println();
        System.out.println("If you want to update profile please login");
        if (this.login()) {
            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            this.email = sc.nextLine();

            //Ask the user to input their first name
            System.out.print("Enter your first name: ");
            String fname = sc.nextLine();

            //Ask the user to input their last name
            System.out.print("Enter your last name: ");
            String lname = sc.nextLine();

            //Ask the user to input their year group
            System.out.print("Enter your year group: ");
            String yrgroup = sc.nextLine();

            //Ask the user to input their current GPA
            System.out.print("Enter your current GPA: ");
            String GPA = sc.nextLine();

            //Ask the user to input their date of birth
            System.out.print("Enter your date of birth: ");
            String dob = sc.nextLine();


            Profile.add(email);
            Profile.add(fname);
            Profile.add(lname);
            Profile.add(yrgroup);
            Profile.add(GPA);
            Profile.add(dob);


            updatedProfile.add(String.valueOf(Profile));


            System.out.println("Profile Updated!");

        } else {
            System.out.println("Access Denied");
        }


    }

    //View Profiles
    public void viewProfile() {
        System.out.println("____PROFILE____");
        if (this.login()) {

            for (int i = 0; i < updatedProfile.size(); i++) {
                System.out.println();
                System.out.println(updatedProfile.get(i).toString().replace("[","").replace("]",""));

            }
        } else {
            System.out.println("NA");
        }

    }

    public boolean setNotificationPreferences() {
        if (this.login()) {
            System.out.println();

            //this is to set notifications for assignments via emails
            System.out.println("___Notification Preference___");

            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            this.email = sc.nextLine();

            //ask the users to choose for assignment notification
            System.out.println("Do you want to be notifications for assignments? (Type YES or NO)");
            String NotifyAssign = sc.nextLine();

            //Ask the users to choose for graded assignments notification
            System.out.println("Do you want to be notifications for graded assignments? (Type YES or NO)");
            String NotifyGassign = sc.nextLine();

            if(email=="YES"){
                System.out.println("Great You will be notified");
                return true;
            }else {
                System.out.println("You will not be notified");
            }
            if(NotifyGassign=="YES"){
                var b = true;
                return b;

            }
        }
        return false;

    }

    public void viewAssignmentsByCourse() {

        Scanner sc = new Scanner(System.in);
        //Ask the user to input the course code
        System.out.print("Enter the course code: ");
        String courseCode = sc.nextLine();
        System.out.println();
        System.out.println("ASSIGNMENT DETAILS: ");

        if(courseCode!=null){
            for(int y=0; y<assI.size();y++) {
                System.out.println(assI.get(y));
            }
        }
    }

    public void submitAssignment() {
        if (this.login()) {
            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            this.email = sc.nextLine();

            //Ask the user to input their course code
            System.out.print("Enter the course code: ");
            String SubmitcC = sc.nextLine();

            //Ask the user to input the name of assignment
            System.out.print("Enter the name of Assignment: ");
            String SubmitAssignName = sc.nextLine();

            // prints out to inform user of submission
            String submisSion = sc.nextLine();
            System.out.println("You have successfully submitted");

            // stores the new data into the submit array.
            submit.add(email);
            submit.add(SubmitcC);
            submit.add(SubmitAssignName);
            submit.add(submisSion);

            submission.add(String.valueOf(submit));
        }


    }

    // this class allows users to view their scores for assignments graded
    public void viewAssignmentScore(){
        //verify if the user is logged in
        if (this.login()) {

            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.println("Enter your email: ");
            this.email = sc.nextLine();

            //Ask the user to input their course code
            System.out.println("Enter the course code: ");
            String cCS = sc.nextLine();

            //Ask the user to input their assignment name
            System.out.println("Enter the name of the assignment");
            String assignment = sc.nextLine();


            if (email != null && cCS != null && assignment != null) {
                for (int i = 0; i < ScoreBoard.size(); i++) {
                    System.out.println(ScoreBoard.get(i));

                }
            } else {
                System.out.println("Assignment not graded");
            }
        }
    }
}
