public class Student {
	private String firstName;
	private String lastName;
	private int idNumber;

	public Student(String firstName, String lastName, int idNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int hashCode() {
		boolean hasHashCode = false;
		int hc = 0;
		if (!hasHashCode) {
			int fnameHash = firstName.hashCode();
			int lnameHash = lastName.hashCode();
			int result = fnameHash;
			result *= 31;
			result += lnameHash;
			result *= 31;
			result += getIdNumber();
			hc = result;
			hasHashCode = true;
		}
		return hc;

	}
}