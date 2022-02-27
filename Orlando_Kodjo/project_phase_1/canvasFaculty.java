import java.util.Scanner;
public class canvasFaculty extends canvasUser{

    boolean isCourseCreator = false; 

    public canvasFaculty(){
        super();
    }

    public canvasFaculty(String Email){
        super(Email);
    }

    public canvasFaculty(String Email, String PassWord){
        super(Email, PassWord);
    }
    

    public void setIsCourseCreator(){
        isCourseCreator= true;
    }

    public void createCourse(){
        Scanner courseScanner = new Scanner(System.in);
        System.out.println("Enter Course Name: ");
        String courseNameString = courseScanner.nextLine();

        Scanner courseCodeScanner = new Scanner(System.in);
        System.out.println("Enter Preferred Course Code: ");
        String courseCodeString = courseCodeScanner.nextLine();

        Scanner courseCreatorScanner = new Scanner(System.in);
        System.out.println("Enter Course  creator email: ");
        String courseCreatorString = courseCreatorScanner.nextLine();

        System.out.println("Course successfully created!");
        canvasCourses newCourse = new canvasCourses(courseCreatorString,courseNameString,courseCodeString);

        projectPhase1.listOfCoursesObj.add(newCourse);
    } 
}
