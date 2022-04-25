package CanvasProject;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.lang.Exception;
import java.util.Set;
import CanvasProject.Assignment.*;


public class Faculty extends User {
    public Role role;
    // This is an array to store courses created
    private ArrayList<Course> course = new ArrayList<>();

    // This is an array to store assignments created
    private ArrayList<Assignment> assI = new ArrayList<Assignment>();


    // This is an array to store submissions
    ArrayList<String> submission = new ArrayList<>();

    // This is an array to store scores
    ArrayList<String> scores = new ArrayList<>();

    // This is an array to store scores
    ArrayList<String> ScoreBoard = new ArrayList<>();

    // Array to store all assignments
    ArrayList<String> allCanvasAssignments = new ArrayList<>();

    // a list is created for the assignment type
    private static final Set<String> ASS_TIES = Set.of("QUIZ", "HOMEWORK", "PROJECT", "EXAM");


    private String email;

    public boolean courseCreator()throws Exception {
        // verify is the user is a faculty member before becoming a course creator
        if (this.isFaculty()) {
            Scanner sc = new Scanner(System.in);
            //Ask the user to input their email
            System.out.println();
            System.out.print("Enter your email: ");
            this.email = sc.nextLine();

            if (this.role == Role.FACULTY || account.contains(email)) {

                if (this.role == Role.FACULTY || account.contains(email)) {
                    System.out.println("you are a course creator");
                    return true;
                } else {
                    throw new Exception("you are not a course creator");

                }
            }
        }
        return false;
    }


    public String createCourse() {
        String cC = null;
        if (this.login()) {
            if (this.isFaculty()) {
                System.out.println("___Create A New Course___");
                Scanner sc = new Scanner(System.in);
                //Ask the user to input the course code
                System.out.print("Enter the course code: ");
                cC = sc.nextLine();
                //Ask the user to input the course name
                System.out.print("Enter the course name: ");
                String cN = sc.nextLine();
                //Ask the user to input the name of the course creator
                System.out.print("Enter the name of the course creator: ");
                String cCName = sc.nextLine();

                // Creating a new course
                Course newCourse = new Course(cN, cC, cCName);
                course.add(newCourse);


            }
        }
        return cC;

    }

    public String addAssignment() throws Exception {
        String assignCourseCode = null;
        if(this.isFaculty()){
            if(this.courseCreator()){
                Scanner sc = new Scanner(System.in);

                //Ask the user to input their email
                System.out.print("Enter your email: ");
                this.email = sc.nextLine();

                //Ask the user to input the assignment's name
                System.out.print("Enter assignment name: ");
                String assigN = sc.nextLine();

                //Ask the user to input their course code
                System.out.print("Enter your course code: ");
                assignCourseCode = sc.nextLine();

                //Ask the user to input the description of the assignment
                System.out.print("Enter the description of the assignment: ");
                String des = sc.nextLine();

                //Ask the user to input the due date of the assignment
                System.out.print("Enter the due date of the assignment: ");
                String Ddate = sc.nextLine();

                //Ask the user to input the assignment type
                System.out.print("Enter the assignment type(type in uppercase): ");
                String assTy = sc.nextLine();

                Assignment newAssignment = new Assignment(assigN, des, Ddate, email, assignCourseCode, assTy);
//                assI.add(assigN);
//                assI.add(des);
//                assI.add(Ddate);
//                assI.add(email);
//                assI.add(assignCourseCode);

                    throw new Exception("Please Enter the correct assignment type");



            }

        }
        return assignCourseCode;
    }

    public void viewSubmissions() throws Exception{
        System.out.println("____SUBMITTED ASSIGNMENTS____");
            if (this.login()) {
                if (submission.size() == 0) {
                    throw new Exception("No Submissions found");
                } else {
                    for (int i = 0; i < submission.size(); i++) {
                        System.out.println(submission.get(i));
                    }
                }
            } else {
//            System.out.println("No Submission");
            throw new Exception("User must be logged in!");
        }


    }

    public void scoreAssignment() throws Exception {
        if (this.login()) {
            if (this.isFaculty()) {
                if (this.courseCreator()) {
                    Scanner sc = new Scanner(System.in);

                    //Ask the user to input their email
                    System.out.print("Enter your email: ");
                    this.email = sc.nextLine();

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
                    scores.add(email);
                    scores.add(cC1S);
                    scores.add(assignNameS);
                    scores.add(cCS);
                    scores.add(String.valueOf(score));

                    //iterates and assigns into thee submitAssignment() function

                    assignNameS= String.valueOf(score);

                    ScoreBoard.add(String.valueOf(scores));


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

    // allows users to viw assignment scores
    public void viewAssignmentsScores() throws Exception {
        if (this.login()) {
            if (this.isFaculty()) {
                if (this.courseCreator()) {
                    Scanner sc = new Scanner(System.in);

                    //Ask the user to input their email
                    System.out.print("Enter your email: ");
                    this.email = sc.nextLine();

                    //Ask the user to input their course code
                    System.out.print("Enter the course code: ");
                    String cC1S = sc.nextLine();

                    if (email != null && cC1S != null) {
                        for (int i = 0; i < ScoreBoard.size(); i++) {
                            System.out.println("Students enrolled into" + cC1S);
                            System.out.println(ScoreBoard.get(1));

                        }

                    }
                }
            }

        }


    }

    public void viewAssignmentGrades() throws Exception {

        if (this.login()) {
            if (this.isFaculty()) {
                if (this.courseCreator()) {


                    Scanner sc = new Scanner(System.in);

                    //Ask the user to input their email
                    System.out.print("Enter your email: ");
                    this.email = sc.nextLine();

                    //Ask the user to input their course code
                    System.out.print("Enter the course code: ");
                    String AssignGradecC = sc.nextLine();

                    //Ask the user to input their assignment name
                    System.out.println("Enter the name of the assignment");
                    String assignGradeNameS = sc.nextLine();


                    if(email!=null & AssignGradecC!=null && assignGradeNameS!=null) {
                        for (int i = 0; i < allCanvasAssignments.size(); i++) {
                            System.out.println();
                            System.out.println("___Assignment Grade___");

                            System.out.println(allCanvasAssignments.get(i));

                        }
                    }


                }
            }

        }

    }

    public ArrayList<Course> getCourse() {
        return this.course;
    }




    public ArrayList<Assignment> getAssignment(){
        return this.assI;
    }

}
