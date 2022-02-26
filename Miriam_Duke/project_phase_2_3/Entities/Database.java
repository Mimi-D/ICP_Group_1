package Entities;

import java.util.ArrayList;

public class Database {


    // Arraylists to store data
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Admin> admins = new ArrayList<>();
    ArrayList<Faculty> faculties = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();


    public void addUser(User user){
        users.add(user);
    }

    public void addAdmin(Admin admin){
        admins.add(admin);
    }

    public void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addCourse(Course course){
        courses.add(course);
    }



}
