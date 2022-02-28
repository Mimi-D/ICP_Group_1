package icpProject.lms;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {
	private String courseCode;
	private String courseName;
	private FacultyInterface courseCreator;
	private ArrayList<Assignment> assignmentsCreated;
	HashMap<String, Student> registeredStudents = new HashMap<String,Student>();
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCoursCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public FacultyInterface getCourseCreator() {
		return courseCreator;
	}

	public void setCourseCreator(FacultyInterface courseCreator) {
		this.courseCreator = courseCreator;
	}

	public ArrayList<Assignment> getAssignmentsCreated() {
		return assignmentsCreated;
	}

	public void setAssignmentsCreated(ArrayList<Assignment> assignmentsCreated) {
		this.assignmentsCreated = assignmentsCreated;
	}

	public HashMap<String, Student> getRegisteredStudents() {
		return registeredStudents;
	}

	public void setRegisteredStudents(HashMap<String, Student> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}

	public Course(String courseCode, String courseName, FacultyInterface courseCreator) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseCreator = courseCreator;
	}
	
	
	@Override
	public String toString() {
		String str;
		str =  this.courseCode + " "+ this.courseName+":";
		for(HashMap.Entry<String, Student>entry:registeredStudents.entrySet()) {
			str = str + "\n"+entry.getKey() + " " + entry.getValue().getFullName();
		}
		return str;
		
	}
	
	
	
	
}
