package CanvasProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {

    private String email;

    // This is an array to store emails created
    ArrayList<String> account = new ArrayList<>();

    // Array for storing registered courses
    ArrayList<String> RegCourse = new ArrayList<>();

    int role = 0; //0=user, 1=faculty

    public void makeFaculty() {
        Scanner sc = new Scanner(System.in);
        //Ask the user to input their email
        System.out.print("Enter your email: ");
        this. email = sc.nextLine();

        if (account.contains(email)) {
            this.role = 1;
            System.out.println("Great! your new role : Faculty");
        }

    }

    //register courses
    public void registerCourse() {
        System.out.println("____Register Course____");
        if (this.login()) {
            Scanner sc = new Scanner(System.in);

            //Ask the user to input their email
            System.out.print("Enter your email: ");
            this.email = sc.nextLine();

            //Ask the user to input the course code
            System.out.print("Enter the course code: ");
            String CourseC = sc.nextLine();

            RegCourse.add(email);
            RegCourse.add(CourseC);



        }

    }
}

