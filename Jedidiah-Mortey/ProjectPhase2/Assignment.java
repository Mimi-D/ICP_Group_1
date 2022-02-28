/**
 * 
 */
package icpProject.lms;

/**
 * @author Jedidiah M
 *
 */
public class Assignment {
	
	enum assignmentType {QUIZ,HOMEWORK,PROJECT,EXAM};
	
	private String courseCode;
	private String dueDate;
	private assignmentType assgtType;
	private String description;
	private Faculty courseCreator;

	
	public Assignment(String courseCode,Faculty aFaculty, assignmentType type, String dueDate, String description) {
		// Constructor for the assignment.
		
		/*
		 *  populate the fields as required
		 */
		
		this.courseCode = courseCode; this.dueDate = dueDate; this.description = description;
		this.courseCreator = aFaculty;
	
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public assignmentType getAssgtType() {
		return assgtType;
	}

	public void setAssgtType(assignmentType assgtType) {
		this.assgtType = assgtType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Faculty getCourseCreator() {
		return courseCreator;
	}

	public void setCourseCreator(Faculty courseCreator) {
		this.courseCreator = courseCreator;
	}
	
	
	
	
}
