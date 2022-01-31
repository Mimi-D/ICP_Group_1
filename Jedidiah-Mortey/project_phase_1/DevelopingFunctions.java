package com.icp22;

//import java.util.ArrayList;
import java.util.*;

public class DevelopingFunctions {

    public static void main(String[] args){

    }

    //Accounts
    private ArrayList<String> emails = new ArrayList();
    protected ArrayList<String> passwords = new ArrayList();

    // Roles and Profiles Setup
    private ArrayList<String> admins = new ArrayList<String>();
    private ArrayList<String> faculty = new ArrayList<String>();
    private ArrayList<String> students = new ArrayList<String>();
    private ArrayList<ArrayList<String>> profileDetails = new ArrayList<ArrayList<String>>();

    // Course Setup
    private ArrayList<String> courseCodes = new ArrayList<String>();
    private ArrayList<String> courseNames = new ArrayList<String>();
    private ArrayList<String> courseCreators = new ArrayList<String>();
    private ArrayList<ArrayList<String>> registeredStudents = new ArrayList<ArrayList<String>>();

    private ArrayList<ArrayList<String>> assignments = new ArrayList<ArrayList<String>>();


    private ArrayList<String> notifyAssgtPosted = new ArrayList<String>();
    private ArrayList<String> notifyAssgtGraded = new ArrayList<String>();
    private ArrayList<String> notifyCourseRegistr = new ArrayList<String>();
    private String loggedInAs;
    private boolean isLoggedIn;


    void createAccount(String email, String password){
        if(!emails.contains(email)){
            if(emails.add(email) && passwords.add(password)){
            System.out.println("New account with email "
                    + email + " created."); return;
            }
        }
        System.out.println("Account not created.");
    }
    void login(){
        int accountIndex;
        Scanner emailScanner = new Scanner(System.in);
        Scanner passwordScanner = new Scanner(System.in);

        System.out.println("Email: ");
        String email = emailScanner.nextLine();

        if(!emails.contains(email)) {
            System.out.println("Account was not found.");
        }else{
            accountIndex = emails.indexOf(email);
            System.out.println("Password: ");
            String passTry = passwordScanner.nextLine();

            if(!passTry.equals(passwords.get(accountIndex))){
                System.out.println("The password was incorrect");
            }else{
                loggedInAs = email;
                isLoggedIn = true;
            }
        }

    }
    void updateProfile(String email){
        String firstName;
        String lastName;
        String yearGroup;
        String cGPA;
        String dateOfBirth;

        if(loggedInAs.equals(email)) {
            System.out.println("Please enter details correctly for the provided fields.");
            Scanner textIn = new Scanner(System.in);
            System.out.println("First Name: ");
            firstName = textIn.nextLine();
            System.out.println("\n");
            System.out.println("Last Name: ");
            lastName = textIn.nextLine();
            System.out.println("\n");
            System.out.println("YearGroup: ");
            yearGroup = textIn.nextLine();
            System.out.println("\n");
            System.out.println("Current GPA: ");
            cGPA = textIn.nextLine();
            System.out.println("\n");
            System.out.println("Date of Birth(DD-MM-YYYY: ");
            dateOfBirth = textIn.nextLine();
            System.out.println("\n");
            String[] detailArray = {firstName, lastName, yearGroup, cGPA, dateOfBirth};

            ArrayList<String> individualProfile = new ArrayList<String>(Arrays.asList(detailArray));

            int indexToUse = emails.indexOf(email);

            profileDetails.add(indexToUse, individualProfile);

            System.out.println("Profile successfully updated.");
        } else{
                System.out.println("Log in with " +email+ "to update this profile");
        }

    }

    void viewProfile(String email){
        if(loggedInAs.equals(email)) {
            int profileIndex = emails.indexOf(email);
            if (profileIndex == -1) {
                System.out.println("This account does not exist.");
            } else {
                ArrayList<String> profile = profileDetails.get(profileIndex);
                if (profile.isEmpty()) {
                    System.out.println("N/A");
                } else {
                    String firstName, lastName, yG, DOB,cGPA;
                    //email = "someone@example.com";
                    firstName = profile.get(0);
                    lastName = profile.get(1);
                    yG = profile.get(2);
                    DOB = profile.get(4);
                    cGPA = profile.get(3);
                    System.out.println("Email: " + email + "\n" +
                            "Name: " + firstName+" "+ lastName+ "\n" +
                            "DOB: " + DOB + "\n" +
                            "Year Group: " + yG + "\n" +
                            "Current: " + cGPA + "\n");
                }
            }
        }
    }
    void makeAdmin(String email){
        if(!emails.contains(email)){
            System.out.println("This account does not exist");
        }
    }

