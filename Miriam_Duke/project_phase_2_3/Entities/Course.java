package Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Course{

    // Instance variables
    protected String creatorEmail;
    protected String courseCode;
    protected String courseName;
    protected ArrayList<Student> registeredStudent = new ArrayList<>();
    protected ArrayList<Assignment> assignments = new ArrayList<>();
    protected ArrayList<Submissions> submissions = new ArrayList<>();



    public Course(){
    }

    public Course(String Email, String code,String courseName){
        this.creatorEmail = Email;
        this.courseCode = code;
        this.courseName = courseName;
    }

    /**
     * @return the creatorEmail
     */
    public String getCreatorEmail() {
        return creatorEmail;
    }


    /**
     * @return the courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }


    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param creatorEmail the creatorEmail to set
     */
    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }


    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }


    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // Add registered students for this course
    public void addStudent(Student student){
        registeredStudent.add(student);
    }


    public void viewCourses(Database database){
        System.out.print("\n_______ Course Details______ \n");
        System.out.print("Lecturer        Course Name     Course Code \n");
        for(Course course: database.courses){
            // Display course details
            System.out.println(course.getCreatorEmail() + "\t\t" + course.getCourseName() + "\t\t" + course.getCourseCode());
        }
    }

    public void addRegisteredStudent(Student student){

        registeredStudent.add(student);
    }

    public void addNewAssignment(Assignment assignment){

        assignments.add(assignment);
    }


    public void viewCourseByCode(Database database){
        System.out.println("____________VIEW COURSE BY CODE_________");
        Scanner getDets = new Scanner(System.in);  // Create a Scanner object
        System.out.print("\nEnter Course Code: ");
        String courseCode = getDets.nextLine();

        System.out.println("\n_______COURSE DETAILS________");
                System.out.print("Lecturer      Course Name     Course Code \n");
        for(Course course: database.courses){
            if (course.getCourseCode().equals(courseCode)){
                System.out.println(course.getCreatorEmail() + "\t\t" + course.getCourseName() + "\t\t" + course.getCourseCode());

                System.out.println("\n_______ List of Students registered for " + courseCode + "________\n");
                System.out.println("Email             Student Name     ");
                for(Student student: course.registeredStudent){
                    System.out.println(student.getEmail() + "\t\t" + student.getFirstName() + " " + student.getLastName());
                }

            }
        }
    }

    public void viewCoursesByEmail(Database database){
        System.out.println("_______VIEW COURSES BY EMAIL______ \n Kindly enter user's Email");
        Scanner getDets = new Scanner(System.in);  // Create a Scanner object
        System.out.print("\nEnter Email: ");
        String mail = getDets.nextLine();

        // check if account  exists
        for (Student student : database.students) {
            if (student.getEmail().equals(mail)) {
                System.out.print("\n_______ Viewing Course by Email______ \n");
                System.out.print("___ List of Courses " + mail + " is registered for ___\n");
                System.out.print(" Course Name     Course Code \n");

                for (Course course : student.registeredCourses) {
                    System.out.println(course.getCourseName() + "\t\t\t" + course.getCourseCode());
                }
                return;
            }
        }
        // Account doesn't exist
        System.out.println("The Email you entered is INCORRECT");
    }
}



