#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;

/*
The name of the program
**/
#ifndef _CANVAS_ // header guards to avoid multiple inclusion
#define _CANVAS_

string email;
string password;
string email1;
string password1;
string email3;
string password3;
string emailx;
string email4;
string Email;
bool roleOfFaculty = 0;

map<string, vector<string>>::iterator i;

// This is a map to store emails created
map<string, string> bank;

// This is a map for storing a user's profile
vector<string> Profile;

/// This is a vector for storing a user's updated profile
map<string, vector<string>> UpdatedProfile;


// This is a vector for storing admin emails
vector<string> admin;


// This is a vector for storing faculty emails
vector<string> faculty;



class Canvas{ 
    // details required for student profile
    private:
        string firstname;
        string lastname;
        string yeargroup;
        string currentGPA;
        string dob;
        string email2;
    // users can create accounts 

    public:
    void CreateAccount(){

        cout <<"____CREATE AN ACCOUNT____\n";
        cout<< "\n";
        // ask users to enter their email
        cout << "Enter your email: ";
        cin >> email;

        cout<< "\n";

        // ask users for their password
        cout <<"Enter your password: ";
        cin >> password;
        bank.insert(std::pair <std::string, std::string> (email, password));
        cout << "\n";
        cout<<"Account Created! " ;

    }
    bool login(){
      
        cout<<"___LOGIN HERE___\n";
        cout<< "\n";
        // ask users to enter their email
        cout << "Enter your email: ";
        cin >> email1;

        cout<< "\n";

        // ask users for their password
        cout <<"Enter your password: ";
        cin >> password1;
        for(std::pair <std::string, std::string> details: bank){
            string key = details.first;
            string value = details.second;
            if (email1 == key && password1 == value) {
                return true;
            }
            return false;
        }

    
    }
    void UpdateProfile(){
        if (login()==true) {
            cout<<"___UPDATE PROFLIE___";

            cout<< "\n";
         // ask users to enter their firstname
            cout << "Enter your firstname: ";
            cin >> firstname;

            cout<< "\n";

            // ask users for their lastname
            cout <<"Enter your lastname: ";
            cin >> lastname;  

            cout<< "\n"; 

            // ask users for their year group
            cout <<"Enter your year group: ";
            cin >> yeargroup;  

            cout<< "\n"; 

            // ask users to enter their current GPA
            cout << "Enter your current GPA: ";
            cin >> currentGPA;

            cout<< "\n";

            // ask users for their dob
            cout <<"Enter your date of birth : ";
            cin >> dob;

            //store the details of the student into the vector Profile    

            Profile.push_back(firstname);
            Profile.push_back(lastname);
            Profile.push_back(yeargroup);
            Profile.push_back(currentGPA);
            Profile.push_back(dob);

            // stores the profile of the user into the UpdateProfile map and  update their details accordingly
            UpdatedProfile.insert(pair<string, vector<string>> (email, Profile));
        }
    }
    void ViewProfile(){
        if(login()==true){
            cout<<"___VIEW PROFILE___";

            cout<< "\n";

            //ask the user to enter their email

            cout << "Enter your email: ";
            cin >> email2;
            //loop through UpdatedProfile to check if the email is the same and prints out the stored data on a new line
            for (i = UpdatedProfile.begin(); i != UpdatedProfile.end(); i++) {
                if (i -> first == email2) {
                    for (auto j : Profile) {
                        cout << j << "\n";
                    }
                }
                
            }


        }

    }

    // a helper function for the isAdmin() class
    void CreateAdmin(){
        if(login()== true){

            // ask users to enter their email
        cout << "Enter the email: ";
        cin >> email3;

        admin.push_back(email3);
        }   
    }

    bool isAdmin(){

        // ask users to enter their email
        cout << "Enter the email: ";
        cin >> emailx;
          
         //loops through the vector admin and if true makes the user an admin 
        for (auto i : admin) {
            if(emailx == i){
                cout<< "\n";
                cout<<"Congratulations you are an admin!";
                return true;
            }
        }
        cout<<"Oops you are not an admin!";
        return false; 
    }

    void makeFaculty(){
        if(login()==true){
            if(isAdmin()==true){

                // ask users to enter their email

                cout << "Enter the email: ";
                cin >> email4;

               faculty.push_back(email4);
               cout<<"You are now a faculty member";

            }
        }
    }

    bool isFaculty(){
        // ask users to enter their email
        cout << "Enter the email: ";
        cin >> Email;

        //loops through the vector faculty and if true, returns a faculty member
        for (auto i : faculty) {
            if(Email == i){
                roleOfFaculty = 1;
                cout<<"Confirmed, you are now a Faculty member!";
                return true;
            }
        }
        cout<<"Oops you are not a faculty member!";
        return false; 
    }
};
#endif //canvas

#ifndef _ADMIN_
#define _ADMIN_

class Admin : public Canvas {
    public:
     void makeFaculty(){
        if(login()==true){
            if(isAdmin()==true){

                // ask users to enter their email

                cout << "Enter the email: ";
                cin >> email4;

               faculty.push_back(email4);
               cout<<"You are now a faculty member";

            }
        }
    }

};
#endif // admin

int main() {
    // create an object of the Canvas class
    Canvas myPage;
    myPage.CreateAccount(); 
     /**myPage.login();
    myPage.UpdateProfile();
    myPage.ViewProfile();
    myPage.isAdmin();
    myPage.isFaculty();*/

    // create an object of the Canvas class

    Admin adminPage;
    adminPage.makeFaculty();

   

    return 0;
}