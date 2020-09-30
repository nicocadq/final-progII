package logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
	
	private List<Subject> subjects;

	public Teacher(int ci, String name, String lastName, String mail, String password,  LocalDate dateBirth) {
		super(ci, name, lastName, mail, password, dateBirth);
		this.subjects = new ArrayList<Subject>();
	}
	
	public void setSubject(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public List<Subject> getSubject(){
		return this.subjects;
	}

}
