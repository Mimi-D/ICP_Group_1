package Interfaces;

import Entities.Database;

public interface Faculty {
    public boolean isCourseCreator(String mail, String courseCode, Database database);
    public void createCourse(Database database);
    public void addAssignment(Database database);
    public void viewAssignmentsByCourse(Database database);
    public void viewSubmissions(Database database);
    public void scoreAssignment(Database database);
    public void viewAssignmentScores(Database database);
    public void viewAssignmentGrades(Database database);
}
