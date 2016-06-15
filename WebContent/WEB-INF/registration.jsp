<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body style="background: url(images/indexBG.jpg); width: 100%; background-size: 100% 100%; background-attachment: fixed; text-align: center">

<div style="width: 100%; height: 100%; position: fixed; top: 40%;">

	<form action="Registration" method="POST">
		Login: <input style="margin-left:28px;" type="text" name="login" value="${prevLog}"/> <span style="font-style: italic; color: red; position: absolute;">${requestScope["loginError"]}</span> <br /><br />
		Password: <input style="margin-left:6px;" type="text" name="password" /> <span style="font-style: italic; color: red; position: absolute;">${requestScope["pwdError"]}</span> <br /><br />
		First name: <input style="margin-left:-1px;" type="text" name="firstName" value="${prevFirst}" /> <span style="font-style: italic; color: red; position: absolute;">${requestScope["fError"]}</span> <br /><br />
		Last name: <input type="text" name="lastName" value="${prevLast}" /> <span style="font-style: italic; color: red; position: absolute;">${requestScope["lError"]}</span> <br /><br />
		<input type="submit" name="registration" value="Registration" /><br /><br />
	</form>
	<a href="/PhotoWall/home" style="font-style: italic">Back to home page</a>

</div>
</body>
</html>