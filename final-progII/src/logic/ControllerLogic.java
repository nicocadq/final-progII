package logic;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		} catch (SQLIntegrityConstraintViolationException ex) {
			
			throw new Exception("The user already Exits");
		}

		return user;
	}

	public Exam createExam(Exam exam) throws Exception {

		try {
			this.db.toPersistExam(exam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(errorMessage);
		}

		return exam;
	}

	public Subject createSubject(Subject subject) throws Exception {

		try {

			this.db.toPersistSubject(subject);

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		return subject;
	}

	public void addTeacherToSubject(Subject subject) throws Exception {
		try {

			this.db.toPersistIntoTeaches(subject, subject.getTeacher());

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}
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

	public List<Absence> absencesList(LocalDate fromDate, LocalDate tillDate) throws Exception {
		List<Absence> absences = null;
		List<Absence> absencesBetweenTwoDates = new ArrayList<Absence>();

		try {
			absences = this.db.recoverAbsences();
		} catch (Exception absencesEx) {
			throw new Exception(errorMessage);
		}

		for (Absence absence : absences) {
			if (absence.getDate().isBefore(tillDate) && absence.getDate().isAfter(fromDate)) {
				absencesBetweenTwoDates.add(absence);
			}

		}

		return absencesBetweenTwoDates;
	}

	public List<Absence> absenceList(Orientation orientation, Generation generation) throws Exception {
		List<Absence> absences = null;
		List<User> users = null;
		List<Student> students = new ArrayList<Student>();
		List<Absence> absencesFiltered = new ArrayList<Absence>();
		List<Integer> studentsMatched = new ArrayList<Integer>();

		try {

			users = this.db.recoverUsers();

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		try {

			absences = this.db.recoverAbsences();

		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		try {

			for (User user : users) {
				if (user instanceof Student) {
					students.add((Student) user);
				}
			}

		} catch (ClassCastException castEx) {

		}

		for (Student student : students) {
			if (student.getOrientation() == orientation && student.getGeneration() == generation) {
				studentsMatched.add(student.getCi());
			}
		}

		for (Absence absence : absences) {
			if (studentsMatched.contains(absence.getStudent().getCi())) {
				absencesFiltered.add(absence);
			}
		}

		return absencesFiltered;
	}

	public User userUpdate(int ci, User user) throws Exception {

		try {
			this.db.updateUser(ci, user);
		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		return user;
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

	// this method must be tested with a database enable
	public List<Student> listStudentsWithSubjToDo() throws Exception {
		List<User> users = null;
		List<Student> students = null;
		Map<Integer, String> takes = null;
		List<Student> studentsWithSubjectsToDo = new ArrayList<Student>();

		try {
			users = this.db.recoverUsers();
		} catch (Exception usersEx) {
			throw new Exception(errorMessage);
		}

		try {
			takes = this.db.recoverTakes();
		} catch (Exception takesEx) {
			throw new Exception(errorMessage);
		}

		try {

			for (User user : users) {
				students.add((Student) user);
			}

		} catch (ClassCastException castEx) {

		}

		for (Student student : students) {
			for (Map.Entry studentAndSubject : takes.entrySet()) {
				if (((Integer) studentAndSubject.getKey()).intValue() == student.getCi()) {
					studentsWithSubjectsToDo.add(student);
				}
			}
		}

		return studentsWithSubjectsToDo;
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

	public List<Exam> listHistoryExams(int ci) throws Exception {
		List<Exam> exams = null;
		List<Exam> examByStudent = new ArrayList<Exam>();

		try {
			exams = this.db.recoverExams();
		} catch (Exception ex) {
			throw new Exception(errorMessage);
		}

		for (Exam exam : exams) {
			if (exam.getStudent().getCi() == ci)
				examByStudent.add(exam);
		}

		return examByStudent;

	}

	public List<Subject> listPendientings(int ci) throws Exception {
		Student student = null;
		List<Subject> subjects = null;
		Map<Integer, String> takes = null;
		List<Subject> pendings = new ArrayList<Subject>();

		try {
			student = (Student) this.db.recoverUser(ci);
		} catch (Exception studentEx) {
			// Here we are handling SQLException and ClassCastException
			throw new Exception(errorMessage);
		}

		try {
			subjects = this.db.recoverSubjects();
		} catch (Exception subjectsEx) {
			throw new Exception(errorMessage);
		}

		try {
			takes = this.db.recoverTakes();
		} catch (Exception takesEx) {
			throw new Exception(errorMessage);
		}

		for (Map.Entry studentAndSubject : takes.entrySet()) {
			if (((Integer) studentAndSubject.getKey()).intValue() == student.getCi()) {
				for (Subject subject : subjects) {
					if (subject.getCode() == studentAndSubject.getValue())
						pendings.add(subject);
				}
			}
		}

		return pendings;
	}

	public User login(int ci, String password) throws Exception {

		String loginErrorMessage = "";

		try {

			this.userLoggedIn = this.db.recoverUser(ci);

			if (this.userLoggedIn instanceof Functionary) {
				if (userLoggedIn.getPassword() == password) {
					return this.userLoggedIn;
				}

			} else {
				userLoggedIn = null;
				throw new Exception("The user has to be a Functionary to Log In");

			}

		} catch (Exception e) {
			e.printStackTrace();

			if (loginErrorMessage != "") {
				throw new Exception(loginErrorMessage);
			}

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
				if (user instanceof Teacher) {
					teachers.add((Teacher) user);
				}
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
				if (user instanceof Functionary) {
					functionaries.add((Functionary) user);
				}

			}

		} catch (ClassCastException castEx) {

		}

		return functionaries;
	}

	public User getUserLoggedIn() {
		return this.userLoggedIn;
	}

}