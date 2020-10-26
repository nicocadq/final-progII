package logic;

import java.time.LocalDate;
import java.util.ArrayList;

import persistence.ControllerDB;

public class ControllerLogic {

	ControllerDB db = new ControllerDB();

	public User createUser(User user) throws Exception {

		try {

			db.toPersistUser(user);

			return user;

		} catch (Exception ex) {
			ex.printStackTrace();
			new Exception("Ups! There was a server error, please try again later");
		}

		return null;
	}

	public Subject createSubject(Subject subject) throws Exception {
		try {

			db.toPersistSubject(subject);

			return subject;
		} catch (Exception ex) {
			ex.printStackTrace();
			new Exception("Ups! There was a server error, please try again later");
		}
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

	public ArrayList<Teacher> listTeachers() {
		return null;
	}

	public ArrayList<Functionary> listFunctionary() {
		return null;
	}
}
