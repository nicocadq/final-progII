package logic;

import java.time.LocalDate;

public class Exam {

	private LocalDate date;
	private int mark;

	public Exam(LocalDate date, int note) {
		super();
		this.date = date;
		this.mark = mark;
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

	public void setNote(int note) {
		this.mark = mark;
	}

}