    boolean isAdmin(String email){
        if(!emails.contains(email)){
            System.out.println("This account does not exist");
            return false;
        }else return admins.contains(email);
    }

    void makeFaculty(String email){
        if(emails.contains(email)){
            if(faculty.contains(email)){
                System.out.println("This account is already a staff account");
            }else{
                faculty.add(email);
            }
        }else{
            System.out.println("This account does not exist");
        }
    }
    boolean isFaculty(){
        return isLoggedIn && faculty.contains(loggedInAs);
    }
    void createCourse(String creatorEmail, String courseCode, String courseName){
        if(isFaculty() && loggedInAs.equals(creatorEmail)){
            courseCodes.add(courseCode);
            courseNames.add(courseName);
            courseCreators.add(creatorEmail);
        }else{
            System.out.println("Please log in as faculty to create the course");
        }
    }
    void viewCourses(){
        String courseCode,courseName,creator;
        int lastCourse = courseCodes.size();
        for(int i = 0; i<lastCourse; i++){
            courseCode = courseCodes.get(i);
            courseName = courseNames.get(i);
            creator = courseCreators.get(i);

            System.out.printf("%10s %50s %100s\n",courseCode,courseName,creator);
        }
    }
    void registerCourse(String registreeEmail,String courseCode){
        int courseIndex;
        if(!isLoggedIn){
            System.out.println("Please log in to register for courses.");
        }else{
            courseIndex = courseCodes.indexOf(courseCode);
            ArrayList<String> alreadyRegistered = registeredStudents.get(courseIndex);
            alreadyRegistered.add(registreeEmail);
            registeredStudents.remove(courseIndex);
            registeredStudents.add(courseIndex, alreadyRegistered);

            System.out.println("You have been successfully registered to "+courseNames.get(courseIndex)+"." );
        }
    }
    void viewCourseByCode(String courseCode){
        if(courseCodes.contains(courseCode)) {
            System.out.printf("%20s%20s%20s", "Email", "First Name", "Last Name");
            String email, firstName, lastName;
            int courseIndex = courseCodes.indexOf(courseCode);
            ArrayList<String> studentsRegistered = registeredStudents.get(courseIndex);
            for (String s : studentsRegistered) {
                email = s;
                int profileIndex = emails.indexOf(email);
                ArrayList<String> profile = profileDetails.get(profileIndex);
                firstName = profile.get(0);
                lastName = profile.get(1);

                System.out.printf("%20s%20s%20s", email, firstName, lastName);
            }
        }
    }
    void viewCoursesByEmail(){}
    void addAssignment(String email, String courseCode, String type, String assignmentDescription, String assignmentName,String dueDate){
        int indexOfCourse = courseCodes.indexOf(courseCode);
        if(isLoggedIn && isFaculty()){
            if(loggedInAs.equals(email) && email.equals(courseCreators.get(indexOfCourse))){
                String[] assignmentDetails = {courseCode, type, assignmentName, assignmentDescription, dueDate};
                ArrayList<String> assignment = new ArrayList<String>(Arrays.asList(assignmentDetails));

                assignments.add(assignment);
            }else{
                System.out.println("You must be the creator of this course to create assignments");
            }
            }else {
                System.out.println("You must sign in as faculty to access this feature");
        }
    }
    void viewAssignmentsByCourse(){}
    void viewAssignmentsByEmail(){}
    void submitAssignment(){}
    void viewSubmissions(){}
    void scoreAssignment(){}
    void viewAssignmentScore(){}
    void viewAssignmentScores(){}
    void viewAssignmentGrade(){}
    void viewAssignmentGrades(){}
    void viewAllAssignmentScores(){}
    void setNotificationPreferences(String email){
        if(isLoggedIn && loggedInAs.equals(email)){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter y or n to agree or disagree respectively to the following.");
            System.out.print("\nAssignment posted: ");
            String AssignmentPosted = input.nextLine();
            System.out.print("\nAssignment Graded: ");
            String AssignmentGrd = input.nextLine();
            System.out.print("\nCourse Registration: ");
            String crsRegistered = input.nextLine();

            if(AssignmentPosted.toLowerCase().equals("y")){
                notifyAssgtPosted.add(email);
            }
            if(AssignmentGrd.toLowerCase().equals("y")){
                notifyAssgtGraded.add(email);
            }
            if(crsRegistered.toLowerCase().equals("y")){
                notifyCourseRegistr.add(email);
            }
        }
    }

    //Auxiliary methods
    void makeStudent(String email){
        if(admins.contains(loggedInAs)){
            if(!isStudent(email)){
                students.add(email);
            }else{
                System.out.println("Student role already specified for " + email +".");
            }
        }
    }
    boolean isStudent(String email){
        return students.contains(email);
    }

}