<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/std-reg.css"/>
<title>Student Registration</title>
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
	    			<form action="studentreg" class="inner-flex">
						<div class="input-box">
							<input type="text" name="userID"/>
							<span>Email ID</span>
						</div>
						<div class="input-box">
							<input type="text" name="name"/>
							<span>Name</span>
						</div>
						<div class="input-box">
							<input type ="password" name="password"/>
							<span>Password</span>
						</div>
						<div class="input-box">
							<input type="text" name="gender"/>
							<span>Gender</span>
						</div>
						<div class="input-box">
							<input type="text" name="collegeID"/>
							<span>College ID</span>
						</div>
						<div class="input-box">
							<input type="text" name="collegeName"/>
							<span>College Name</span>
						</div>
						<div>
							<button type="submit" id="reg-button">Register</button>
						</div>
					</form>
	    			</div>
	    			<div class="flex-item">
	    				Or : <a href="./stdlgn.jsp">Login</a>
	    			</div>
				</div>
	<div>
</body>
</html>