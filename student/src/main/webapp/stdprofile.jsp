<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./styles/std-profile.css">
<title>Student Profile</title>
</head>
<body>
      <header>
      <div class="logo" alt="logo"><a href="#">SRC</a></div>
      <nav>
        <ul class="nav-links">
          <li><a href="/edit">Edit</a></li>
          <button><a href="/stdindex.jsp">Go back</a></button>
        </ul>
      </nav>
    </header>
    <div class="flex-container">
    	<div class="flex-item">Profile</div>
    	<div class="flex-item">
    		<c:if test="${not empty profile}">
				<form class="inner-flex">
					<div class="input-box">
						<input type="text" value="${profile.userID}" readonly/>
						<span>user id</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.name}" readonly/>
						<span>Name</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.gender}" readonly/>
						<span>gender</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.collegeID}" readonly/>
						<span>college id</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.branch}" readonly/>
						<span>branch</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.specilization}" readonly/>
						<span>specialization</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.passingOutYear}" readonly/>
						<span>passing out year</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.cGPA}" readonly/>
						<span>cgpa</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.linkedinUrl}" readonly/>
						<span>linkedin username</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.githubUrl}" readonly/>
						<span>github username</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.stopstalkUrl}" readonly/>
						<span>stopstalk id</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.collegeName}" readonly/>
						<span>college Name</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.codeforces}" readonly/>
						<span>codeforces id</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.codechef}" readonly/>
						<span>codechef id</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.leetcode}" readonly/>
						<span>leetcode id</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.interviewBit}" readonly/>
						<span>interviewbit id</span>
					</div>
					<div class="input-box">
						<input type="text" value="${profile.spoj}" readonly/>
						<span>spoj id</span>
					</div>
				</form>
			</c:if>
    	</div>
    </div>
</body>
</html>