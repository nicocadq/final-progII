package logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import persistence.ControllerDB;

public class ControllerLogic {

	public ControllerDB db;
	private List<User> users;

	public ControllerLogic() {
		db = new ControllerDB();
		this.users = new ArrayList<User>();
	}

	public User createUser(User user) throws Exception {

		try {

			db.toPersistUser(user);
			getUsers();

			return user;

		} catch (Exception ex) {
			ex.printStackTrace();
			new Exception("Ups! There was a server error, please try again later");
		}

		return null;
	}

	public Subject createSubject(Subject subject) {
		return null;
	}

	public Absence createSubject(Absence absence) {

		return absence;
	}

	public User consultUsers(int ci) {
		try {

			db.recoverUser(ci);

		} catch (Exception ex) {
			ex.printStackTrace();
			new Exception("Ups! There was a server error, please try again later");
		}
		return null;
	}

	public Subject consultSubject(String code) {
		return null;
		// return Materi.codigo
	}

	public ArrayList<Absence> consultAbstence(String ci) {
		return null;
		// ...?
	}

	public ArrayList<Student> studentsToList() {
		return null;
		// void creo
	}

	public ArrayList<Subject> subjectsToList() {
		return null;
	}

	public ArrayList<Absence> abstencesToList() {
		return null;
	}

	public ArrayList<Absence> abstencesToList(LocalDate fromDate, LocalDate tillDate) {
		return null;
	}

	public User userModify(String ci, User user) {
		return null;
	}

	public Subject subjectModify(Subject code, Subject subject) {
		return null;
	}

	public void deleteAbstence(Absence absence) {
	}

	public ArrayList<User> listStudentsWithSubjToDo() {
		return null;
	}

	public ArrayList<Exam> listHistoricExamns() {
		return null;
	}

	public ArrayList<Exam> listHistoricExamns(String ci) {
		return null;
	}

	public ArrayList<Subject> listPendientings(String ci) {
		return null;
	}

	public User login(String ci, String password) {
		return null;
	}

	public Boolean logout() {
		return null;
	}

	public ArrayList<User> listClass(Generation generation, Orientation orientation) {
		return null;
	}

	public List<Teacher> listTeachers() throws Exception {
		List<Teacher> teachers = new ArrayList<Teacher>();

		try {
			getUsers();

			for (User user : users) {
				if (user instanceof Teacher) {
					teachers.add((Teacher) user);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			new Exception("Ups! There was a server error, please try again later");
		}

		return teachers;
	}

	public List<Functionary> listFunctionary() {
		List<Functionary> functionaries = new ArrayList<Functionary>();

		try {
			getUsers();

			for (User user : users) {
				if (user instanceof Functionary) {
					functionaries.add((Functionary) user);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			new Exception("Ups! There was a server error, please try again later");
		}

		return functionaries;
	}

	public List<User> getUsers() {
		try {
			this.users = db.recoverUsers();
		} catch (Exception ex) {
			ex.printStackTrace();
			new Exception("Ups! There was a server error, please try again later.");
		}
		return this.users;
	}

}
