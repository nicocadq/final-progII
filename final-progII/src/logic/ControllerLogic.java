package logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import persistence.ControllerDB;

public class ControllerLogic {

	private final String errorMessage = "There was a server error, please try again later.";

	private User userLoggedIn = null;
	
	private ControllerDB db;

	public ControllerLogic() {
		this.db = new ControllerDB();
	}

	public User createUser(User user) throws Exception {

		try {

			this.db.toPersistUser(user);

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		return user;
	}

	public Subject createSubject(Subject subject) throws Exception {

		try {

			this.db.toPersistSubject(subject);

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		return subject;
	}

	public Absence createAbsence(Absence absence) throws Exception {

		try {

			this.db.toPersistAbsence(absence);

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		return absence;
	}

	public User consultUsers(int ci) throws Exception {

		User user = null;

		try {

			user = this.db.recoverUser(ci);

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		return user;
	}

	public Subject consultSubject(String code) throws Exception {

		Subject subject = null;

		try {

			subject = this.db.recoverSubject(code);

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		return subject;
	}

	public List<Absence> consultAbstence(int ci) throws Exception {
		List<Absence> absences = null;

		try {

			absences = this.db.recoverAbsences();

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		for (Absence absence : absences) {
			if (absence.getStudent().getCi() != ci) {
				absences.remove(absence);
			}
		}

		return absences;
	}

	public List<Student> studentsList() throws Exception {
		List<User> users = null;
		List<Student> students = new ArrayList<Student>();

		try {
			users = this.db.recoverUsers();

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		try {

			for (User user : users) {
				students.add((Student) user);
			}

		} catch (ClassCastException castEx) {

		}

		return students;
	}

	public List<Subject> subjectsList() throws Exception {
		List<Subject> subjects = null;

		try {

			subjects = this.db.recoverSubjects();

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		return subjects;
	}

	public List<Absence> abstencesList() throws Exception {
		List<Absence> absences = null;

		try {

			absences = this.db.recoverAbsences();

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		return absences;
	}

	// To implement
	public ArrayList<Absence> abstencesToList(LocalDate fromDate, LocalDate tillDate) {
		return null;
	}

	// To implement in ControllerDB
	public User userUpdate(int ci, User user) {
		return null;
	}

	public Subject subjectUpdate(String code, Subject subject) throws Exception {

		try {

			this.db.updateSubject(code, subject);

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		return subject;
	}

	public void deleteAbsence(Absence absence) throws Exception {

		try {

			this.db.deleteAbsence(absence);

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

	}

	// To implement in ControllerDB
	public List<User> listStudentsWithSubjToDo() throws Exception {
		List<User> users = null;
		List<Subject> subjects = null;

		
		return null;
	}

	public List<Exam> listHistoryExams() throws Exception {
		List<Exam> exams = null;

		try {

			exams = this.db.recoverExams();

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		return exams;
	}

	// To implement
	public List<Exam> listHistoryExams(int ci) throws Exception {
		return null;
		
	}

	// To implement
	public List<Subject> listPendientings(int ci) {
		List<User> users = null;
		List<Subject> subjects = null;

		return null;
	}

	public User login(int ci, String password) throws Exception {

		try {
			
			this.userLoggedIn = this.db.recoverUser(ci);

			if (this.userLoggedIn instanceof Functionary) {
				if (userLoggedIn.getPassword() != password) {
					throw new Exception("The password doesn't match.");
				}

			} else {

				throw new Exception("Something is wrong! Try Again");
			}

		} catch (Exception e) {
			throw new Exception(errorMessage);
		}
		
		return this.userLoggedIn;
	}

	public void logout() {

		this.userLoggedIn = null;
		
	}

	public List<User> listClass(Generation generation, Orientation orientation) {
		return null;
	}

	public List<Teacher> teachersList() throws Exception {
		List<User> users = null;
		List<Teacher> teachers = new ArrayList<Teacher>();

		try {
			users = this.db.recoverUsers();

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		try {

			for (User user : users) {
				teachers.add((Teacher) user);
			}

		} catch (ClassCastException castEx) {

		}

		return teachers;
	}

	public List<Functionary> functionariesList() throws Exception {
		List<User> users = null;
		List<Functionary> functionaries = new ArrayList<Functionary>();

		try {
			users = this.db.recoverUsers();

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		try {

			for (User user : users) {
				functionaries.add((Functionary) user);
			}

		} catch (ClassCastException castEx) {

		}

		return functionaries;
	}
	
	public User getUserLoggedIn() {
		return this.userLoggedIn;
	}

	// This is here just for testing purposes, we must delete the method before
	// merge to develop
	public static void main(String[] args) {
		ControllerDB db = new ControllerDB();

		/*
		 * Teacher teacher = null;
		 * 
		 * try { teacher = (Teacher) db.recoverUser(99999); } catch(Exception ex) {
		 * ex.printStackTrace(); }
		 */
		Teacher teacher = new Teacher(888, "Ruben", "Derigo", "rb@mail.com", "psswdRuben", LocalDate.of(1898, 2, 8));
		Subject subject = new Subject("123", "Geometria", Orientation.ADM, Generation.FIRST, teacher);
		Student student = new Student(9939, "Alejandro", "Gonzalez", Orientation.TIC, Status.ACTIVE, Generation.FIRST,
				"al@mail.com", "psswd", LocalDate.of(1999, 12, 28));
		Absence absence = new Absence(2, LocalDate.of(2001, 1, 8), AbstenceType.JUSTIFY, 8, student, subject);
		Exam exam = new Exam(LocalDate.of(2000, 3, 8), 7, student, subject);
		try {
			// Tested to persist
			// db.toPersistUser(student);
			// db.toPersistUser(teacher);
			// db.toPersistSubject(subject);
			db.toPersistAbsence(absence);
			// db.toPersistExam(exam);
			// db.toPersistIntoTeaches(subject, teacher);

			// System.out.println(db.recoverSubject("123").getCode());

			// db.updateSubject(subject.getCode(), subject);

			// db.deleteAbsence(absence);

//			for (Subject sub : db.recoverSubjects()) {
//				System.out.println(sub.getCode());
//			}

//			for(Exam examFromDB : db.recoverExams()) {
//				System.out.println(examFromDB.getMark());
//			}

//			for(Absence absenceFromDB : db.recoverAbsences()) {
//				System.out.println(absenceFromDB.getSubject().getCode());
//			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}