package CanvasProject;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;

import CanvasProject.Assignment;
import CanvasProject.*;

public class Canvas {

    // Containers

    // a list is created for the assignment type
    private static final Set<String> ASS_TIES = Set.of("QUIZ", "HOMEWORK", "PROJECT", "EXAM");

    // This is an array to store emails created
    ArrayList<String> account = new ArrayList<>();

    // This is an array to a user's updated profile
    ArrayList<String> updatedProfile = new ArrayList<>();

    // This is an array to store admin emails created
    ArrayList<String> admin = new ArrayList<>();

    // This is an array to store assignments created
    ArrayList<String> allCanvasAssignments = new ArrayList<>();

    // This is an array to store courses created
    ArrayList<String> course = new ArrayList<>();

    // This is an array to store profiles created
    ArrayList<String> Profile = new ArrayList<>();

    // This is an array to store register created
    ArrayList<String> RegCourse = new ArrayList<>();

    // This is an array to store submissions
    ArrayList<String> submission = new ArrayList<>();

    // This is an array to store scores
    ArrayList<String> ScoreBoard = new ArrayList<>();

    // This is an array to store assignments created
    ArrayList<String> assI = new ArrayList<>();

    // Variables
    //int role = 0; //0=user, 1=faculty


    private String email;

    public void createAccount() {
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
            System.out.println("Login Successful");
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

    public void viewProfile() {
        System.out.println("____PROFILE____");
        if (this.login()) {

            for (int i = 0; i < updatedProfile.size(); i++) {
                System.out.println();
                System.out.println(updatedProfile.get(i).toString().replace("[", "").replace("]", ""));

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
        this.email = sc.nextLine();
        //Ask the user to enter password
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        admin.add(email);
    }

    public boolean isAdmin() {
        Scanner sc = new Scanner(System.in);

        //Ask the user to input their email
        System.out.print("Enter your email: ");
        this.email = sc.nextLine();

        if (admin.contains(email)) {
            System.out.println("You are an Admin");
            return true;


        } else {
            System.out.println("You are not an admin");
            return false;
        }

    }

    public boolean isFaculty() {

        Scanner sc = new Scanner(System.in);
        //Ask the user to input their email
        System.out.print("Enter your email: ");
        this.email = sc.nextLine();

        if (User.Role.FACULTY.equals(account.contains(email))) {
            System.out.println("you are a faculty member");
            return true;
        } else {
            System.out.println("you are not a faculty member");
            return false;

        }


    }

    public boolean courseCreator() {
        // verify is the user is a faculty member before becoming a course creator
        if (this.isFaculty()) {
            Scanner sc = new Scanner(System.in);
            //Ask the user to input their email
            System.out.println();
            System.out.print("Enter your email: ");
            this.email = sc.nextLine();

            if (User.Role.FACULTY.equals(account.contains(email))) {
                System.out.println("you are a course creator");
                return true;
            } else {
                System.out.println("you are not a course creator");
                return false;

            }
        }
        return false;
    }

    public void createCourse() {
        if (this.login()) {
            if (this.isFaculty()) {
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
        for (int i = 0; i < course.size(); i++) {
            System.out.println(course.get(i));


        }
    }

    public void viewCourseByCode() {
        Scanner sc = new Scanner(System.in);
        //Ask the user to input the course code
        System.out.print("Enter the course code: ");
        String courseCode = sc.nextLine();

        if (courseCode != null) {
            for (int y = 0; y < course.size(); y++) {
                System.out.println(course.get(y));
            }
        }


    }

    public void viewCourseByEmail() {
        Scanner sc = new Scanner(System.in);
        //Ask the user to input the email
        System.out.print("Enter the course code: ");
        this.email = sc.nextLine();

        System.out.println("____COURSES____");
        for (String s : course) {
            System.out.println(s);

        }

    }

    public String addAssignment() {
        if (this.isFaculty()) {
            if (this.courseCreator()) {
                Scanner sc = new Scanner(System.in);

                //Ask the user to input their email
                System.out.print("Enter your email: ");
                this.email = sc.nextLine();

                //Ask the user to input the assignment's name
                System.out.print("Enter assignment name: ");
                String assigN = sc.nextLine();

                //Ask the user to input their course code
                System.out.print("Enter your course code: ");
                String assignCourseCode = sc.nextLine();

                //Ask the user to input the description of the assignment
                System.out.print("Enter the description of the assignment: ");
                String des = sc.nextLine();

                //Ask the user to input the due date of the assignment
                System.out.print("Enter the due date of the assignment: ");
                String Ddate = sc.nextLine();

                //Ask the user to input the assignment type
                System.out.print("Enter the assignment type(type in uppercase): ");
                String assTy = sc.nextLine();

                assI.add(assigN);
                assI.add(des);
                assI.add(Ddate);
                assI.add(email);
                assI.add(assignCourseCode);

                if ((Objects.equals(assTy, "QUIZ")) || (assTy.equals("ASSIGNMENT")) || (assTy.equals("PROJECT")) || (assTy.equals("EXAM"))) {
                    assI.add(assTy);

                } else {
                    System.out.println("Please Enter the correct assignment type");
                }


            }

        }

        return null;
    }


    public boolean viewAssignmentsByEmail() {
        Scanner sc = new Scanner(System.in);

        //Ask the user to input their email
        System.out.print("Enter your email: ");
        this.email = sc.nextLine();

        //if (addAssignment(assignEmail).equals(email)) {}
        if (email != null) {
            for (int a = 0; a < allCanvasAssignments.size(); a++) {
                System.out.println(allCanvasAssignments.get(a));
            }
        }

        return false;
    }

    public void viewSubmissions() {
        System.out.println("____SUBMITTED ASSIGNMENTS____");
        if (this.login()) {
            for (int i = 0; i < submission.size(); i++) {
                System.out.println(submission.get(i));

            }
        } else {
            System.out.println("No Submission");
        }


    }

    public void viewAllAssignmentScores() {
        //this is to verify id the user is logged in
        if (this.login()) {
            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            this.email = sc.nextLine();

            //Ask the user to input their course code
            System.out.print("Enter the course code: ");
            String ScorescC = sc.nextLine();


            // this is to loop through the assignment array and display the user's assignment and scores
            if (email != null && ScorescC != null) {
                for (int i = 0; i < allCanvasAssignments.size(); i++) {
                    System.out.println();
                    System.out.println("___ASSIGNMENTS GRADED__");
                    System.out.println(allCanvasAssignments.get(i));

                }
            }
        }


    }

    public void viewAssignmentGrade() {
        if (this.login()) {
            Scanner sc = new Scanner(System.in);

            System.out.println("View Assignment Grades ");

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            this.email = sc.nextLine();

            //Ask the user to input their course code
            System.out.print("Enter the course code: ");
            String ViewcC = sc.nextLine();

            //Ask the user to input their assignment name
            System.out.println("Enter the name of the assignment");
            String ViewassignNameS = sc.nextLine();


            if (email != null && ViewcC != null && ViewassignNameS != null) {
                for (int i = 0; i < ScoreBoard.size(); i++) {
                    System.out.println();
                    System.out.println("___Assignment Grade___");

                    System.out.println(ScoreBoard.get(i));
                }


            }


        }

    }

    public void viewAllAssignmentScoress() throws Exception {
        if (this.login()) {
            Scanner sc = new Scanner(System.in);


            try {
                //Ask the user to input their email
                System.out.print("Enter your email: ");
                this.email = sc.nextLine();

                //Ask the user to input their course code
                System.out.print("Enter the course code: ");
                String AssigncC = sc.nextLine();


                //loops through the array and prints the scores for the user's assignment assignments
                for (int i = 0; i < submission.size(); i++) {


                    if (submission == null) {
                        throw new Exception("Sorry now Assignment has been graded.");
                    } else {
                        System.out.println();
                        System.out.println("List of Graded Assignment");
                        System.out.println(submission.get(i));
                    }
                }


            } finally {

            }
        }
    }

    public void logout() {
        System.out.println("Logout successful");
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        // Polymorphism
        Student student = new Student("miriam.adjaye@gmail.com");
        Canvas canvasObject = new Canvas();
        Faculty faculty = (Faculty) new User();
        Admin admin = new Admin();
        canvasObject.createAccount();

        // Creating a course
        String courseCode = faculty.createCourse();
        ArrayList<Course> courses = faculty.getCourse();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseCode().equals(courseCode)) {
                System.out.printf("Course Name: %s", courses.get(i).getCourseName());
            }
        }
        //Adding an Assignment
        String AssignmentName = faculty.addAssignment();
//        Assignment.getAssignmentCourseCode();
        ArrayList<Assignment> assignment = faculty.getAssignment();
        for (int x = 0; x < assignment.size(); x++) {
            if (assignment.get(x).getAssignmentCourseCode().equals(Course.getCourseCode())) {
            }

            canvasObject.login();
            canvasObject.logout();


            UserImplement uses = new UserImplement();
            uses.CreateAccount();


        }
    }
}



