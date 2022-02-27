package CanvasProject;

public class Course {
    private String courseName;
    private static String courseCode;
    private String courseCreator;

    public Course(String courseName, String courseCode, String courseCreator) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCreator = courseCreator;
    }

    //setters
    public void setCourseName(String courseName){
        courseName = courseName;
    }
    public void setCourseCreator(String courseCreator){

        courseCreator = courseCreator;
    }
    public void setCourseCode(String courseCode){
        courseCode = courseCode;
    }

    //getters
    public static String getCourseCode() {
        return courseCode;
    }

    public String getCourseCreator() {
        return courseCreator;
    }

    public String getCourseName() {
        return courseName;
    }
}
