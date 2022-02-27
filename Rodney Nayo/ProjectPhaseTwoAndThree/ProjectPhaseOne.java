import java.util.*;

//AN OUTLINE OR BLUEPRINT OF THE COURSE CREATION
interface projectPhaseOneInterface {

    void createCourse();
    void registerCourse();
    void addAssignment();
    void submitAssignment();
    void scoreAssignment();
    void setNotificationPreferences();
    
   }

class ProjectPhaseOne implements projectPhaseOneInterface {


//#global variables
private static Scanner scan = new Scanner(System.in);

private static String email, checkEmail, password, firstName, lastName, yearGroup, gPa, DoB, course, courseCreator, courseCode, courseCreatorCode, assignmentName, assignmentDescription, TypeOfAssignment, DueDate, userResponse, response2, SystemResponse, submitterEmail, score;
   
private static ArrayList<String> data;

private static ArrayList<String> credentials;

private static ArrayList<String> datainBase;

private static ArrayList<String> datainBase2;

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
   
   System.out.print("\nDo you want to view your updated profile? >>> ");
   response2 = scan.next();
   
   SystemResponse = "YES";
   
   if(response2.equals(SystemResponse)){
      System.out.println("\nLogin is required");
      System.out.print("\nPlease enter your email>>> ");
      email = scan.next();
      System.out.print("\nPlease enter your password>>> ");
      password = scan.next();
      
      System.out.println("\nLogin Successful!");
      viewProfile();
      } else {
         System.out.println("\nInvalid response");
         }
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

//#isFaculty
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
@Override
public void createCourse() {

   Scanner scan = new Scanner(System.in);
   System.out.print("\nYou have selected the course creation.");
   System.out.print("\n\nUse three dashes to space out for different people for easy recognition.");
   System.out.print("\n\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the name of the course you want to create >>> ");
   course = scan.next();
   System.out.print("\nName of Course Creator >>> ");
   courseCreator = scan.next();
   System.out.print("\nPlease enter the course code >>> ");
   courseCode = scan.next();
   
   System.out.print("\nDo you want to view the course outline? >>> ");
   response2 = scan.next();
   
   SystemResponse = "YES";
   
   if(response2.equals(SystemResponse)){
      System.out.println("\nLogin is required");
      System.out.print("\nPlease enter your email>>> ");
      checkEmail = scan.next();  
      System.out.print("\nPlease enter your password>>> ");
      password = scan.next();
      
      if(checkEmail.contains("aucampus.onmicrosoft.com")) {
         System.out.println("\nWelcome Admin");
         viewCourses();
         }else{
         System.out.println("\nUser not Faculty or Admin. Please try again.");
      }
   }
   
 }

//#viewCourses
public static void viewCourses() {
   
   datainBase = new ArrayList<>();
   datainBase.add(email);
   datainBase.add(courseCode);
   datainBase.add(course);
   datainBase.add(courseCreator);
   
   System.out.println("\n Here are your courses you have been registered with: ");
   
   System.out.println("\nCourse code(s): " + courseCode);
   System.out.println("\nCourse(s): " + course);
   System.out.println("\nEmail(s) Registered: " + email);
   System.out.println("\nCourse Creator(s): " +  courseCreator);

}

//#registerCourse
@Override
public void registerCourse() {
   
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
@Override
public void addAssignment() {
   
   System.out.println("\nYou have selected to add an assignment.");
   System.out.print("\nUse three dashes to space out for different people for easy recognition.");
   System.out.print("\n\nPlease enter your email >>> ");
   email = scan.next();
   System.out.print("\nPlease enter the course code(s)>>> ");
   courseCode = scan.next();
   System.out.print("\nRequesting for the name of your assignment(s)>>> ");
   assignmentName = scan.next();
   System.out.print("\nA brief description about it>>> ");
   assignmentDescription = scan.next();
   System.out.print("\nRequesting for the due date?>>> ");
   DueDate = scan.next();
   System.out.print("\nType of assignment (Either QUIZ, HOMEWORK, PROJECT, or EXAM) ? >>> ");
   TypeOfAssignment = scan.next();
   System.out.println("\n\nAssignment Created.");
   
   System.out.print("\nDo you want to view the assignments before it gets added to the canvas? >>> ");
   response2 = scan.next();
   
   SystemResponse = "YES";
   
   if(response2.equals(SystemResponse)){
      System.out.println("\nLogin is required");
      System.out.print("\nPlease enter your email>>> ");
      checkEmail = scan.next();  
      System.out.print("\nPlease enter your password>>> ");
      password = scan.next();
      
      if(checkEmail.contains("aucampus.onmicrosoft.com")) {
         System.out.println("\nWelcome Admin");
         System.out.print("\nBefore access --- Register in Course Creator Code>>> ");
         courseCreatorCode = scan.next();
            if(courseCreatorCode.contains("ASH222")){
               System.out.println("\nAccess granted");
               viewAssignmentsByCourse();
               }else{ System.out.println("Invalid Code. User not Course Creator. Please try again.");}
         }else{
         System.out.println("\nUser not Faculty or Admin. Please try again.");
      }
   }

}

//#viewAssignmentsByCourse
public static void viewAssignmentsByCourse() {

   datainBase2 = new ArrayList<>();
   datainBase2.add(email);
   datainBase2.add(courseCode);
   datainBase2.add(assignmentName);
   datainBase2.add(assignmentDescription);
   datainBase2.add(DueDate);
   datainBase2.add(TypeOfAssignment);
   
   
   System.out.print("\n\nPlease enter the course code>>> ");
   courseCode = scan.next();
   
   System.out.println("\n\nAssignment Updated Successfully.");
  
   System.out.println("\nCourse code: " + courseCode);
   System.out.println("\nThe assignment name: " + assignmentName);
   System.out.println("\nThe assignment Description: " + assignmentDescription);
   System.out.println("\nDue Date: " + DueDate); 
   System.out.println("\nType of Assignment: " + TypeOfAssignment);  
}

//#viewAssignmentByEmail
public static void viewAssignmentByEmail() {
   
   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   
   System.out.println("Email input successful. Here are your assignments : ");
   
}

//#submitAssignment
@Override
public void submitAssignment() {
   
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
@Override
public void scoreAssignment() {

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
@Override
public void setNotificationPreferences() {

   System.out.print("\nPlease enter your email >>> ");
   email = scan.next();
   
   if(email == email) {
      System.out.println("An email notification would be sent to you.");
   } else{
      System.out.println("Email unidentified");
      }
}


 }
