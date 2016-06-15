<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*"%>
	<%@ page import="Servlets.ClassUsersManager"%>
	<% ClassUsersManager classUM = new ClassUsersManager();
	ArrayList<String> ul = classUM.getUsersList();
	%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main page</title>
</head>

<body style="background: url(images/mainBG.jpg); width: 100%; background-size: 100% 100%; background-attachment: fixed;">
SESSION: <%= (String) session.getAttribute("authorization") %>
		<a href="/PhotoWall/home"/>Quit</a><br />
		
		
<div>
            <h3> Choose File to Upload in Server </h3>
            <form action="Uploader" method="post" enctype="multipart/form-data">
                <input type="file" name="file" />
                <input type="submit" value="upload" />
            </form>          
        </div>	
		
		<div>
           ${requestScope["message"]}
        </div>
		
</form>
	<div style="width: 1000px; margin: 50px auto; background-color: black; padding: 15px 0; overflow: hidden;">
		<div style="display: table; width: 100%;">

			<div style="background-color: #a6a6a6; width: 100%; float: left; padding: 10px 0; display: inline-block; box-sizing: border-box;">
				<img src="photos/" style="width:600px; height:400px; margin-left: 50px; padding-bottom: inherit; padding-top: inherit;">
				<div style="background: brown; width: 100%; height: 35px; padding: 10px; box-sizing: border-box;">
				<b>Posted:</b>&nbsp;<b>By:</b>
				</div>
			</div>
		
			<div style="width: 300px; border: 2px; background: url(images/usersBG.jpg); padding: 10px 0; box-sizing: border-box; display: table-cell; vertical-align: top; text-align: center;">
			<h3>Our Users:<h3/><br />
			<% for (int i=0; i<ul.size();i++){ %>
        	<tr>      
            	<td><% out.write(ul.get(i).toString());%></td><br /> <br /> 
       	 	</tr>
			<%}%>

			</div>
		</div>
	</div>
</body>


</html>