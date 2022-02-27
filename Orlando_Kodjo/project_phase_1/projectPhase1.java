import java.util.Scanner; //Importing Scanner class to be able to receive user input 
import java.util.ArrayList;
import java.util.*;

public class projectPhase1 implements canvasInterface{
    public static void main(String[] args) {
     projectPhase1 canvas = new projectPhase1();
     canvasAdmin admin = new canvasAdmin("partrick@ashesi.edu.gh");
     canvas.createAccount();
     canvas.login();
     canvas.updateProfile();
     canvas.viewProfile();

        
    }

        ArrayList<String> existingEmails = new ArrayList<String>();
        ArrayList<String> existingPasswords = new ArrayList<String>();
        ArrayList<String> userGPA = new ArrayList<String>();
        ArrayList<String> userFirstName = new ArrayList<String>();
        ArrayList<String> userLastName = new ArrayList<String>();
        ArrayList<String> userYearGroup = new ArrayList<String>();
        ArrayList<String> userDateOfBirth = new ArrayList<String>();
        ArrayList<String> adminAccounts = new ArrayList<String>();{adminAccounts.add("patrick.awuah@ashesi.edu.gh");}
        public ArrayList<String> faculty = new ArrayList<String>();
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

        ArrayList <canvasUser> listOfUsersobj = new ArrayList <>();
        static ArrayList <canvasFaculty> facultyobj = new ArrayList<>();
        static ArrayList <canvasCourses> listOfCoursesObj = new ArrayList<>();
        
            
        public void createAccount(){
            Scanner userEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String userEmail = userEm.nextLine();

            Scanner passw = new Scanner(System.in);
            System.out.println("Enter preferred password: ");
            String password = passw.nextLine();

            canvasUser newUser = new canvasUser(userEmail,password);
            listOfUsersobj.add(newUser);
            System.out.println(newUser);
            System.out.println("Account created successfully");
        }
        
