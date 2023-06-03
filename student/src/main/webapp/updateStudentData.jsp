<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/stu-update.css"/>
<title>Update Student Details</title>
</head>
<body>
      <navbar>
        <ul class="nav-list">
          <li class="nav-item"><a href="./main.jsp">IRP-RC</a></li>
          <li class="nav-item"><a href="./stdindex.jsp">Go back: ${loggedInUser_userName}</a></li>
          <li class="nav-item"><a
      href="${pageContext.servletContext.contextPath}/logout1">Logout</a></li>
        </ul>
      </navbar>
    <fieldset>
      <form action="updateStudentData" class="form-class">        
        <div><input type="text" placeholder="Name" name="name"/></div>
        <div><input type="text" placeholder="ID" name="userID"/></div>
        <div><input type ="password" placeholder="***" name="password"/></div>
        <div><input type="text" placeholder="gender" name="gender"/><br></div>
        <div><input type="text" placeholder="special roll no in clg" name="collegeID"/></div>
        <div><input type="text" placeholder="clg name" name="collegeName"/></div>
        <div><input type="text" placeholder="CGPA" name="cGPA"/></div>
        <div><input type="text" placeholder="passing out yr" name="passingOutYear"/></div>
        <div><input type="text" placeholder="Linkedin url" name="linkedinUrl"/></div>
        <div><input type="text" placeholder="Github url" name="githubUrl"/></div>
        <div><input type="text" placeholder="Stopstalk url" name="stopstalkUrl"/></div>
        <div><input type="submit" value="update" id="reg-button"></div>
      </form>
    </fieldset>
</body>
</html>