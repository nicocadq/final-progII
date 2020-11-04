package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.Subject;
import logic.Absence;
import logic.AbstenceType;
import logic.Exam;
import logic.Functionary;
import logic.Generation;
import logic.Orientation;
import logic.Status;
import logic.Student;
import logic.Teacher;
import logic.User;

public class ControllerDB extends Conn {

	public void toPersistUser(User user) throws Exception {
		try {
			System.out.println("Creating a Connection Object.");
			this.MySQLconnection();

			System.out.println("Creating PreparedStatement");
			PreparedStatement userSt = this.conn.prepareStatement(
					"INSERT INTO User(CI, NAME, LASTNAME, BIRTH, MAIL, PASSWORD) VALUES(?,?,?,?,?,?)");

			userSt.setInt(1, user.getCi());
			userSt.setString(2, user.getName());
			userSt.setString(3, user.getLastName());
			userSt.setDate(4, java.sql.Date.valueOf(user.getDateBirth()));
			userSt.setString(5, user.getMail());
			userSt.setString(6, user.getPassword());

			System.out.println("Created PreparedStatement.");

			System.out.println("Execute Update.");
			int updatedUserRows = userSt.executeUpdate();

			System.out.println("Update rows: " + updatedUserRows);

			try {

				System.out.println("Casting User to Student");
				Student student = (Student) user;

				System.out.println("Creating PreparedStatement");

				PreparedStatement studentSt = this.conn.prepareStatement(
						"INSERT INTO Student(CIUSER, ORIENTATION, GENERATION, STATE) VALUES(?, ?, ? ,?)");

				studentSt.setInt(1, student.getCi());
				studentSt.setString(2, student.getOrientation().toString());
				studentSt.setString(3, student.getGeneration().toString());
				studentSt.setString(4, student.getStatus().toString());

				System.out.println("Created PreparedStatement.");

				System.out.println("Execute Update.");

				int updatedStudentRows = studentSt.executeUpdate();

				System.out.println("Update rows: " + updatedStudentRows);

			} catch (ClassCastException castStudentEx) {

				try {

					System.out.println("Casting User to Teacher");
					Teacher teacher = (Teacher) user;

					System.out.println("Creating PreparedStatement");

					PreparedStatement teacherSt = this.conn.prepareStatement("INSERT INTO Teacher(CIUSER) VALUES(?)");

					teacherSt.setInt(1, teacher.getCi());

					System.out.println("Created PreparedStatement.");

					System.out.println("Execute Update.");

					int updatedteacherRows = teacherSt.executeUpdate();

					System.out.println("Update rows: " + updatedteacherRows);

				} catch (ClassCastException castTeacherEx) {

					try {

						System.out.println("Casting User to Functionary");
						Functionary functionary = (Functionary) user;

						System.out.println("Creating PreparedStatement");

						PreparedStatement functionarySt = this.conn
								.prepareStatement("INSERT INTO Functionary(CIUSER) VALUES(?)");

						functionarySt.setInt(1, functionary.getCi());

						System.out.println("Created PreparedStatement.");

						System.out.println("Execute Update.");

						int updatedStudentRows = functionarySt.executeUpdate();

						System.out.println("Update rows: " + updatedStudentRows);

					} catch (ClassCastException castFunctionaryEx) {

					}

				}

			}

		} catch (Exception ex) {
			throw ex;
		} finally {
			this.coloseConecction();
		}

	}

	public void toPersistSubject(Subject subject) throws Exception {

		try {

			System.out.println("Creting a connection object");
			this.MySQLconnection();

			System.out.println("Created PreparedStatement");
			PreparedStatement subjectSt = this.conn
					.prepareStatement("INSERT INTO Subject(IDSUBJECT, NAME, ORIENTATION, GENERATION) VALUES(?,?,?,?)");

			subjectSt.setString(1, subject.getCode());
			subjectSt.setString(2, subject.getName());
			subjectSt.setString(3, subject.getOrientation().toString());
			subjectSt.setString(4, subject.getGeneration().toString());

			System.out.println("Execute Update");

			int updatedSubjetRows = subjectSt.executeUpdate();

			System.out.println("Update subject rows: " + updatedSubjetRows);

		} catch (SQLException ex) {
			throw ex;
		} finally {
			this.coloseConecction();
		}

	}

