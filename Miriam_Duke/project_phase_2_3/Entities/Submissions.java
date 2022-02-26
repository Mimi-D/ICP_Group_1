package Entities;

public class Submissions {
    private String email,assName,submission;
    private int score = -1;

    // When score is not set at all initial value is -1, a student can get 0

    public Submissions(String email,String assName,String submission){
        this.email = email;
        this.assName = assName;
        this.submission = submission;
    }
    /**
     * @return the submission
     */
    public String getSubmission() {
        return submission;
    }

    /**
     * @param submission the submission to set
     */
    public void setSubmission(String submission) {
        this.submission = submission;
    }
    /**
     * @return the assName
     */
    public String getAssName() {
        return assName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param assName the assName to set
     */
    public void setAssName(String assName) {
        this.assName = assName;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }


}
