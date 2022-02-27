package CanvasProject;

import java.util.Set;

public class Assignment {

    // a list is created for the assignment type
    private static final Set<String> ASS_TIES = Set.of("QUIZ", "HOMEWORK", "PROJECT", "EXAM");

    private enum AssignmentType {QUIZ, HOMEWORK, PROJECT, EXAM};
    private AssignmentType assignmentType;


    private String AssignmentName;
    private String AssignmentDescription;
    private String AssignmentDueDate;
    private static String AssignmentType = String.valueOf(ASS_TIES);
    public static String AssignmentCourseCode = Course.getCourseCode();


    public Assignment(String AssignmentName, String AssignmentDescription, String AssignmentDueDate, String AssignmentType, String AssignmentCourseCode, String assTy) {
        this.AssignmentName = AssignmentName;
        this.AssignmentDescription = AssignmentDescription;
        this.AssignmentDueDate = AssignmentDueDate;
        this.AssignmentType = AssignmentType;
        this.AssignmentCourseCode = AssignmentCourseCode;
    }

    public String getAssignmentName() {
        return AssignmentName;
    }

    public String getAssignmentDescription() {
        return AssignmentDescription;
    }

    public String getAssignmentDueDate() {
        return AssignmentDueDate;
    }

    public String getAssignmentCourseCode() {
        return AssignmentCourseCode;
    }

    public AssignmentType getAssignmentType() {
        return this.assignmentType;

    }

    public void setAssignmentType(AssignmentType assignmentType){
        this.assignmentType = assignmentType;
    }

}
