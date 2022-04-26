//MY CANVA C++ PROJCECT

#include <string>
#include <iostream>
using namespace std;

//CANVAS CLASS
class Canvas
{
public:
  
  //GLOBAL VARIABLES
  string email, username, emailverify, password, mailAdminVerify, mailFacultyVerify;
  string firstName, FacultyEmail, lastName, yearGroup, GPA, DoB, ID, secondMailAdminVerify;
  string courseCode, courseName;
  string keypass = "2023"; 
  string adminPass = "@aucampus.microsoft.co";
  
  //USERS WHO ARE ADMINS
  string UserOne = "roadham45@aucampus.microsoft.co";
  string UserTwo = "feliciab21@aucampus.microsoft.co";
  
  //USERS WHO ARE FACULTY
  string FaOne = "jessicaflie@ashesi.aucampus.microsoft.co";
  string FaTwo = "robert2332@ashesi.aucampus.microsoft.co";
  
  //1st method -- CREATEACCOUNT
  void createAccount ()
  {
    cout << "\nWelcome to Canvas, lets create an account for you";
    cout << "\nPlease enter your email: ";
    cin >> email;
    cout << "Please enter your password: ";
    cin >> password;
    cout << "\nUsername and password saved successfully";
    cout << "\nYour credentials are [" << email +
      "," << password + "]" << endl;
    this->login ();
  }
  
  //2nd method -- LOGIN
  void login ()
  {
    string emailTry, passwordTry;
    cout << "\nNow lets login with your credentials.\nEnter your email: ";
    cin >> emailTry;
    if (emailTry == email)
      {
	cout << "Please type in your password: ";
	cin >> passwordTry;
	if (passwordTry == password)
	  {
	    cout << "\nLogin successful";
	  }
	else
	  {
	    cout << "\nError logging in! Please try again.";
	  }
      }
    else
      {
	cout << "\nError logging in! Please try again.";
      }
  }

  //3rd method -- UPDATEPROFILE
  void updateProfile ()
  {
    cout << "Enter your access key pass: ";
    cin >> ID;
    //if ID not equal to keypass, login to canvas
    if(ID != keypass)
      {
      cout <<"\nInvalid ID";
      this->login(); //LOGIN REQUIRED
      }else{
          //if done, profile will continue to update.
        cout << "Access key successful";
        cout << "\nUpdating your profile\nPlease enter your first name: ";
        cin >> firstName;
        cout << "Please enter your last name: ";
        cin >> lastName;
        cout << "Your year group: ";
        cin >> yearGroup;
        cout << "Your current GPA: ";
        cin >> GPA;
        cout << "Your date of Birth: ";
        cin >> DoB;
        cout << "\nProfile Updated successfully";
        
        this->viewProfile();
      }
  }
  
  //4th method -- VIEWPROFILE
  void viewProfile() {
      string emailTest;
      cout <<"\n\nYou want to view your profile?";
      cout << "\nEnter your access key pass: ";
      cin >> ID;
      if(ID != keypass)
      {
      cout <<"\nInvalid ID";
      this->login();//LOGIN REQUIRED
      }else{
      cout << "\nAccess key successful";
      cout << "\nEnter your email: ";
      cin >> emailTest;
      cout << "Enter your email AGAIN: ";
      cin >> emailverify;
      if(emailTest == emailverify){
          cout<< "\nSecurity Check Successful";
          cout<< "\nDisplaying updates";
          cout<< "\nFirst name: " << firstName;
          cout<< "\nLast name: " << lastName;
          cout<< "\nYear Group: " << yearGroup;
          cout<< "\nYour current GPA: " << GPA;
          cout<< "\nYour date of birth: " << DoB;
      }
  }
  
  }
  
  //5th method -- ISADMIN
  void isAdmin(){
      cout << "Enter your email to confirm Admin user: ";
      cin >> mailAdminVerify;
      //if mailAdminVerify is not the same as registered user one and two,
      //it would be false,otherwise
      if((mailAdminVerify == UserOne) || (mailAdminVerify == UserTwo)){
        cout << "Verification: True.";
      }else{
          cout << "Verification: False.";
          cout << "\nPlease try again.";
      }
     
  }
  
  //6th method -- MAKEFACULTY
  void makeFaculty(){
      cout << "\nYou want to be assigned a Faculty?";
      cout << "\nEnter your email: ";
      cin >> secondMailAdminVerify;
      if(secondMailAdminVerify != adminPass){
          cout << "Error reassigning, Please log in";
          this->login(); //LOGIN REQUIRED
          this->isAdmin(); //ADMIN REQUIRED
      }else{
          cout << "Verification successful";
          cout << "\nYou are now Faculty";
      }
  }
  
  //7th method --ISFACULTY
  void isFaculty(){
      cout << "Enter your email to confirm Faculty user: ";
      cin >> mailFacultyVerify;
      if((mailFacultyVerify == FaOne) || (mailFacultyVerify == FaTwo)){
        cout << "Verification: True.";
      }else{
          cout << "Verification: False.";
          cout << "\nPlease try again.";
      }
  }
  
  //8th method -- CREATECOURSE
  void createCourse(){
      cout << "Enter your access key pass: ";
    cin >> ID;
    if(ID != keypass)
      {
      cout <<"\nInvalid ID";
      this->login(); //LOGIN REQUIRED
      this->isFaculty(); //FACULTY ROLE REQUIRED
      }else{
        cout << "Access key successful";
        cout << "\nCreating a course...\nPlease enter your faculty role email: ";
        cin >> FacultyEmail;
        cout << "Please enter the course code: ";
        cin >> courseCode;
        cout << "The name of the course: ";
        cin >> courseName;
        cout << "\nCourse created successfully";
  }
}


};

//9th method -- MAIN METHOD
int
main ()
{
  Canvas run;
  run.createCourse();
  return 0;
}
