package Interfaces;

import Entities.Database;

public interface Course {
    public void viewCourses(Database database);
    public void viewCourseByCode(Database database);
    public void viewCoursesByEmail(Database database);
}
