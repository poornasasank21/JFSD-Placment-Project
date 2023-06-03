<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/std-reg.css"/>
<title>Student - Registration</title>
</head>
<body>
    <header>
      <div class="logo" alt="logo"><a href="main.jsp">SRC</a></div>
      <nav>
        <ul class="nav-links">
          <li><a href="./stdlgn.jsp">Student</a></li>
          <li><a href="#">Recruiter</a></li>
          <li><a href="#">Placement Officer</a></li>
          <button>About Us</button>
        </ul>
      </nav>
    </header>
        <div class="flex-continer">
			<div class="flex-container">
	    			<div class="flex-item">
	    				Register
	    			</div>
	    			<div class="flex-item">
	    			<form:form action="register123" method="post" modelAttribute="student" class="inner-flex">
						<div class="input-box">
							<form:label path="userID">Email :</form:label>
      							<form:input path="userID" />
      							<form:errors path="userID" cssClass="error" />
							<!--<span>user ID</span>-->
						</div>
						<div class="input-box">
							 <form:label path="password">Password :</form:label>
      							<form:password path="password"/>
     							 <form:errors path="password" cssClass="error" />
							<!--<span>password</span>-->
						</div>
						<div class="input-box">
							  <form:label path="name">Name :</form:label>
						      <form:input path="name" />
						      <form:errors path="name" cssClass="error" />
							<!--<span>name</span>-->
						</div>
						<div class="input-box">
							      <form:label path="gender">Gender :</form:label>
							      <form:input path="gender" />
							      <form:errors path="gender" cssClass="error" />
							<!--<span>Gender</span>-->
						</div>
						<div class="input-box">
							      <form:label path="collegeName">College Name :</form:label>
							      <form:input path="collegeName" />
							      <form:errors path="collegeName" cssClass="error" />
							<!--<span>College name</span>-->
						</div>
						<div class="input-box">
							      <form:label path="collegeID">College ID :</form:label>
							      <form:input path="collegeID" />
							      <form:errors path="collegeID" cssClass="error" />
							<!--<span>College id</span>-->
						</div>
						<div>
							<form:button>Register</form:button>
						</div>
					</form:form>
	    			</div>
	    			<div class="flex-item">
	    				Or : <a href="./stdlgn.jsp">Login</a>
	    			</div>
				</div>
	<div>
</body>
</html>