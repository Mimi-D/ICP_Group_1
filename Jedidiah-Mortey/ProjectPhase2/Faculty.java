/**
 * 
 */
package icpProject.lms;

import java.util.HashMap;

/**
 * @author Jedidiah M
 *
 */
public class Faculty extends Account implements FacultyInterface{
	HashMap<String, Course> coursesCreated = new HashMap<String,Course>();
	@SuppressWarnings("unused")
	private boolean isCerti;
	
	private String firstName,lastName,fullName;
	private String doB;
	final private String cGPA = "N/A";
	final private String yearGroup = "N/A";
	
	public Faculty(String email, String pword) {
		super(email, pword);
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName() {
		this.fullName = this.firstName + " " + this.lastName;
	}
	public String getDoB() {
		return doB;
	}
	public void setDoB(String doB) {
		this.doB = doB;
	}
	public String getcGPA() {
		return cGPA;
	}
	
	public String getYearGroup() {
		return yearGroup;
	}

	@Override
	public Course createCourse(String courseCode, String courseName) {
		Course courseObject = new Course(courseCode, courseName, this);
		coursesCreated.put(courseCode, courseObject);
		return courseObject;
		
	}
	
	void makeFaculty() {this.isCerti = true;}
	
	@Override
	public String toString() {
		return  "Full Name: "+ this.fullName + "\nYear Group: N/A\n"+ "Current GPA: N/A\n" +
				"Date of Birth: "+ this.doB.toString();
	}
	
	
}
