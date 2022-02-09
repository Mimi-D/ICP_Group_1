package CanvasProject;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;

public class Canvas {
    // a list is created for the assignment type
    private static final Set<String> ASS_TIES = Set.of("QUIZ", "HOMEWORK", "PROJECT", "EXAM");
    // This is an array to store emails created
    ArrayList<String> bank = new ArrayList<>();

    // This is an array to a user's updated profile
    ArrayList<String> updatedProfile = new ArrayList<>();

    // This is an array to store admin emails created
    ArrayList<String> admin = new ArrayList<>();

    int role = 0; //0=user, 1=faculty

    // This is an array to store courses created
    ArrayList<String> course = new ArrayList<>();

    // This is an array to store assignments created
    ArrayList<String> assI = new ArrayList<>();

    // This is an array to store submitted assignments
    ArrayList<String> submit = new ArrayList<>();

    // This is an array to store scores
    ArrayList<String> scores = new ArrayList<>();

    //this is array to register courses


    public void CreateAccount() {
        System.out.println("CREATE ACCOUNT");
        Scanner sc = new Scanner(System.in);
        // This is an array to store emails created

        //Ask the user to input their email
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        //Ask the user to enter password
        System.out.print("Enter your password: ");
        String paswd = sc.nextLine();

        bank.add(email);
    }


    public boolean login() {

        System.out.println();
        System.out.println("LOGIN HERE");
        System.out.println();
        Scanner sc = new Scanner(System.in);


        //Ask the user to input their email
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        //Ask the user to enter password
        System.out.print("Enter your password: ");
        String paswd = sc.nextLine();

        if (bank.contains(email)) {
            //System.out.println(" This account exist");
            return true;
        } else {

            //System.out.println("Please create an account!");
            return false;
        }

    }

    public void updateProfile() {
        System.out.println();
        System.out.println("If you want to update profile please login");
        if (this.login()) {
            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            String email = sc.nextLine();

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

            updatedProfile.add(email);
            updatedProfile.add(fname);
            updatedProfile.add(lname);
            updatedProfile.add(yrgroup);
            updatedProfile.add(GPA);
            updatedProfile.add(dob);

            System.out.println("Profile Updated!");

        } else {
            System.out.println("Access Denied");
        }


    }

    public void viewProfile() {
        System.out.println("____PROFILE____");
        if (this.login()) {
            for (int i = 0; i < updatedProfile.size(); i++) {
                System.out.println(updatedProfile.get(i));

            }
        } else {
            System.out.println("NA");
        }

    }

    public void CreateAdmin() {
        System.out.println();
        System.out.println("CREATE ADMIN");
        Scanner sc = new Scanner(System.in);
        // This is an array to store emails created

        //Ask the user to input their email
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        //Ask the user to enter password
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        admin.add(email);
    }

    public boolean isAdmin() {
        Scanner sc = new Scanner(System.in);

        //Ask the user to input their email
        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        if (admin.contains(email)) {
            System.out.println("You are an Admin");
            return true;


        } else {
            System.out.println("You are not an admin");
            return false;
        }

    }

    public void makeFaculty() {
        Scanner sc = new Scanner(System.in);
        //Ask the user to input their email
        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        if (bank.contains(email)) {
            this.role = 1;
            System.out.println("Great! you new role : Faculty");
        }

    }

    public boolean isFaculty() {

        Scanner sc = new Scanner(System.in);
        //Ask the user to input their email
        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        if (this.role == 1 || bank.contains(email)) {
            System.out.println("you are a faculty member");
            return true;
        } else {
            System.out.println("you are not a faculty member");
            return false;

        }


    }

    public void createCourse() {
        if(this.login()){
            if(this.isFaculty()){
                System.out.println("___Create A New Course___");
                Scanner sc = new Scanner(System.in);
                //Ask the user to input the course code
                System.out.print("Enter the course code: ");
                String cC = sc.nextLine();
                //Ask the user to input the course name
                System.out.print("Enter the course name: ");
                String cN = sc.nextLine();
                //Ask the user to input the name of the course creator
                System.out.print("Enter the name of the course creator: ");
                String cCName = sc.nextLine();

                course.add(cC);
                course.add(cN);
                course.add(cCName);
            }
        }



    }

    public void viewCourse() {
        System.out.println("____COURSES____");
        for (String s : course) {
            System.out.println(s);

        }
    }

    public boolean courseCreator() {
        // verify is the user is a faculty member before becoming a course creator
        if (this.isFaculty()) {
            Scanner sc = new Scanner(System.in);
            //Ask the user to input their email
            System.out.println();
            System.out.print("Enter your email: ");
            String email = sc.nextLine();

            if (this.role == 1 || bank.contains(email)) {
                System.out.println("you are a course creator");
                return true;
            } else {
                System.out.println("you are not a course creator");
                return false;

            }
        }
        return false;
    }


    public void registerCourse() {
        System.out.println("____Register Course____");
        if (this.login()) {
            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            String email = sc.nextLine();

            //Ask the user to input the course code
            System.out.print("Enter the course code: ");
            String CourseC = sc.nextLine();



        }

    }

