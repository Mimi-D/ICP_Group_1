import java.util.Scanner; //Importing Scanner class to be able to receive user input 
import java.util.ArrayList;
import java.util.*;

public class projectPhase1 {
    public static void main(String[] args) {
        //System.out.println("Code so far working!");
        //System.out.println("Profile successfully Updated!\nFirst Name: " + "Orlando" + " Last Name: " + "Kodjo"
                //+ "\nGPA: " + "4.0" + "  Date of Birth: " + "birthDate" + "  Year Group: " + "yearGroup");

        projectPhase1 cls = new projectPhase1();
        cls.createAccount();
        cls.login();
        cls.updateProfile();
        cls.viewProfile();
        cls.isAdmin();
        cls.makeFaculty();
        cls.isFaculty();
        cls.createCourse();
        cls.viewCourses();
        cls.viewCourseByCode();
        cls.viewAssignmentsByEmail();
        cls.addAssignment();
        cls.viewAssignmentsByCourse();
        cls.viewAssignmentsByEmail();
        cls.submitAssignment();
        cls.viewSubmissions();
        cls.scoreAssignment();
    }

        ArrayList<String> existingEmails = new ArrayList<String>();
        ArrayList<String> existingPasswords = new ArrayList<String>();
        ArrayList<String> userGPA = new ArrayList<String>();
        ArrayList<String> userFirstName = new ArrayList<String>();
        ArrayList<String> userLastName = new ArrayList<String>();
        ArrayList<String> userYearGroup = new ArrayList<String>();
        ArrayList<String> userDateOfBirth = new ArrayList<String>();
        ArrayList<String> adminAccounts = new ArrayList<String>();{adminAccounts.add("patrick.awuah@ashesi.edu.gh");}
        ArrayList<String> faculty = new ArrayList<String>();
        ArrayList<String> courseName = new ArrayList<String>();
        ArrayList<String> courseCode = new ArrayList<String>();
        ArrayList<String> courseCreator = new ArrayList<String>();
        ArrayList<List<String>> ListofMembers = new ArrayList<>();
        ArrayList <String> members = new ArrayList<>();
        ArrayList <String> assignmentName = new ArrayList<String>();
        ArrayList <List<String>> listOfAssignments = new ArrayList<>();
        ArrayList <String> dueDate = new ArrayList<String>();
        ArrayList <String> assignmentType = new ArrayList<String>();
        ArrayList <String> description = new ArrayList<String>();
        ArrayList <List<String>> listofSubmissions = new ArrayList<>();
        ArrayList <String> singleSubmissions = new ArrayList <String>();


        
        

        public void createAccount() {

            Scanner userEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String userEmail = userEm.nextLine();
            existingEmails.add(userEmail);

            Scanner passw = new Scanner(System.in);
            System.out.println("Enter preferred password: ");
            String password = passw.nextLine();
            
            existingPasswords.add(password);

            System.out.println("Account created Successfully!");
            //userEm.close();
            //passw.close();
        }

