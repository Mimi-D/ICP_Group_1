import java.util.*;
//BASE CLASS
class Login{
   
   //GLOBAL VARIABLES
   private static Scanner scan = new Scanner(System.in);

   static String email, checkEmail, password, firstName, 
   lastName, yearGroup, gPa, DoB, course, courseCreator, courseCode, 
   courseCreatorCode, assignmentName, assignmentDescription, 
   TypeOfAssignment, DueDate, userResponse, response2, SystemResponse, 
   submitterEmail, score;
   
   static int roleCode;
   private static ArrayList<String> data;
   private static ArrayList<String> credentials;
   
   //#LOGIN METHOD
   public void login() {
   
   System.out.println("\nWelcome to Project Phase One");
   Scanner scan = new Scanner(System.in);
   System.out.print("\nPlease enter your email>>> ");
   email = scan.next();
   System.out.print("\nPlease enter your password>>> ");
   password = scan.next();
   
   }
 
}
   
//POLYMORPHISM

//SUB-POLY CLASS

//#makeFaculty
class MakeFaculty extends Login{
   
   //#LOGIN METHOD
   public void login(){

   Scanner scan = new Scanner(System.in);
   System.out.print("\nPlease register with your email>>> ");
   email = scan.next();
   
   //EXCEPTIONS WITH THE TRY AND CATCH METHOD
    try{
      System.out.print("\nEnter the Faculty Role Code>>> ");
      roleCode = scan.nextInt();
   }catch(Exception e) {
   
    System.out.println("\nSorry there was an error, please try again");
    System.out.println("Enter the 3 digit numbers attached to your note-letter.");
    
   }
   
   if(email.contains("aucampus.onmicrosoft.com")) {
      System.out.println("\nRegistered Successfully");
      System.out.print("\nYou have been given the ROLE of FACULTY");
           }
   else{
      System.out.println("\nYour email seems to be Non-existent. Please try again");
      }
   
   
}
   }

