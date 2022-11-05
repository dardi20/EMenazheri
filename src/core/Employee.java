package core;

import java.util.GregorianCalendar;

public class Employee extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GregorianCalendar employmentDate;
	private String department;
	private String role;

	public Employee() {

		this(new GregorianCalendar(), null, null);
	}

	public Employee(GregorianCalendar employmentDate, String department, String role) {
		super();
		this.employmentDate = employmentDate;
		this.department = department;
		this.role = role;
	}

	public Employee(int id, String name, String surname, String email, String phone, String address,
			GregorianCalendar birthday, Gender gender, String username, String password, GregorianCalendar regDate,
			boolean isActive, GregorianCalendar employmentDate, String department, String role) {
		super(id, name, surname, email, phone, address, birthday, gender, username, password, regDate, isActive);
		this.employmentDate = employmentDate;
		this.department = department;
		this.role = role;
	}

	public GregorianCalendar getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(GregorianCalendar employmentDate) {
		this.employmentDate = employmentDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [employmentDate=" + employmentDate + ", department=" + department + ", role=" + role + "]";
	}
}
