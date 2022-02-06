import java.util.*;

class ProjectPhaseOne {


//#global variables
private static Scanner scan = new Scanner(System.in);

private static String email, password, firstName, lastName, yearGroup, gPa, DoB, course, courseCode, assignmentName, assignmentDescription, TypeOfAssignment, DueDate, userResponse, submitterEmail, score;
   
private static ArrayList<String> data;

private static ArrayList<String> credentials;

//#Printing the credentils
public static void PrintData(){

   data = new ArrayList<>();
   data.add(email);
   data.add(password); 
      
  System.out.println("\nYour credentials: " + data);
    }
      
   
//#createAccount
public static void createAccount(){
   
   System.out.println("\nWelcome to Project Phase One");
   Scanner scan = new Scanner(System.in);
   System.out.print("\nPlease enter your new email>>> ");
   email = scan.nextLine();
   System.out.print("\nPlease enter your new password>>> ");
   password = scan.nextLine();
   
   System.out.println("\nAccount Created Successfully!");
   
   PrintData();
}

//#login
public static void login(){

   System.out.println("\nWelcome to Project Phase One");
   Scanner scan = new Scanner(System.in);
   System.out.print("\nPlease enter your email>>> ");
   email = scan.next();
   System.out.print("\nPlease enter your password>>> ");
   password = scan.next();
   
   if(data == data){
       System.out.println("\nLog In Successful");
       System.out.println("\nYour credentials: " + data);
   }else{
     System.out.println("\nInvalid email and password");
    }
    
 }
 
//#UpdateProfile
public static void updateProfile(){

   System.out.println("\nYou've selected to Update your Profile");
   Scanner scan = new Scanner(System.in);
   System.out.print("\nPlease enter your email>>> ");
   email = scan.next();
   System.out.print("\nYour first name>>> ");
   firstName = scan.next();
   System.out.print("\nYour last name>>> ");
   lastName = scan.next();
   System.out.print("\nYour year group>>> ");
   yearGroup = scan.next();
   System.out.print("\nYour current GPA>>> ");
   gPa = scan.next();
   System.out.print("\nYour Date of Birth (type in figures, eg. 01/12/2002) >>> ");
   DoB = scan.next();
   
   System.out.println("\nProfile Updated Successfully!");
   
   viewProfile();
}

//#viewProfile
public static void viewProfile(){
   
   credentials = new ArrayList<>();
   credentials.add(firstName);
   credentials.add(lastName);
   credentials.add(yearGroup);
   credentials.add(gPa);
   credentials.add(DoB);
   
   System.out.println("\nHere are your updated credentials: "); 
   System.out.println("\nCheck to see if they are accurate");
   System.out.println("\nYour First name: " + firstName);
   System.out.println("\nYour Last name: " + lastName);
   System.out.println("\nYour Year group: " + yearGroup);
   System.out.println("\nYour current GPA: " + gPa);
   System.out.println("\nYour date of Birth: " + DoB);

}

//#IsAdmin
public static boolean isAdmin(){

   System.out.println("\nWelcome to Project Phase One");
   Scanner scan = new Scanner(System.in);
   System.out.print("\nPlease enter your email>>> ");
   email = scan.next();
   
   if(email == email) {
      System.out.println(email.contains("aucampus.onmicrosoft.com"));
           }
   else{
      System.out.println("Non-existent");
      }
    return false;
   }
   
 
//#makeFaculty
public static void makeFaculty(){

   Scanner scan = new Scanner(System.in);
   System.out.print("\nPlease register with your email>>> ");
   email = scan.next();

   System.out.print("\nCONGRATULATIONS, You have been given the ROLE of FACULTY");

}

public static boolean isFaculty(){

   Scanner scan = new Scanner(System.in);
   System.out.print("\nPlease register with your email>>> ");
   email = scan.next();
   
   if(true){
   System.out.print("\nThis mail : " + email + " is now a Faculty Member");
   }
   return false;
  }

//#createCourse
public static void createCourse() {

   Scanner scan = new Scanner(System.in);
   System.out.print("\nYou have selected the course creation.");
   System.out.print("\n\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the name of the course you want to create >>> ");
   course = scan.next();
   System.out.print("\nPlease enter the course code>>> ");
   courseCode = scan.next();
   
   System.out.print("\nCourse created successfully");
   }

//#viewCourses
public static void viewCourses() {

   System.out.println("\nCourse code: ");
   System.out.println("\nCourse: ");
   System.out.println("\nEmail Registered: ");
   System.out.println("\nCourse Creator: ");

}

//#registerCourse
public static void registerCourse() {

   System.out.print("\n\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the Course Code >>> ");
   courseCode = scan.next();
   
   System.out.println("\nYou have been successfully registered to the course.");
   
}

//#viewCourseByCode
public static void viewCourseByCode() {
   
   System.out.print("\nPlease enter the Course Code >>> ");
   courseCode = scan.next();
   
   System.out.println("\nCode input successfull");
   System.out.println("\nCourse code: " + courseCode);
   System.out.println("\nCourse: ");
   System.out.println("\nEmail(s) Registered: ");
   System.out.println("\nNames of users: ");
}
   
//#viewCoursesByEmail
public static void viewCoursesByEmail() {

   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   
   System.out.println("\nYou are registered for these courses : ");
   System.out.println("Course codes, Course Names:  ");
}


//#addAssignment
public static void addAssignment() {
   
   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the course code>>> ");
   courseCode = scan.next();
   System.out.print("\nRequesting for the name of your assignment>>> ");
   assignmentName = scan.next();
   System.out.print("\nA brief description about it>>> ");
   assignmentDescription = scan.next();
   System.out.print("\nRequesting for the due date?>>> ");
   DueDate = scan.next();
   System.out.print("\nType of assignment (Either QUIZ, HOMEWORK, PROJECT, or EXAM) ? >>> ");
   TypeOfAssignment = scan.next();
   System.out.println("\n\nAssignment Created. Added Successfully to the course.");
}

//#viewAssignmentsByCourse
public static void viewAssignmentsByCourse() {

   System.out.print("\nPlease enter the course code>>> ");
   courseCode = scan.next();
   
   System.out.println("\nCode Input Successful");
   System.out.println("\n Assignments created : ");
}

//#viewAssignmentByEmail
public static void viewAssignmentByEmail() {
   
   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   
   System.out.println("Email input successful. Here are your assignments : ");
   
}

//#submitAssignment
public static void submitAssignment() {
   
   String assName;
   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the course code>>> ");
   courseCode = scan.next();
   System.out.print("\nPlease enter the assignemt Name >>> ");
   assName = scan.next();   
   System.out.print("\nAre you sure you want to submit your assignment? YES or NO>>> ");
   userResponse = scan.next();
   
   if(userResponse == "YES"){
      System.out.println("\nAssignment Submitted Successfully");
   } else{
      System.out.println("\nInvalid statement.");
      }
   
   }

//#viewSubmissions
public static void viewSubmissions() {
   
   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the course code>>> ");
   courseCode = scan.next();
   System.out.print("\nPlease enter the assignemt Name >>> ");
   assignmentName = scan.next();
   
   System.out.println("Displaying all current submissions : ");
}

//#scoreAssignment
public static void scoreAssignment() {

   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the course code>>> ");
   courseCode = scan.next();
   System.out.print("\nPlease enter the assignemt Name >>> ");
   assignmentName = scan.next();
   System.out.print("\nSubmitters' email >>> ");
   submitterEmail = scan.next();
   System.out.print("\nThe score of the student out of 100>>> ");
   score = scan.next();
   
   System.out.println("Updated Successfully");
}

//#viewAssignmentScore
public static void viewAssignmentScore() {

   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the course code>>> ");
   courseCode = scan.next();
   System.out.print("\nPlease enter the assignemt Name >>> ");
   assignmentName = scan.next();

   System.out.println("Your results are shown here : ");
}

//#viewAssingmentScores
public static void viewAssignmentScores() {

   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the course code>>> ");
   courseCode = scan.next();
   System.out.print("\nPlease enter the assignemt Name >>> ");
   assignmentName = scan.next();
   
   System.out.println("The results of all students are shown here : ");
 }

//viewAllAssignmentScores
public static void viewAllAssignmentScores() {

   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the course code>>> ");
   courseCode = scan.next();
   
   System.out.println("\nAll Assignments and Scores are shown below: ");
   }  
   
//#viewAssignmentGrade
public static void viewAssignmentGrade() {

   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the course code>>> ");
   courseCode = scan.next();
   System.out.print("\nPlease enter the assignemt Name >>> ");
   assignmentName = scan.next();
   
   System.out.println("Your Score: ");
   System.out.println("Your Grade: ");

}

//#viewAssignmentGrades
public static void viewAssignmentGrades() {

   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the course code>>> ");
   courseCode = scan.next();
   System.out.print("\nPlease enter the assignemt Name >>> ");
   assignmentName = scan.next();
   
   System.out.println("Scores for all Students are shown below: ");
}

//#viewAllAssignmentScores
public static void TheviewAllAssignmentScores() {

   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the course code>>> ");
   courseCode = scan.next();
   System.out.print("\nPlease enter the assignemt Name >>> ");
   assignmentName = scan.next();
   
   System.out.println("Scores for all Students, including their grades are shown below: ");
}

//#setNotificationPreferences
public static void setNotificationPreferences() {

   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   
   if(email == email) {
      System.out.println("An email notification would be sent to you.");
   } else{
      System.out.println("Email unidentified");
      }
}


//main function

public static void main(String[]args){
     
    //createAccount();
    //login();
    //updateProfile();
    //isAdmin();
    //makeFaculty();
    //isFaculty();
    //createCourse();
    //registerCourse();
    //addAssignment();
    //submitAssignment();
   }

 }
