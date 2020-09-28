package logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import persistence.ControllerDB;

public class User {

	private int ci;
	private String password;
	private String name;
	private String lastName;
	private String mail;
	private LocalDate dateBirth;

	public User(int ci, String name, String lastName, String mail, String password, LocalDate dateBirth) {
		super();
		this.ci = ci;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.mail = mail;
		this.dateBirth = dateBirth;
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
	
	public static void main(String[] args) {
		User user = new User(53013989, "Ruben", "Derigo", "ruben.derigo@anima.edu.uy", "rubenPuto", LocalDate.of(1010, 9, 9));
		ControllerDB controller =  new ControllerDB();
		
		try {
			System.out.println("Insert at beginnig.");
			controller.toPersistUser(user);
			System.out.println("Insert at the end.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			System.out.println("Query at the beginning.");
			List<User> users = controller.recoverUsers();
			System.out.println("Query at the end.");
			
			for(User usr : users) {
				System.out.println(usr.getCi());
			}
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
