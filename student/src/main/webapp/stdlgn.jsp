<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/std-lgn.css"/>
<title>Student Login</title>
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
    			<div class="flex-container">
	    			<div class="flex-item">
	    				Login
	    			</div>
	    			<div class="flex-item">
	    			<form action="studentlogincheck" class="inner-flex">
						<div class="input-box">
							<input type="text" name="userID"/>
							<span>ID</span>
						</div>
						<div class="input-box">
							<input type ="password" name="password"/>
							<span>Password</span>
						</div>
						<div><button type="submit" id="login-button">Login</button></div>
					</form>
	    			</div>
	    			<div class="flex-item">
	    				Or : <a href="register123">Register</a>
	    			</div>
	    			
				</div>
</body>
</html>