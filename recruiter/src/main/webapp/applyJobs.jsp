<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.sdp.entity.JobOffers"%>
   
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply Job</title>
</head>
<body style="background-color:grey;">
<navbar>
        <ul class="nav-list">
          <li class="nav-item"><a href="./main.jsp">IRP-RC</a></li>
          <li class="nav-item"><a href="./stdindex.jsp">${loggedInUser_userName}</a></li>
          <li class="nav-item"><a
      href="${pageContext.servletContext.contextPath}/logout1">Logout</a></li>
        </ul>
      </navbar>
<h1>Job's Available to apply</h1>
<% 
  List<JobOffers> l=(List)request.getAttribute("list");
%>
<br><br><br>


<% for(JobOffers p: l){ %>
<form action="applyJobController">
 <fieldset>
  <legend>Job :</legend>
<input type="hidden"  name="userID" value="${loggedInUser_userName}")>
<input type="hidden"  name="jobid" value=<%=p.getJobid()%>>

  <input type="submit" value="Submit">
 </fieldset>
</form>
<br>

<% } %>
</body>
</html>