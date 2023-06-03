<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/delete-job.css" />
<title>Recruiter - Delete Job</title>
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
					<div class="flex-container">
	    			<div class="flex-item">
	    				Enter Job ID
	    			</div>
	    			<div class="flex-item">
	    			<form action="deleteJob" class="inner-flex">
						<div class="input-box">
							<input type="text" name="jobid"/>
							<span>job id</span>
						</div>
						<div><button type="submit" id="login-button">Delete</button></div>
					</form>
	    			</div>
				</div>
</body>
</html>