<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="./styles/index.css" var="indCss"/>
<link rel="stylesheet" type="text/css" href="./styles/rec-index.css"/>
<title>Recruiter Home</title>
</head>
<body>
    	      <header>
			      <div class="logo" alt="logo"><a href="./stdindex.jsp">SRC</a></div>
			      <nav>
			        <ul class="nav-links">
			          <button><a href="${pageContext.servletContext.contextPath}/logout">Logout</a></button>
			        </ul>
			      </nav>
			    </header>
			      <div class="main-content">
				    <ol>
					    <li class=""><a href="./addjob.jsp">Add Jobs</a></li>
					    <li class=""><a href="./viewjobs">View Jobs</a></li>
					    <li class=""><a href="./deletejob.jsp">Delete Jobs</a></li>
					</ol>
				  </div>
</body>
</html>