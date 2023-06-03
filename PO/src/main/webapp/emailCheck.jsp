<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./styles/emailcheck.css">
<title>PO - Email Check</title>
</head>
<body>
    <header>
      <div class="logo" alt="logo"><a href="pomain.jsp">SRC</a></div>
      <nav>
        <ul class="nav-links">
          <li><a href="#">Student</a></li>
          <li><a href="#">Recruiter</a></li>
          <li><a href="./emailCheck.jsp">Placement Officer</a></li>
          <button>About Us</button>
        </ul>
      </nav>
    </header>
				<div class="flex-container">
	    			<div class="flex-item">
	    				Enter Email
	    			</div>
	    			<div class="flex-item">
	    			<form action="emailCheck" class="inner-flex">
						<div class="input-box">
							<input type="text" name="poEmail"/>
							<span>PO Email</span>
						</div>
						<div><button type="submit" id="login-button">Submit</button></div>
					</form>
	    			</div>
				</div>
</body>
</html>