        public boolean login(String retUserEmail, String retUserPassword) {
            
            // create a way to cross check the validity of the email and password typed
            if (existingEmails.contains(retUserEmail) && existingPasswords.contains(retUserPassword)) {
                if (existingPasswords.indexOf(retUserPassword) == existingEmails.indexOf(retUserEmail)) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        public boolean login() {
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail= retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            
            
            // create a way to cross check the validity of the email and password typed
            if (existingEmails.contains(retUserEmail) && existingPasswords.contains(retUserPassword)) {
                if (existingPasswords.indexOf(retUserPassword) == existingEmails.indexOf(retUserEmail)) {
                    System.out.println("Login successful!");
                    return true;
                } else {
                    System.out.println("Login failed!");
                    return false; 
                }
            }
            System.out.println("Login failed!");
            return false;
        }

        public void updateProfile() {
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            
            if (login(retUserEmail, retUserPassword)) {
                Scanner enteredFirstName = new Scanner(System.in);
                System.out.println("Enter User's First Name: ");
                String firstName = enteredFirstName.nextLine();
                
                userFirstName.add(existingEmails.indexOf(retUserEmail),firstName);

                Scanner enteredLastName = new Scanner(System.in);
                System.out.println("Enter User's Last Name: ");
                String lastName = enteredLastName.nextLine();
                
                userLastName.add(existingEmails.indexOf(retUserEmail),lastName);

                Scanner enteredGPA = new Scanner(System.in);
                System.out.println("Enter User's GPA: ");
                String GPA = enteredGPA.nextLine();
                
                userGPA.add(existingEmails.indexOf(retUserEmail),GPA);

                Scanner enteredBirthDate = new Scanner(System.in);
                System.out.println("Enter User's Birth Date format:(21/06/1968): ");
                String birthDate = enteredBirthDate.nextLine();
                
                userDateOfBirth.add(existingEmails.indexOf(retUserEmail),birthDate);

                Scanner enteredYearGroup = new Scanner(System.in);
                System.out.println("Enter User's Year group: ");
                String yearGroup = enteredYearGroup.nextLine();
                
                userYearGroup.add(existingEmails.indexOf(retUserEmail),yearGroup);

                System.out.println("Profile successfully Updated\nFirst Name: " + firstName + " Last Name: " + lastName
                        + "\nGPA: " + GPA + "  Date of Birth: " + birthDate + "  Year Group: " + yearGroup);
            } else {
                System.out.println("Login is required!");
            }

        }

        public void viewProfile() {
            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            
            if (login(retUserEmail, retUserPassword)) {
                int i = existingEmails.indexOf(retUserEmail);

                if (userFirstName.get(i) == null) {
                    System.out.println("User's First Name: NA");
                } else {
                    System.out.println("User's First Name: " + userFirstName.get(i));
                }

                if (userLastName.get(i) == null) {
                    System.out.println("User's Last Name: NA");
                } else {
                    System.out.println("Last Name: " + userLastName.get(i));
                }

                if (userGPA.get(i) == null) {
                    System.out.println("User's GPA: NA");
                } else {
                    System.out.println("User's" + " GPA: " + userGPA.get(i));
                }

                if (userDateOfBirth.get(i) == null) {
                    System.out.println("User's Date of Birth: NA");
                } else {
                    System.out.println("User's" + " Date of Birth: " + userDateOfBirth.get(i));
                }

                if (userYearGroup.get(i) == null) {
                    System.out.println("User's Year Group: NA");
                } else {
                    System.out.println("User's" + " Year Group: " + userYearGroup.get(i));
                }

            } else {
                System.out.println("Login is required!");
            }
        }

        public boolean isAdmin(String retUserEmail) {
            // Scanner retUserEm = new Scanner(System.in);
            // System.out.println("Enter existing User Email: ");
            // String retUserEmail= retUserEm.nextLine();
            // retUserEm.close();

            if (adminAccounts.contains(retUserEmail)) {
                return true;
            }
            return false;
        }

        public boolean isAdmin() {
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter existing User Email: ");
            String retUserEmail= retUserEm.nextLine();
            

            if (adminAccounts.contains(retUserEmail)) {
                System.out.println("User is an Administrator");
                return true;
            }
            System.out.println("User is not an Administrator");
            return false;
        }

        public void makeFaculty() {
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            
            
            if (login(retUserEmail, retUserPassword)) {
                if (isAdmin(retUserEmail)) {
                    Scanner faculttobe = new Scanner(System.in);
                    System.out.println("Enter User Email to be made Faculty: ");
                    String facultyToBe = faculttobe.nextLine();

                    faculty.add(facultyToBe);
                    System.out.println("Faculty successfully added!");
                }
            }
        }

        public boolean isFaculty(String UserEmail) {
           
            if (faculty.contains(UserEmail)) {
                return true;
            }
            return false;
        }

        public boolean isFaculty( ) {
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String userInQuestion = retUserEm.nextLine();
            
            if (faculty.contains(userInQuestion)) {
                return true;
            }
            return false;
        }


        public void createCourse() {
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
           

            if (login(retUserEmail, retUserPassword)) {
                if (isFaculty(retUserEmail)) {
                    courseCreator.add(retUserEmail);
                    Scanner courseScanner = new Scanner(System.in);
                    System.out.println("Enter Course Name: ");
                    String courseName = courseScanner.nextLine();
                    

                    this.courseName.add(courseName);

                    Scanner courseCodeScanner = new Scanner(System.in);
                    System.out.println("Enter User Email: ");
                    String courseCode = courseCodeScanner.nextLine();
                    

                    this.courseCode.add(courseCode);
                    System.out.println("Course successfully created!");
                }
            }

        }

        public void viewCourses() {
            ListIterator<String> codeiterator = courseCode.listIterator();
            ListIterator<String> courseNameIterator = courseName.listIterator();
            ListIterator<String> courseCreatorIterator = courseCreator.listIterator();
            try {
                while (codeiterator.hasNext()) {
                    System.out.println("----- COURSES ------");
                    System.out.println("Course Name: " + courseNameIterator.next() + " Course Code: "
                            + codeiterator.next() + " Course Creator: " + courseCreatorIterator.next());
                }
            } catch (NullPointerException e) {
                System.out.println("Exception thrown : " + e);
            }
        }

        public void registerCourse() {
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            retUserEm.close();

            Scanner courseCodeScanner = new Scanner(System.in);
            System.out.println("Enter Course Code: ");
            String courseCodepref = courseCodeScanner.nextLine();
            courseCodeScanner.close();
            //should add accounts to various code registers

            
            int index = courseCode.indexOf(courseCodepref);
            members.add(retUserEmail);
            ListofMembers.add(index,members);
        }

        public void viewCourseByCode(){
            Scanner courseCodeScanner = new Scanner(System.in);
            System.out.println("Enter Course Code to be viewed: ");
            String courseCodesString = courseCodeScanner.nextLine();
            courseCodeScanner.close();

            courseCode.indexOf(courseCodesString);
        }

        public void viewCoursesByEmail(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            retUserEm.close();

            //ListIterator<String> memIterator = members.listIterator();
            ListIterator<List<String>> memListIterator = ListofMembers.listIterator();
            System.out.println("---- Courses Enrolled by "+userFirstName.get(existingEmails.indexOf(retUserEmail))+"----");
            while(memListIterator.hasNext()){
                int count =0;
                if(members.contains(retUserEmail)){
                    courseName.get(count);
                }
                count++;
            }
        }

        public void addAssignment(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            retUserEm.close();

            if(isFaculty(retUserEmail)){
                if(courseCreator.get(existingEmails.indexOf(retUserEmail))==retUserEmail){
                    Scanner courseCodeScanner = new Scanner(System.in);
                    System.out.println("Enter Course Code: ");
                    String courseCodeprefString = courseCodeScanner.nextLine();
                    courseCodeScanner.close();
        
                    Scanner assignmentNameScanner = new Scanner(System.in);
                    System.out.println("Enter Assignment Name: ");
                    String assignmentNameString = assignmentNameScanner.nextLine();
                    assignmentNameScanner.close();
                    assignmentName.add(courseCode.indexOf(courseCodeprefString),assignmentNameString);
        
                    Scanner descriptionScanner = new Scanner(System.in);
                    System.out.println("Enter Assignment Description: ");
                    String descriptionString = descriptionScanner.nextLine();
                    descriptionScanner.close();
                    dueDate.add(courseCode.indexOf(courseCodeprefString),descriptionString);
        
                    Scanner dueDateScanner = new Scanner(System.in);
                    System.out.println("Enter Due Date for Assignment: ");
                    String dueDateString = dueDateScanner.nextLine();
                    dueDateScanner.close();
                    dueDate.add(courseCode.indexOf(courseCodeprefString),dueDateString);
        
                    Scanner assignmentTypeScanner = new Scanner(System.in);
                    System.out.println("Enter Assignment type(QUIZ, HOMEWORK, PROJECT OR EXAM): ");
                    String assignmentTypeString = assignmentTypeScanner.nextLine();
                    assignmentTypeScanner.close();
                    assignmentType.add(courseCode.indexOf(courseCodeprefString),assignmentTypeString);
        
                    System.out.println(assignmentNameString+"("+assignmentTypeString+") created successfully!");

                    listOfAssignments.add(courseCode.indexOf(courseCodeprefString),assignmentName);
                }
               
            }

            
        }


        public void viewAssignmentsByCourse(){
            Scanner courseCodeScanner = new Scanner(System.in);
            System.out.println("Enter Course Code: ");
            String courseCodeprefString = courseCodeScanner.nextLine();
            courseCodeScanner.close();
            
            System.out.println("--- Assignments for"+assignmentName.get(courseName.indexOf(courseCodeprefString))+"---");
            listOfAssignments.get(courseCode.indexOf(courseCodeprefString));
            
        }

        public void viewAssignmentsByEmail(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            retUserEm.close();

            boolean pending = false;
            ListIterator<List<String>> memListIterator = ListofMembers.listIterator();

            System.out.println("---- Courses Enrolled by "+userFirstName.get(existingEmails.indexOf(retUserEmail))+"----");
            while(memListIterator.hasNext()){
                if(pending){
                    //not done 
                }
            }
        }

        public void submitAssignment(){
            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            retpassw.close();

            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            retUserEm.close();

            //ListIterator<String> courseCodeIterator = courseCode.listIterator();
            //ListIterator<String> assignmentIterator = courseName.listIterator();
            

            if(login(retUserEmail, retUserPassword)){
                
                Scanner courseCodeScanner = new Scanner(System.in);
                System.out.println("Enter Course Code: ");
                String courseCodeprefString = courseCodeScanner.nextLine();
                

                Scanner assignmentNameScanner = new Scanner(System.in);
                System.out.println("Enter Assignment Name: ");
                String assignmentNameString = assignmentNameScanner.nextLine();
                
                
                Scanner submissionScanner = new Scanner(System.in);
                System.out.println("Enter Course Code: ");
                String submissionString = submissionScanner.nextLine(); 
                

                singleSubmissions.add(submissionString);
                listofSubmissions.add(assignmentName.indexOf(assignmentNameString),singleSubmissions);

            }else{
                System.out.println("Submission cannot be made");
            }
                
        }

        public void viewSubmissions(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            

            if(login(retUserEmail,retUserPassword)){
                if(isFaculty(retUserEmail)){
                    if(courseCreator.get(courseCode.indexOf(retUserEmail))==retUserEmail){
                        Scanner courseCodeScanner = new Scanner(System.in);
                        System.out.println("Enter Course Code: ");
                        String courseCodeprefString = courseCodeScanner.nextLine();
                            

                        Scanner assignmentNameScanner = new Scanner(System.in);
                        System.out.println("Enter Assignment Name: ");
                        String assignmentNameString = assignmentNameScanner.nextLine();
                            
                        if(listofSubmissions.get(courseCode.indexOf(courseCodeprefString))==null){
                        System.out.println("No submission"); 
                        }else{
                            listofSubmissions.get(courseCode.indexOf(courseCodeprefString));}
                    }
                }
                    
            }
                
        }

        public void scoreAssignment(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            

            if(login(retUserEmail,retUserPassword)){
                if(isFaculty(retUserEmail)){
                    if(courseCreator.get(courseCode.indexOf(retUserEmail))==retUserEmail){
                    }
                }
            
            }

        }
    }
