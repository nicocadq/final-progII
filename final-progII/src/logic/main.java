package logic;

import java.time.LocalDate;

import persistence.ControllerDB;

public class main {

	// This is here just for testing purposes, we must delete the method before merge it to master

	public static void main(String[] args) {
		ControllerDB db = new ControllerDB();
		
		ControllerLogic con = new ControllerLogic();

		/*
		 * Teacher teacher = null;
		 * 
		 * try { teacher = (Teacher) db.recoverUser(99999); } catch(Exception ex) {
		 * ex.printStackTrace(); }
		 */
		Functionary functionary = new Functionary (87897, "Pedro","Varela", "fun@mail.com", "password", LocalDate.of(1898, 2, 8));
		Teacher teacher = new Teacher(888, "Ruben", "Derigo", "rb@mail.com", "psswdRuben", LocalDate.of(1898, 2, 8));
		Subject subject = new Subject("123", "Geometria", Orientation.ADM, Generation.FIRST, teacher);
		Student student = new Student(9939, "Alejandro", "Gonzalez", Orientation.TIC, Status.ACTIVE, Generation.FIRST,
				"al@mail.com", "psswd", LocalDate.of(1999, 12, 28));
		Absence absence = new Absence(2, LocalDate.of(2001, 1, 8), AbstenceType.JUSTIFY, 8, student, subject);
		
		Exam exam = new Exam(LocalDate.of(2015, 6, 3), 10, student, subject);
		try {
			// Tested to persist
			//db.toPersistUser(functionary);
			// db.toPersistUser(student);
			// db.toPersistUser(teacher);
			// db.toPersistSubject(subject);
			// db.toPersistAbsence(absence);
			// db.toPersistExam(exam);
			// con.createExam(exam);
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
			/*
			LocalDate desde= LocalDate.of(100, 01, 01);
			LocalDate hasta=LocalDate.of(2100, 01, 15);
			

			/*for (User fun : db.recoverUsers()) {
				System.out.println( (Teacher)fun);
			}*/

			 for(Student stu : con.listStudentsWithSubjToDo()) {
				 System.out.println(stu.getCi());
			 }
			 

//			for(Absence absenceFromDB : db.recoverAbsences()) {
//				System.out.println(absenceFromDB.getSubject().getCode());
//			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
