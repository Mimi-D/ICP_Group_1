import java.util.*;

class ProjectPhaseOne {

//#global variables
private static String email, password, firstName, lastName, yearGroup, gPa, DoB;
   
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


//main function
public static void main(String[]args){
     
    //createAccount();
    //login();
    updateProfile();
   }

 }
