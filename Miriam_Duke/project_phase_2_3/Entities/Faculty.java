package Entities;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

public class Faculty extends User implements Interfaces.Faculty {

    public Faculty(){

    }
    public Faculty(String email, String password){
        // Use parent class parameterized constructor
        super(email,password);
    }

    public Faculty(String email, String password,String fName, String lName) {
        // Use parent class parameterized constructor
        super(email, password, fName, lName);
    }

    // Getters and setters of parent class is inherited



    // Function checks if Faculty is the creator of a specific course
    public boolean isCourseCreator(String mail, String courseCode, Database database) {
        for (Course course : database.courses) {
            if (course.getCreatorEmail().equals(mail) && course.getCourseCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }


    // Function to allow faculty create a course
    public void createCourse(Database database){

        System.out.print("\n");
        System.out.print("To Create Course, you must be a Faculty, kindly login first: \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // Verify login
        if (login(Email, Password, database)) {

            // If user is a faculty
            if(isFaculty(Email,database)){

                System.out.println("You are eligible to create a course");

                System.out.print("Enter Course Name: ");
                String cName = getDets.nextLine();

                System.out.print("Enter Course Code: ");
                String cCode = getDets.nextLine();

                // Add course to Database
                Course newCourse = new Course(Email,cCode,cName);
                database.addCourse(newCourse);

                System.out.println(cName + " " + cCode + " has been created");

            }

            else{System.out.println("You MUST be a FACULTY");}
        }

        else{ System.out.println("INVALID username or password");}

    }

    public void addAssignment(Database database){

        System.out.print("\n");
        System.out.print("To Add Assignment to a Course, you must be the Course Creator, kindly login first: \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // Verify login
        if (login(Email, Password, database)) {

            // If user is a faculty
            if(isFaculty(Email,database)){
                System.out.print("Enter Course Code: ");
                String code = getDets.nextLine();

                if(isCourseCreator(Email,code,database)){
                    System.out.print("Enter Assignment Name: ");
                    String name = getDets.nextLine();

                    System.out.print("Enter Assignment Description: ");
                    String description = getDets.nextLine();

                    System.out.print("Enter Due Date: ");
                    String due = getDets.nextLine();

                    System.out.print("Enter Assignment Type: ");
                    String type = getDets.nextLine();

                    Assignment newAssignment = new Assignment(Email,code, name, description, due, type);

                    for(Course course: database.courses){
                        if(course.getCourseCode().equals(code)){
                            course.addNewAssignment(newAssignment);

                            for(Student stu : course.registeredStudent){
                                stu.myAssignment.add(newAssignment);
                            }
                            System.out.print("_____________ASSIGNMENT ADDED______________");

                        }
                    }
                }
                else{ System.out.println("You MUST be the COURSE CREATOR");}

            }
            else{ System.out.println("You MUST be a FACULTY");}
        }
        else{ System.out.println("INVALID username or password");}


    }

    public void viewAssignmentsByCourse(Database database){
        System.out.println("\n_______ View Assignments By Course Code______ \n");
        Scanner getDets = new Scanner(System.in);  // Create a Scanner object
        System.out.print("\nEnter Course code: ");
        String courseCode = getDets.nextLine();

        System.out.println("\n_____ Current Assignments for " + courseCode + " _____\n");
        System.out.println("Name                  Description                  Due Date                  Type \n");
        for (Course course: database.courses) {
            if (course.getCourseCode().equals(courseCode)) {
                for(Assignment hw : course.assignments){
                System.out.println(hw.getAssignmentName() + "\t\t\t\t" + hw.getAssignmentDescription() + "\t\t\t\t" + hw.getDueDate() + "\t\t\t\t" + hw.getAssignmentType() + "\n");
                }
            }
        }
    }

    public void viewSubmissions(Database database){
        System.out.print("\n");
        System.out.print("To VIEW SUBMISSIONS, kindly login first: \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // Verify login
        if (login(Email, Password, database)) {

            // If user is a faculty
            if(isFaculty(Email,database)){
                System.out.print("Enter Course Code: ");
                String code = getDets.nextLine();

                // Ensure the user is the Course creator
                if(isCourseCreator(Email,code,database)){

                    System.out.print("\nEnter Assignment Name: ");
                    String assignmentName = getDets.nextLine();
                    System.out.print("\nStudent Mail            Submission\n");

                    // Ensure assignment exists
                    for(Course course:database.courses) {
                        for (Assignment hw : course.assignments) {
                            if (course.getCourseCode().equals(code) && hw.getAssignmentName().equals(assignmentName)) {

                                ArrayList<String> submissionEmails = new ArrayList<>();
                                for (Submissions submissions : course.submissions) {
                                    // List of students who submitted the assignment
                                    if(submissions.getAssName().equals(assignmentName)){
                                        submissionEmails.add(submissions.getEmail());
                                    }
                                }


                                for (Student student : course.registeredStudent) {
                                    if (!submissionEmails.contains(student.getEmail())) {
                                        System.out.println(student.getEmail() + "\t\t" + "NO SUBMISSION");
                                    }
                                    for (Submissions submissions: course.submissions){
                                        if(student.getEmail().equals(submissions.getEmail())){
                                            System.out.println(student.getEmail() + "\t\t" + submissions.getSubmission());
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
                else{System.out.println("You MUST be the COURSE CREATOR");}
            }
            else{System.out.println("You MUST be a FACULTY");}
        }
        else{System.out.println("INVALID username or password");}
    }

    public void scoreAssignment(Database database) {
        System.out.println(" \n _________ SCORE ASSIGNMENT _____________ \n");
        System.out.println(" \n Kindly login to your Account \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // Verify login
        if (login(Email, Password, database)) {

            // If user is a faculty
            if(isFaculty(Email,database)){
                System.out.print("Enter Course Code: ");
                String code = getDets.nextLine();

                // Ensure the user is the Course creator
                if(isCourseCreator(Email,code,database)){

                    System.out.print("\nEnter Assignment Name: ");
                    String assignmentName = getDets.nextLine();

                    // check if assignment exists
                    for(Course course:database.courses) {
                        for (Assignment hw : course.assignments) {
                            if (course.getCourseCode().equals(code) && hw.getAssignmentName().equals(assignmentName)) {
                                System.out.print("\nEnter Student's Email: ");
                                String studentMail = getDets.nextLine();

                                // Check if user is a student
                                if(isStudent(studentMail,database)){
                                    for(Submissions submissions: course.submissions){
                                        if(submissions.getEmail().equals(studentMail)){
                                            System.out.print("\nEnter Score: ");
                                            int studentScore = getDets.nextInt();
                                            submissions.setScore(studentScore);
                                            System.out.println(studentMail + "'s Assignment has been GRADED");
                                            return;
                                        }
                                    }
                                }
                                else{        System.out.println("The email provided is INVALID");                         }
                            }
                        }
                    }
                }
            }
        }
        else{ System.out.println("The username or password provided is INVALID");  }
    }

    public void viewAssignmentScores(Database database){
        System.out.print("\n");
        System.out.print("To VIEW ASSIGNMENT SCORES, kindly login first: \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // Verify login
        if (login(Email, Password, database)) {

            // If user is a faculty
            if(isFaculty(Email,database)){
                System.out.print("Enter Course Code: ");
                String code = getDets.nextLine();

                // Ensure the user is the Course creator
                if(isCourseCreator(Email,code,database)){

                    System.out.print("\nEnter Assignment Name: ");
                    String assignmentName = getDets.nextLine();
                    System.out.println("\n");
                    System.out.print("\nStudent Mail            Score\n");

                    // Ensure assignment exists
                    for(Course course:database.courses) {
                        for (Assignment hw : course.assignments) {
                            if (course.getCourseCode().equals(code) && hw.getAssignmentName().equals(assignmentName)) {

                                ArrayList<String> submissionEmails = new ArrayList<>();
                                for (Submissions submissions : course.submissions) {
                                    // List of students who submitted the assignment
                                    if(submissions.getAssName().equals(assignmentName)){
                                        submissionEmails.add(submissions.getEmail());
                                    }
                                }


                                for (Student student : course.registeredStudent) {
                                    if (!submissionEmails.contains(student.getEmail())) {
                                        System.out.println(student.getEmail() + "\t\t" + "NO SUBMISSION");
                                    }
                                    for (Submissions submissions: course.submissions){
                                        if(student.getEmail().equals(submissions.getEmail())){
                                            if(submissions.getScore() < 0){
                                                System.out.println(student.getEmail() + "\t\t NOT GRADED");
                                            }
                                            else if(submissions.getScore() >= 0){
                                                System.out.println(student.getEmail() + "\t\t" + submissions.getScore());
                                            }

                                        }
                                    }
                                }

                            }
                        }
                    }
                }
                else{System.out.println("You MUST be the COURSE CREATOR");}
            }
            else{System.out.println("You MUST be a FACULTY");}
        }
        else{System.out.println("INVALID username or password");}
    }

    public void viewAssignmentGrades(Database database){
        System.out.print("\n");
        System.out.print("To VIEW ASSIGNMENT GRADES, kindly login first: \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // Verify login
        if (login(Email, Password, database)) {

            // If user is a faculty
            if(isFaculty(Email,database)){
                System.out.print("Enter Course Code: ");
                String code = getDets.nextLine();

                // Ensure the user is the Course creator
                if(isCourseCreator(Email,code,database)){

                    System.out.print("\nEnter Assignment Name: ");
                    String assignmentName = getDets.nextLine();
                    System.out.println("\n");
                    System.out.print("\nStudent Mail            Score           Grade\n");

                    // Ensure assignment exists
                    for(Course course:database.courses) {
                        for (Assignment hw : course.assignments) {
                            if (course.getCourseCode().equals(code) && hw.getAssignmentName().equals(assignmentName)) {

                                ArrayList<String> submissionEmails = new ArrayList<>();
                                for (Submissions submissions : course.submissions) {
                                    // List of students who submitted the assignment
                                    if(submissions.getAssName().equals(assignmentName)){
                                        submissionEmails.add(submissions.getEmail());
                                    }
                                }


                                for (Student student : course.registeredStudent) {
                                    if (!submissionEmails.contains(student.getEmail())) {
                                        System.out.println(student.getEmail() + "\t\t" + "NO SUBMISSION");
                                    }
                                    for (Submissions submissions: course.submissions){
                                        if(student.getEmail().equals(submissions.getEmail())){
                                            if(submissions.getScore() < 0){
                                                System.out.println(student.getEmail() + "\t\t NOT GRADED");
                                            }
                                            else if(submissions.getScore() >= 0){
                                                System.out.println(student.getEmail() + "\t\t" + submissions.getScore() + "\t\t" + grader(submissions.getScore()));
                                            }

                                        }
                                    }
                                }

                            }
                        }
                    }
                }
                else{System.out.println("You MUST be the COURSE CREATOR");}
            }
            else{System.out.println("You MUST be a FACULTY");}
        }
        else{System.out.println("INVALID username or password");}
    }

}
