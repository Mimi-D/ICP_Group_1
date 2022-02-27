import java.util.ArrayList;
import java.util.Scanner;

public class canvasUser {
    private String firstName = "NA";
    private String lastName= "NA";
    private String dateOfBirth= "NA";
    private String GPA= "NA";
    private String yearGroup= "NA";
    private String email= "NA";
    private String passWord= "NA";
    private String emailPreferencesforAssignment= "NA";
    private String emailPreferenceforsubmission= "NA";
    private String emailPreferenceCourseReg= "NA";
    ArrayList <canvasCourses> canvasCourses = new ArrayList<>();
    
    public canvasUser(){}

    public canvasUser(String Email){
        email = Email;
    }

    public canvasUser(String Email, String PassWord){
        email = Email;
        passWord = PassWord;
    }

    public canvasUser(String fName,String Lname,String DoBirth, String gpa, String yeargroup){
        firstName = fName;
        lastName = Lname;
        dateOfBirth = DoBirth;
        GPA = gpa;
        yearGroup = yeargroup;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getDateofBirth(){
        return dateOfBirth;
    }

    public String getGPA(){
        return GPA;
    }

    public String getYearGroup(){
        return yearGroup;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return passWord;
    }

    public void setFirstName(String fName){
        firstName = fName;
    }

    public void setLastName(String LName){
        lastName = LName;
    }

    public void setDateofBirth(String DBirth){
        dateOfBirth = DBirth;
    }

    public void setYearGroup(String YGroup){
        yearGroup = YGroup;
    }

    public void setGPA(String UGPA){
        GPA = UGPA;
    }

    public void setEmail(String Email){
        email = Email;
    }

    public void setPassword(String PassWord){
        passWord=PassWord;
    }

    public void setEmailPreferencesforAssignment(String pref){
        emailPreferencesforAssignment=pref;
    }

    public void setEmailPreferencesforSubmissions(String pref){
        emailPreferenceforsubmission=pref;
    }

    public void setEmailPreferencesforCourseReg(String pref){
        emailPreferenceCourseReg=pref;
    }

    public void addUserCourse(canvasCourses course){
        canvasCourses.add(course);
    }

    public String toString(){
        
        String retVal="First Name: "+firstName+"\n"+"Last Name: "+lastName+"\n"+"Date of Birth: "+dateOfBirth+"\n"+"GPA: "+GPA+"\n"+"User's Year Group: "+yearGroup;
        return retVal;
    }

    public void updateProfile(){
        System.out.println("--update Profile--");
        
            Scanner enteredFirstName = new Scanner(System.in);
                System.out.println("Enter User's First Name: ");
                String firstNameString = enteredFirstName.nextLine();
                setFirstName(firstNameString);
            
                Scanner enteredLastName = new Scanner(System.in);
                System.out.println("Enter User's Last Name: ");
                String lastNameString = enteredLastName.nextLine();
                setLastName(lastNameString);
                
                Scanner enteredGPA = new Scanner(System.in);
                System.out.println("Enter User's GPA: ");
                String GPAString = enteredGPA.nextLine();
                setGPA(GPAString);

                Scanner enteredBirthDate = new Scanner(System.in);
                System.out.println("Enter User's Birth Date format:(21/06/1968): ");
                String birthDateString = enteredBirthDate.nextLine();
                setDateofBirth(birthDateString);
               
                Scanner enteredYearGroup = new Scanner(System.in);
                System.out.println("Enter User's Year group: ");
                String yearGroupString = enteredYearGroup.nextLine();
                setYearGroup(yearGroupString);

                System.out.println("Profile successfully Updated\nFirst Name: " + firstName + " Last Name: " + lastName
                        + "\nGPA: " + GPA + "  Date of Birth: " + dateOfBirth + "  Year Group: " + yearGroup);
        
    }

    public void viewProfile(){
        System.out.println("First Name: "+firstName);
        System.out.println("Last Name: "+ lastName);
        System.out.println("date of birth: "+dateOfBirth);
        System.out.println("GPA: "+GPA);
        System.out.println("year group: "+yearGroup);
    }

    public void viewCourses(){
        System.out.println("--- Courses taken by "+firstName+" ---"); 
        System.out.println(canvasCourses);
    }


    public void setNotfificationPreferences(){
        Scanner notifEmScanner= new Scanner(System.in);
        System.out.println("Enter whether User will like to receive email Notifications when an assignment for a registered course is posted(Yes/No): ");
        String notifEmString ="Email preference for assignment post: "+notifEmScanner.nextLine();
        setEmailPreferencesforAssignment(notifEmString);
                
        Scanner notifSubScanner = new Scanner(System.in);
        System.out.println("Enter User will like to receive email notification when an assignment is submitted(Yes/No): ");
        String notifSubEmail = "Email Preference for assignment submission: "+notifSubScanner.nextLine();
        setEmailPreferencesforSubmissions(notifSubEmail);
                
        Scanner notifRegScanner = new Scanner(System.in);
        System.out.println("Enter User will like to receive email notification when user registers for a course(Yes/No): ");
        String notifRegEmail = "Email preference for course Registration: "+notifRegScanner.nextLine();
        setEmailPreferencesforCourseReg(notifRegEmail);
        
        System.out.println("Notification Preferences successfully updated!");
        System.out.println(emailPreferencesforAssignment);
        System.out.println(emailPreferenceforsubmission);
        System.out.println(emailPreferenceCourseReg);
    }

    public boolean isFaculty(canvasUser user){
        if(projectPhase1.facultyobj.contains(user)){
            System.out.println("User is faculty!");
            return true;
        }
        System.out.println("User is not faculty");
        return false;
    }

    public boolean isAdmin(canvasUser user){
        if(user instanceof canvasAdmin){
            System.out.println("User is an Admin");
            return true;
        }
        System.out.println("User is not an Admin");
        return false; 
    }
}
