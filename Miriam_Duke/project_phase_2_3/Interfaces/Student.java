package Interfaces;

import Entities.Database;

public interface Student {

    public void updateProfile(Database database);
    public boolean findCourse(String course);
    public void registerCourse(Database database);
    public void viewProfile(Database database);
    public void submitAssignment(Database database);
    public void viewAssignmentScore(Database database);
    public void viewAllAssignmentScores(Database database);
    public void viewAssignmentGrade(Database database);
    public void viewAllAssignmentGrades(Database database);
}