	public void toPersistIntoTeaches(Subject subject, Teacher teacher) throws Exception {
		try {
			System.out.println("Creting a connection object");
			this.MySQLconnection();

			System.out.println("Created PreparedStatement for teaches");

			PreparedStatement teachesSt = this.conn
					.prepareStatement("INSERT INTO TEACHES(IDSUBJECT, CITEACHER) VALUES(?,?)");

			teachesSt.setString(1, subject.getCode());
			teachesSt.setInt(2, teacher.getCi());

			System.out.println("Execut Update");

			int updateTeachesRows = teachesSt.executeUpdate();

			System.out.println("Update teaches rows: " + updateTeachesRows);

		} catch (SQLException ex) {
			throw ex;
		}

	}

	public void toPersistAbsence(Absence absence) throws Exception {

		try {

			System.out.println("Creating a Connection object");
			this.MySQLconnection();

			System.out.println("Created PreparedStatment for absences");
			PreparedStatement absencesSt = this.conn.prepareStatement(
					"INSERT INTO Absence(IDABSENCE, CISTUDENT, IDSUBJECT, TYPE, DATE, AMOUNTOFHOURS) VALUES(?,?,?,?,?,?)");

			absencesSt.setInt(1, 0);
			absencesSt.setInt(2, absence.getStudent().getCi());
			absencesSt.setString(3, absence.getSubject().getCode());
			absencesSt.setString(4, absence.getType().toString());
			absencesSt.setDate(5, java.sql.Date.valueOf(absence.getDate()));
			absencesSt.setInt(6, absence.getAmountHours());

			System.out.println("Ëxecute Update for Absences");
			int updatedAbsence = absencesSt.executeUpdate();

			System.out.println("Update absence rows: " + updatedAbsence);

		} catch (Exception ex) {
			throw ex;
		}
	}

	public void toPersistExam(Exam exam) throws Exception {

		try {

			System.out.println("Crearing a connection Object");
			this.MySQLconnection();

			System.out.println("Creating preparedStatement for Exams");
			PreparedStatement examSt = this.conn.prepareStatement(
					"INSERT INTO Exam(IDEXAM, CISTUDENT, IDSUBJECT, DATE, MARKFAILED) VALUES(?,?,?,?,?)");

			examSt.setInt(1, 0);
			examSt.setInt(2, exam.getStudent().getCi());
			examSt.setString(3, exam.getSubject().getCode());
			examSt.setDate(4, java.sql.Date.valueOf(exam.getDate()));
			examSt.setInt(5, exam.getMark());

			System.out.println("Execut Update");

			int updatedExamRows = examSt.executeUpdate();

			System.out.println("Update teaches rows: " + updatedExamRows);

		} catch (Exception e) {
			throw e;
		}

	}

