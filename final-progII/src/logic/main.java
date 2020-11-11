package logic;

import java.time.LocalDate;

import persistence.ControllerDB;

public class main {

	// This is here just for testing purposes, we must delete the method before merge it to master

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
			// db.toPersistAbsence(absence);
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
