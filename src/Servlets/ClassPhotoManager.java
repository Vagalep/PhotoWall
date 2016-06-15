package Servlets;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClassPhotoManager {
	public ArrayList<String> getPhotosList() throws ClassNotFoundException, SQLException{
		ClassConnector c = new ClassConnector();
		return c.selectPhotosName();
	}	
	String getPhotosDate(){
		return null;
	}
	
	String getUploaderName(){
		return null;
	}
}
	

