<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/view-app-stux.css" />
<title>View Applied Status</title>
</head>
<body>
	<%@page import="com.sdp.entity.*"%>
	<%@page import="java.util.*"%>
	<%
	GetAppliedStudents g = (GetAppliedStudents) request.getAttribute("resultclass");

	List<Student> l = g.getL();
	%>

	<table class="styled-table">
		<thead>
			<tr>
				<th>ID</th>
			</tr>
			<tr>
				<th>Name</th>
			</tr>
			<tr>
				<th>Gender</th>
			</tr>
			<tr>
				<th>College ID</th>
			</tr>
			<tr>
				<th>Email</th>
			</tr>
		</thead>

		<%
		for (int i = 0; i < l.size(); i++) {
		%>
		<tr>
			<td><%=l.get(i).getUserID()%></td>
		</tr>
		<tr>
			<td><%=l.get(i).getCollegeName()%></td>
		</tr>
		<tr>
			<td><%=l.get(i).getGender()%></td>
		</tr>
		<tr>
			<td><%=l.get(i).getCollegeID()%></td>
		</tr>
		<tr>
			<td><%=l.get(i).getCollegeName()%></td>
		</tr>


		<%
		}
		%>
	</table>

</body>
</html>