<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Profile</h2>
<form action="slgn">

Username<input type="text" value="${loggedInUser_userName}" disabled="disabled"/></br>
Password<input type ="password" placeholder="***" name="spass"/>
<input type="submit" value="Login">

<h2></h2>

</form>
</body>
</html>