        public boolean login(){
            Scanner userEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String userEmail = userEm.nextLine();

            Scanner passw = new Scanner(System.in);
            System.out.println("Enter preferred password: ");
            String password = passw.nextLine();

            try{
                for(int i=0;i < listOfUsersobj.size();i++){
                    if(listOfUsersobj.get(i).getEmail().equals(userEmail) && listOfUsersobj.get(i).getPassword().equals(password)){
                        System.out.println("Login Successful");
                        return true;
                    }
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("No account created, Create an Account to proceed");
            }
            System.out.println("Login failed");
            return false;
        }

        public boolean login(String userEmail, String Password){
            try{
                for(int i=0;i<listOfUsersobj.size()+1;i++){
                    canvasUser x=listOfUsersobj.get(i);
                    if(x.getEmail().equals(userEmail) && x.getPassword().equals(Password)){
                        
                        return true;
                    }
                }
            }catch(ArrayIndexOutOfBoundsException e){
                return false;
            }
            return false;
        }

        public void updateProfile(){
            Scanner userEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String userEmail = userEm.nextLine();

            Scanner passw = new Scanner(System.in);
            System.out.println("Enter preferred password: ");
            String password = passw.nextLine();

            if(login(userEmail,password)){
                try{
                    for(int i=0;i<listOfUsersobj.size();i++){
                        if(listOfUsersobj.get(i).getEmail().equals(userEmail) && listOfUsersobj.get(i).getPassword().equals(password)){
                            listOfUsersobj.get(i).updateProfile();
                        }

                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("User not found");
                }
            }
        }

        public void viewProfile(){
            Scanner userEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String userEmail = userEm.nextLine();

            Scanner passw = new Scanner(System.in);
            System.out.println("Enter preferred password: ");
            String password = passw.nextLine();

            if(login(userEmail,password)){
                try{
                    for(int i=0;i<listOfUsersobj.size();i++){
                        if(listOfUsersobj.get(i).getEmail().equals(userEmail) && listOfUsersobj.get(i).getPassword().equals(password)){
                            listOfUsersobj.get(i).viewProfile();
                        }

                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("User not found");
                }
            }
        }

        public void viewCourses(){
            try{
                for(int i=0;i<listOfCoursesObj.size();i++){
                    canvasCourses x = listOfCoursesObj.get(i);
                    System.out.println("Course Name: "+x.getCourseName());
                    System.out.println("Course Code"+x.getCourseCode());
                    System.out.println("Course Creator"+x.getCourseCreator());
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("No course currently registered");
            }
        }

        public void viewCourseByCode(){
            Scanner courseCodeScanner = new Scanner(System.in);
            System.out.println("Enter Course Code to be viewed: ");
            String courseCodesString = courseCodeScanner.nextLine();
            try{
                for(int i=0;i<listOfCoursesObj.size();i++){
                    canvasCourses x = listOfCoursesObj.get(i);
                    if(x.getCourseCode().equals(courseCodesString)){
                        System.out.println("Course Name: "+x.getCourseName());
                        System.out.println("Course Code: "+x.getCourseCode());
                        System.out.println("Course Creator: "+x.getCourseCreator());
                    }
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("No course currently existing with entered course code");
            }
        }

        public void addAssignment(){
            Scanner userEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String userEmail = userEm.nextLine();

            Scanner passw = new Scanner(System.in);
            System.out.println("Enter preferred password: ");
            String password = passw.nextLine();

            if(login(userEmail,password)){
                try{
                    for(int i=0;i<listOfUsersobj.size();i++){
                        canvasUser x = listOfUsersobj.get(i);
                        
                        if(x.isFaculty(x)){
                            Scanner courseCodeScanner = new Scanner(System.in);
                            System.out.println("Enter Course Code to be viewed: ");
                            String courseCodesString = courseCodeScanner.nextLine();

                            Scanner assignmentNameScanner = new Scanner(System.in);
                            System.out.println("Enter Assignment Name: ");
                            String assignmentNameString = assignmentNameScanner.nextLine();
                    
                            Scanner descriptionScanner = new Scanner(System.in);
                            System.out.println("Enter Assignment Description: ");
                            String descriptionString = descriptionScanner.nextLine();
                                
                            Scanner dueDateScanner = new Scanner(System.in);
                            System.out.println("Enter Due Date for Assignment: ");
                            String dueDateString = dueDateScanner.nextLine();
                    
                            Scanner assignmentTypeScanner = new Scanner(System.in);
                            System.out.println("Enter Assignment type(QUIZ, HOMEWORK, PROJECT OR EXAM): ");
                            String assignmentTypeString = assignmentTypeScanner.nextLine();

                            canvasAssignments assignmentobj=new canvasAssignments(assignmentNameString, descriptionString, dueDateString, assignmentTypeString);
                            for(int k=0; k<listOfCoursesObj.size();k++){
                                canvasCourses y = listOfCoursesObj.get(k);
                                if(y.getCourseCode().equals(courseCodesString)){
                                    y.assignment.add(assignmentobj);
                                }
                            
                            }
                        }
    
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Assignment could not be created");
                }
            }
            
            
        }

        public void viewAssignmentsByCourse(){
            Scanner courseCodeScanner = new Scanner(System.in);
            System.out.println("Enter Course Code to be viewed: ");
            String courseCodesString = courseCodeScanner.nextLine();
            try{
                for(int k=0; k<listOfCoursesObj.size();k++){
                    canvasCourses y = listOfCoursesObj.get(k);
                    if(y.getCourseCode().equals(courseCodesString)){
                        y.viewAllassignments();
                    }
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("No registered assignment for chosen course");
            }
            
        }

        public void viewAssignmentsByEmail(){
            Scanner userEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String userEmail = userEm.nextLine();

                try{
                    for(int i = 0; i<listOfUsersobj.size(); i++){
                        canvasUser x = listOfUsersobj.get(i);
                        if(listOfUsersobj.get(i).getEmail().equals(userEmail)){
                            for(int k=0;k<x.canvasCourses.size();k++){
                                x.canvasCourses.get(i).viewAllassignments();
                            }
                        }
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("User does not have any registered assignemnts");
                }
        }

        public void submitAssignment(){
            Scanner userEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String userEmail = userEm.nextLine();

            Scanner passw = new Scanner(System.in);
            System.out.println("Enter preferred password: ");
            String password = passw.nextLine();

            if(login(userEmail,password)){
                try{
                    Scanner courseCodeScanner = new Scanner(System.in);
                    System.out.println("Enter Course Code: ");
                    String courseCodeprefString = courseCodeScanner.nextLine();
                    
                    Scanner assignmentNameScanner = new Scanner(System.in);
                    System.out.println("Enter Assignment Name: ");
                    String assignmentNameString = assignmentNameScanner.nextLine();
                    
                    Scanner submissionScanner = new Scanner(System.in);
                    System.out.println("Enter Course Code: ");
                    String submissionString = submissionScanner.nextLine(); 

                    for(int i = 0;i<listOfCoursesObj.size();i++){
                        canvasCourses x = listOfCoursesObj.get(i);
                        if(courseCodeprefString.equals(x.getCourseCode())){
                            for(int k=0; k<x.assignment.size();k++){
                                if(x.assignment.get(i).getAssignmentName().equals(assignmentNameString)){
                                    canvasSubmission obj = new canvasSubmission(submissionString, userEmail);
                                    x.assignment.get(i).submissions.add(obj);
                                    System.out.println("Submission successfully made!");
                                }
                            }    
                        }
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Unable to make the submission at this time, try again!");
                }

            }
        }

        public void viewSubmissions(){
            Scanner userEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String userEmail = userEm.nextLine();

            Scanner passw = new Scanner(System.in);
            System.out.println("Enter preferred password: ");
            String password = passw.nextLine();

            if(login(userEmail, password)){
                Scanner assignmentNameScanner = new Scanner(System.in);
                System.out.println("Enter Assignment Name: ");
                String assignmentNameString = assignmentNameScanner.nextLine();

                Scanner courseCodeScanner = new Scanner(System.in);
                System.out.println("Enter Course Code: ");
                String courseCodeprefString = courseCodeScanner.nextLine();
                try{
                    for(int i=0; i<listOfUsersobj.size();i++){
                        if(listOfUsersobj.get(i).getEmail().equals(userEmail) && listOfUsersobj.get(i).isFaculty(listOfUsersobj.get(i))){
                            for(int k=0; k<listOfCoursesObj.size();k++){
                                canvasCourses y = listOfCoursesObj.get(i);
                                if(y.getCourseCreator().equals(userEmail)){
                                    if(y.getCourseCode()==courseCodeprefString){
                                        for(int b=0;b<y.assignment.size();b++){
                                            canvasAssignments p = y.assignment.get(i);
                                            if(p.getAssignmentName().equals(assignmentNameString)){
                                                System.out.println("Submissions for "+y.getCourseName());
                                                for(int j=0;j<p.submissions.size();j++){
                                                    System.out.println(p.submissions.get(i).getSubmission());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }catch(ArrayIndexOutOfBoundsException E){
                    System.out.println("No submissions made yet");
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

            if(login(retUserEmail, retUserPassword)){
                Scanner assignmentNameScanner = new Scanner(System.in);
                System.out.println("Enter Assignment Name: ");
                String assignmentNameString = assignmentNameScanner.nextLine();

                Scanner courseCodeScanner = new Scanner(System.in);
                System.out.println("Enter Course Code: ");
                String courseCodeprefString = courseCodeScanner.nextLine();

                try{
                    for(int i=0; i<listOfUsersobj.size();i++){
                        if(listOfUsersobj.get(i).getEmail().equals(retUserEmail) && listOfUsersobj.get(i).isFaculty(listOfUsersobj.get(i))){
                            for(int k=0; k<listOfCoursesObj.size();k++){
                                canvasCourses y = listOfCoursesObj.get(k);
                                if(y.getCourseCreator().equals(retUserEmail)){
                                    if(y.getCourseCode().equals(courseCodeprefString)){
                                        for(int b=0;b<y.assignment.size();b++){
                                            canvasAssignments p = y.assignment.get(b);
                                            if(p.getAssignmentName().equals(assignmentNameString)){
                                                System.out.println("Submissions for "+y.getCourseName());
                                                for(int j=0;j<p.submissions.size();j++){
                                                    System.out.println(p.submissions.get(j).getSubmission());
                                                    Scanner gradeScanner = new Scanner(System.in);
                                                    System.out.println("Enter submission grade(out of 100): ");
                                                    String gradeString = gradeScanner.nextLine();
                                                    p.submissions.get(j).setGrade(gradeString);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }catch(ArrayIndexOutOfBoundsException E){
                    System.out.println("No submissions made yet");
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

            if(login(retUserEmail, retUserPassword)){
                Scanner assignmentNameScanner = new Scanner(System.in);
                System.out.println("Enter Assignment Name: ");
                String assignmentNameString = assignmentNameScanner.nextLine();

                Scanner courseCodeScanner = new Scanner(System.in);
                System.out.println("Enter Course Code: ");
                String courseCodeprefString = courseCodeScanner.nextLine();

                try{
                    for(int k=0; k<listOfCoursesObj.size();k++){
                        canvasCourses y = listOfCoursesObj.get(k);
                            if(y.getCourseCode().equals(courseCodeprefString)){
                                for(int b=0;b<y.assignment.size();b++){
                                    canvasAssignments p = y.assignment.get(b);
                                        if(p.getAssignmentName().equals(assignmentNameString)){
                                            System.out.println("Submissions for "+y.getCourseName());
                                            for(int j=0;j<p.submissions.size();j++){
                                                if(p.submissions.get(j).getSubmitter().equals(retUserEmail)){
                                                    System.out.println(p.submissions.get(j).getGrade());
                                                }
                                            }
                                        }
                                    }
                            }   
                    }
                }catch(ArrayIndexOutOfBoundsException E){
                    System.out.println("No submissions made yet");
                }
            }
        }
        
        public void viewAssignmentScores(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();

            if(login(retUserEmail, retUserPassword)){
                Scanner assignmentNameScanner = new Scanner(System.in);
                System.out.println("Enter Assignment Name: ");
                String assignmentNameString = assignmentNameScanner.nextLine();

                Scanner courseCodeScanner = new Scanner(System.in);
                System.out.println("Enter Course Code: ");
                String courseCodeprefString = courseCodeScanner.nextLine();

                try{
                    for(int i=0; i<listOfUsersobj.size();i++){
                        if(listOfUsersobj.get(i).getEmail().equals(retUserEmail) && listOfUsersobj.get(i).isFaculty(listOfUsersobj.get(i))){
                            for(int k=0; k<listOfCoursesObj.size();k++){
                                canvasCourses y = listOfCoursesObj.get(k);
                                if(y.getCourseCreator().equals(retUserEmail)){
                                    if(y.getCourseCode().equals(courseCodeprefString)){
                                        for(int b=0;b<y.assignment.size();b++){
                                            canvasAssignments p = y.assignment.get(b);
                                            if(p.getAssignmentName().equals(assignmentNameString)){
                                                System.out.println("Submissions for: "+y.getCourseName());
                                                for(int j=0;j<p.submissions.size();j++){
                                                    System.out.println("Grade for "+p.getAssignmentName()+" : "+p.submissions.get(j).getGrade()+" or "+listOfUsersobj.get(i).getFirstName());
                        
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }catch(ArrayIndexOutOfBoundsException E){
                    System.out.println("No submissions made yet");
                }
            }
        }

        public void viewAllAssignmentScores(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
        
            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();

            if(login(retUserEmail, retUserPassword)){
            
            try{
                for(int k=0; k<listOfCoursesObj.size();k++){
                    canvasCourses y = listOfCoursesObj.get(k);
                        for(int b=0;b<y.assignment.size();b++){
                            canvasAssignments p = y.assignment.get(b);   
                                for(int j=0;j<p.submissions.size();j++){
                                    if(p.submissions.get(j).getSubmitter().equals(retUserEmail)){
                                        System.out.println("Grade for "+p.getAssignmentName()+" : "+p.submissions.get(j).getGrade());
                                    }
                                }
                        }
                                    
                              
                    }
                }catch(ArrayIndexOutOfBoundsException E){
                    System.out.println("No submissions made yet");
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

            if(login(retUserEmail, retUserPassword)){
                Scanner assignmentNameScanner = new Scanner(System.in);
                System.out.println("Enter Assignment Name: ");
                String assignmentNameString = assignmentNameScanner.nextLine();

                Scanner courseCodeScanner = new Scanner(System.in);
                System.out.println("Enter Course Code: ");
                String courseCodeprefString = courseCodeScanner.nextLine();

                try{
                    for(int k=0; k<listOfCoursesObj.size();k++){
                        canvasCourses y = listOfCoursesObj.get(k);
                            if(y.getCourseCode()==courseCodeprefString){
                                for(int b=0;b<y.assignment.size();b++){
                                    canvasAssignments p = y.assignment.get(b);
                                        if(p.getAssignmentName().equals(assignmentNameString)){
                                            System.out.println("Submissions for "+y.getCourseName());
                                            for(int j=0;j<p.submissions.size();j++){
                                                if(p.submissions.get(j).getSubmitter().equals(retUserEmail)){
                                                    String l;
                                                    String x =p.submissions.get(j).getGrade() ;
                                                    int f = Integer.parseInt(x);
                                                    if(f>84){
                                                        l="A+";
                                                   }else if(f>79){
                                                       l="A";
                                                   }else if(f>74){
                                                       l="B+";
                                                   }else if(f>69){
                                                        l="B";
                                                   }else if(f>64){
                                                       l="C+";
                                                   }else if(f>59){
                                                       l="C";
                                                   }else if(f>54){
                                                       l="D+";
                                                   }else if(f>49){
                                                       l="D";
                                                   }else{
                                                       l="E";
                                                   }
                                                   System.out.println(retUserEmail+"'s "+"grade for "+p.getAssignmentName()+" : "+l);
                                                }
                                            }
                                        }
                                    }
                            }   
                    }
                }catch(ArrayIndexOutOfBoundsException E){
                    System.out.println("No submissions made yet");
                }
            }
        }

        public void viewAssignmentGrades(){
            Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
            

            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();

            if(login(retUserEmail, retUserPassword)){
                Scanner assignmentNameScanner = new Scanner(System.in);
                System.out.println("Enter Assignment Name: ");
                String assignmentNameString = assignmentNameScanner.nextLine();

                Scanner courseCodeScanner = new Scanner(System.in);
                System.out.println("Enter Course Code: ");
                String courseCodeprefString = courseCodeScanner.nextLine();

                try{
                    for(int i=0; i<listOfUsersobj.size();i++){
                        if(listOfUsersobj.get(i).getEmail().equals(retUserEmail) && listOfUsersobj.get(i).isFaculty(listOfUsersobj.get(i))){
                            for(int k=0; k<listOfCoursesObj.size();k++){
                                canvasCourses y = listOfCoursesObj.get(k);
                                if(y.getCourseCreator().equals(retUserEmail)){
                                    if(y.getCourseCode().equals(courseCodeprefString)){
                                        for(int b=0;b<y.assignment.size();b++){
                                            canvasAssignments p = y.assignment.get(b);
                                            if(p.getAssignmentName().equals(assignmentNameString)){
                                                System.out.println("Submissions for: "+y.getCourseName());
                                                for(int j=0;j<p.submissions.size();j++){
                                                    String l;
                                                    String x =p.submissions.get(j).getGrade() ;
                                                    int f = Integer.parseInt(x);
                                                    if(f>84){
                                                        l="A+";
                                                   }else if(f>79){
                                                       l="A";
                                                   }else if(f>74){
                                                       l="B+";
                                                   }else if(f>69){
                                                        l="B";
                                                   }else if(f>64){
                                                       l="C+";
                                                   }else if(f>59){
                                                       l="C";
                                                   }else if(f>54){
                                                       l="D+";
                                                   }else if(f>49){
                                                       l="D";
                                                   }else{
                                                       l="E";
                                                   }
                                                    System.out.println("Grade for "+p.getAssignmentName()+" : "+l+" for "+listOfUsersobj.get(i).getFirstName());
                        
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }catch(ArrayIndexOutOfBoundsException E){
                    System.out.println("No submissions made yet");
                }
            }
        }
    public void viewAllAssignmentScores1(){
        Scanner retUserEm = new Scanner(System.in);
            System.out.println("Enter User Email: ");
            String retUserEmail = retUserEm.nextLine();
        
            Scanner retpassw = new Scanner(System.in);
            System.out.println("Enter User Password: ");
            String retUserPassword = retpassw.nextLine();

            if(login(retUserEmail, retUserPassword)){
            
            try{
                for(int k=0; k<listOfCoursesObj.size();k++){
                    canvasCourses y = listOfCoursesObj.get(k);
                        for(int b=0;b<y.assignment.size();b++){
                            canvasAssignments p = y.assignment.get(b);   
                                for(int j=0;j<p.submissions.size();j++){
                                    if(p.submissions.get(j).getSubmitter().equals(retUserEmail)){
                                        String l;
                                        String x =p.submissions.get(j).getGrade() ;
                                        int f = Integer.parseInt(x);
                                        if(f>84){
                                            l="A+";
                                        }else if(f>79){
                                            l="A";
                                        }else if(f>74){
                                            l="B+";
                                        }else if(f>69){
                                            l="B";
                                        }else if(f>64){
                                            l="C+";
                                        }else if(f>59){
                                            l="C";
                                        }else if(f>54){
                                            l="D+";
                                        }else if(f>49){
                                            l="D";
                                        }else{
                                            l="E";
                                        }
                                        System.out.println("Grade for "+p.getAssignmentName()+" : "+p.submissions.get(j).getGrade()+" with letter score: "+l);
                                    }
                                }
                        }
                                    
                              
                    }
                }catch(ArrayIndexOutOfBoundsException E){
                    System.out.println("No submissions made yet");
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
            try{
                if(login(retUserEmail, retUserPassword)){
                    for(int i=0;i<listOfUsersobj.size();i++){
                        canvasUser x =listOfUsersobj.get(i);
                        if(x.getEmail().equals(retUserEmail)){
                            x.setNotfificationPreferences();
                            System.out.println("Notifications Preferences set successfully!");
                        }
                    }
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Notification Preferences could not be set, please try again at a later time");
            }
        }       
}
