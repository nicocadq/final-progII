package logic;

import java.time.LocalDate;

public class Functionary extends User {

	public Functionary(int ci, String name, String lastName, String mail, String password, LocalDate dateBirth) {
		super(ci, name, lastName, mail, password, dateBirth);
	}

}