    public void viewCourseByCode() {
        Scanner sc = new Scanner(System.in);
        //Ask the user to input the course code
        System.out.print("Enter the course code: ");
        String email = sc.nextLine();

    }

    public void viewCourseByEmail() {
        Scanner sc = new Scanner(System.in);
        //Ask the user to input the email
        System.out.print("Enter the course code: ");
        String email = sc.nextLine();

        System.out.println("____COURSES____");
       if(email!=null){
            for(int a=0; a<assI.size();a++) {
                System.out.println(assI.get(a));
            }
        }

        }

    }

    public void addAssignment() {
        if(this.isFaculty()){
            if(this.courseCreator()){
                Scanner sc = new Scanner(System.in);

                //Ask the user to input their email
                System.out.print("Enter your email ");
                String assignEmail = sc.nextLine();

                //Ask the user to input the assignment's name
                System.out.print("Enter assignment name ");
                String assigN = sc.nextLine();

                //Ask the user to input the description of the assignment
                System.out.print("Enter the description of the assignment: ");
                String des = sc.nextLine();

                //Ask the user to input the due date of the assignment
                System.out.print("Enter the due date of the assignment: ");
                String Ddate = sc.nextLine();

                //Ask the user to input the assignment type
                System.out.print("Enter the assignment type: ");
                String assTy = sc.nextLine();

                assI.add(assigN);
                assI.add(des);
                assI.add(Ddate);
                assI.add(assignEmail);

                if ((Objects.equals(assTy, "QUIZ")) || (assTy.equals("HOMEWORK")) || (assTy.equals("PROJECT")) || (assTy.equals("EXAM"))) {
                    assI.add(assTy);

                } else {
                    System.out.println("Please Enter the correct assignment type");
                }


            }

        }
    }




    public void viewAssignmentsByCourse() {

        Scanner sc = new Scanner(System.in);
        //Ask the user to input the course code
        System.out.print("Enter the course code: ");
        System.out.println();
        System.out.println("ASSIGNMENTS");

        for (String s : assI) {
            System.out.println(s);

        }
    }


    public boolean viewAssignmentsByEmail() {
        Scanner sc = new Scanner(System.in);

        //Ask the user to input their email
        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        //if (addAssignment(assignEmail).equals(email)) {}

        return false;
        }





    public void submitAssignment() {
        if (this.login()) {
            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            String Submitemail = sc.nextLine();

            //Ask the user to input their course code
            System.out.print("Enter the course code: ");
            String SubmitcC = sc.nextLine();

            //Ask the user to input the name of assignment
            System.out.print("Enter the name of Assignment: ");
            String SubmitAssignName = sc.nextLine();

            // prints out to inform user of submission
            String submission = sc.nextLine();
            System.out.println("You have successfully submitted");

            // stores the new data into the submit array.
            submit.add(Submitemail);
            submit.add(SubmitcC);
            submit.add(SubmitAssignName);
            submit.add(submission);
        }


    }

    public void viewSubmissions() {
        System.out.println("____SUBMITTED ASSIGNMENTS____");
        if (this.login()) {
            for (int i = 0; i < submit.size(); i++) {
                System.out.println(submit.get(i));

            }
        } else {
            System.out.println("No Submission");
        }


    }

    public void scoreAssignment() {
        if (this.login()) {
            if (this.isFaculty()) {
                if (this.courseCreator()) {
                    Scanner sc = new Scanner(System.in);

                    //Ask the user to input their email
                    System.out.print("Enter your email: ");
                    String emailS = sc.nextLine();

                    //Ask the user to input their course code
                    System.out.print("Enter the course code: ");
                    String cC1S = sc.nextLine();

                    //Ask the user to input their assignment name
                    System.out.println("Enter the name of the assignment");
                    String assignNameS = sc.nextLine();

                    //Ask for the submitter's email
                    System.out.print("Enter the submitter's email: ");
                    String cCS = sc.nextLine();

                    //Ask for the user's score
                    System.out.print("Enter the score ");
                    double score = sc.nextDouble();



                    //adding user input into the scores array
                    scores.add(emailS);
                    scores.add(cC1S);
                    scores.add(assignNameS);
                    scores.add(cCS);
                    scores.add(String.valueOf(score));

                    //iterates and assigns into thee submitAssignment() function

                    assignNameS= String.valueOf(score);


                    //Using the Ashesi grading system to letter grade user's score input
                    if(score >= 100 && score >=85){
                        System.out.println("Excellent: Grade A+");
                    }else if(score <= 84 && score >= 80){
                        System.out.println("Excellent: Grade A");
                    }else if(score <= 79 && score >= 75){
                        System.out.println("Very Good: Grade B+");
                    }else if(score <= 74 && score >= 70){
                        System.out.println("Very Good: Grade B");
                    }else if(score <= 69 && score >= 65){
                        System.out.println("Good: Grade C+");
                    }else if(score <= 64 && score >= 60){
                        System.out.println("Satisfactory: Grade C");
                    }else if(score <= 59 && score >= 55){
                        System.out.println("Pass: Grade D+");
                    }else if (score<=54 && score >= 50){
                        System.out.println("Pass: Grade D");
                    }else if(score<50){
                        System.out.println("Fail: E");

                    }else {
                        System.out.println("Sorry, letter grade cannot be found!");
                    }

                    }
                }





                }
            }




