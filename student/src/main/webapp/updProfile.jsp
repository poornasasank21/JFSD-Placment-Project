<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./styles/std-edit.css"/>
<title>Edit Student Details</title>
</head>
<body>
	<header>
      <div class="logo" alt="logo"><a href="#">SRC</a></div>
      <nav>
        <ul class="nav-links">
          <button><a href="/stdindex.jsp">Go back</a></button>
        </ul>
      </nav>
    </header>
    <div class="flex-container">
    	<div class="flex-item">Edit</div>
    	<div class="flex-item">
    		<form action="updateStudentData" class="inner-flex">
    			<div class="input-box">
    				<input type="text" value="${profile.name}" name="name"/>
    				<span>name</span>
    			</div>
    			<div class="input-box">
    				<input type="text" value="${profile.userID}" name="userID"/>
    				<span>user ID</span>
    			</div>
    			<div class="input-box">
    				<input type ="password" value="${profile.password}" name="password"/>
    				<span>password</span>
    			</div>
    			<div class="input-box">
    				<input type="text" value="${profile.gender}" name="gender"/>
    				<span>gender</span>
    			</div>
    			<div class="input-box">
    				<input type="text" value="${profile.collegeID}" name="collegeID"/>
    				<span>college id</span>
    			</div>
    			<div class="input-box">
						<input type="text" value="${profile.branch}" name="branch"/>
						<span>branch</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.specilization}" name="specilization"/>
						<span>specialization</span>
					</div>
    			<div class="input-box">
    				<input type="text" value="${profile.collegeName}" name="collegeName"/>
    				<span>college name</span>
    			</div>
    			<div class="input-box">
    				<input type="text" value="${profile.cGPA}" name="cGPA"/>
    				<span>cgpa</span>
    			</div>
    			<div class="input-box">
    				<input type="text" value="${profile.passingOutYear}" name="passingOutYear"/>
    				<span>passing out year</span>
    			</div>
    			<div class="input-box">
    				<input type="text" value="${profile.linkedinUrl}" name="linkedinUrl"/>
    				<span>linkedin username</span>
    			</div>
    			<div class="input-box">
    				<input type="text" value="${profile.githubUrl}" name="githubUrl"/>
    				<span>github username</span>
    			</div>
    			<div class="input-box">
    				<input type="text" value="${profile.stopstalkUrl}" name="stopstalkUrl"/>
    				<span>stopstalk id</span>
    			</div>
    			<div class="input-box">
						<input type="text" value="${profile.codeforces}" name="codeforces"/>
						<span>codeforces id</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.codechef}" name="codechef"/>
						<span>codechef id</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.leetcode}" name="leetcode"/>
						<span>leetcode id</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.interviewBit}" name="interviewBit"/>
						<span>interviewbit id</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.spoj}" name="spoj"/>
						<span>spoj id</span>
					</div>
    			<div class="input-box"><button type="submit" id="reg-button">Update</button></div>
	      </form>
    	</div>
    </div>
</body>
</html>