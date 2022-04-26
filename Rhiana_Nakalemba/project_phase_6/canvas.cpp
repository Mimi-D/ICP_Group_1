//
// Created by trhiana.
//

#include "canvas.h"
#include <iostream>
#include <regex>
#include <vector>
#include <string>
using namespace std;

// all account user based actions
class User: public canvas {
public:
    // email format
    static bool isValid(const string& user_email) {
        const regex pattern("(\\w+)(\\.|_)?(\\w*)@(\\w+)(\\.(\\w+))+");
        return regex_match(user_email, pattern);
    }

    // password format
    static bool passIsValid(const string& user_password) {
        const regex pattern("[a-zA-Z_] [a-zA-Z_0-9]*\\.[a-zA-Z0-9]+");
        return regex_match(user_password, pattern);
    }

    // create new account
    void createAccount(string& user_email, string& user_password) {
        bool valid_email = isValid(user_email), valid_password = passIsValid(user_password);
        vector<string> new_account; // list to store all information of one account

        // validating user email and password
        if (valid_email) {
            for (vector<string> account : accounts) {
                string account_email = account[0];
                if (account_email == user_email){
                    // if provided email exists
                    cout << "Accounts already exists.";
                } else {
                    email = user_email;
                    new_account.push_back(email);

                    // if email is new and valid, validate the password provided with that email
                    if (valid_password) {
                        // save provided password.
                        // password can only be validated and saved if the email is new and validate
                        password = user_password;
                        new_account.push_back(password);
                        cout << "Account has been created!";

                    } else {
                        cout << "Password should follow this pattern: " << endl;
                        cout << "1. Password must contain at least one digit [0-9]." << endl;
                        cout << "2. Password must contain at least one lowercase Latin character [a-z]." << endl;
                        cout << "3. Password must contain at least one uppercase Latin character [A-Z]." << endl;
                        cout << "4. Password must contain at least one special character like ! @ # & ( )." << endl;
                        cout << "5. Password must contain a length of at least 8 characters and a maximum of 20 characters." << endl;
                    }
                }
            }
        } else {
            cout << "Invalid email or password!";
        }

        // adding provided information to the accounts list
        if (!new_account.empty()) {
            accounts.push_back(new_account);
            cout << "Account created!";
        }

    }

    // logging in an existing user
    bool login(string& user_email, string& user_password) {
        for (vector<string> account : accounts) {
            const string& account_email = account[0];
            const string& account_password = account[1];

            if (account_email == user_email && account_password == user_password) {
                return true;
            }
        }
        return false;
    }

    // update the user profile
    void updateProfile(string& user_email, string& user_password){
        while (login(user_email, user_password)) {
            // vector<string> new_account;
            cout << "Enter new details below: ";
            cout << "First name: ";
            cin >> first_name; // input first name
            cout << "Last name: ";
            cin >> last_name; // input last name
            cout << "Year group: ";
            cin >> year; // input year group
            cout << "Current GPA: ";
            cin >> gpa; // input current gpa
            cout << "Date of birth (DD/MM/YYYY): ";
            cin >> dob; // input date of birth

            for (vector<string> account : accounts) {
                string account_email = account[0];
                if (account_email == user_email) {
                    // if the login email is similar to the email of the account in the accounts
                    // add the new details to the account
                    account.push_back(first_name);
                    account.push_back(last_name);
                    account.push_back(dob);
                    account.push_back(year);
                    account.push_back(gpa);

                    // let user know details have been updated
                    cout << "Profile information successfully updated.";

                } else {
                    cout << "Invalid email! Login with appropriate email.";
                }
            }
        }
    }

    // viewing the user profile
    void viewProfile(string& user_email, string& user_password) {
        while(login(user_email, user_password)){
            for (vector<string> account : accounts) {
                string account_email = account[0];
                if (account_email == user_email) { // check that login email matches the account email
                    // display first name idf available in profile
//                    try {
//                        cout << "First name: " << account[2] << endl;
//                    } catch (const out_of_range& e) {
//                        cout << "First name: NA";
//                    }
//
//                    // display last name idf available in profile
//                    try {
//                        cout << "Last name: " << account[3] << endl;
//                    } catch (const out_of_range& e) {
//                        cout << "Last name: NA";
//                    }
// still working on exception handling in C++.


                } else {
                    cout << "Login with the correct email";
                }
            }
        }
    }
};

class Student: public User {

};


int main() {
    string user_email, user_password;

    // get user information
    cout << "Enter email: ";
    cin >> user_email;
    cout << "Enter password: ";
    cin >> user_password;

    // creating a new account
//    User new_account;
//    new_account.createAccount(user_email, user_password);

    // logging an existing user in
//    User user_login;
//    cout << user_login.login(user_email, user_password);

    return 0;
}
