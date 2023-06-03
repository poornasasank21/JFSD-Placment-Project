<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/del-stu.css" />
<title>PO - Delete student</title>
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
					<div class="flex-container">
	    			<div class="flex-item">
	    				Delete Student
	    			</div>
	    			<div class="flex-item">
	    			<form action="deleteStudent" class="inner-flex">
						<div class="input-box">
							<input type="text" name="userID"/>
							<span>username</span>
						</div>
						<div><button type="submit" id="login-button">Delete</button></div>
					</form>
	    			</div>
					</div>
</body>
</html>