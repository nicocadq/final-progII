package logic;

import java.time.LocalDate;

public class Absence {

	private LocalDate date;
	private AbstenceType type;
	private int amountHours;

	public Absence(LocalDate date, AbstenceType type, int amountHours) {
		super();
		this.date = date;
		this.type = type;
		this.amountHours = amountHours;
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

}
