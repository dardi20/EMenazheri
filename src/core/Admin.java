
package core;

	import java.util.GregorianCalendar;

import core.Person.Gender;

	public class Admin extends Manager {

		private static final long serialVersionUID = 6817221395827977014L;

		public Admin() {
			super(); 
		}

		public Admin(int id, String name, String surname, String email, String phone, String address,
				GregorianCalendar birthday, Gender gender, String username, String password, GregorianCalendar regDate,
				boolean isActive, GregorianCalendar employmentDate, String department, String role) {
			super(id, name, surname, email, phone, address, birthday, gender, username, password, regDate, isActive,employmentDate,
			department, role);	
		}

		@Override
		public String toString() { 
			return "core.Admin[" + super.toString() + "]";
		}
		
	}


