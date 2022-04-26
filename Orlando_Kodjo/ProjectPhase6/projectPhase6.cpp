#include <iostream>
#include <vector>
#include <string>
using namespace std;


class canvasUser{
    public: 
    string userName; // This is a variable for user email 
    string userPassword; // This is a variable to hold user password 
    string gpa; // This holds the user's gpa which is not relevant to the administrator and faculty  
    string yearGroup;// this variable holds user's year group 
    bool Admin; // this variable is used to check if user is an Admin
    bool isFac; // varibale is used to set a faculty 
    string firstName; // holds user's first name 
    string lastName; // holds user's last name
    string DOB; // holds user's date of birth 

    // the following constructor is used to create a normal user 
    void canvasUserconst(string UserName, string UserPassword){ 
        userName=UserName;
        userPassword = UserPassword; 
        gpa = "null";
        yearGroup ="null";
        firstName = "null";
        lastName = "null";
        DOB = "null";
        Admin = false;
        isFac = false;
    }

    // the following constructor is used to create a normal user with additional parameters 
    void canvasUserconst1(string UserName, string UserPassword, double Gpa, string YearGroup){
        userName=UserName;
        userPassword = UserPassword; 
        gpa = Gpa; 
        yearGroup= YearGroup;
        firstName="null";
        lastName="null";
        DOB ="null";
    }

    // the following constructor is used to create an adminnistrator user 
    void canvasUserconstAdmin(string UserName, string UserPassword){
        userName=UserName;
        userPassword = UserPassword; 
        Admin = true;
        isFac = false;
        DOB = "null";
        firstName = "null";
        lastName ="null";
        yearGroup = "null";
        gpa = "null";
    }

    // this is basically a setter to set admin as true 
    void mAdmin(){
        Admin = true; 
    }

    // this is basically a setter to set isFac as true 
    void mFaculty(){
        isFac = true;
    }
};

// the following class is used to create a course in canvas 
class canvasCourse{
    public:
    string courseCode; // holds the course code of the course 
    string courseCreator; // keeps the name or a holder of the creator of the course 
    string courseName; // holds the name of the course 


    //A contructor to create an instance of the canvasCourse class as well set the variables 
    void canvasCourseConst(string CourseCode, string CourseName, string CourseCreator){
        courseCode = CourseCode; 
        courseName = CourseName; 
        courseCreator = CourseCreator; 
    }

};


//stroage unit for the varuious users created 
vector <class canvasUser> canvasUsers;

void makeAdmin(){
    canvasUser admin1;
    admin1.canvasUserconstAdmin("orlando.kodjo@ashesi.edu.gh", "ko");
}


 
// This function creates an instance of the canvasUser class and stores it in the vector or storage unit it takes in user input 
void createAccount(){
    string userName; 
    string userPassword; 

    cout << "Hello new user please enter your desired user email: ";
    cin >> userName ; 

    cout << "Hello new user please enter your desired password: ";
    cin >> userPassword;

    canvasUser user; 
    user.canvasUserconst(userName,userPassword);
    canvasUsers.insert(canvasUsers.end(),user);
}

//this function is used to verify user authentication, from already existing accounts, does so by taking user input 
bool login(){
    string userName; 
    string userPassword; 

    cout << "Please enter registered user email: "; 
    cin>> userName;

    cout << "Please enter corresponding password: ";
    cin >> userPassword; 
    try{
        for(int i=0; i<canvasUsers.size();i++){
        if(canvasUsers.at(i).userName==userName && canvasUsers.at(i).userPassword==userPassword){
            cout << "Login sucessful" <<endl;
            return true;
        }else{
            cout << "Login failed" <<endl;
            return false; 
        }
    }
    }catch(exception E){
        cout << "Login failed";
    }
    
    return false;
}

// this is a replicate of the initial login but with oparameters in order to allow for code reuse
bool login(string userName,string userPassword){

    try{
        for(int i=0; i<canvasUsers.size();i++){
        if(canvasUsers.at(i).userName==userName && canvasUsers.at(i).userPassword==userPassword){
            cout << "Login sucessful" <<endl;
            return true;
        }else{
            cout << "Login failed" <<endl;
            return false; 
        }
    }
    }catch(exception E){
        cout << "Login failed";
    }
    
    return false;
}

// This is a method used to check if user has access to the special capabilities offered the administrator 
bool isAdmin(canvasUser user){
    if(user.Admin){
        return true;
    }
    return false;
}

