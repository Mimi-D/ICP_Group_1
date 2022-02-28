package icpProject.lms;

import java.util.HashMap;

public class Main {
	
	static HashMap<String, Administrator> administrators = new HashMap<String, Administrator>();
	static HashMap<String, Faculty> facultyMembers = new HashMap<String, Faculty>();
	static HashMap<String, Student> students = new HashMap<String, Student>();
	
	static HashMap<String, Course> courses = new HashMap<String, Course>();
	
	static enum role {ADMINISTRATOR,FACULTY,STUDENT};	
	static role loggedInAs; static String currentUser;
	static Administrator adminAcc;
	static Student studentAcc;
	static Faculty facultyAcc;
	private static String adminName;
	private static String anotherParameter;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		createAccount("StudentOne@mail.com","playtime",role.STUDENT);
		studentLogin("StudentOne@mail.com","playtime");
	}
	
	
	 static void createAccount(String email,String pass,Main.role accountRole) {
		switch (accountRole){
		case ADMINISTRATOR:
			Administrator anAdmin = new Administrator(email,pass);
			try {
				administrators.put(email,anAdmin);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case FACULTY:
			Faculty aFacultyMember = new Faculty(email,pass);
			try {
				facultyMembers.put(email,aFacultyMember);
			}catch(Exception e) {
				e.printStackTrace();
			}
		case STUDENT:
			Student aStudent = new Student(email,pass);
			try {
				students.put(email,aStudent);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	static void adminLogin(String email,String pass) {
		Administrator account = null;
		if(administrators.containsKey(email)) {
			account = administrators.get(email);
			loggedInAs = role.ADMINISTRATOR;
		}else {
			System.out.println("User account does not exist.");
		}
		if(!pass.equals(account.getPassword())) {
			System.out.println("Password Incorrect");
		}else {
			currentUser = email;
			adminAcc = account;studentAcc = null;facultyAcc = null;
		}
	}
	
	static void facultyLogin(String email,String pass) {
		Faculty account = null;
		if(administrators.containsKey(email)) {
			account = facultyMembers.get(email);
			loggedInAs = role.ADMINISTRATOR;
		}else {
			System.out.println("User account does not exist.");
		}
		if(!pass.equals(account.getPassword())) {
			System.out.println("Password Incorrect");
		}else {
			currentUser = email;
			adminAcc = null;studentAcc = null;facultyAcc = account;
		}
	}
	
	static void studentLogin(String email,String pass) {
		Student account = null;
		if(students.containsKey(email)) {
			account = students.get(email);
			loggedInAs = role.ADMINISTRATOR;
		}else {
			System.out.println("User account does not exist.");
		}
		if(!pass.equals(account.getPassword())) {
			System.out.println("Password Incorrect");
		}else {
			currentUser = email;
			adminAcc = null;studentAcc = account;facultyAcc = null;
		}
	}
	
	
	static void updateProfile(String fname,String lname, String yearGroup, String cGPA, String dOB) {
		if(loggedInAs == role.ADMINISTRATOR) {
			adminAcc.setFirstName(fname); adminAcc.setLastName(lname);
			adminAcc.setDoB(dOB); adminAcc.setFullName();
		}else if(loggedInAs == role.FACULTY) {
			facultyAcc.setFirstName(lname);
		}
	}
	static void viewProfile(String email) {
		Account account = null;
		if(administrators.containsKey(currentUser)) {
			account = (Administrator) administrators.get(currentUser);
		}else if(facultyMembers.containsKey(currentUser)){
			account = (Faculty)facultyMembers.get(currentUser);
		}else if(students.containsKey(currentUser)) {
			account = (Student) students.get(currentUser);
		}else {
			System.out.println("User account does not exist.");
		}
		System.out.println(account.toString());
	}
	
	static boolean isAdmin(String email) {
		return administrators.containsKey(email);
	}
	static boolean isFaculty(String email) {
		return facultyMembers.containsKey(email);
	}
	static boolean isStudent(String email) {
		return students.containsKey(email);
	}
	
	static void makeFaculty(String email) {
		//Account account;
		if(!isFaculty(email)) {
			
		}
	}
	
	static void createCourse(String email, String courseCode, String courseName) {
		Course createdCourse = null;
		if(email.equals(currentUser) && isFaculty(currentUser)) {
			createdCourse = facultyAcc.createCourse(courseCode, courseName);
		}else {
			System.out.println("Please Login as faculty to create course");
		}
		courses.put(courseCode, createdCourse);
	}
	static void viewCourses() {
		for(HashMap.Entry<String, Course>entry:courses.entrySet()) {
			System.out.printf("%20s , %35s",entry.getKey(),entry.getValue().getCourseName());
		}
	}
	//11
	static void registerCourses(String email,String courseCode) {
		if(!(loggedInAs == role.STUDENT || (currentUser.equals(null))&&currentUser.equals(email))){
			System.out.println("Please login as student to register for courses.");
		}else {
			studentAcc.registeredCourses.put(courseCode, courses.get(courseCode));
			courses.get(courseCode).registeredStudents.put(currentUser, studentAcc);
		}
	}
	static void viewCourseByCode(String courseCode) {
		Course calledCourse = courses.get(courseCode);
		System.out.println(calledCourse.toString());
	}
	static void viewCoursesByEmail(String email) {
		if(!(loggedInAs == role.STUDENT || (currentUser.equals(null))&&currentUser.equals(email))){
			System.out.println("Please login as student to register for courses.");
		}else {
			HashMap<String, Course> allCourses = studentAcc.registeredCourses;
			for(HashMap.Entry<String,Course> particularCourse:allCourses.entrySet()) {
				System.out.println(particularCourse.getKey()+ " - " + particularCourse.getValue().getCourseName());
			}
		}
	}
	
	static void viewAssignmentsByEmail() {}
	static void viewAssignmentsByCourse() {}
	static void viewAllAssignmentScores() {}
	static void viewAssignmentGrade() {}
	static void setAssignmentPreferences() {}
	
}
