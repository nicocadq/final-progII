package logic;

import java.time.LocalDate;

public class Absence {

	private LocalDate date;
	private AbstenceType type;
	private int amountHours;

	private int studentCI;
	private String subjectCode;

	public Absence(LocalDate date, AbstenceType type, int amountHours, int studentCI, String subjectCode) {
		this.date = date;
		this.type = type;
		this.amountHours = amountHours;
		this.studentCI = studentCI;
		this.subjectCode = subjectCode;
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

	public void setStudentCI(int studentCI) {
		this.studentCI = studentCI;
	}

	public int getStudentCI() {
		return this.studentCI;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectCode() {
		return this.subjectCode;
	}

}
