// BuildingCanvas.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string>
#include <list>
#include <map>

using namespace std;

// Global variables
//data stores
map<string, Account> accounts = {};

map<string, course> courses;

// Active account
string activeAccount;


// Methods

void createAccount(string email, string password);
// create an account using email and password
// store the account details in map with email as key and
// account object as value

void login(string email,string password); 
// Take email and password. Check if email is a key in account map
// Confirm if password is the same. If so set active account to
// Corresponding account value in map.

void updateProfile(string firstName, string lastName,string role,string yearGroup,string DOB, float CGPA); 
//take various details of the user and put them in corresponding fields
// in the active account object. Replace the object in the accounts map
// with active account to update details

void viewProfile(string email);
// using email, find the email key value and display account information

bool isAdmin(string email);
// use the email to find the profile of user and check if role is ADMIN
void makeFaculty(string email);

bool isFaculty(string email);       //7
void createCourse(string courseName,string courseCode,string creatorEmail);

// DataStructures and classes

struct course {
public:
    string courseName;
    string courseCode;
    string creatorEmail;
};

class Account
{
    //login details
    string email;
    string password;

    //account details
    string fullName;
    string Role;
    string yearGroup;
    string dOB;
    float CGPA = 0.0;

    
public:
    Account(string email, string password)
    {
        this->email = email;
        this->password = password;
    }

    void setName(string firstName, string lastName)
    {
        this->fullName = firstName + " " + lastName;
    }

    void setYearGroup(string yGrp)
    {
        this->yearGroup = yGrp;
    }

    void setDOB(string dOB)
    {
        this->dOB = dOB;
    }

    void setCGPA(float CGPA)
    {
        this->CGPA = CGPA;
    }


    void displayProfile() 
    {
        cout << "Name:\t" << this->fullName << endl;
        cout << "Role:\t" << this->Role << endl;
        cout << "Year Group:\t" << this->yearGroup << endl;
        cout << "Date Of Birth: \t" << this->dOB << endl;
        cout << "CGPA:\t" << this->CGPA << endl;

    }

    void setRole(string role)
    {
        this->Role = role;
    }

    string getPass()
    {
        return this->password;
    }

    string getEmail()
    {
        return this->email;
    }

};



int main()
{
    cout << "=============================Building with Canvas=============================" << endl;
    cout << "------------------------------------------------------------------------------" << endl;

    createAccount("someone@example.domain","password1");
    login("","");
    login("someone@example.domain", "password1");


    system("pause>0");
}



// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file

void createCourse(string courseName, string courseCode, string creatorEmail)
{
    course aCourse;
    aCourse.courseCode = courseCode;
    aCourse.courseName = courseName;
    aCourse.creatorEmail = creatorEmail;
    
    courses[courseCode] = aCourse;
}

void createAccount(string email, string password)
{
    bool dne = accounts.find(email) == accounts.end();
    Account newAccount(email, password);
    if (dne)
    {
        accounts[email] -> newAccount;
        cout << "Account created.";
    }
    else
    {
        cout << "This email is already in use" << endl;
    }
    
    
    
}

void login(string email, string password)
{
    bool dne = accounts.find(email) == accounts.end();
    if (dne)
    {
        cout << "This account does not exist.";
    }
    else
    {
        Account* emailMatch = accounts[email];
        if (password != emailMatch->getPass())
        {
            cout << "Wrong password!";
        }
        else
        {
            activeAccount = email;
            cout << "You're welcome";
        }
    }
}

void updateProfile(string firstName, string lastName,string role, string yearGroup, string DOB, float CGPA)
{
    accounts[activeAccount].setName(firstName, lastName);
    accounts[activeAccount].setYearGroup(yearGroup);
    accounts[activeAccount].setCGPA(CGPA);
    accounts[activeAccount].setDOB(DOB);
    accounts[activeAccount].setRole(role);

    accounts[activeAccount]->displayProfile();


}

void viewProfile(string email)
{
    bool dne = accounts.find(email) == accounts.end();
    if (dne)
    {
        cout << "This account does not exist.";
    }
    else
    {
        accounts[email]->displayProfile();
    }
}

bool isAdmin(string email)
{
    if (accounts[email].getRole() != "ADMIN")
    {
        return true;
    }
    return false;
}

void makeFaculty(string email)
{
    accounts[email].setRole("FACULTY");
}

bool isFaculty(string email)
{
    if (accounts[email].getRole() != "FACULTY")
    {
        return true;
    }
    return false;
}