	public User recoverUser(int ci) throws Exception {

		User user = null;

		try {
			System.out.println("Creating a Connection Object.");
			this.MySQLconnection();

			System.out.println("Creating PreparedStatement");
			PreparedStatement userSt = this.conn.prepareStatement("SELECT * FROM User WHERE CI = ?");

			userSt.setInt(1, ci);

			System.out.println("Executing Query and creating ResultSet.");
			ResultSet userRs = userSt.executeQuery();

			while (userRs.next()) {

				System.out.println("Database User");

				user = new User(userRs.getInt("CI"), userRs.getString("NAME"), userRs.getString("LASTNAME"),
						userRs.getString("MAIL"), userRs.getString("PASSWORD"), userRs.getDate("BIRTH").toLocalDate());
			}
		} catch (SQLException userException) {
			System.out.println(userException.getMessage());
		}

		if (user != null) {

			try {
				System.out.println("Creating PreparedStatement Student");
				PreparedStatement studentSt = this.conn.prepareStatement("SELECT * FROM Student WHERE ciUser = ?");

				studentSt.setInt(1, ci);

				System.out.println("Executing Query and creating ResultSet.");
				ResultSet studentRs = studentSt.executeQuery();

				while (studentRs.next()) {

					System.out.println("Database Student");
					User userCopy = new User(user.getCi(), user.getName(), user.getLastName(), user.getMail(),
							user.getPassword(), user.getDateBirth());

					user = new Student(userCopy.getCi(), userCopy.getName(), userCopy.getLastName(),
							Orientation.valueOf(studentRs.getString(2)), Status.valueOf(studentRs.getString(4)),
							Generation.valueOf(studentRs.getString(3)), userCopy.getMail(), userCopy.getPassword(),
							userCopy.getDateBirth());

				}

			} catch (SQLException studentEx) {
				System.out.println(studentEx.getMessage());
			}

			if (!(user instanceof Student)) {

				try {

					System.out.println("Creating PreparedStatement Teacher");
					PreparedStatement teacherSt = this.conn.prepareStatement("SELECT * FROM Teacher WHERE ciUser = ?");

					teacherSt.setInt(1, ci);

					System.out.println("Executing Query and creating ResultSet.");
					ResultSet teacherRs = teacherSt.executeQuery();

					while (teacherRs.next()) {

						System.out.println("Database Teacher");

						User userCopyForTeacher = new User(user.getCi(), user.getName(), user.getLastName(),
								user.getMail(), user.getPassword(), user.getDateBirth());

						user = new Teacher(userCopyForTeacher.getCi(), userCopyForTeacher.getName(),
								userCopyForTeacher.getLastName(), userCopyForTeacher.getMail(),
								userCopyForTeacher.getPassword(), userCopyForTeacher.getDateBirth());
					}

				} catch (SQLException teacherEx) {
					System.out.println(teacherEx.getMessage());
				}
			}

			if (!(user instanceof Teacher)) {

				try {
					System.out.println("Creating PreparedStatement Functionary");
					PreparedStatement functionarySt = this.conn
							.prepareStatement("SELECT * FROM Functionary WHERE CIUSER = ?");

					functionarySt.setInt(1, ci);

					System.out.println("Executing Query and creating ResultSet.");
					ResultSet functionaryRs = functionarySt.executeQuery();

					while (functionaryRs.next()) {

						System.out.println("Database Functioanry");

						User userCopyForFunctionary = new User(user.getCi(), user.getName(), user.getLastName(),
								user.getMail(), user.getPassword(), user.getDateBirth());

						user = new Functionary(userCopyForFunctionary.getCi(), userCopyForFunctionary.getName(),
								userCopyForFunctionary.getLastName(), userCopyForFunctionary.getMail(),
								userCopyForFunctionary.getPassword(), userCopyForFunctionary.getDateBirth());
					}

				} catch (SQLException functionaryEx) {
					System.out.println(functionaryEx.getMessage());
				} finally {
					coloseConecction();
				}

			}

		}

		return user;

	}

