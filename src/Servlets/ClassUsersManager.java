package Servlets;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClassUsersManager {
	public ArrayList<ClassUsers> getUsersList() throws ClassNotFoundException, SQLException{
		ClassConnector c = new ClassConnector();
		return c.selectUsersInfo();
	}	
}