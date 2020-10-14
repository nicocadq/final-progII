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
	

//	This main it's have a testing stuff so it'll not be here in a few commits

	public static void main(String[] args) {
		ControllerDB dbCon = new ControllerDB();
		Student student = new Student(545344, "Nicola", "Alejandro", Orientation.ADM, Status.ACTIVE, Generation.FIRST, "asdasdasd@asdasd.com", "asdasdasdasd", LocalDate.of(1,1,1));
		Teacher teacher = new Teacher(99999, "Ruben", "Maria","asdasdasd@asdasd.com", "sioa", LocalDate.of(7,1,1));
		Functionary functionary = new Functionary(88888, "Nicola", "Alejandro", "asdasdasd@asdasd.com", "asdasdasdasd", LocalDate.of(1,1,1));

		try {
			for( User user :  dbCon.recoverUsers()) {
				System.out.println(user.getCi());
			}
			
			
/*
 			dbCon.toPersistUser(functionary);
			User user = dbCon.recoverUser(545344);
			User userTeacher = dbCon.recoverUser(99999);
			User userFunctionary = dbCon.recoverUser(88888);
*/
			try {
/*
				Student studeent = (Student) user;
				System.out.println(studeent.getName());
				
				
				Teacher teacheer = (Teacher) userTeacher;
				System.out.println(teacheer.getName());
				
				
				Functionary functionaary =  (Functionary) userFunctionary;
				System.out.println(functionaary.getLastName());
*/
				
				
			}catch(ClassCastException ex) {
				ex.getMessage();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
