#include <iostream>
using namespace std;

class User {       // The User class
  private:         // Access specifier, class variables are being declared private
    string email;
    string password;
    string firstName;
    string lastName;

  public:              // Access specifier
    void createAccount() {  // Method to create a new account
        cout <<"\n\n__________CREATE  ACCOUNT_________ " ;

        cout <<"\nPlease enter your email: " ;
        cin >> email;

        cout <<"\nPlease enter your password: " ;
        cin >> password;

        cout <<"\nPlease enter your first name: " ;
        cin >> firstName;

        cout <<"\nPlease enter your last name: " ;
        cin >> lastName;

        cout <<"\n____________ ACCOUNT CREATED_______________" ;

    }


// Getters and setters to access/modify private variables

    public:
    // Setter for email
    void setEmail(string mail) {
      email = mail;
    }
    // Getter for email
    string getEmail() {
      return email;
    }

    public:
    // Setter for password
    void setPassword(string p) {
      password = p;
    }
    // Getter for password
    string getPassword() {
      return password;
    }

    public:
    // Setter for firstName
    void setFirstName(string fn) {
      firstName = fn;
    }
    // Getter for firstName
    string getFirstName() {
      return firstName;
    }

    public:
    // Setter for lastName
    void setLastName(string ln) {
      lastName = ln;
    }
    // Getter for lastName
    string getLastName() {
      return lastName;
    }
    
};



//Faculty class derived from User class 
class Faculty: public User {
  
};

//Student class derived from User class 
class Student: public User {

// private clas variables
string DOB;
int yearGroup = 0;
double GPA = 0.0;


// Getters and setters to access/modify private variables
   public:
    // Setter for GPA
    void setGPA(double grade) {
      GPA = grade;
    }
    // Getter for GPA
    double getGPA() { 
      return GPA;
    }

    public:
    // Setter for Year group
    void setYearGroup(int grp) {
      yearGroup = grp;
    }
    // Getter for year group
    int getYearGroup() {
      return yearGroup;
    }

    public:
    // Setter for DOB
    void setDOB(string date) {
      DOB = date;
    }
    // Getter for DOB
    string getDOB() {
      return DOB;
    }

    // This method updates student profile
    public:
    Student updateProfile(Student student) {
     
      cout <<"\nKINDLY UPDATE YOUR PROFILE: " ;

       // Local variables to hold input from user before setting
        string tempMail;
        string tempFN;
        string tempLN;
        string tempDOB;
        string tempPWD;
        int tempYG;
        double tempGPA;

        // Setters are used because the variables are declared private in parent class
        cout <<"\nPlease enter your email: " ;
        cin >> tempMail;
        student.setEmail(tempMail);

        cout <<"\nPlease enter your password: " ;
        cin >> tempPWD;
        student.setPassword(tempPWD);

        cout <<"\nPlease enter your first name: " ;
        cin >> tempFN;
        student.setFirstName(tempFN);

        cout <<"\nPlease enter your last name: " ;
        cin >> tempLN;
        student.setLastName(tempLN);

        cout <<"\nPlease enter your Date of Birth: " ;
        cin >> tempDOB;
        student.setDOB(tempDOB);

        cout <<"\nPlease enter your Year Group: " ;
        cin >> tempYG;
        student.setYearGroup(tempYG);

        cout <<"\nPlease enter your GPA: " ;
        cin >> tempGPA;
        student.setGPA(tempGPA);

        cout <<"\n____________ ACCOUNT UPDATED_______________" ;

        return student;
    }


    // This method is to view the student profile
    public:
    void viewProfile(Student student) {
        cout <<"\nYour information: ";
        cout <<"\n Email: " << student.getEmail();
        cout <<"\n First Name: " << student.getFirstName();
        cout <<"\n Last Name: " << student.getLastName();

        if(student.getDOB() == ""){cout <<"\n Date of birth: N/A ";}
        else{cout <<"\n Date of birth: " << student.getDOB();}

        if(student.getYearGroup() == 0){cout <<"\n Year Group: N/A ";}
        else{cout <<"\n Year Group: " << student.getYearGroup();}

        if(student.getGPA() == 0.0){cout <<"\n GPA: N/A ";}
        else{cout <<"\n GPA: " << student.getGPA();}

    }

};


