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

		
		 /* Teacher teacher = null;
		  
		  try { teacher = (Teacher) db.recoverUser(99999); } catch(Exception ex) {
		  ex.printStackTrace(); }*/
		Teacher teacheer = new Teacher(888, "Ruben", "Derigo", "rb@mail.com", "psswdRuben", LocalDate.of(1898, 2, 8)); 
		Subject subject = new Subject("123", "Matematica", Orientation.ADM,Generation.FIRST, teacheer);
		Student student = new Student(999, "Alejandro", "Gonzalez", Orientation.TIC, Status.ACTIVE, Generation.FIRST, "al@mail.com", "psswd", LocalDate.of(1999, 12, 28));
		Absence absence = new Absence(LocalDate.of(2001, 1, 8),AbstenceType.JUSTIFY,8,student.getCi(),subject.getCode());
		try {
			/*db.toPersistUser(student);
			db.toPersistUser(teacheer);
			db.toPersistSubject(subject);
			*/
			/*db.toPersistSubject(subject);*/
			db.recoverSubject("123");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
