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
        cls.registerCourse();
        cls.viewCourses();
        cls.viewCourseByCode();
        cls.viewCoursesByEmail();
        cls.addAssignment();
        cls.viewAssignmentsByEmail();
        cls.viewAssignmentsByCourse();
        cls.submitAssignment();
        cls.viewSubmissions();
        cls.scoreAssignment();
        cls.viewAssignmentScore();
        cls.viewAllAssignmentScores();
        cls.viewAssignmentScores();
        cls.viewAssignmentGrade();
        cls.viewAssignmentGrades();
        cls.viewAllAssignmentScores1();
        cls.setNotfificationPreferences();

        
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
        ArrayList <String> singleScores= new ArrayList <String>();
        ArrayList <List<String>> listOfScores = new ArrayList<>();
        ArrayList <String> singleGrades = new ArrayList<>();
        ArrayList <String> submitters = new ArrayList<>();
        ArrayList <List<String>> listOfSubmitters = new ArrayList<>();
        ArrayList <String> notificationpref = new ArrayList <>();
        ArrayList <List<String>> listOfNotificationpref = new ArrayList<>();



        
        

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

            System.out.println("---login---");
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
            System.out.println("--update Profile--");
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
            System.out.println("--View Profile--");
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            
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
            System.out.println("--isAdmin--");
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
            System.out.println("--makeFaculty--");
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
                System.out.println("User is faculty!");
                return true;
            }
            System.out.println("User is not faculty!");
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
                    String courseNameString = courseScanner.nextLine();
                    courseName.add(courseNameString);

                    Scanner courseCodeScanner = new Scanner(System.in);
                    System.out.println("Enter Preferred Course Code: ");
                    String courseCodeString = courseCodeScanner.nextLine();
                    courseCode.add(courseCodeString);

                    System.out.println("Course successfully created!");
                    System.out.println(courseCode.size());
                }
            }

        }

        public void viewCourses() {
            for(int i = 0;i<courseName.size();i++){
                System.out.println("---Course---");
                System.out.println("Course: "+courseName.get(i));
                System.out.println("Course Code: "+courseCode.get(i));
                System.out.println("Course Creator: "+courseCreator.get(i));
            }
        }

        public void registerCourse() {
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner courseCodeScanner = new Scanner(System.in);
            System.out.println("Enter Course Code: ");
            String courseCodepref = courseCodeScanner.nextLine();
            
            //should add accounts to various code registers

            int index = courseCode.indexOf(courseCodepref);
            members.add(retUserEmail);
            ListofMembers.add(index,members);
        }

        public void viewCourseByCode(){
            Scanner courseCodeScanner = new Scanner(System.in);
            System.out.println("Enter Course Code to be viewed: ");
            String courseCodesString = courseCodeScanner.nextLine();
            

            System.out.println("Course: "+courseName.get(courseCode.indexOf(courseCodesString)));
        }

        public void viewCoursesByEmail(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            
            System.out.println("---- Courses Enrolled by "+userFirstName.get(existingEmails.indexOf(retUserEmail))+" ----");
            if(courseCode.size()==1){
                System.out.println(courseName.get(existingEmails.indexOf(retUserEmail)));
            }else if(courseCode.size()>1){
                for(int i =0;i<ListofMembers.size();i++){
                    List<String> list = ListofMembers.get(i);
                    if(list.contains(retUserEmail)){
                        System.out.println(list);
                    }
                }
            }else{
                System.out.println("No courses enrolled by User");
            }
        }

        public void addAssignment(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            
            Scanner courseCodeScanner = new Scanner(System.in);
            System.out.println("Enter Course Code: ");
            String courseCodeprefString = courseCodeScanner.nextLine();

            if(isFaculty(retUserEmail)){
                if(courseCreator.get(courseCode.indexOf(courseCodeprefString))==retUserEmail||courseCreator.contains(retUserEmail)){
                    
                    Scanner assignmentNameScanner = new Scanner(System.in);
                    System.out.println("Enter Assignment Name: ");
                    String assignmentNameString = assignmentNameScanner.nextLine();
                    
                    assignmentName.add(courseCode.indexOf(courseCodeprefString),assignmentNameString);
        
                    Scanner descriptionScanner = new Scanner(System.in);
                    System.out.println("Enter Assignment Description: ");
                    String descriptionString = descriptionScanner.nextLine();
                    
                    dueDate.add(courseCode.indexOf(courseCodeprefString),descriptionString);
        
                    Scanner dueDateScanner = new Scanner(System.in);
                    System.out.println("Enter Due Date for Assignment: ");
                    String dueDateString = dueDateScanner.nextLine();
                    
                    dueDate.add(courseCode.indexOf(courseCodeprefString),dueDateString);
        
                    Scanner assignmentTypeScanner = new Scanner(System.in);
                    System.out.println("Enter Assignment type(QUIZ, HOMEWORK, PROJECT OR EXAM): ");
                    String assignmentTypeString = assignmentTypeScanner.nextLine();
                    
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
            
            
            System.out.println("--- Assignments for "+courseName.get(courseCode.indexOf(courseCodeprefString))+"---");
            System.out.println(listOfAssignments.get(courseCode.indexOf(courseCodeprefString)));
            
        }

        public void viewAssignmentsByEmail(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();

            for(int i=0;i<existingEmails.size();i++){
                if(ListofMembers.get(i).contains(retUserEmail)){
                    System.out.println(listOfAssignments.get(i));
                }
            }
        }

        public void submitAssignment(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            
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
                listofSubmissions.add(singleSubmissions);
                submitters.add(retUserEmail);

            }else{
                System.out.println("Submission cannot be made");
            }
              listOfSubmitters.add(submitters);  
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
                    if(courseCreator.get(existingEmails.indexOf(retUserEmail))==retUserEmail){
                        Scanner courseCodeScanner = new Scanner(System.in);
                        System.out.println("Enter Course Code: ");
                        String courseCodeprefString = courseCodeScanner.nextLine();
                            

                        Scanner assignmentNameScanner = new Scanner(System.in);
                        System.out.println("Enter Assignment Name: ");
                        String assignmentNameString = assignmentNameScanner.nextLine();
                            
                        if(listofSubmissions.get(courseCode.indexOf(courseCodeprefString))==null){
                        System.out.println("No submission"); 
                        }else{
                            System.out.println(listofSubmissions.get(courseCode.indexOf(courseCodeprefString)));}
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
                    if(courseCreator.contains(retUserEmail)){
                        Scanner courseCodeScanner = new Scanner(System.in);
                        System.out.println("Enter Course Code: ");
                        String courseCodeprefString = courseCodeScanner.nextLine();

                        Scanner assignmentNameScanner = new Scanner(System.in);
                        System.out.println("Enter Assignment Name: ");
                        String assignmentNameString = assignmentNameScanner.nextLine();


                        for(int i =0;i<(listOfAssignments.get(assignmentName.indexOf(assignmentNameString))).size();i++){
                            int index = assignmentName.indexOf(assignmentNameString);
                            System.out.println("-- "+assignmentName.get(index)+" --");
                            System.out.println(listofSubmissions.get(index).get(i));
                            
                            Scanner scoreScanner = new Scanner(System.in);
                            System.out.println("Enter deserved score based on Student's submission (out of 100): ");
                            String scoreString = scoreScanner.nextLine();

                            singleScores.add(scoreString);
                            System.out.println("Assignment successfully graded: "+scoreString+"/100");
                        }
                        listOfScores.add(singleScores);
                    }
                }
            }

        }

        public void viewAssignmentScore(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();

            if(login(retUserEmail,retUserPassword)){
                Scanner courseCodeScanner = new Scanner(System.in);
                System.out.println("Enter Course Code: ");
                String courseCodeprefString = courseCodeScanner.nextLine();

                Scanner assignmentNameScanner = new Scanner(System.in);
                System.out.println("Enter Assignment Name: ");
                String assignmentNameString = assignmentNameScanner.nextLine();

                List<String> x = listOfSubmitters.get(assignmentName.indexOf(assignmentNameString));
                System.out.println(userFirstName.get(existingEmails.indexOf(retUserEmail))+"'s grade for "+assignmentNameString+" "+singleScores.get(x.indexOf(retUserEmail)));
            }
        }


        public void viewAssignmentScores(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();

            if(login(retUserEmail,retUserPassword) && isFaculty(retUserEmail) && courseCreator.contains(retUserEmail)){
                Scanner courseCodeScanner = new Scanner(System.in);
                System.out.println("Enter Course Code: ");
                String courseCodeprefString = courseCodeScanner.nextLine();

                Scanner assignmentNameScanner = new Scanner(System.in);
                System.out.println("Enter Assignment Name: ");
                String assignmentNameString = assignmentNameScanner.nextLine();

                System.out.println("Note = Scores being displayed are out of 100");
                System.out.println(listOfScores.get(assignmentName.indexOf(assignmentNameString)));
            }
        }

        public void viewAllAssignmentScores(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();

            if(login(retUserEmail,retUserPassword)){

                for(int i = 0;i<listOfSubmitters.size();i++){
                    int y= 0;
                    List <String> x = listOfSubmitters.get(i);
                    if(x.contains(retUserEmail)){
                        y = x.indexOf(retUserEmail);
                        System.out.println(assignmentName.get(i)+" "+listOfScores.get(i).get(y));
                    }

                }

            }
        }

        public void viewAssignmentGrade(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();

            String y; 

            if(login(retUserEmail,retUserPassword)){
                Scanner courseCodeScanner = new Scanner(System.in);
                System.out.println("Enter Course Code: ");
                String courseCodeprefString = courseCodeScanner.nextLine();

                Scanner assignmentNameScanner = new Scanner(System.in);
                System.out.println("Enter Assignment Name: ");
                String assignmentNameString = assignmentNameScanner.nextLine();

                List<String> x = listOfSubmitters.get(assignmentName.indexOf(assignmentNameString));
                int f = Integer.parseInt(singleScores.get(x.indexOf(retUserEmail)));
                if(f>84){
                    y="A+";
               }else if(f>79){
                   y="A";
               }else if(f>74){
                   y="B+";
               }else if(f>69){
                    y="B";
               }else if(f>64){
                   y="C+";
               }else if(f>59){
                   y="C";
               }else if(f>54){
                   y="D+";
               }else if(f>49){
                   y="D";
               }else{
                   y="E";
               }
                System.out.println(userFirstName.get(existingEmails.indexOf(retUserEmail))+"'s grade for "+assignmentNameString+" "+singleScores.get(x.indexOf(retUserEmail))+" "+y);
            }

        }

        public void viewAssignmentGrades(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            if(login(retUserEmail,retUserPassword) && isFaculty(retUserEmail) && courseCreator.contains(retUserEmail)){
                Scanner courseCodeScanner = new Scanner(System.in);
                System.out.println("Enter Course Code: ");
                String courseCodeprefString = courseCodeScanner.nextLine();

                Scanner assignmentNameScanner = new Scanner(System.in);
                System.out.println("Enter Assignment Name: ");
                String assignmentNameString = assignmentNameScanner.nextLine();

                for(int i=0;i<listOfScores.get(assignmentName.indexOf(assignmentNameString)).size();i++){
                    int x=Integer.parseInt(listOfScores.get(assignmentName.indexOf(assignmentNameString)).get(i));
                   if(x>84){
                        singleGrades.add("A+");
                   }else if(x>79){
                       singleGrades.add("A");
                   }else if(x>74){
                       singleGrades.add("B+");
                   }else if(x>69){
                        singleGrades.add("B");
                   }else if(x>64){
                       singleGrades.add("C+");
                   }else if(x>59){
                       singleGrades.add("C");
                   }else if(x>54){
                       singleGrades.add("D+");
                   }else if(x>49){
                       singleGrades.add("D");
                   }else{
                       singleGrades.add("E");
                   }
                   
                }
                System.out.println(singleGrades);
            }
        }

        public void viewAllAssignmentScores1(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();
            String y; 

            if(login(retUserEmail,retUserPassword)){

                for(int i = 0;i<listOfSubmitters.size();i++){
                    int f= 0;
                    List <String> x = listOfSubmitters.get(i);
                    if(x.contains(retUserEmail)){
                        f = x.indexOf(retUserEmail);
                        int c = Integer.parseInt(listOfScores.get(i).get(f));

                        if(c>84){
                            y="A+";
                       }else if(c>79){
                           y="A";
                       }else if(c>74){
                           y="B+";
                       }else if(c>69){
                            y="B";
                       }else if(c>64){
                           y="C+";
                       }else if(c>59){
                           y="C";
                       }else if(c>54){
                           y="D+";
                       }else if(c>49){
                           y="D";
                       }else{
                           y="E";
                       }

                       System.out.println(assignmentName.get(i)+" "+listOfScores.get(i).get(f)+" Grade: "+y);
                    }

                }

            }
        }

        public void setNotfificationPreferences(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();

            if(login(retUserEmail,retUserPassword)){
                Scanner notifEmScanner= new Scanner(System.in);
                System.out.println("Enter whether User will like to receive email Notifications when an assignment for a registered course is posted(Yes/No): ");
                String notifEmString ="Email preference for assignment post: "+notifEmScanner.nextLine();
                notificationpref.add(notifEmString);

                Scanner notifSubScanner = new Scanner(System.in);
                System.out.println("Enter User will like to receive email notification when an assignment is submitted(Yes/No): ");
                String notifSubEmail = "Email Preference for assignment submission: "+notifSubScanner.nextLine();
                notificationpref.add(notifSubEmail);

                Scanner notifRegScanner = new Scanner(System.in);
                System.out.println("Enter User will like to receive email notification when user registers for a course(Yes/No): ");
                String notifRegEmail = "Email preference for course Registration: "+notifRegScanner.nextLine();
                notificationpref.add(notifRegEmail);

                System.out.println(notificationpref);

                listOfNotificationpref.add(notificationpref);
            }
        }
}