// This class stores information of the Users in arrays
class Database {

    User users[50] = {};    // Users array
    Faculty faculty[20] = {};     // Faculty array
    Student students [30] = {}; // Student array
    string admins[50][2] = {}; // admins array
    string courses[50][3] = {}; // Courses array
    
    // Variables To keep count of array size
    public:
        int size =  0;     //  keeps track of users array size
        int size1 = 0;     //  keeps track of faculty array size
        int size2 = 0;     //  keeps track of students array size
        int size3 = 0;    //  keeps track of admin array size
        int size4 = 0; // keeps track of courses array size

    // The login method to login
    public:
      bool login(){

        string mail;
        string pw;

        cout <<"\n\n__________LOGIN_________ " ;
        cout <<"\nPlease enter your email: " ;
        cin >> mail;

        cout <<"\nPlease enter your password: " ;
        cin >> pw;

        // Crosscheck provided details with contents of the database
        for (int i = 0; i < size; i++) {
              if (users[i].getEmail().compare(mail) == 0 && users[i].getPassword().compare(pw) == 0){
                cout <<"\n_______LOGGED IN________" ;
                return true;
              }
          }
          cout <<"\nINVALID USERNAME OR PASSWORD" << endl;
          return false;
      }

  // The update profile method from the student class is called here
  public:
  void updateStudentProfile(){
        cout <<"\n\n____________ UPDATE PROFILE_______________" ;
        cout <<"\nLOGIN REQUIRED" ;
        string mail;
        string pw;
        Student st;

        cout <<"\nPlease enter your email: " ;
        cin >> mail;

        cout <<"\nPlease enter your password: " ;
        cin >> pw;

        // Crosscheck provided details with contents of the database
        for (int i = 0; i < size2; i++) {
              if (students[i].getEmail().compare(mail) == 0 && students[i].getPassword().compare(pw) == 0){
                cout <<"\n_______LOGGED IN________" ;
                students[i] = st.updateProfile(students[i]);
                return;
              }
          }
          cout <<"\nINVALID USERNAME OR PASSWORD" << endl;


  }


  // The view profile method from the student class is called here
  public:
  void viewStudentProfile(){

    cout <<"\n\n____________ VIEW PROFILE_______________" ;
        cout <<"\nLOGIN REQUIRED" ;
        string mail;
        string pw;
        Student st;

        cout <<"\nPlease enter your email: " ;
        cin >> mail;

        cout <<"\nPlease enter your password: " ;
        cin >> pw;

        // Crosscheck provided details with contents of the database
        for (int i = 0; i < size2; i++) {
              if (students[i].getEmail().compare(mail) == 0 && students[i].getPassword().compare(pw) == 0){
                cout <<"\n_______LOGGED IN________" ;
                st.viewProfile(students[i]);
                return;
              }
          }
          cout <<"\nINVALID USERNAME OR PASSWORD" << endl;

  }

  // This method checks if a user is an admin
  public:
  bool isAdmin(string mail) { 
            // Crosscheck provided details with contents of the database
        for (int i = 0; i < size3; i++) {
              if (admins[i][0].compare(mail) == 0){
                cout <<"\n_______ADMIN VERIFIED________" ;
                return true;
              }
          }
          cout <<"\n NOT ADMIN" << endl;
          
          return false;
  }

