//
// Created by trhiana.
//

#ifndef CPP_PROJECT_PHASE_CANVAS_H
#define CPP_PROJECT_PHASE_CANVAS_H

#include <iostream>
#include <regex>
#include <vector>
#include <string>
using namespace std;

class canvas {
    // each account in accounts  = [email, password, date of birth, year group, gpa]
protected:
    vector<vector<string>> accounts;
    string email, password;

public:
    string first_name, last_name, dob, year, gpa;

};


#endif //CPP_PROJECT_PHASE_CANVAS_H
