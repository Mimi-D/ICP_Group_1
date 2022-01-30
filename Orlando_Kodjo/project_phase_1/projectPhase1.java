import java.util.Scanner; //Importing Scanner class to be able to receive user input 
import java.util.ArrayList;


public class projectPhase1{
    public static void main(String [] args){
        System.out.println("Code so far working!");
        System.out.println("Profile successfully Updated\nFirst Name: "+"Orlando"+" Last Name: "+"Kodjo"+"\nGPA: "+"4.0"+"  Date of Birth: "+"birthDate"+"  Year Group: "+"yearGroup");
    }


    public class userCanvas{
        ArrayList <String> existingEmails = new ArrayList<String>();
        ArrayList <String> existingPasswords = new ArrayList<String>();
        ArrayList <String> userGPA= new ArrayList<String>();
        ArrayList <String> userFirstName = new ArrayList<String>();
        ArrayList <String> userLastName = new ArrayList<String>();
        ArrayList <String> userYearGroup = new ArrayList<String>();
        ArrayList <String> userDateOfBirth = new ArrayList<String>();
        ArrayList <String> adminAccounts = new ArrayList<String>();
        ArrayList <String> faculty=new ArrayList<String>();
        ArrayList <String> courseName = new ArrayList<String>();
        ArrayList <String> courseCode = new ArrayList<String>();

        public void createAccount(){
        
            Scanner userEm = new Scanner(System.in);
            System.out.println("Enter User Email: "); 
            String userEmail = userEm.nextLine();
            userEm.close();
            existingEmails.add(userEmail);


            Scanner passw = new Scanner(System.in);
            System.out.println("Enter preferred password: ");
            String password = passw.nextLine();
            passw.close();
            existingPasswords.add(password);

            System.out.println("Account created Successfully\n");
        }

        public boolean login(String retUserEmail,String retUserPassword){
            //Scanner retUserEm = new Scanner(System.in);
            //System.out.println("Enter User Email: ");
            //String retUserEmail= retUserEm.nextLine();
            //retUserEm.close();
            

            //Scanner retpassw = new Scanner(System.in);
            //System.out.println("Enter User Password: ");
            //String retUserPassword = retpassw.nextLine();
            //retpassw.close();
            

            //create a way to cross check the validity of the email and password typed
            if (existingEmails.contains(retUserEmail)&&existingPasswords.contains(retUserPassword)){
                if(existingPasswords.indexOf(retUserPassword)==existingEmails.indexOf(retUserEmail)){
                    return true;
                }
                else{
                    return false;
                }
            }
            return false;
        }

        public void updateProfile(){
            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            retpassw.close();

            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail= retUserEm.nextLine();
            retUserEm.close();

            if (login(retUserEmail,retUserPassword)){
                Scanner enteredFirstName = new Scanner(System.in);
                System.out.println("Enter User's First Name: ");
                String firstName = enteredFirstName.nextLine();
                enteredFirstName.close();

                Scanner enteredLastName = new Scanner(System.in);
                System.out.println("Enter User's Last Name: ");
                String lastName = enteredLastName.nextLine();
                enteredLastName.close();

                Scanner enteredGPA = new Scanner(System.in);
                System.out.println("Enter User's GPA: ");
                String GPA = enteredGPA.nextLine();
                enteredGPA.close();

                Scanner enteredBirthDate = new Scanner(System.in);
                System.out.println("Enter User's Birth Date: ");
                String birthDate = enteredBirthDate.nextLine();
                enteredBirthDate.close();

                Scanner enteredYearGroup = new Scanner(System.in);
                System.out.println("Enter User's Year group: ");
                String yearGroup = enteredYearGroup.nextLine();
                enteredYearGroup.close();

                System.out.println("Profile successfully Updated\nFirst Name: "+firstName+" Last Name: "+lastName+"/n GPA: "+GPA+"  Date of Birth: "+birthDate+"  Year Group: "+yearGroup);
            } else{
                System.out.println("Login is required!");
            }
            
        }

        public void viewProfile(){
            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            retpassw.close();

            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail= retUserEm.nextLine();
            retUserEm.close();
            if(login(retUserEmail, retUserPassword)){
                int i = existingEmails.indexOf(retUserEmail);

                if(userFirstName.get(i)== null){
                    System.out.println("User's First Name: NA");
                }else{System.out.println("User's First Name: "+userFirstName.get(i));}

                if(userLastName.get(i)==null){
                    System.out.println("User's Last Name: NA");
                }else{System.out.println(" Last Name: "+userLastName.get(i));}

                if(userGPA.get(i)==null){
                    System.out.println("User's GPA: NA");
                }else{System.out.println("User's"+" GPA: "+userGPA.get(i));}
                
                if(userDateOfBirth.get(i)==null){
                    System.out.println("User's Date of Birth: NA");
                }else{System.out.println("User's"+" Date of Birth: "+userDateOfBirth.get(i));}

                if(userYearGroup.get(i)==null){
                    System.out.println("User's Year Group: NA");
                }else{System.out.println("User's"+" Year Group: "+userYearGroup.get(i));}
                
            }else{
                System.out.println("Login is required!");
            }
        }

        public boolean isAdmin(String retUserEmail){
            //Scanner retUserEm = new Scanner(System.in);
            //System.out.println("Enter existing User Email: ");
           // String retUserEmail= retUserEm.nextLine();
            //retUserEm.close();

            if(adminAccounts.contains(retUserEmail)){
                return true;
            }
            return false;
        }

        public void makeFaculty(){
            
            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            retpassw.close();

            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail= retUserEm.nextLine();
            retUserEm.close();

            Scanner faculttobe = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String facultyToBe= faculttobe.nextLine();
            faculttobe.close();
            
            if(login(retUserEmail,retUserPassword)){
                if(isAdmin(retUserEmail)){
                    faculty.add(facultyToBe);
                }
            }
        }

        public boolean isFaculty(String UserEmail){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String userInQuestion = retUserEm.nextLine();
            retUserEm.close();
            if(faculty.contains(userInQuestion)){
                return true;
            }
            return false;
        }
        
        public void createCourse(){
            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            retpassw.close();

            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail= retUserEm.nextLine();
            retUserEm.close();


            if(login(retUserEmail,retUserPassword)){
                if(isFaculty(retUserEmail)){
                    Scanner courseScanner = new Scanner(System.in);
                    System.out.println("Enter User Password: ");
                    String courseName= courseScanner.nextLine();
                    courseScanner.close();

                    this.courseName.add(courseName);
        
                    Scanner courseCodeScanner = new Scanner(System.in);
                    System.out.println("Enter User Email: ");
                    String courseCode= courseCodeScanner.nextLine();
                    courseCodeScanner.close();   

                    this.courseCode.add(courseCode);
                    System.out.println("Course successfully created!");
                }
            }

        }




    }
}