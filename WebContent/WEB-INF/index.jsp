<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body
	style="background: url(images/indexBG.jpg); width: 100%; background-size: 100% 100%; background-attachment: fixed; text-align: center">
	<div style="width: 100%; height: 100%; position: fixed; top: 50%;">
		<form action="LogInServlet" method="POST">
			<b>Login:&nbsp;</b><input type="text" name="login" /> 
			<b>Password:&nbsp;</b><input type="password" name="password" /> <br /> <br /> 
			<input type="submit" name="enter" value="Log In" /> <br /> <br />
		</form>
		<a href="/PhotoWall/registration">Sing in</a>
	</div>
</body>
</html>