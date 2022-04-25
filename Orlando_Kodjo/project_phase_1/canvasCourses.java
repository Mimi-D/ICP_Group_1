import java.util.ArrayList;
public class canvasCourses {
    private String courseCreator; 
    private String courseName; 
    private String courseCode;
    ArrayList <canvasUser> CourseMembers = new ArrayList<>();
    ArrayList <canvasAssignments> assignment = new ArrayList<>();

    public canvasCourses(String CourseCreator, String CourseName, String CourseCode){
        courseCreator=CourseCreator;
        courseName=CourseName;
        courseCode=CourseCode;
    }

    public void registerCourse(canvasUser user){
        CourseMembers.add(user);
    }

    public String getCourseCreator(){
        return courseCreator;
    }

    public String getCourseName(){
        return courseName;
    }

    public String getCourseCode(){
        return courseCode;
    }


    public void viewAllassignments(){
        System.out.println("--- Assignments for "+courseName+"---");
        System.out.println(assignment);
    }
    
    
}
