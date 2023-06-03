<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/add-stu.css" />
<title>PO - Add Student</title>
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
	    				Add Student
	    			</div>
	    			<div class="flex-item">
	    			<form action="addStudent" class="inner-flex">
						<div class="input-box">
							<input type="text" name="userID"/>
							<span>user id</span>
						</div>
						<div class="input-box">
							<input type="text" name="name"/>
							<span>name</span>
						</div>
						<div class="input-box">
							<input type ="password" name="password"/>
							<span>password</span>
						</div>
						<div class="input-box">
							<input type="text" name="gender"/>
							<span>gender</span>
						</div>
						<div class="input-box">
							<input type="text" name="collegeID"/>
							<span>college id</span>
						</div>
						<div class="input-box">
							<input type="text" name="collegeName"/>
							<span>college name</span>
						</div>
						<div>
							<button type="submit" id="login-button">Add</button>
						</div>
					</form>
				</div>
		<div>
</body>
</html>