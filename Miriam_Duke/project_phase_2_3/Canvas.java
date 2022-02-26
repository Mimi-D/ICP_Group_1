import Entities.*;

import java.text.ParseException;
import java.util.ArrayList;

public class Canvas {

    // for view assignments by email
    public static boolean pending = true;

    public static void main(String[] args) throws ParseException {

        // Create a new Database to store data
        Database database = new Database();

        // Create account
        Admin newAdmin = new Admin("admin","admin");  // Admin
        User newUser = new User("person","person");   //Normal User
        Student newStud = new Student("Mimi@gmail.com","mimi","Miriam","Duke");
        Student newStud0 = new Student("Duke@gmail.com","duke","Sammy","Duke");

        // Creating objects if classes for accessing data
        Faculty fac = new Faculty();
        Course course = new Course();

        //Add new Admin account to Admin database
        database.addAdmin(newAdmin);
        database.addUser(newAdmin);

        //Add new account to User database
        database.addUser(newUser);
        database.addUser(newStud);
        database.addStudent(newStud);
        database.addUser(newStud0);
        database.addStudent(newStud0);
        //Login
        //newAdmin.login("admin","admin",database);

        //Update Profile
        //newAdmin.updateProfile(database);

        newAdmin.makeFaculty(database);

        // Test if person has faculty priviledges
        //System.out.println(newUser.isFaculty("person",database));
        fac.createCourse(database);
        //fac.createCourse(database);

        // Register course
        newStud.registerCourse(database);
        //newStud0.registerCourse(database);

        // View all courses
        //course.viewCourses(database);

        //course.viewCourseByCode(database);
        //course.viewCoursesByEmail(database);
        fac.addAssignment(database);
        fac.addAssignment(database);
        //fac.viewAssignmentsByCourse(database);

        /*try {
            newStud.viewAssignmentsByEmail(database,pending);
        } catch (Exception e) {
            System.out.println(" ");
        }*/

        newStud.submitAssignment(database);
        newStud.submitAssignment(database);

        //fac.viewSubmissions(database);
        fac.scoreAssignment(database);
        fac.scoreAssignment(database);
        //newStud.viewAssignmentScore(database);
        //fac.viewAssignmentScores(database);
        newStud.viewAllAssignmentScores(database);

    }
}
