package Interfaces;

import Entities.Database;

public interface User {

    public boolean login(String email, String password, Database database);
    public void updateProfile(Database database);
    public void viewProfile(Database database);
    public boolean isAdmin(String mail,Database database);
    public boolean isFaculty(String mail,Database database);

}
