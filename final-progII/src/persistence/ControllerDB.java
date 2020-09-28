package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.auth.Subject;

import logic.Absence;
import logic.Exam;
import logic.User;

public class ControllerDB extends Conn {

	public void toPersistUser(User user) throws Exception {
		try {
			System.out.println("Creating a Connection Object.");
			this.MySQLconnection();
			
			System.out.println("Creating PreparedStatement");
			PreparedStatement st = this.conn.prepareStatement(
					"INSERT INTO User(CI, NAME, LASTNAME, BIRTH, MAIL, PASSWORD) VALUES(?,?,?,?,?,?)");

			st.setInt(1, user.getCi());
			st.setString(2, user.getName());
			st.setString(3, user.getLastName());
			st.setDate(4, java.sql.Date.valueOf(user.getDateBirth()));
			st.setString(5, user.getMail());
			st.setString(6, user.getPassword());
			
			System.out.println("Created PreparedStatement.");
			
			System.out.println("Execute Update.");
			int rows = st.executeUpdate();

			System.out.println("Update rows: " + rows);

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

	public User recoverUser(String ci) {
		return null;

	}

	public Subject recoverSubject(String code) {
		return null;

	}

	public List<User> recoverUsers() throws Exception {
		List<User> users = new ArrayList<User>();

		try {
			System.out.println("Creating a Connection Object.");
			this.MySQLconnection();
			
			
			System.out.println("Creating PreparedStatement");
			PreparedStatement st = this.conn.prepareStatement("SELECT * FROM User");
			
			System.out.println("Executing Query and creating ResultSet.");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				System.out.println("Database User");
				users.add(new User(rs.getInt("CI"), rs.getString("NAME"), rs.getString("LASTNAME"),
						rs.getString("MAIL"), rs.getString("PASSWORD"), rs.getDate("BIRTH").toLocalDate()));
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