// this is a method designed to give certain users access to capabilities offered to those who belong in faculty 
void makeFaculty(){
    string userName; 
    string userPassword;
    string facultyToBe; 

    cout << "Please enter registered user email: " << endl;
    cin >> userName;

    cout << "Please enter corresponding password: " << endl;
    cin >> userPassword; 

    if(login(userName,userPassword)){
        try{
            for(int i; i<canvasUsers.size();++i){
            if(canvasUsers.at(i).userName == userName && canvasUsers.at(i).userPassword== userPassword){
                if(isAdmin(canvasUsers.at(i))){
                    cout << "Enter username of desired user to be made faculty: " << endl;
                    cin >> facultyToBe;
                    
                    for(int j; j>canvasUsers.size();i++){
                        if(canvasUsers.at(i).userName == facultyToBe){
                            canvasUsers.at(i).mFaculty();
                        }
                    }
                }
        }else{
           cout << "Process failed" << endl;
        }
    }
        }catch(exception e){
            cout << "Process failed" << endl;
        } 
    }
}

// This method verifies whether the user has access to the capoabilities of faculty members 
bool isFaculty(){
    string userName; 
    string userPassword;

    cout << "Please enter registered user email: " << endl;
    cin >> userName;

    cout << "Please enter corresponding password: " << endl;
    cin >> userPassword; 

    if(login(userName,userPassword)){
        try{
            for(int i; i<canvasUsers.size();++i){
                if(canvasUsers.at(i).userName == userName && canvasUsers.at(i).userPassword== userPassword){
                    if(canvasUsers.at(i).isFac){
                        return true;
                    }
                }
            }
        }catch(exception E){
            cout <<"Process failed";
            return false; 
        }
    }
    return false; 
}

// this method allows the user to set certain variables of the particular user
void updateProfile(){
    string userName; 
    string userPassword;
    

    cout << "Please enter registered user email: "<< endl;
    cin>> userName;

    cout << "Please enter corresponding password: "<<endl;
    cin >> userPassword;

    if(login(userName,userPassword)){
        for(int i=0; i<canvasUsers.size();++i){
            if(canvasUsers.at(i).userName == userName && canvasUsers.at(i).userPassword== userPassword){
                cout << "Enter user's first name: " << endl;
                cin >> canvasUsers.at(i).firstName;

                cout << "Enter user's last Name: " <<endl;
                cin >> canvasUsers.at(i).lastName; 

                cout << "Enter user's date of birth 29/06/1981: "<<endl;
                cin >> canvasUsers.at(i).DOB;

                cout << "Enter user's current GPA(in decimal 3.90): "<<endl;
                cin >> canvasUsers.at(i).gpa;

                cout << "Enter user's year group: "<<endl;
                cin >> canvasUsers.at(i).yearGroup;

            }

        }
    }

}

// this method allows for user to see predefined parameters of the user 
void viewProfile(){
    string userName; 
    string userPassword;
    
    cout << "Please enter registered user email: "<<endl;
    cin>> userName;

    cout << "Please enter corresponding password: "<<endl;
    cin >> userPassword;

    if(login(userName,userPassword)){
        for(int i = 0;i<canvasUsers.size(); i++){
            if(canvasUsers.at(i).userName == userName && canvasUsers.at(i).userPassword== userPassword){
                cout << "First Name: "+canvasUsers.at(i).firstName <<endl;
                cout << "Last Name: "+canvasUsers.at(i).lastName <<endl;
                cout << "Date of Birth: "+canvasUsers.at(i).DOB <<endl;
                cout << "GPA: "+canvasUsers.at(i).gpa <<endl; 
                cout << "Year Group: "+canvasUsers.at(i).yearGroup <<endl;
                
            }
        }
    }
}

// this method allows the user to create an instance of the canvasCourse class whilst setting certain parameters
void createCourse(){
    string userEmail;
    string userPassword;
    string CourseName; 
    string CourseCode; 
    
    cout << "Enter user's email: " <<endl;
    cin >> userEmail; 

    cout << "Enter user's password: " <<endl; 
    cin >> userPassword;

    if(login(userEmail,userPassword)){
        for(int i=0; i<canvasUsers.size();i++){
            if(canvasUsers.at(i).userName == userEmail && canvasUsers.at(i).userPassword== userPassword){
                if(canvasUsers.at(i).isFac){
                    cout <<"Enter the desired course name: " << endl;
                    cin >> CourseName;

                    cout <<"Enter desired course code: " << endl;
                    cin >> CourseCode;

                    struct canvasCourse newCourse; 
                    newCourse.canvasCourseConst(CourseCode,CourseName,userEmail);
                }
            } 
        }
    }
}

// this is the main method where all the running occurs 
int main(){
    makeAdmin();
   createAccount();
   login();
   makeFaculty();
   updateProfile();
   viewProfile();
   createCourse();

}



