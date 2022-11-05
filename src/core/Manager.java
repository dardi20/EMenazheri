package core;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import core.Person.Gender;

	public class Manager extends Employee {

		private ArrayList<Project> projects;
		
		public Manager() {
			this(null);
		}
		public Manager(ArrayList<Project> projects) {
			super();
			this.projects = projects;
		}

		public Manager(GregorianCalendar employmentDate, String department, String role,ArrayList<Project> projects) {
			super(employmentDate, department, role);
			this.projects = projects;
		}
		public Manager(int id, String name, String surname, String email, String phone, String address,
			GregorianCalendar birthday, Gender gender, String username, String password, GregorianCalendar regDate,
			boolean isActive, GregorianCalendar employmentDate, String department, String role) {
			super(id, name, surname, email, phone, address, birthday, gender, username, password, regDate, isActive,employmentDate,
					department, role);
		}
		public ArrayList<Project> getProjects() {
			return projects;
		}
		public void setProjects(ArrayList<Project> projects) {
			this.projects = projects;
		}
		@Override
		public String toString() {
			return "Manager [projects=" + projects + "]";
		}
	
	}
	
	
	
	

