package Entities;

import java.util.Scanner;

public class Admin extends User implements Interfaces.Admin {

    public Admin(String email, String password){
        // Use parent class parameterized constructor
        super(email,password);
    }

    public Admin(String email, String password,String fName, String lName) {
        // Use parent class parameterized constructor
        super(email, password, fName, lName);
    }


    // Function to make user a faculty
    public void makeFaculty(Database database) {
        System.out.print("\n");
        System.out.print("To make Faculty, you must be an admin, kindly login first: \n");

        Scanner getDets = new Scanner(System.in);  // Create a Scanner object

        // Ask user for input
        System.out.print("Enter Email: ");
        String Email = getDets.nextLine();

        System.out.print("Enter Password: ");
        String Password = getDets.nextLine();

        // Verify login
        if (login(Email, Password, database)) {

            // If user is an admin
            if(isAdmin(Email,database)){
                // Get user's email to make faculty
                System.out.print("Enter User's Email: ");
                String mail = getDets.nextLine();

                // Check if email entered belongs to a user in database
                for (User user : database.users) {
                    if (mail.equals(user.getEmail())){
                        // Make faculty
                        Faculty newFalc = new Faculty(mail, user.getPassword(), user.getFirstName(), user.getLastName());
                        database.addFaculty(newFalc);
                        System.out.println(mail + " has been given Faculty privileges");
                        return;
                    }
                }
                System.out.println("User's email MUST be VALID!");
            }
            else{
                System.out.println("You MUST be an admin");
            }
        }
        else{
            System.out.println("INVALID username or password");
        }

    }
    // Getter and setters of parent class is inherited
}
