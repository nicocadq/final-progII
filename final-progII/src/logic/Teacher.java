package logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
	
	private List<Subject> subjects;

	public Teacher(String ci, String password, String name, String mail, LocalDate dateBirth) {
		super(ci, password, name, mail, dateBirth);
		this.subjects = new ArrayList<Subject>();
	}
	
	public void setSubject(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public List<Subject> getSubject(){
		return this.subjects;
	}

}
