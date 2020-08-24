package logic;

import java.time.LocalDate;

public class Absence {

	private LocalDate date;
	private AbstenceType type;
	private int amountHours;

	private Student student;
	private Subject subject;

	public Absence(LocalDate date, AbstenceType type, int amountHours, Student student, Subject subject) {
		super();
		this.date = date;
		this.type = type;
		this.amountHours = amountHours;
		this.student = student;
		this.subject = subject;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public AbstenceType getType() {
		return type;
	}

	public void setType(AbstenceType type) {
		this.type = type;
	}

	public int getAmountHours() {
		return amountHours;
	}

	public void setAmountHours(int amountHours) {
		this.amountHours = amountHours;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Subject getSubject() {
		return this.subject;
	}

}