  // login methods for admins
  bool adminLogin(string mail,string pw){

        for(int i = 0; i < size3; ++i){ 
           if (admins[i][0].compare(mail) == 0 && admins[i][1].compare(pw) == 0){
                cout <<"\n_______LOGGED IN________" ;
                return true;
              }
    }
    return false;

  }


// This method verifies is a user is a faculty
  public:
  bool isFaculty(string mail) { 
            // Crosscheck provided details with contents of the database
        for (int i = 0; i < size1; i++) {
              if (faculty[i].getEmail().compare(mail) == 0){
                cout <<"\n_______FACULTY VERIFIED________" ;
                return true;
              }
          }
          cout <<"\n NOT FACULTY" << endl;
          
          return false;
  }

public:              // This function adds a user to the user array
    void addUser(User user){ 
        users[size++] = user; 
         }

public:              // This function adds a faculty to the faculty array
    void addFaculty(Faculty fac){ 
        faculty[size1++] = fac; 
         }  

public:              // This function adds a student to the student array
    void addStudent(Student stu){ 
        users[size++] = stu;
        students[size2++] = stu; 
         } 

public:              // This function adds an admin to the admin array
    void addAdmin(string mail,string pw){ 
        int s = size3++;
        size3++;
        admins[s][0] = mail;
        admins[s][1] = pw;
         } 

    // this function adds a course to the list of courses
    void addCourse(string mail,string name,string code){
        int s = size4++;
        size4++;
        courses[s][0] = mail;
        courses[s][1] = name;
        courses[s][2] = code;

    }

// Methods to get the size for user,student, faculty and admins arrays
public:
  int getSize() {
      return size;
    }

public:
  int getSize1() {
      return size1;
    }     

public:
  int getSize2() {
      return size2;
    }    

public:
  int getSize3() {
      return size3;
    } 


// method to make a user a faculty
void makeFaculty(){
      cout <<"\nADMIN LOGIN REQUIRED" ;
        string mail;
        string facmail;
        string pw;

        cout <<"\nPlease enter your email: " ;
        cin >> mail;

        cout <<"\nPlease enter your password: " ;
        cin >> pw;

        // verify admin log in
        if(adminLogin(mail,pw) == 1){
           cout <<"\nPlease enter faculty email: " ;
           cin >> facmail;

          for (int i = 0; i < size; i++) {
              if (users[i].getEmail().compare(facmail) == 0){
                Faculty newFaculty;  // Create an object of Faculty class
                newFaculty.setEmail(users[i].getEmail());
                newFaculty.setPassword(users[i].getPassword());
                newFaculty.setFirstName(users[i].getFirstName());
                newFaculty.setLastName(users[i].getLastName());
                addFaculty(newFaculty);  // add faculty to faculty arrya
                cout <<"\n_______SUCCESSFUL________" ;      
        
        }
        }
        }

        else{cout << "FAILED LOG IN" << endl;}

  }

  void createCourse(){

    string mail;
    string courseName;
    string courseCode;
    cout<<"\nFACULTY LOGIN";  
    if(login()==1){
        cout <<"\nPlease enter your email again: " ;
        cin >> mail;
        if(isFaculty(mail)){
          cout <<"\nEnter Course Name: " ;
          cin >> courseName;

          cout <<"\nEnter Course Code: " ;
          cin >> courseCode;
          addCourse(mail,courseName,courseCode);   //add new course to the courses array
          cout <<"\n______COURSE ADDED_____ " ;

        }
    }

  }
           
};


int main() {

  User newUser;  // Create an object of User class
  Student newStudent; // Create an object of Student class
  Database Dbase;    // Create an object of Database class

  cout<<"Create a student account for the demo";  
  newStudent.createAccount();

  Dbase.addUser(newUser);
  Dbase.addStudent(newStudent);

  Dbase.viewStudentProfile();
  Dbase.updateStudentProfile();
  Dbase.viewStudentProfile();

  Dbase.addAdmin("Lovely","pass");
  Dbase.isAdmin("Lovely");

  cout<<"Create a faculty account for the demo";  
  newUser.createAccount();
  Dbase.makeFaculty();
  Dbase.createCourse();
  return 0;
}