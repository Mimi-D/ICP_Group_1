package Entities;

public class Assignment {

    // Instance variables
    protected String lecturerEmail;
    protected String courseCode;
    protected String assignmentName;
    protected String assignmentDescription;
    protected String dueDate;
    protected String assignmentType;

    public Assignment(){    }

    public Assignment(String mail, String code, String name, String description,String due,String type){
        lecturerEmail = mail;
        courseCode = code;
        assignmentName = name;
        assignmentDescription = description;
        dueDate = due;
        assignmentType = type;
    }
    /**
     * @return the lecturerEmail
     */
    public String getLecturerEmail() {
        return lecturerEmail;
    }

    /**
     * @return the courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * @return the assignmentName
     */
    public String getAssignmentName() {
        return assignmentName;
    }

    /**
     * @return the assignmentDescription
     */
    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    /**
     * @return the dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * @return the assignmentType
     */
    public String getAssignmentType() {
        return assignmentType;
    }

    /**
     * @param lecturerEmail the lecturerEmail to set
     */
    public void setLecturerEmail(String lecturerEmail) {
        this.lecturerEmail = lecturerEmail;
    }

    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * @param assignmentName the assignmentName to set
     */
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    /**
     * @param assignmentDescription the assignmentDescription to set
     */
    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @param assignmentType the assignmentType to set
     */
    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }


}
