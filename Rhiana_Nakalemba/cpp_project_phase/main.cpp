#include <iostream>
#include <regex>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

class Account {
protected:
    vector<string> accounts;
    string email;
    string password;
};

class User: public Account {
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
        vector<string> new_account;

        // validating user email and password
        if (valid_email) {
            if (*find(accounts.begin(), accounts.end(), user_email) == user_email) {
                // if provided email exists
                cout << "Accounts already exists.";
            } else {
                email = user_email;
                new_account.push_back(email);

                // if email is new and valid, validate the password provided with that email
                if (valid_password) {
                    // save provided password
                    // password can only be validated and saved if the email is new and validate
                    password = user_password;
                    new_account.push_back(password);

                } else {
                    cout << "Password should follow this pattern: " << endl;
                    cout << "1. Password must contain at least one digit [0-9]." << endl;
                    cout << "2. Password must contain at least one lowercase Latin character [a-z]." << endl;
                    cout << "3. Password must contain at least one uppercase Latin character [A-Z]." << endl;
                    cout << "4. Password must contain at least one special character like ! @ # & ( )." << endl;
                    cout << "5. Password must contain a length of at least 8 characters and a maximum of 20 characters." << endl;
                }
            }
        } else {
            cout << "Invalid email!";
        }

        // adding provided information to the accounts
        if (!new_account.empty()) {
            accounts.insert(accounts.end(), new_account.begin(), new_account.end());
            cout << "Account created!";
        }

    }
};


int main() {
    string user_email, user_password;

    // get user information
    cout << "Enter email: ";
    cin >> user_email;
    cout << "Enter password: ";
    cin >> user_password;

    // creating a new account
    User new_account;
    new_account.createAccount(user_email, user_password);

    return 0;
}
