package core;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Person implements Serializable {

	public enum Gender {
		MALE, FEMALE, OTHER
	}

	private static final long serialVersionUID = 737909918171279248L;

	private int id;
	private static int nextId;
	private String name, surname, email, phone, address;
	private GregorianCalendar birthday;
	private Gender gender;

	public int getId() {
		return id;
	}

	public Person() {
		this(0, null, null, null, null, null, new GregorianCalendar(), Gender.MALE);
	}

	public Person(int id, String name, String surname, String email, String phone, String address,
			GregorianCalendar birthday, Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		this.gender = gender;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public GregorianCalendar getBirthday() {
		return birthday;
	}

	public void setBirthday(GregorianCalendar birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", birthday=" + birthday + ", gender=" + gender + "]";
	}

	public static int getNextId() {
		return nextId;
	}

	public static void setNextId(int nextId) {
		Person.nextId = nextId;
	}

}
