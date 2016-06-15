package Servlets;

import java.sql.*;

public class ClassConnector {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	ClassConnector() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/insta_killer?user=root&password=123123123");
		st = con.createStatement();
	}

	boolean selectLoginCheck(String login) throws SQLException {
		try {
			rs = st.executeQuery("SELECT (user_name) FROM users where user_name='" + login + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs.next();
	}
	
	boolean selectLoginPwdCheck(String login, String password) throws SQLException {
		try {
			rs = st.executeQuery("SELECT * FROM users where user_name='" + login + "' and user_password='" + password + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs.next();
	}
	
	String selectUserID(String login) throws SQLException {
		try {
			rs = st.executeQuery("SELECT (id) FROM users where user_name='" + login + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String id = null;
		if (rs.next()){
			id = rs.getString(1);
			}
		return id;
	}

	void insertNewUser(String login, String password, String firstName, String lastName) throws SQLException {
		st.execute("insert into users (user_name, user_password, user_first_name, user_last_name) values ('"
						+ login + "', '" + password + "', '" + firstName + "', '" + lastName + "');");
	}

	void close() throws SQLException {
		rs.close();
		st.close();
		con.close();
	}

}
