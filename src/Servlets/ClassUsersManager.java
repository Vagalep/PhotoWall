package Servlets;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClassUsersManager {
	public ArrayList<String> getUsersList() throws SQLException{
		ClassConnector c = new ClassConnector();
		return c.selectUsersName();
	}	
}