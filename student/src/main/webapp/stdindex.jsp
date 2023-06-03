<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/std-index.css" />
<title>Student Home</title>
</head>
<body>
      <header>
      <div class="logo" alt="logo"><a href="./stdindex.jsp">SRC</a></div>
      <nav>
        <ul class="nav-links">
          <li><a href="./profile">Profile</a></li>
          <button><a href="${pageContext.servletContext.contextPath}/logout1">Logout</a></button>
        </ul>
      </nav>
    </header>
  <div class="main-content">
    <ol>
	    <li class=""><a href="/applyjob">Apply for a job</a></li>
	    <!--<li class=""><a href="/writeExam">Exams</a></li>-->
	</ol>
  </div>
</body>
</html>