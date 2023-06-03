<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/add-job.css" />
<title>Recruiter - Add Job</title>
</head>
<body>
      <header>
      <div class="logo" alt="logo"><a href="#">SRC</a></div>
      <nav>
        <ul class="nav-links">
          <button><a href="./recindex.jsp">Go back</a></button>
        </ul>
      </nav>
    </header>
     <div class="flex-continer">
			<div class="flex-container">
	    			<div class="flex-item">
	    				Add Job
	    			</div>
	    			<div class="flex-item">
	    			<form action="addJob" class="inner-flex">
	    				<div class="input-box">
							<input type="text" value="${loggedInUser_userName}" name="postuser" disabled="disabled"/>
							<span>username</span>
						</div>
						<div class="input-box">
							<input type="text" name="jobid"/>
							<span>job ID</span>
						</div>
						<div class="input-box">
							<input type="text" name="role"/>
							<span>job role</span>
						</div>
						<div class="input-box">
							<input type="text" name="location"/>
							<span>location</span>
						</div>
						<div class="input-box">
							<input type="text" name="description"/>
							<span>description</span>
						</div>
						<div class="input-box">
							<input type="text" name="qualification"/>
							<span>qualification</span>
						</div>
						<div class="input-box">
							<input type="text" name="responsibilities"/>
							<span>responsibilities</span>
						</div>
						<div class="input-box">
							<input type="date" name="lastDate"/>
							<span>last date</span>
						</div>
						<div>
							<button type="submit" id="login-button">Add</button>
						</div>
					</form>
	    			</div>
				</div>
	<div>
</body>
</html>