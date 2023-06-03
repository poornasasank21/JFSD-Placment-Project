<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./styles/change-pass.css">
<title>Recruiter - Change Pass</title>
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
<!--<form action="/changePass">
<input type="password" placeholder="password" name="pass">
<input type="password" placeholder="Confirm password">
<input type="submit" value="change">-->
			<div class="flex-container">
	    			<div class="flex-item">
	    				Change Password
	    			</div>
	    			<div class="flex-item">
	    			<form action="/changePass" class="inner-flex">
						<div class="input-box">
							<input type="password" name="pass"/>
							<span>password</span>
						</div>
						<div class="input-box">
							<input type ="password"/>
							<span>confirm Password</span>
						</div>
						<div><button type="submit>Change</button></div>
					</form>
	    			</div>
				</div>
</form>
</body>
</html>