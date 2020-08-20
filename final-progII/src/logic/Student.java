package logic;

import java.time.LocalDate;

public class Student extends User {

	public Student(String ci, String password, String name, String mail, LocalDate dateBirth) {
		super(ci, password, name, mail, dateBirth);
		// TODO Auto-generated constructor stub
	}

	private Orientation orientation;
	private Status status;
	private Generation generation;

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Generation getGeneration() {
		return generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

}
