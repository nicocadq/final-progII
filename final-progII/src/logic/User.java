package logic;

import java.time.LocalDate;

public class User {

	private int ci;
	private String password;
	private String name;
	private String lastName;
	private String mail;
	private LocalDate dateBirth;

	public User(int ci, String name, String lastName, String mail, String password, LocalDate dateBirth) {
		this.ci = ci;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.mail = mail;
		this.dateBirth = dateBirth;
	}
	
	public User(int ci) {
		this.ci = ci;
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}

}
