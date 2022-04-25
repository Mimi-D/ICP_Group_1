/**
 * 
 */
package icpProject.lms;

import java.util.Date;

/**
 * @author Jedidiah M
 *
 */
public abstract class Account {
	enum roles  {ADMINISTRATOR,FACULTY,STUDENT};
	private String email;
	private String password;
	

	private String firstName;				//this will take the account owner's first name
	private String lastName;				//this will take the account owner's last name
	private String fullName;				//this will combine the first and last name of the user;
	
	
	private String cGPA;
	private String yearGroup;
	


	private Date dOB;
	private String role;
	
	public Account(String email, String pword) {
		this.email = email;
		this.setPassword("",pword);
	}	
		
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPassword(String old, String newPass) {
		if(old.equals(this.password)) {
		this.password = newPass;
		}else {
			System.out.println("Old password is incorrect.");
		}
		
	}

	public boolean equals(Account obj) {
		// TODO Auto-generated method stub
		return false;
	}


	public Date getdOB() {
		return dOB;
	}


	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}
	
	@Override
	public String toString() {
		return "Account email: " + email + "\n Name:" + fullName + "\n CGPA=" + cGPA + ",\n yearGroup=" + yearGroup
				+ "\n dOB=" + dOB;
	}
	
}
