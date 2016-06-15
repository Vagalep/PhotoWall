package Servlets;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ClassPhotoManager {
	public ArrayList<ClassPicture> getPhotosList() throws ClassNotFoundException, SQLException{
		ClassConnector c = new ClassConnector();
		return c.selectPhotosInfo();
	}	
}
	

