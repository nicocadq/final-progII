package logic;

import java.time.LocalDate;

public class User {

	private String ci;
	private String password;
	private String name;
	private String mail;
	private LocalDate dateBirth;

	public User(String ci, String password, String name, String mail, LocalDate dateBirth) {
		super();
		this.ci = ci;
		this.password = password;
		this.name = name;
		this.mail = mail;
		this.dateBirth = dateBirth;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
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