// this class allows users to view their scores for assignments graded
    public void viewAssignmentScore(){
        //verify if the user is logged in
        if (this.login()) {

            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.print("Enter your email: ");

            //Ask the user to input their course code
            System.out.print("Enter the course code: ");

            //Ask the user to input their assignment name
            System.out.println("Enter the name of the assignment");


            for (int i = 0; i < scores.size(); i++) {
                    System.out.println(scores.get(i));

                }
        }
        else {
            System.out.println("Assignment not graded");
        }
    }

// allows users to viw assignment scores
    public void viewAssignmentsScores() {
        if (this.login()) {
            if (this.isFaculty()) {
                if (this.courseCreator()) {
                    Scanner sc = new Scanner(System.in);

                    //Ask the user to input their email
                    System.out.print("Enter your email: ");
                    String emailS = sc.nextLine();

                    //Ask the user to input their course code
                    System.out.print("Enter the course code: ");
                    String cC1S = sc.nextLine();

                    for (int i = 0; i < scores.size(); i++) {
                        System.out.println("Students enrolled into"+ cC1S);
                        System.out.println(scores.get(1));

                    }

                }
            }

        }


    }

    public void viewAllAssignmentScores() {
        //this is to verify id the user is logged in
        if (this.login()){
            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            String ScoresemailS = sc.nextLine();

            //Ask the user to input their course code
            System.out.print("Enter the course code: ");
            String ScorescC = sc.nextLine();



            // this is to loop through the assignment array and display the user's assignment and scores
            for (int i = 0; i < assI.size(); i++) {
                System.out.println();
                System.out.println("___ASSIGNMENTS GRADED__");
                System.out.println(assI.get(i));

            }
        }


    }

    public  void viewAssignmentGrade() {
        if(this.login()){
            Scanner sc = new Scanner(System.in);

            System.out.println("View Assignment Grades ");

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            String Viewemail = sc.nextLine();

            //Ask the user to input their course code
            System.out.print("Enter the course code: ");
            //String ViewcC = sc.nextLine();

            //Ask the user to input their assignment name
            System.out.println("Enter the name of the assignment");
            String ViewassignNameS = sc.nextLine();

            for(int i = 0; i < scores.size(); i++){
                System.out.println(scores.get(i));

            }



        }

    }

    public void viewAssignmentGrades() {

        if (this.login()) {
            if (this.isFaculty()) {
                if (this.courseCreator()) {


                    Scanner sc = new Scanner(System.in);

                    //Ask the user to input their email
                    System.out.print("Enter your email: ");
                    String AssignGradesemail = sc.nextLine();

                    //Ask the user to input their course code
                    System.out.print("Enter the course code: ");
                    String AssignGradecC = sc.nextLine();

                    //Ask the user to input their assignment name
                    System.out.println("Enter the name of the assignment");
                    String assignGradeNameS = sc.nextLine();


                    //if(AssignGradesemail== emailS){}



                }
            }

        }

    }

    public void viewAllAssignmentScoress() {
        if (this.login()) {
            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            String Assignemail = sc.nextLine();

            //Ask the user to input their course code
            System.out.print("Enter the course code: ");
            String AssigncC = sc.nextLine();

            //loops through the array and prints the scores for the user's assignment assignments
            for (int i = 0; i < submit.size(); i++) {
                System.out.println(submit.get(i));

                if(submit == null){
                    System.out.println("Sorry now Assignment has been graded.");
                }
                else{
                    System.out.println();
                    System.out.println("List of Graded Assignment");
                }


            }

        }


    }
    public boolean setNotificationPreferences () {
        if (this.login()) {
            System.out.println();

            //this is to set notifications for assignments via emails
            System.out.println("___Notification Preference___");

            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            String NotifyemailS = sc.nextLine();

            //ask the users to choose for assignment notification
            System.out.println("Do you want to be notifications for assignments? (Type YES or NO)");
            String NotifyAssign = sc.nextLine();

            //Ask the users to choose for graded assignments notification
            System.out.println("Do you want to be notifications for graded assignments? (Type YES or NO)");
            String NotifyGassign = sc.nextLine();

            if(NotifyemailS=="YES"){
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

    public static void main (String[]args){
        Canvas c1 = new Canvas();
        //c1.CreateAccount();
        c1.login();
        //c1.updateProfile();
        //c1.viewProfile();
        //c1.CreateAdmin();
        //c1.isAdmin();
        //c1.makeFaculty();
        //c1.isFaculty();
        //c1.createCourse();
        //c1.viewCourse();
        //c1.scoreAssignment();
        //c1.viewAllAssignmentScoress();
        c1.viewAssignmentGrade();
        c1.setNotificationPreferences();
    }
}
