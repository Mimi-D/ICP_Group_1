/**
 * 
 */
package icpProject.lms;

import java.util.Objects;

/**
 * @author Jedidiah M
 *
 */
public class Administrator extends Account{
	
	private String firstName,lastName,fullName;
	private String doB;
	final private String cGPA = "N/A";
	final private String yearGroup = "N/A";
	final private String role = "ADMIN";
	
	public Administrator(String email, String pword) {
		super(email, pword);									//Create an account with email and password, "pword"
	}
	
	void makeFaculty(String email) {}
	
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

	public void setFullName() {
		this.fullName = firstName +" "+ lastName;
	}

	public String getDoB() {
		return doB;
	}

	public void setDoB(String doB) {
		this.doB = doB;
	}

	public String getYearGroup() {
		return yearGroup;
	}

	public String getRole() {
		return role;
	}

	public String getcGPA() {
		return cGPA;
	}

	@Override
	public String toString() {
		return "Administrator Name: " + fullName + ", Date of Birth" + doB ;
	}
	

	@Override
	public boolean equals(Account obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrator other = (Administrator) obj;
		return Objects.equals(fullName, other.fullName);
	}
	

}
