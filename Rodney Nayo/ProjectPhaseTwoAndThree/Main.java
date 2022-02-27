//CLASSES

//The Main method Class
class Main {
     
   //The main method itself
   public static void main(String[]args){
   
    ProjectPhaseOne Run = new ProjectPhaseOne();
    Run.registerCourse();
   
    updateAndProfileView sight = new updateAndProfileView();
    sight.updateProfile();
    sight.message();
   
    MakeFaculty activate = new MakeFaculty();
    activate.login();
   
   
    CreateAccount collect = new CreateAccount();
   
   String emailInput = collect.takeEmailInput();
   collect.setEmail(emailInput);
   String passwordInput = collect.takePasswordInput();
   collect.setPassword(passwordInput);
   
   System.out.println("\nAccount Created Successfully!");
   System.out.print("\nYour credentials: ");
   System.out.print( "[" + emailInput + "]" );
   System.out.print( "[" + passwordInput + "]");
       
      }

}