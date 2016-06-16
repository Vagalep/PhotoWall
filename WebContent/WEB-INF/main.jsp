<%@page import="Servlets.ClassPhotoManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*"%>
	<%@ page import="Servlets.ClassUsersManager"%>
	<%@ page import="Servlets.ClassPicture"%>
	<%@ page import="Servlets.ClassUsers"%>
	
	<% ClassUsersManager classUM = new ClassUsersManager();
	ArrayList<ClassUsers> ul = classUM.getUsersList();
	
	ClassPhotoManager classPM = new ClassPhotoManager();
	ArrayList<ClassPicture> pl = classPM.getPhotosList();
	%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main page</title>
</head>

<body style="background: url(images/mainBG.jpg); width: 100%; background-size: 100% 100%; background-attachment: fixed;">
<!--SESSION: <%= (String) session.getAttribute("authorization") %>
		-->
			<form action="RedirectToIndex" method="POST">
                <input type="submit" value="QUIT" />
            </form>
		
		
<div>
            <h3> Choose File to Upload</h3>
            <form action="Uploader" method="post" enctype="multipart/form-data">
                <input type="file" name="file" />
                <input type="submit" value="upload" />
            </form>          
        </div>	
		<span style="font-style: italic; color: red; position: absolute;">${requestScope["message"]}</span>
		
</form>
		<center><h2>THE WALL</h2></center>
	<div style="width: 1000px; margin: 25px auto; background-color: #FAEBD7; padding: 15px 0; overflow: hidden;">
		<div style="display: table; width: 100%;">
	<% for (int i=0; i<pl.size();i++){ %>
			<div style="background-color: #a6a6a6; width: 100%; float: left; padding: 10px 0; display: inline-block; box-sizing: border-box;">
				<img src="photos/<%= pl.get(i).get_photo_name() %>" style="width:600px; height:400px; margin-left: 50px; padding-bottom: inherit; padding-top: inherit;">
				<div style="background: #FFEBCD; width: 100%; height: 35px; padding: 10px; box-sizing: border-box;">
				<b><span style="font-style: italic;">Posted: </span><%= pl.get(i).get_post_date() %>; <%= pl.get(i).get_post_time() %></b>&nbsp;<b> <span style="font-style: italic;">By: </span> <%= pl.get(i).get_uploader() %></b>
				</div>
			</div>
		<%}%>
			<div style="width: 300px; border: 2px; background: url(images/usersBG.jpg); padding: 10px 0; box-sizing: border-box; display: table-cell; vertical-align: top; text-align: center;">
			<h3>Users TOP:</h3>
			<% for (int i=0; i<ul.size();i++){ %>
        	<tr>      
            	<td><%= ul.get(i).get_photos_count() %> images posted by: <%= ul.get(i).get_user_name() %></td><br /> <br /> 
       	 	</tr>
			<%}%>

			</div>
		</div>
	</div>
</body>


</html>