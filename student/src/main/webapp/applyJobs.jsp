<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.sdp.entity.JobOffers"%>

<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/apply-jobs.css" />
<title>Apply for Jobs</title>
</head>
<body>
      <header>
      <div class="logo" alt="logo"><a href="#">SRC</a></div>
      <nav>
        <ul class="nav-links">
          <button><a href="/stdindex.jsp">Go back</a></button>
        </ul>
      </nav>
    </header>
    <main-cards>
    <%List<JobOffers> l = (List) request.getAttribute("list");%>
		<%for (JobOffers p : l)
		{%>
			<form action="applyJobController">
			<div class="container">
			  <div class="card">
			    <div class="box">
			      <div class="content">
			        <input type="hidden" name="userID" value="${loggedInUser_userName}"> 
        			<input type="hidden" name="jobid" value=<%=p.getJobid()%>>
			        <h2><%=p.getJobid()%></h2>
			        <h3><%=p.getRole()%></h3>
			        <%=p.getDescription()%>
			        <p>Recruiter:
					<%=p.getPostedbyusername()%></p>
			        <p>Responsibility:
					<%=p.getResponsibilities()%></p>
			        <p>Qualification:
					<%=p.getQualification()%></p>
			        <p>Location:
					<%=p.getLocation()%></p>
			        <input type="submit" value="Submit" id="button">
			      </div>
			    </div>
			  </div>
			</div>
			</form>
		<%}
		%>
	</main-cards>
</body>
</html>