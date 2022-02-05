import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Phase_1 {

    // Arraylist holds all the accounts
    static ArrayList<ArrayList<String>> Accounts = new ArrayList<ArrayList<String>>();

    //Array list holds admin accounts
    static ArrayList<String> Admins = new ArrayList<String>();

    // Array list holds faculty details
    static ArrayList<String> Faculty = new ArrayList<String>();

    //Array list holds all courses details
    static ArrayList<ArrayList<String>> Courses = new ArrayList<ArrayList<String>>();

    //Array list holds all assignments details
    static ArrayList<ArrayList<String>> Assignments = new ArrayList<ArrayList<String>>();

    //Array list holds registered courses details
    static ArrayList<ArrayList<String>> registeredCourses = new ArrayList<ArrayList<String>>();

    //Array list holds submitted assignments
    static ArrayList<ArrayList<String>> submittedAssignments = new ArrayList<ArrayList<String>>();

    // Arraylist holds Notification preferences
    static ArrayList<ArrayList<String>> notificationPreferences = new ArrayList<ArrayList<String>>();


    public static void main(String[] args) {
        // populate Accounts array with admin emails
        Admins.add("admin@gmail.com");
        Admins.add("boss@gmail.com");

        ArrayList<String> admin1 = new ArrayList<String>();
        admin1.add("admin@gmail.com");
        admin1.add("admin");
        Accounts.add(admin1);

        ArrayList<String> admin2 = new ArrayList<String>();
        admin2.add("boss@gmail.com");
        admin2.add("boss");


        // methods are static so instance of the class doesn't need to be created
        newAccount();
        newAccount();
        //newAccount();
        /*updateProfile();
        updateProfile();
        viewProfile();*/
        makeFaculty();
        createCourse();
        //createCourse();
        //viewCourses();
        registerCourse();
        //registerCourse();
        //registerCourse();
        //viewCourseByCode();
        //viewCourseByEmail();
        addAssignment();
        addAssignment();
        //addAssignment();
        submitAssignment();
        submitAssignment();
        //viewSubmissions();
        //viewAssignmentsByCourse();


        //submitAssignment();
        //submitAssignment();
        //submitAssignment();
        //viewSubmissions();
        scoreAssignment();
        scoreAssignment();
        //viewAssignmentScore();
        //viewAssignmentScore();
        viewAssignmentScores();
        //viewAllAssignmentScores();

        /*try {
            viewAssignmentsByEmail();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        viewAssignmentGrade();
        viewAssignmentGrades();
        viewAllAssignmentGrades();
        setNotificationPreferences();

    }

    // Requesting user details for creation of new account
    public static void newAccount() {
        System.out.print("\n");
        System.out.print("__________CREATE NEW ACCOUNT__________ \n");
        System.out.print("\n");
        Scanner getDets = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter Email: ");
        String email = getDets.nextLine();  // Read user input
        System.out.print("Enter Password: ");
        String password = getDets.nextLine();
        createAccount(email, password);
    }

    // This function created a new account
    public static void createAccount(String email, String password) {
        // check if account already exists
        for (ArrayList<String> account : Accounts) {
            String checkEmail = account.get(0);
            if (checkEmail.equals(email)) {
                System.out.println("This Account ALREADY exists");
                return;
            }
        }
        // Create new account
        ArrayList<String> newAccount = new ArrayList<String>();
        newAccount.add(email);
        newAccount.add(password);
        Accounts.add(newAccount);
        System.out.println("Your account has been created");
    }


    // Login function, request user details
    public static ArrayList<String> login() {
        System.out.print("\n");
        System.out.print("__________LOGIN__________\n");
        System.out.print("\n");
        Scanner getDets = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter Email: ");
        String mail = getDets.nextLine();  // Read user input
        System.out.print("Enter Password: ");
        String passWord = getDets.nextLine();  // Read user input

        String verify = loginVerify(mail, passWord);

        ArrayList<String> userInfo = new ArrayList<String>();
        userInfo.add(verify);
        userInfo.add(mail);
        userInfo.add(passWord);

        return userInfo;
    }

    // Verify login details provided
    public static String loginVerify(String email, String password) {

        for (ArrayList<String> account : Accounts) {
            String checkEmail = account.get(0);
            String checkPassword = account.get(1);
            if (checkEmail.equals(email)) {
                if (checkPassword.equals(password)) {
                    return "True";
                }
            }
        }

        return "False";
    }


    // Update User profile
    public static void updateProfile() {
        System.out.print("\n");
        System.out.print("To UPDATE your profile, kindly login first: \n");

        // Login & login verification
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);
        String password = userInfo.get(2);

        //Request details from user for update
        Scanner getDets = new Scanner(System.in);  // Create a Scanner object
        if (verify.equals("True")) {
            System.out.println("You're logged in, you can now update your profile");

            System.out.print("Enter First Name: ");
            String firstName = getDets.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = getDets.nextLine();

            System.out.print("Enter Year group: ");
            String yearGroup = getDets.nextLine();

            System.out.print("Enter current GPA: ");
            String gpa = getDets.nextLine();

            System.out.print("Enter Date of birth e.g 24/04/2002: ");
            String dob = getDets.nextLine();


            for (ArrayList<String> account : Accounts) {
                String checkEmail = account.get(0);
                if (checkEmail.equals(mail)) {

                    // If Account has been previously updated
                    try {
                        account.set(0, mail);
                        account.set(1, password);
                        account.set(2, firstName);
                        account.set(3, lastName);
                        account.set(4, yearGroup);
                        account.set(5, gpa);
                        account.set(6, dob);
                    }

                    // First update of account
                    catch (IndexOutOfBoundsException e) {
                        account.set(0, mail);
                        account.set(1, password);
                        account.add(firstName);
                        account.add(lastName);
                        account.add(yearGroup);
                        account.add(gpa);
                        account.add(dob);
                    }
                }


            }
            System.out.print("Thank You, your profile has successfully been UPDATED ");
        } else {
            System.out.println("INCORRECT Username or Password");
        }
    }

    // View account details
    public static void viewProfile() {
        System.out.print("\n");
        System.out.print("To VIEW your profile, kindly login first: \n");

        // Login & verification of user
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        if (verify.equals("True")) {
            System.out.println("\nYou're logged in \n _____Your profile_____");
            for (ArrayList<String> account : Accounts) {
                String checkEmail = account.get(0);

                if (checkEmail.equals(mail)) {

                    System.out.print("\nEmail: " + account.get(0));

                    try {
                        System.out.print("\nFirst Name: " + account.get(2));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.print("\nFirst Name: NA \n");
                    }

                    try {
                        System.out.print("\nLast Name: " + account.get(3));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.print("Last Name: NA \n");
                    }

                    try {
                        System.out.print("\nYear Group: " + account.get(4));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.print("Year Group: NA \n");
                    }

                    try {
                        System.out.print("\nGPA: " + account.get(5));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.print("GPA: NA \n");
                    }

                    try {
                        System.out.print("\nD.O.B: " + account.get(6));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.print("D.O.B: NA \n");
                    }

                }

            }
        } else {
            System.out.println("INCORRECT Username or Password\n");
        }
    }

    // Check if user is an admin
    public static boolean isAdmin(String mail) {
        for (String admin : Admins) {
            if (admin.equals(mail)) {
                return true;
            }
        }
        return false;
    }


    // Assign faculty role to an account N.B can only be done by admin
    public static void makeFaculty() {
        System.out.print("\n");
        System.out.print("To assign Faculty role. you MUST be an ADMIN \n Kindly login first: \n");

        // User login & verification
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        if (verify.equals("True")) {
            // Check if user is an admin
            if (isAdmin(mail)) {
                System.out.print("Which User do you want to assign Faculty role to? \n");

                Scanner getDets = new Scanner(System.in);  // Create a Scanner object
                System.out.print("Enter User's Email: ");
                String userEmail = getDets.nextLine();  // Read user input

                for (ArrayList<String> account : Accounts) {
                    String checkEmail = account.get(0);

                    if (checkEmail.equals(userEmail)) {
                        Faculty.add(userEmail);
                        System.out.println(userEmail + " has been given Faculty privileges");
                        return;
                    }

                }
                System.out.println("Account provided DOES NOT exists");
            } else {
                System.out.print(" You are NOT an admin, High level authorization needed");
            }
        } else {
            System.out.print("INCORRECT Username or Password");
        }


    }

    // Check if user is a faculty
    public static boolean isFaculty(String mail) {
        for (String s : Faculty) {
            if (s.equals(mail)) {
                return true;
            }
        }
        return false;
    }


    // create a course N.B can only be done by faculty
    public static void createCourse() {
        System.out.print("\n");
        System.out.print("To create a course, you MUST be a FACULTY \n Kindly login first: \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        if (verify.equals("True")) {
            if (isFaculty(mail)) {
                System.out.print("You are eligible to create a course \n");
                Scanner getDets = new Scanner(System.in);  // Create a Scanner object
                System.out.print("Enter Course Name: ");
                String courseName = getDets.nextLine();

                System.out.print("Enter Course Code: ");
                String courseCode = getDets.nextLine();

                // Check if course-code already exists
                for (ArrayList<String> course : Courses) {
                    if (course.get(2).equals(courseCode)) {
                        System.out.print("This course has previously been created");
                        return;
                    }
                }

                // create new course
                ArrayList<String> newCourse = new ArrayList<String>();
                newCourse.add(mail);
                newCourse.add(courseName);
                newCourse.add(courseCode);
                Courses.add(newCourse);
                System.out.print("New Course has been created");
                return;
                // allow user to create many courses
            }
            System.out.println("You are NOT Authorized to Create a course");
        } else {
            System.out.print("INCORRECT Username or Password");
        }
    }

    // display course details
    public static void viewCourses() {
        System.out.print("\n_______ Course Details______ \n");
        System.out.print("Lecturer      Course Name     Course Code \n");
        for (ArrayList<String> course : Courses) {
            System.out.println(course.get(0) + "\t\t" + course.get(1) + "\t\t" + course.get(2) + "\n");
        }
    }


    // Student course registration
    public static void registerCourse() {
        System.out.print(" \n _________COURSE REGISTRATION_____________ \n");
        System.out.print(" \n Kindly login to your Account \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);


        if (verify.equals("True")) {
            // Make sure it's a student
            if (isFaculty(mail)) {
                System.out.println("Only Students can register for a course");

            } else {
                System.out.print("You have SUCCESSFULLY logged in");
                Scanner getDets = new Scanner(System.in);  // Create a Scanner object
                System.out.print("\nEnter Course Code: ");
                String courseCode = getDets.nextLine();

                //check if course code exists
                for (ArrayList<String> course : Courses) {
                    if (course.get(2).equals(courseCode)) {

                        // check if student has registered for course before
                        for (ArrayList<String> registered : registeredCourses) {
                            if (registered.get(0).equals(mail)) {
                                if (registered.get(1).equals(courseCode)) {
                                    System.out.print("You are ALREADY registered for this course");
                                    return;
                                }
                            }
                        }

                        ArrayList<String> newReg = new ArrayList<String>();
                        newReg.add(mail);
                        newReg.add(courseCode);
                        registeredCourses.add(newReg);
                        System.out.print("You have SUCCESSFULLY registered for " + courseCode);
                        return;
                    }

                }
                System.out.print("You entered an INVALID course code");
            }
        } else {
            System.out.print("INCORRECT Username or Password");
        }
    }


    // View course by course-code
    public static void viewCourseByCode() {

        System.out.print("\nYou would like to view Courses by Code, Kindly enter the Course Code");
        Scanner getDets = new Scanner(System.in);  // Create a Scanner object
        System.out.print("\nEnter Course Code: ");
        String courseCode = getDets.nextLine();

        System.out.print("\n_______ Viewing Course by code______ \n");
        System.out.print("Lecturer      Course Name     Course Code \n");

        for (ArrayList<String> course : Courses) {
            System.out.println(course.get(0) + "\t\t" + course.get(1) + "\t\t" + course.get(2) + "\n");
        }

        System.out.println("\n_______ List of Students registered for " + courseCode + "________\n");
        System.out.println("Email            Student Name     \n");

        // List of student emails registered for the course
        ArrayList<String> studentsInCourse = new ArrayList<>();

        for (ArrayList<String> registeredCourse : registeredCourses) {
            if (registeredCourse.get(1).equals(courseCode)) {
                studentsInCourse.add(registeredCourse.get(0));
            }
        }

        for (ArrayList<String> account : Accounts) {
            for (String s : studentsInCourse) {
                if (account.get(0).equals(s)) {

                    //Print student details
                    try {
                        System.out.println(account.get(0) + "\t" + account.get(2) + " " + account.get(3));
                    }
                    // Print details when account details haven't been updated
                    catch (IndexOutOfBoundsException e) {
                        System.out.println(account.get(0) + "\t\t" + "*NOT UPDATED*");
                    }
                }
            }
        }
    }

    // View course by Email
    public static void viewCourseByEmail() {
        System.out.print("\nYou would like to view Courses by Email, Kindly enter user's Email");
        Scanner getDets = new Scanner(System.in);  // Create a Scanner object
        System.out.print("\nEnter Email: ");
        String mail = getDets.nextLine();

        // check if account  exists
        for (ArrayList<String> account : Accounts) {
            String checkEmail = account.get(0);

            if (checkEmail.equals(mail)) {
                System.out.print("\n_______ Viewing Course by Email______ \n");
                System.out.print("___ List of Courses " + mail + " is registered for ___\n");
                System.out.print(" Course Name     Course Code \n");

                for (ArrayList<String> course : registeredCourses) {
                    if (course.get(0).equals(mail)) {
                        for (ArrayList<String> coursedet : Courses) {
                            if (course.get(1).equals(coursedet.get(2))) {
                                System.out.println(coursedet.get(1) + "\t\t\t" + coursedet.get(2));
                            }
                        }
                    }
                }
                return;
            }
        }
        System.out.print("\nThe Email you entered is INCORRECT");
    }

    // Check if faculty is the course creator
    public static boolean isCourseCreator(String mail, String courseCode) {
        for (ArrayList<String> s : Courses) {
            if (s.get(0).equals(mail)) {
                if (s.get(2).equals(courseCode)) {
                    return true;
                }
            }
        }
        return false;
    }

    // This function adds and assignment
    public static void addAssignment() {
        System.out.print(" \n _________ ADD ASSIGNMENT_____________ \n");
        System.out.print(" \n Kindly login to your Account \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        // Login
        if (verify.equals("True")) {
            // Make sure it's a Faculty
            if (isFaculty(mail)) {
                Scanner getDets = new Scanner(System.in);  // Create a Scanner object
                System.out.print("\nEnter Course code: ");
                String courseCode = getDets.nextLine();

                //Check if Course code exists
                for (ArrayList<String> course : Courses) {
                    if (course.get(2).equals(courseCode)) {
                        // Make sure the faculty is the course creator
                        if (isCourseCreator(mail, courseCode)) {
                            // add assignment

                            System.out.print("\nEnter Assignment Name: ");
                            String assName = getDets.nextLine();

                            System.out.print("\nEnter Assignment Description: ");
                            String assDesc = getDets.nextLine();

                            System.out.print("\nEnter Assignment Type: ");
                            String assType = getDets.nextLine();

                            System.out.print("\nEnter Assignment Due Date e.g 24/3/2022: ");
                            String assDue = getDets.nextLine();

                            ArrayList<String> hw = new ArrayList<>();
                            hw.add(mail);
                            hw.add(courseCode);
                            hw.add(assName);
                            hw.add(assDesc);
                            hw.add(assDue);
                            hw.add(assType);
                            Assignments.add(hw);
                        } else {
                            System.out.println("You are NOT the Course Creator, CANNOT add assignment");
                        }
                        return;
                    }

                }
                System.out.println("INVALID Course Code");

            } else {
                System.out.println("You are NOT a faculty");

            }

        } else {
            System.out.println("INCORRECT username or password");
        }
    }

    public static void viewAssignmentsByCourse() {

        System.out.println("\n_______ View Assignments By Course Code______ \n");
        Scanner getDets = new Scanner(System.in);  // Create a Scanner object
        System.out.print("\nEnter Course code: ");
        String courseCode = getDets.nextLine();

        System.out.println("\n_____ Current Assignments for " + courseCode + " _____\n");
        System.out.println("Name                  Description                  Due Date                  Type \n");
        for (ArrayList<String> each : Assignments) {
            if (each.get(1).equals(courseCode)) {
                System.out.println(each.get(2) + "\t\t\t\t" + each.get(3) + "\t\t\t\t" + each.get(4) + "\t\t\t\t" + each.get(5) + "\n");
            }
        }
    }


    public static void viewAssignmentsByEmail() throws Exception {
        System.out.print("\nYou would like to view Assignments by Email, Kindly enter Email");
        Scanner getDets = new Scanner(System.in);  // Create a Scanner object
        System.out.print("\nEnter Email: ");
        String mail = getDets.nextLine();

        // list to store curse codes where student has homework
        ArrayList<String> hw = new ArrayList<>();
        // check if account  exists
        for (ArrayList<String> account : Accounts) {
            String checkEmail = account.get(0);

            if (checkEmail.equals(mail)) {
                // Ensure the person is a student
                if (!isFaculty(mail)) {
                    System.out.println("___ List of Assigments " + mail + " has ___\n");

                    // go through registered courses to find courses student is registered in
                    for (ArrayList<String> course : registeredCourses) {
                        if (course.get(0).equals(mail)) {
                            // check if the course has assignments
                            for (ArrayList<String> each : Assignments) {
                                if (course.get(1).equals(each.get(1))) {
                                    // add it to the list of homeworks the user has
                                    if (!hw.contains(each.get(1))) {
                                        hw.add(each.get(1));
                                    }
                                }

                            }
                        }
                    }
                } else {
                    System.out.println("Faculty have NO assignment");
                }
            }
        }

        //invalid email check?

        System.out.println("Would you like to see only Pending assignments? Enter 1 for yes and 0 for no: ");
        int pend = getDets.nextInt();
        System.out.println("Name           Description            Due Date            Type \n");

        if (pend == 1) {
            Date todayDate = new Date();
            for (ArrayList<String> each : Assignments) {
                for (String s : hw) {
                    if (each.get(1).equals(s)) {
                        String date = each.get(4);
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date day = sdf.parse(date);
                        int val = todayDate.compareTo(day);
                        if (val < 0) {
                            System.out.println(each.get(2) + "\t\t\t\t" + each.get(3) + "\t\t\t\t" + each.get(4) + "\t\t\t\t" + each.get(5) + "\n");
                        }
                    }
                }

            }
        } else if (pend == 0) {
            for (String s : hw) {
                for (ArrayList<String> each : Assignments) {
                    if (each.get(1).equals(s)) {
                        System.out.println(each.get(2) + "\t\t\t\t" + each.get(3) + "\t\t\t\t" + each.get(4) + "\t\t\t\t" + each.get(5) + "\n");
                    }
                }

            }

        }
    }

    public static void submitAssignment() {
        System.out.print(" \n _________ SUBMIT ASSIGNMENT _____________ \n");
        System.out.print(" \n Kindly login to your Account \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        if (verify.equals("True")) {
            // Make sure it's a student
            if (isFaculty(mail)) {
                System.out.println("Only Students can submit Assignments for a course");
            } else {

                Scanner getDets = new Scanner(System.in);
                System.out.print("\nYou have SUCCESSFULLY logged in ");

                System.out.print("\nEnter Course Code: ");
                String courseCode = getDets.nextLine();

                System.out.print("\nEnter Assignment Name: ");
                String assName = getDets.nextLine();


                // check if assignment exists for submission
                for (ArrayList<String> each : Assignments) {
                    if (each.contains(courseCode) && each.contains(assName)) {
                        System.out.print("\nEnter Submission: ");
                        String submission = getDets.nextLine();
                        ArrayList<String> submit = new ArrayList<>();
                        submit.add(mail);
                        submit.add(courseCode);
                        submit.add(assName);
                        submit.add(submission);
                        submittedAssignments.add(submit);
                        System.out.print("\n___ SUBMITTED __");
                        return;
                    }
                }
                System.out.print("INVALID course code or Assignment Name");
            }
        } else {
            System.out.print("INCORRECT Username or Password");
        }
    }

    public static void viewSubmissions() {
        System.out.print(" \n _________ VIEW ASSIGNMENT SUBMISSIONS_____________ \n");
        System.out.print(" \n Kindly login to your Account \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        // Login
        if (verify.equals("True")) {
            // Make sure it's a Faculty
            if (isFaculty(mail)) {
                Scanner getDets = new Scanner(System.in);  // Create a Scanner object
                System.out.print("\nEnter Course code: ");
                String courseCode = getDets.nextLine();

                //Check if Course code exists

                for (ArrayList<String> course : Courses) {
                    if (course.contains(courseCode)) {
                        // Make sure the faculty is the course creator
                        if (isCourseCreator(mail, courseCode)) {

                            System.out.print("\nEnter Assignment Name: ");
                            String assName = getDets.nextLine();
                            System.out.print("\nStudent Mail            Submission\n");

                            // array list for all doing the course
                            ArrayList<String> stu = new ArrayList<>();
                            // check if particular assignment exists for that course code

                            for (ArrayList<String> hw : Assignments) {
                                // if assignment does exist, then view submissions
                                if (hw.contains(assName)) {
                                    // display names and submissions

                                    for (ArrayList<String> user : registeredCourses) {
                                        // check users registered for particular course
                                        if (user.contains(courseCode)) {
                                            // if user is registered, add them to the stu array
                                            stu.add(user.get(0));
                                        }
                                    }

                                    //list of those who did the current assignment
                                    ArrayList<String> stuSub = new ArrayList<>();
                                    for (ArrayList<String> each : submittedAssignments) {
                                        if (each.contains(courseCode) && each.contains(assName)) {
                                            stuSub.add(each.get(0));
                                        }
                                    }

                                    for (String st : stu) {
                                        for (ArrayList<String> each : submittedAssignments) {
                                            if (each.get(0).equals(st)) {
                                                System.out.println(st + "\t\t\t" + each.get(3));

                                            } else {
                                                // if user did not submit
                                                if (!stuSub.contains(st)) {
                                                    System.out.println(st + "\t\t\t" + "NO SUBMISSION");
                                                }
                                            }

                                        }
                                    }
                                }

                                // Assignment doesnt exists
                                else {
                                    System.out.print("\n NO such Assignment for this course");
                                }
                                return;
                            }
                            System.out.print("\n NO Assignment for this course");

                        } else {
                            System.out.print("\n You MUST be the course creator to view submissions");
                        }
                    }
                    return;
                }
                System.out.print("\n INVALID course code");
            } else {
                System.out.print("\n You MUST be a FACULTY to view submissions");
            }
        } else {
            System.out.print("\n INVALID username or password");
        }

    }

    public static void scoreAssignment() {
        System.out.println(" \n _________ SCORE ASSIGNMENT _____________ \n");
        System.out.println(" \n Kindly login to your Account \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        // Login
        if (verify.equals("True")) {
            // Make sure it's a Faculty
            if (isFaculty(mail)) {
                Scanner getDets = new Scanner(System.in);  // Create a Scanner object
                System.out.print("\nEnter Course code: ");
                String courseCode = getDets.nextLine();

                //Check if Course code exists

                for (ArrayList<String> course : Courses) {
                    if (course.contains(courseCode)) {
                        // Make sure the faculty is the course creator
                        if (isCourseCreator(mail, courseCode)) {
                            System.out.print("\nEnter Assignment name: ");
                            String assName = getDets.nextLine();

                            System.out.print("\nEnter Submitter email: ");
                            String subEmail = getDets.nextLine();


                            // check if assignment exists
                            for (ArrayList<String> each : Assignments) {
                                if (each.contains(courseCode) && each.contains(assName)) {
                                    // ensure submitter email is a student
                                    if (!isFaculty(subEmail)) {

                                        //list of those who did the current assignment
                                        ArrayList<String> stuSub = new ArrayList<>();
                                        for (ArrayList<String> one : submittedAssignments) {
                                            if (one.contains(courseCode) && one.contains(assName)) {
                                                stuSub.add(one.get(0));
                                            }
                                        }
                                        // check if the person submitted
                                        if (stuSub.contains(subEmail)) {
                                            // score them
                                            for (ArrayList<String> sc : submittedAssignments) {
                                                if (sc.get(0).equals(subEmail)) {
                                                    if (sc.get(2).equals(assName)){
                                                    System.out.print("\nEnter Score out of 100: ");
                                                    String score = getDets.nextLine();
                                                    sc.add(score);
                                                    System.out.println("The student has been graded");
                                                    return;}
                                                }
                                            }
                                        } else {
                                            System.out.println("This student has NOT submitted yet");
                                        }

                                    } else {
                                        System.out.println("The submitter HAS to be a student");
                                    }

                                }

                            }
                            System.out.println("The Assignment does NOT exist");

                        } else {
                            System.out.println("You MUST be the course creator");
                        }
                    }

                }
            } else {
                System.out.println("You MUST be a faculty");
            }
        } else {
            System.out.println("INVALID username or password");
        }

    }

    public static void viewAssignmentScore() {
        System.out.println(" \n _________ VIEW ASSIGNMENT SCORE _____________ \n");
        System.out.println("Kindly login to your Account \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        // Login
        if (verify.equals("True")) {
            // Make sure it's NOT Faculty
            if (!isFaculty(mail)) {
                Scanner getDets = new Scanner(System.in);  // Create a Scanner object
                System.out.print("\nEnter Course code: ");
                String courseCode = getDets.nextLine();

                System.out.print("\nEnter Assignment name: ");
                String assName = getDets.nextLine();

                // check if the user submitted the assignment

                //list of those who did the current assignment
                ArrayList<String> stuSub = new ArrayList<>();
                for (ArrayList<String> one : submittedAssignments) {
                    if (one.contains(courseCode) && one.contains(assName)) {
                        stuSub.add(one.get(0));
                    }
                }
                // check if the person submitted
                if (stuSub.contains(mail)) {

                    for (ArrayList<String> sc : submittedAssignments) {
                        if (sc.get(0).equals(mail) && sc.get(2).equals(assName)) {
                            //print grade if they've been graded

                            try {
                                System.out.println("Your grade for " + sc.get(2) + " is " + sc.get(4));
                            } catch (IndexOutOfBoundsException e) {
                                 System.out.println("This assignment has NOT been graded");
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("INVALID username or password");
        }
    }

    public static void viewAssignmentScores() {
        System.out.println(" \n _________ VIEW ASSIGNMENT SCORES _____________ \n");
        System.out.println(" \n Kindly login to your Account \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        // Login
        if (verify.equals("True")) {
            // Make sure it's a Faculty
            if (isFaculty(mail)) {
                Scanner getDets = new Scanner(System.in);  // Create a Scanner object
                System.out.print("\nEnter Course code: ");
                String courseCode = getDets.nextLine();

                //Check if Course code exists

                for (ArrayList<String> course : Courses) {
                    if (course.contains(courseCode)) {
                        // Make sure the faculty is the course creator
                        if (isCourseCreator(mail, courseCode)) {
                            System.out.print("\nEnter Assignment name: ");
                            String assName = getDets.nextLine();

                            // check if assignment exists
                            System.out.print("\nStudent             Score\n");
                            for (ArrayList<String> each : Assignments) {
                                if (each.contains(courseCode) && each.contains(assName)) {

                                    // Display student email and grades
                                    for (ArrayList<String> one : submittedAssignments) {
                                        if (one.contains(courseCode) && one.contains(assName)) {

                                            try {
                                                System.out.println(one.get(0) + "\t\t\t" + one.get(4));
                                            } catch (IndexOutOfBoundsException e) {
                                                System.out.println(one.get(0) + "\t\t\t NOT GRADED");
                                            }
                                        }
                                    }
                                }
                            }
                            //System.out.println("The Assignment does NOT exist");
                        } else {
                            System.out.println("You MUST be the course creator");
                        }
                    } else {
                        System.out.println("INVALID course code");
                    }
                }
            } else {
                System.out.println("You MUST be a faculty");
            }
        } else {
            System.out.println("INVALID username or password");
        }
    }

    public static void viewAllAssignmentScores() {
        System.out.println(" \n _________ VIEW ASSIGNMENT SCORES _____________ \n");
        System.out.println(" \n Kindly login to your Account \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        // Login
        if (verify.equals("True")) {
            // Make sure it's not a Faculty
            if (!isFaculty(mail)) {
                //get course code
                Scanner getDets = new Scanner(System.in);  // Create a Scanner object
                System.out.print("\nEnter Course code: ");
                String courseCode = getDets.nextLine();
                System.out.println("Assignment      Score");
                for (ArrayList<String> sc : submittedAssignments) {
                    if (sc.get(0).equals(mail)) {
                        //print grade if they've been graded
                        try {
                            System.out.println(sc.get(2) + "\t\t\t\t " + sc.get(4));
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(sc.get(2) + "\t\t" + "NOT GRADED");
                        }
                    }
                }

            } else {
                System.out.println("You MUST be a student");
            }

        } else {
            System.out.println("INVALID username or password");
        }
    }

    // this function converts a score to a grade letter
    public static String grader(int score) {
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

    public static void viewAssignmentGrade(){
        System.out.println(" \n _________ VIEW ASSIGNMENT SCORE WITH GRADE_____________ \n");
        System.out.println("Kindly login to your Account \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        // Login
        if (verify.equals("True")) {
            // Make sure it's NOT Faculty
            if (!isFaculty(mail)) {
                Scanner getDets = new Scanner(System.in);  // Create a Scanner object
                System.out.print("\nEnter Course code: ");
                String courseCode = getDets.nextLine();

                System.out.print("\nEnter Assignment name: ");
                String assName = getDets.nextLine();

                // check if the user submitted the assignment

                //list of those who did the current assignment
                ArrayList<String> stuSub = new ArrayList<>();
                for (ArrayList<String> one : submittedAssignments) {
                    if (one.contains(courseCode) && one.contains(assName)) {
                        stuSub.add(one.get(0));
                    }
                }
                // check if the person submitted
                if (stuSub.contains(mail)) {

                    for (ArrayList<String> sc : submittedAssignments) {
                        if (sc.get(0).equals(mail) && sc.get(2).equals(assName)) {
                            //print grade if they've been graded

                            try {
                                System.out.println("Your grade for " + sc.get(2) + " is " + sc.get(4) + "  " + grader(Integer.parseInt(sc.get(4))));
                            } catch (IndexOutOfBoundsException e) {
                                // System.out.println("This assignment has NOT been graded");
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("INVALID username or password");
        }

    }

    public static void viewAssignmentGrades(){
        System.out.println(" \n _________ VIEW ASSIGNMENT SCORES WITH GRADES _____________ \n");
        System.out.println(" \n Kindly login to your Account \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        // Login
        if (verify.equals("True")) {
            // Make sure it's a Faculty
            if (isFaculty(mail)) {
                Scanner getDets = new Scanner(System.in);  // Create a Scanner object
                System.out.print("\nEnter Course code: ");
                String courseCode = getDets.nextLine();

                //Check if Course code exists

                for (ArrayList<String> course : Courses) {
                    if (course.contains(courseCode)) {
                        // Make sure the faculty is the course creator
                        if (isCourseCreator(mail, courseCode)) {
                            System.out.print("\nEnter Assignment name: ");
                            String assName = getDets.nextLine();

                            // check if assignment exists
                            System.out.print("\nStudent             Score           Grade\n");
                            for (ArrayList<String> each : Assignments) {
                                if (each.contains(courseCode) && each.contains(assName)) {

                                    // Display student email and grades
                                    for (ArrayList<String> one : submittedAssignments) {
                                        if (one.contains(courseCode) && one.contains(assName)) {

                                            try {
                                                System.out.println(one.get(0) + "\t\t\t" + one.get(4) + "\t\t\t" + grader(Integer.parseInt(one.get(4))));
                                            } catch (IndexOutOfBoundsException e) {
                                                System.out.println(one.get(0) + "\t\t\t NOT GRADED");
                                            }
                                        }
                                    }
                                }
                            }
                            //System.out.println("The Assignment does NOT exist");
                        } else {
                            System.out.println("You MUST be the course creator");
                        }
                    } else {
                        System.out.println("INVALID course code");
                    }
                }
            } else {
                System.out.println("You MUST be a faculty");
            }
        } else {
            System.out.println("INVALID username or password");
        }

    }

    public static void viewAllAssignmentGrades(){
        System.out.println(" \n _________ VIEW ASSIGNMENT SCORES WITH GRADES_____________ \n");
        System.out.println(" \n Kindly login to your Account \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        // Login
        if (verify.equals("True")) {
            // Make sure it's not a Faculty
            if (!isFaculty(mail)) {
                //get course code
                Scanner getDets = new Scanner(System.in);  // Create a Scanner object
                System.out.print("\nEnter Course code: ");
                String courseCode = getDets.nextLine();
                System.out.println("Assignment      Score       Grade");
                for (ArrayList<String> sc : submittedAssignments) {
                    if (sc.get(0).equals(mail)) {
                        //print grade if they've been graded
                        try {
                            System.out.println(sc.get(2) + "\t\t\t\t " + sc.get(4) +"\t\t\t\t"+ grader(Integer.parseInt(sc.get(4))));
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(sc.get(2) + "\t\t" + "NOT GRADED");
                        }
                    }
                }

            } else {
                System.out.println("You MUST be a student");
            }

        } else {
            System.out.println("INVALID username or password");
        }
    }

    public static void setNotificationPreferences(){
        System.out.println(" \n _________ NOTIFICATION PREFERENCES ___________ \n");
        System.out.println(" \n Kindly login to your Account \n");
        ArrayList<String> userInfo = login();
        String verify = userInfo.get(0);
        String mail = userInfo.get(1);

        // Login
        if (verify.equals("True")) {
            // Make sure it's not a Faculty
            System.out.print("\nYou have SUCCESSFULLY logged in ");
            if (!isFaculty(mail)) {
                System.out.println("Please set your notification preferences ");

                Scanner getDets = new Scanner(System.in);

                System.out.println("Would you like to be notified when you register for a course? Enter Y or N: ");
                String regNotify = getDets.nextLine();

                System.out.println("Would you like to be notified when an assignment is posted? Enter Y or N: ");
                String assNotify = getDets.nextLine();

                System.out.println("Would you like to be notified when a grade is posted? Enter Y or N: ");
                String gradeNotify = getDets.nextLine();

                ArrayList<String> newPref = new ArrayList<>();
                newPref.add(mail);
                newPref.add(regNotify);
                newPref.add(assNotify);
                newPref.add(gradeNotify);

                notificationPreferences.add(newPref);
                System.out.println("CHANGES SAVED");
            }


        }
    }
}

