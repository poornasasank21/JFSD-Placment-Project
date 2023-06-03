<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./styles/add-exam.css"/>
<title>Add Exams</title>
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
	    				Add Exam
	    			</div>
	    			<div class="flex-item">
	    			<form action="addExam" class="inner-flex">
						<div class="input-box">
							<input type="text" name="examName"/>
							<span>Exam name</span>
						</div>
						<div><button type="submit">Add</button></div>
					</form>
	    			</div>
				</div>	
</body>
</html>