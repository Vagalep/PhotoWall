package Servlets;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

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
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/photo_wall?user=root&password=123123123");
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
		String id = null;
		try {
			rs = st.executeQuery("SELECT (user_id) FROM users where user_name='" + login + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while (rs.next()){
			id = rs.getString(1);
			}
		return id;
	}
	
	ArrayList<String> selectUsersName() throws SQLException {
		ArrayList<String> usersList = new ArrayList<String>();
		try {
			rs = st.executeQuery("SELECT (user_name) FROM users;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while (rs.next()){
			usersList.add(rs.getString(1));
			}
		return usersList;
	}
	
	ArrayList<ClassPicture> selectPhotosInfo() throws SQLException {
		ArrayList<ClassPicture> photoList = new ArrayList<ClassPicture>();
		ClassPicture picture;
		try {
			rs = st.executeQuery("SELECT * FROM photos;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while (rs.next()){
			picture = new ClassPicture(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			photoList.add(picture);
			}
		return photoList;
	}

	void insertNewUser(String login, String password, String firstName, String lastName) throws SQLException {
		st.execute("insert into users (user_name, user_password, user_first_name, user_last_name) values ('"
						+ login + "', '" + password + "', '" + firstName + "', '" + lastName + "');");
	}
	
	void insertNewPhoto(String photosName, String userID) throws SQLException {
		st.execute("insert into photos (photo_name, uploader_id, post_date, post_time) values ('"+ photosName + "', " + userID + ", now(), now());");
	}

	void close() throws SQLException {
		rs.close();
		st.close();
		con.close();
	}
//
//
}
