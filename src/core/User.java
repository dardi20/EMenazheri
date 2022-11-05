package core;

import java.util.GregorianCalendar;

public class User extends Person {
	private static final long serialVersionUID = 3213213120448891688L;

	private String username, password;
	private GregorianCalendar regDate;
	private boolean isActive;
	
	public User(int id, String name, String surname, String email, String phone, String address,
			GregorianCalendar birthday, Gender gender,String username, String password, GregorianCalendar regDate, boolean isActive) {
		super(id, name, surname, email, phone, address,
				birthday, gender);
		this.username = username;
		this.password = password;
		this.regDate = regDate;
		this.isActive = isActive;
	}

	public User() {
		this(null, null, new GregorianCalendar(), false);
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, GregorianCalendar regDate, boolean isActive) {
		super();
		this.username = username;
		this.password = password;
		this.regDate = regDate;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", regDate=" + regDate + ", isActive="
				+ isActive + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public GregorianCalendar getRegDate() {
		return regDate;
	}

	public void setRegDate(GregorianCalendar regDate) {
		this.regDate = regDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
}