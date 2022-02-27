//ENCAPSULATION

import java.util.*;
class CreateAccount {
  
   //PRIVATE VARIABLES
   private String email, password;
 
   Scanner userinput = new Scanner(System.in);
   
   //SETTERS
   public void setEmail(String email) {
      this.email = email;
      }
    
   public void setPassword(String password) {
      this.password = password;
      }
   
   //GETTERS
   public String getEmail() {
      return this.email;
      }
   
   public String getPassword() {
      return this.password;
      }
   
   //TAKING INPUT FROM EMAIL
   public String takeEmailInput() {
      
      System.out.println("\nWelcome to Project Phase One");
      System.out.print("\nEnter your new email >>> ");
      String inputEmail = userinput.next();
      return inputEmail;
   }
   
   //TAKING INPUT FROM PASSWORD
   public String takePasswordInput() {
      System.out.print("\nEnter your password >>> ");
      String inputPassword = userinput.next();
      return inputPassword;
      }
       
    
    }
 