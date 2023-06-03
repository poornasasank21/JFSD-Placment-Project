<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h1 {
   border: 5px solid black;
  margin: 2%;
  padding: 10%;
  color: red;
}
</style>
<meta charset="ISO-8859-1">
<title>view students</title>
</head>
<body>
<h1 >View Students</h1>
<%@ page import="com.mrs.services.Main" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mrs.pojo.Student" %>
<%
List<Student> l=(List)request.getAttribute("list");
%>
<table>
  <tr>
    <th>ID</th>
    
    
  </tr>

<% for(Student p: l){ %>
  <tr>
    <td><%=p.getUserID() %></td>
  </tr>
<%  } %>
</table>
</body>
</html>