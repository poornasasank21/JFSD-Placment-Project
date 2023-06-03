<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/add-rec.css"/>
<title>PO - Add Recruiter</title>
</head>
<body>
	<header>
      <div class="logo" alt="logo"><a href="#">SRC</a></div>
      <nav>
        <ul class="nav-links">
          <button><a href="./polgnsuccess.jsp">Go back</a></button>
        </ul>
      </nav>
    </header>
		<div class="flex-continer">
			<div class="flex-container">
	    			<div class="flex-item">
	    				Add Recruiter
	    			</div>
	    			<div class="flex-item">
	    			<form action="addRec" class="inner-flex">
						<div class="input-box">
							<input type="text" name="username"/>
							<span>username</span>
						</div>
						<div class="input-box">
							<input type="text" name="companyName"/>
							<span>company name</span>
						</div>
						<div class="input-box">
							<input type ="email" name="email"/>
							<span>email</span>
						</div>
						<div class="input-box">
							<input type="text" name="phoneno"/>
							<span>phone no</span>
						</div>
						<div class="input-box">
							<input type="text" name="location"/>
							<span>location</span>
						</div>
						<div class="input-box">
							<input type="password" name="password"/>
							<span>password</span>
						</div>
						<div>
							<button type="submit" id="login-button">Add</button>
						</div>
					</form>
				</div>
		<div>
</body>
</html>