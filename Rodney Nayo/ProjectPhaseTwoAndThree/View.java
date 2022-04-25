//INHERITANCE

import java.util.*;

//BASE CLASS OR PARENT 
class View {
   
   //MESSAGE TO TELL USER AND SYSTEM DATA
   public static void message(){
   
   System.out.println("\nCredentials viewed Successfully. Updated on Storage System");
   }
   
}

//SUBCLASS OR CHILD
class updateAndProfileView extends View {

   private static ArrayList<String> credentials;
   private static String email, checkEmail, password, firstName, lastName, yearGroup, gPa, DoB, course, courseCreator, courseCode, courseCreatorCode, assignmentName, assignmentDescription, TypeOfAssignment, DueDate, userResponse, response2, SystemResponse, submitterEmail, score;
   
   //UPDATING PROFILE
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

   //VIEWING THE PROFILE
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


}