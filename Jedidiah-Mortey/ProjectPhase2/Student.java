/**
 * 
 */
package icpProject.lms;

import java.io.File;
import java.util.HashMap;

/**
 * @author Jedidiah M
 *
 */
public class Student extends Account{
	private String firstName,lastName,fullName;
	private String doB;
	private String cGPA = "N/A";
	private String yearGroup = "N/A";
	final private String role = "Student";
	
	HashMap<String,Course> registeredCourses = new HashMap<String,Course>();

	public Student(String email, String pword) {
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

	public void setFullName(String fullName) {
		this.fullName = this.firstName+" "+this.lastName;
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

	public void setcGPA(String cGPA) {
		this.cGPA = cGPA;
	}

	public String getYearGroup() {
		return yearGroup;
	}

	public void setYearGroup(String yearGroup) {
		this.yearGroup = yearGroup;
	}

	void registerCourse(String courseCode) {}
	static void submitAssignment(File aFIle) {}
	
}
