<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h1 {
   border: 5px solid black;
  margin: 2%;
  padding: 2%;
  color: red;
}
th {
color: orange;
padding: 5%;
}
td {
color: red;
padding: 5%;
}
</style>
<meta charset="ISO-8859-1">
<title>view students</title>
</head>
<body>
<h1 >View JOB OFFERS</h1>
<%@ page import="com.sdp.services.Main" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sdp.entity.JobOffers" %>
<%
List<JobOffers> l=(List)request.getAttribute("list");
%>
<table>
  <tr>
    <th>ID</th>
    <th>Desc</th>
    <th>loc</th>
    <th>user</th>
    <th>qual</th>
    <th>recp</th>
  </tr>

<% for(JobOffers p: l){ %>
  <tr>
    <td><%=p.getJobid() %></td>
    <td><%=p.getDescription() %></td>
    <td><%=p.getLocation() %></td>
    <td><%=p.getPostedbyusername() %></td>
    <td><%=p.getQualification() %></td>
    <td><%=p.getResponsibilities() %></td>
  </tr>
<%  } %>
</table>
</body>
</html>