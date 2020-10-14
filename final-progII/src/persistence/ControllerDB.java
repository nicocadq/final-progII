package persistence;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.auth.Subject;

import logic.Absence;
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

	public void toPersistSubject(Subject subject) {

	}

	public void toPersistAbsence(Absence absence) {

	}

	public void toPersistExam(Exam exam) {

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

	public Subject recoverSubject(String code) {
		return null;

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

		} catch (Exception ex) {
			throw ex;
		}

		return users;
	}

	public List<Subject> recoverSubjects() {
		return null;

	}

	public List<Subject> recoverExams() {
		return null;

	}
}
