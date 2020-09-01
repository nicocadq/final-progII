package logic;

import java.time.LocalDate;

public class Exam {

	private LocalDate date;
	private int mark;
	
	private Student student;
	private Subject subject;

	public Exam(LocalDate date, int mark, Student student, Subject subject) {
		super();
		this.date = date;
		this.mark = mark;
		this.student = student;
		this.subject = subject;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNote() {
		return mark;
	}

	public void setNote(int mark) {
		this.mark = mark;
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
