import java.util.ArrayList;

public class canvasAssignments {
    ArrayList <canvasSubmission> submissions = new ArrayList<>();
    String assignmentName;
    String assignmentDescription;
    String assignementGrade;
    String submissionDate;
    String assignmentType;

    public canvasAssignments(){};
    public canvasAssignments(String AssignmentName, String AssignmentDescription,String SubmissionDate, String AssignmentType){
        assignmentName = AssignmentName;
        assignmentDescription = AssignmentDescription;
        submissionDate= SubmissionDate;
        assignmentType=AssignmentType;
    }

    public void scoreAssignment(){

    }

    public void makeSubmission(canvasSubmission submissionString){
        submissions.add(submissionString);
    }

    public String getAssignmentName(){
        return assignmentName;
    }
}
