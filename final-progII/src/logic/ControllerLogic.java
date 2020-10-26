package logic;

import java.time.LocalDate;
import java.util.ArrayList;
import persistence.Conn;
import persistence.ControllerDB;

public class ControllerLogic {

	public User createUsers(User user) {

		return user;
	}

	public Subject createSubject(Subject subject) {

		return subject;
	}

	public Absence createSubject(Absence absence) {

		return absence;
	}

	public User consultUsers(String ci) {
		return null;
		// return Usuario.ci o alg asi
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

	public static void main(String[] args) {
		ControllerDB db = new ControllerDB();
		
		Teacher teacher = null;
		
		try {
			teacher = (Teacher) db.recoverUser(99999);
		} catch(Exception ex) {
			ex.printStackTrace();
		}

		Subject subject = new Subject("Code", "Name", Orientation.ADM, Generation.FIRST, teacher);

		try {
			db.toPersistSubject(subject);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		

	}

}
