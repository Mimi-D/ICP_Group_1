package Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Student extends User implements Interfaces.Student {

    // Instance variables
    protected String DOB;
    protected int yearGroup;
    protected double GPA;
    protected  ArrayList<Course> registeredCourses = new ArrayList<>(); //Made up of course details of courses user has registered
    protected  ArrayList<Assignment> myAssignment = new ArrayList<>();;


    public Student(String email, String password){
        // Use parent class parameterized constructor
        super(email,password);
    }

    public Student(String email, String password,String fName, String lName) {
        // Use parent class parameterized constructor
        super(email, password, fName, lName);
    }

    public Student(String email, String password,String fName, String lName, String DOB, int yearGroup, int GPA){
        this.email = email;
        this.password = password;
        this.firstName = fName;
        this.lastName = lName;
        this.DOB = DOB;
        this.yearGroup = yearGroup;
        this.GPA = GPA;
    }

    public void registerCourse(Database database){
        System.out.println(" _________COURSE REGISTRATION_____________ ");
        System.out.println("  Kindly login to your Account ");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // If login is successful
        if (login(Email, Password, database)) {

            // Make sure it's a student
            if (isFaculty(Email,database)) {
                System.out.println("Only Students can register for a course");

            }
            else {

                System.out.print("Enter Course Code: ");
                String cCode = getDets.nextLine();

                //check if course code exists
                for (Course course: database.courses) {
                    if (course.getCourseCode().equals(cCode)) {
                        // check if student has registered for course before
                       if(findCourse(cCode)){
                           System.out.println("You have ALREADY registered for this course");
                           return;
                       }

                       // Add course to list of courses student does
                        registeredCourses.add(course);

                       // Register student to course
                        course.addRegisteredStudent(this);

                        System.out.println("You have SUCCESSFULLY registered for " + cCode);
                        return;
                    }

                }
                System.out.print("You entered an INVALID course code");
            }
        } else {
            System.out.print("INCORRECT Username or Password");
        }

    }

    // Check if user is already registered for a course
    public boolean findCourse(String courseCode){
        try{
            for (Course course1 : registeredCourses) {
                if (course1.getCourseCode().equals(courseCode)) {
                    return true;
                }
            }
        }
        catch (NullPointerException e){
            return false;
        }
        return false;
    }

    /**
     * @return the dOB
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * @return the yearGroup
     */
    public int getYearGroup() {
        return yearGroup;
    }

    /**
     * @return the GPA
     */
    public double getGPA() {
        return GPA;
    }

    /**
     * @param dOB the dOB to set
     */
    public void setDOB(String dOB) {
        DOB = dOB;
    }

    /**
     * @param yearGroup the yearGroup to set
     */
    public void setYearGroup(int yearGroup) {
        this.yearGroup = yearGroup;
    }

    /**
     * @param GPA the GPA to set
     */
    public void setGPA(double GPA) {
        this.GPA = GPA;
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

        // If login is successful
        if (login(Email, Password, database)) {
            System.out.println("You're logged in, you can now update your profile");

            System.out.print("Enter First Name: ");
            String fName = getDets.nextLine();

            System.out.print("Enter Last Name: ");
            String lName = getDets.nextLine();

            System.out.print("Enter Role ID: ");
            int role = getDets.nextInt();

            System.out.print("Enter Year group: ");
            int yGroup = getDets.nextInt();

            System.out.print("Enter current GPA: ");
            int gpa = getDets.nextInt();

            System.out.print("Enter Date of birth e.g 24/04/2002: ");
            String dob = getDets.nextLine();

            for (Student student : database.students) {
                if (email.equals(student.getEmail()) && password.equals(student.getPassword())) {
                    student.setFirstName(fName);
                    student.setLastName(lName);
                    student.setYearGroup(yGroup);
                    student.setGPA(gpa);
                    student.setDOB(dob);
                    System.out.print("Thank You, your profile has successfully been UPDATED ");
                }
            }

        }

        // Login failed, account does not exist
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
            for (Student user : database.students) {
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

                    if(user.getDOB() == null){
                        System.out.println("Date of Birth: NA");
                    }

                    else {
                        System.out.println("Date of Birth: " + user.getDOB());
                    }

                    if(user.getGPA() <= 0){
                        System.out.println("GPA: NA");
                    }

                    else {
                        System.out.println("GPA: " + user.getGPA());
                    }

                    if(user.getYearGroup() <= 0){
                        System.out.println("Year Group: NA");
                    }

                    else {
                        System.out.println("Year Group: " + user.getYearGroup());
                    }


                }
            }
        }

        // Wrong details provided
        else {
            System.out.println("INCORRECT Username or Password");
        }
    }

    public void viewAssignmentsByEmail(Database database,boolean pending) throws ParseException {

        // Ask user for input
        Scanner getDets = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\n____________VIEW ASSIGNMENT BY EMAIL____________");
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();
        System.out.println("Name                  Description                  Due Date                  Type \n");

        for(Student student: database.students){
            //Find student
            if(student.getEmail().equals(Email)){
                for(Assignment hw: student.myAssignment){
                    if(!pending){
                        System.out.println(hw.getAssignmentName() + "\t\t\t\t" + hw.getAssignmentDescription() + "\t\t\t\t" + hw.getDueDate() + "\t\t\t\t" + hw.getAssignmentType() + "\n");
                    }
                    else{
                        Date todayDate = new Date();
                        String date = hw.getDueDate();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date day = sdf.parse(date);
                        int val = todayDate.compareTo(day);
                        if (val < 0) {
                            System.out.println(hw.getAssignmentName() + "\t\t\t\t" + hw.getAssignmentDescription() + "\t\t\t\t" + hw.getDueDate() + "\t\t\t\t" + hw.getAssignmentType() + "\n");
                        }
                    }

                }
            }
        }

    }

    public void submitAssignment(Database database){
        System.out.print("\n");
        System.out.print("_____SUBMIT ASSIGNMENT_____ \n");
        System.out.println("Kindly Login to submit");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // If login is successful
        if (login(Email, Password, database)) {
            System.out.print("Enter Course Code: ");
            String cCode = getDets.nextLine();

            System.out.print("Enter Assignment Name: ");
            String assName = getDets.nextLine();


            // check if assignment exists for submission
            for (Course course : database.courses) {
                for(Assignment hw: course.assignments){
                    if (hw.getAssignmentName().equals(assName) && course.getCourseCode().equals(cCode)) {
                        System.out.print("Enter Submission: ");
                        String submission = getDets.nextLine();
                        Submissions newSubmission = new Submissions(Email,assName,submission);
                        course.submissions.add(newSubmission);
                        System.out.println("_____________SUBMITTED___________");
                        return;
                    }
                }
            }
            System.out.print("INVALID course code or Assignment Name");
        }
        else {
            System.out.println("INVALID username or password");
        }
    }

    public void viewAssignmentScore(Database database){

        System.out.println(" \n _________ VIEW ASSIGNMENT SCORE _____________ \n");
        System.out.println("Kindly login to your Account \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // If login is successful
        if (login(Email, Password, database)) {
            if(isStudent(Email,database)){
                System.out.print("Enter Course Code: ");
                String cCode = getDets.nextLine();

                System.out.print("Enter Assignment Name: ");
                String assignmentName = getDets.nextLine();

                //Ensure course exists
                for(Course course:database.courses) {
                    for (Assignment hw : course.assignments) {
                        if (course.getCourseCode().equals(cCode) && hw.getAssignmentName().equals(assignmentName)) {

                            for (Submissions submissions : course.submissions) {
                                if(submissions.getAssName().equals(assignmentName) && submissions.getEmail().equals(Email)){
                                    if(submissions.getScore() < 0){
                                        System.out.println("Assignment" + "\t\tScore");
                                        System.out.println(assignmentName + "\t\t NOT GRADED");
                                    }
                                    else if(submissions.getScore() >= 0){
                                        System.out.println("Assignment" + "\t\tScore");
                                        System.out.println(assignmentName + "\t\t" + submissions.getScore());
                                    }
                                    return;
                                }

                            }
                            System.out.println("Assignment" + "\t\tScore");
                            System.out.println(assignmentName + "\t\t  NO SUBMISSION");

                                }
                            }
                }
            }
            else{System.out.println("UNAUTHORIZED ACCESS ");}
        }
        else {System.out.println("INVALID username or password");}
    }

    public void viewAllAssignmentScores(Database database){
        System.out.println(" \n _________ VIEW ALL ASSIGNMENT SCORES _____________ \n");
        System.out.println("Kindly login to your Account \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // If login is successful
        if (login(Email, Password, database)) {
            if(isStudent(Email,database)){
                System.out.print("Enter Course Code: ");
                String cCode = getDets.nextLine();
                //Ensure course exists
                System.out.println("Assignment" + "\t\tScore");
                for(Course course:database.courses) {
                    if (course.getCourseCode().equals(cCode)) {

                        for (Submissions submissions : course.submissions) {

                            if(submissions.getEmail().equals(Email)){
                                if(submissions.getScore() < 0){

                                    System.out.println(submissions.getAssName() + "\t\t NOT GRADED");
                                }
                                else if(submissions.getScore() >= 0){

                                    System.out.println(submissions.getAssName() + "\t\t" + submissions.getScore());
                                }
                            }
                        }
                    }
                }
            }
            else{System.out.println("UNAUTHORIZED ACCESS ");}
        }
        else {System.out.println("INVALID username or password");}
    }

    // this function converts a score to a grade letter


    public void viewAssignmentGrade(Database database){
        System.out.println(" \n _________ VIEW ASSIGNMENT GRADE _____________ \n");
        System.out.println("Kindly login to your Account \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // If login is successful
        if (login(Email, Password, database)) {
            if(isStudent(Email,database)){
                System.out.print("Enter Course Code: ");
                String cCode = getDets.nextLine();

                System.out.print("Enter Assignment Name: ");
                String assignmentName = getDets.nextLine();

                //Ensure course exists
                for(Course course:database.courses) {
                    for (Assignment hw : course.assignments) {
                        if (course.getCourseCode().equals(cCode) && hw.getAssignmentName().equals(assignmentName)) {

                            for (Submissions submissions : course.submissions) {
                                if(submissions.getAssName().equals(assignmentName) && submissions.getEmail().equals(Email)){
                                    if(submissions.getScore() < 0){
                                        System.out.println("Assignment" + "\t\tScore" + "\t\tGrade");
                                        System.out.println(assignmentName + "\t\t NOT GRADED");
                                    }
                                    else if(submissions.getScore() >= 0){
                                        System.out.println("Assignment" + "\t\tScore" + "\t\tGrade");
                                        System.out.println(assignmentName + "\t\t" + submissions.getScore() + "\t\t" + grader(submissions.getScore()));
                                    }
                                    return;
                                }

                            }
                            System.out.println("Assignment" + "\t\tScore");
                            System.out.println(assignmentName + "\t\t  NO SUBMISSION");

                        }
                    }
                }
            }
            else{System.out.println("UNAUTHORIZED ACCESS ");}
        }
        else {System.out.println("INVALID username or password");}
    }

    public void viewAllAssignmentGrades(Database database){
        System.out.println(" \n _________ VIEW ALL ASSIGNMENT Grades _____________ \n");
        System.out.println("Kindly login to your Account \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // If login is successful
        if (login(Email, Password, database)) {
            if(isStudent(Email,database)){
                System.out.print("Enter Course Code: ");
                String cCode = getDets.nextLine();
                //Ensure course exists
                System.out.println("Assignment" + "\t\tScore" + "\t\tScore");
                for(Course course:database.courses) {
                    if (course.getCourseCode().equals(cCode)) {

                        for (Submissions submissions : course.submissions) {

                            if(submissions.getEmail().equals(Email)){
                                if(submissions.getScore() < 0){

                                    System.out.println(submissions.getAssName() + "\t\t NOT GRADED");
                                }
                                else if(submissions.getScore() >= 0){

                                    System.out.println(submissions.getAssName() + "\t\t" + submissions.getScore() + "\t\t" + grader(submissions.getScore()));
                                }
                            }
                        }
                    }
                }
            }
            else{System.out.println("UNAUTHORIZED ACCESS ");}
        }
        else {System.out.println("INVALID username or password");}
    }




}