	public Subject recoverSubject(String code) throws Exception {

		Subject subject = null;
		Teacher teacher = null;

		try {
			System.out.println("Creating a connection for a RecoverSubject Method");
			this.MySQLconnection();

			PreparedStatement subjectSt = this.conn.prepareStatement("SELECT * FROM subject WHERE IDSUBJECT = ?");

			subjectSt.setString(1, code);

			System.out.println("Executing Query and creating ResultSet for the RecoverSubject");
			ResultSet subjectRs = subjectSt.executeQuery();

			PreparedStatement teachesSt = this.conn.prepareStatement("SELECT * FROM teaches WHERE IDSUBJECT = ?");

			teachesSt.setString(1, code);

			System.out.println("Executing Query and creating ResultSet for the Recover Teaches");
			ResultSet teachesRs = teachesSt.executeQuery();

			while (teachesRs.next()) {
				System.out.println("Database IDTEACHER");
				teacher = new Teacher(teachesRs.getInt("CITEACHER"));
			}

			while (subjectRs.next()) {

				System.out.println("Database Subject");

				Subject subjectCopy = new Subject(subjectRs.getString("IDSUBJECT"), subjectRs.getString("NAME"),
						Orientation.valueOf(subjectRs.getString(3)), Generation.valueOf(subjectRs.getString(4)),
						teacher);
				subject = new Subject(subjectCopy.getCode(), subjectCopy.getName(), subjectCopy.getOrientation(),
						subjectCopy.getGeneration(), subjectCopy.getTeacher());

			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			coloseConecction();
		}

		return subject;

	}

	public void updateSubject(String code, Subject subject) throws Exception {
		try {
			System.out.println("Creating a connection for a RecoverSubject Method");
			this.MySQLconnection();

			System.out.println("Created PreparedStatement for Update Subject");

			PreparedStatement subjectSt = this.conn.prepareStatement(
					"UPDATE Subject SET NAME = ?, GENERATION = ?, ORIENTATION = ? WHERE IDSUBJECT = ?");

			subjectSt.setString(1, subject.getName());
			subjectSt.setString(2, subject.getGeneration().toString());
			subjectSt.setString(3, subject.getOrientation().toString());
			subjectSt.setString(4, code);

			System.out.println("Execut Update");

			int updatedSubjectRows = subjectSt.executeUpdate();

			System.out.println("Updated subject rows: " + updatedSubjectRows);

		} catch (SQLException ex) {
			throw ex;
		}

	}

	public void deleteAbsence(Absence absence) throws Exception {
		try {
			System.out.println("Creating a connection for a RecoverSubject Method");
			this.MySQLconnection();

			System.out.println("Created PreparedStatement for delete absence");

			PreparedStatement absenceSt = this.conn.prepareStatement("DELETE FROM Absence WHERE IDABSENCE = ?");

			absenceSt.setInt(1, absence.getId());

			System.out.println("Execute Update");

			absenceSt.execute();

		} catch (SQLException ex) {
			throw ex;
		}

	}

	public List<User> recoverUsers() throws Exception {
		List<User> users = new ArrayList<User>();

		System.out.println("Creating a Connection Object.");
		this.MySQLconnection();

		try {
			System.out.println("Creating PreparedStatement");
			PreparedStatement studentst = this.conn
					.prepareStatement("SELECT * FROM User INNER JOIN student where ci= ciUser");

			System.out.println("Executing Query and creating ResultSet.");
			ResultSet studentrs = studentst.executeQuery();

			while (studentrs.next()) {

				System.out.println("Database User student ");
				User userStudent = new Student(studentrs.getInt("CI"), studentrs.getString("NAME"),
						studentrs.getString("LASTNAME"), Orientation.valueOf(studentrs.getString("ORIENTATION")),
						Status.valueOf(studentrs.getString("state")),
						Generation.valueOf(studentrs.getString("GENERATION")), studentrs.getString("MAIL"),
						studentrs.getString("PASSWORD"), studentrs.getDate("BIRTH").toLocalDate());

				users.add(userStudent);
			}

		} catch (Exception exx) {
			throw exx;
		}

		try {
			System.out.println("Creating PreparedStatement for Teacher");
			PreparedStatement teacherst = this.conn
					.prepareStatement("SELECT * FROM User INNER JOIN teacher where ci= ciUser");

			System.out.println("Executing Query and creating ResultSet for teacher");
			ResultSet teacherRs = teacherst.executeQuery();

			while (teacherRs.next()) {

				System.out.println("Database User Teacher");
				User userTeacher = new Teacher(teacherRs.getInt("CI"), teacherRs.getString("NAME"),
						teacherRs.getString("LASTNAME"), teacherRs.getString("MAIL"), teacherRs.getString("PASSWORD"),
						teacherRs.getDate("BIRTH").toLocalDate());

				users.add(userTeacher);
			}

		} catch (Exception ex) {
			throw ex;
		}
		try {
			System.out.println("Creating PreparedStatement for Functionary");
			PreparedStatement functionaryst = this.conn
					.prepareStatement("SELECT * FROM User INNER JOIN functionary where ci= ciUser");

			System.out.println("Executing Query and creating ResultSet Functionary");
			ResultSet functionaryRs = functionaryst.executeQuery();

			while (functionaryRs.next()) {

				System.out.println("Database User Functionary ");
				User userFunctionary = new Functionary(functionaryRs.getInt("CI"), functionaryRs.getString("NAME"),
						functionaryRs.getString("LASTNAME"), functionaryRs.getString("MAIL"),
						functionaryRs.getString("PASSWORD"), functionaryRs.getDate("BIRTH").toLocalDate());

				users.add(userFunctionary);

			}
		} catch (Exception exc) {
			throw exc;
		} finally {
			this.coloseConecction();
		}
		return users;
	}

	public List<Subject> recoverSubjects() throws Exception {
		List<Subject> subjects = new ArrayList<Subject>();

		try {
			System.out.println("Creating a Connection Object.");
			this.MySQLconnection();

			System.out.println("Creating PreparedStatement");
			PreparedStatement subjectSt = this.conn.prepareStatement("SELECT * FROM Subject");

			System.out.println("Executing Query and creating ResultSet.");
			ResultSet subjectRs = subjectSt.executeQuery();

			while (subjectRs.next()) {
				Teacher teacher = null;
				
				PreparedStatement teachesSt = this.conn.prepareStatement("SELECT * FROM teaches WHERE IDSUBJECT = ?");

				teachesSt.setString(1, subjectRs.getString("IDSUBJECT"));

				System.out.println("Executing Query and creating ResultSet for the Recover Teaches");
				ResultSet teachesRs = teachesSt.executeQuery();

				while (teachesRs.next()) {
					System.out.println("Database IDTEACHER");
					teacher = new Teacher(teachesRs.getInt("CITEACHER"));
				}

				System.out.println("Database User student ");
				Subject subject = new Subject(subjectRs.getString(1), subjectRs.getString(2),
						Orientation.valueOf(subjectRs.getString(3)), Generation.valueOf(subjectRs.getString(4)),
						teacher);
				subjects.add(subject);
			}

		} catch (Exception ex) {
			throw ex;
		}

		return subjects;

	}

	public List<Exam> recoverExams() throws Exception {
		List<Exam> exams = new ArrayList<Exam>();

		try {

			System.out.println("Creating a Connection Object.");
			this.MySQLconnection();

			System.out.println("Creating PreparedStatement");
			PreparedStatement examSt = this.conn.prepareStatement("SELECT * FROM Exam");

			System.out.println("Executing Query and creating ResultSet.");
			ResultSet examRs = examSt.executeQuery();

			while (examRs.next()) {
				Exam exam = new Exam(examRs.getDate("DATE").toLocalDate(), examRs.getInt("MARKFAILED"),
						new Student(examRs.getInt("CISTUDENT")), new Subject(examRs.getString("IDSUBJECT")));
				exams.add(exam);
			}

		} catch (Exception ex) {
			throw ex;
		}

		return exams;
	}

	public List<Absence> recoverAbsences() throws Exception {
		List<Absence> absences = new ArrayList<Absence>();

		try {

			System.out.println("Creating a Connection Object.");
			this.MySQLconnection();

			System.out.println("Creating PreparedStatement");
			PreparedStatement absenceSt = this.conn.prepareStatement("SELECT * FROM Absence");

			System.out.println("Executing Query and creating ResultSet.");
			ResultSet absenceRs = absenceSt.executeQuery();

			while (absenceRs.next()) {
				Absence absence = new Absence(absenceRs.getInt(1), absenceRs.getDate("DATE").toLocalDate(),
						AbstenceType.valueOf(absenceRs.getString("TYPE")), absenceRs.getInt("AMOUNTOFHOURS"),
						new Student(absenceRs.getInt("CISTUDENT")), new Subject(absenceRs.getString("IDSUBJECT")));
				absences.add(absence);
			}

		} catch (Exception ex) {
			throw ex;
		}

		return absences;
	}
}