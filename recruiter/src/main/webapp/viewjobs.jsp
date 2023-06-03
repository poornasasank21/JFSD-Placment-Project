<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./styles/view-jobs.css"/>
<title>Recruiter - View Jobs</title>
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
<div class="table-wrapper">
 <c:if test="${not empty joboffers}">
 <c:set var = "uname" scope = "application" value = "${uname}"/>
	<table class="fl-table">
		<thead>
        <tr>
		<th>JOb ID</th>
		<th>Job Location</th>
		<th>Job Responsibilities</th>
		<th>Job Description</th>
		<th>Job Qualification</th>
		<th>Job Recruiter</th>
		<th>Last Date to Apply</th>
		<th>Applied List</th>
        </tr>
        </thead>
        <tbody>
        	<c:forEach var="p" items="${joboffers}">
		<c:if test="${p.postedbyusername == uname}">
				<tr>
    					<td>${p.jobid}</td>
    					<td>${p.location}</td>
    					<td>${p.responsibilities}</td>
    					<td>${p.description}</td>
    					<td>${p.qualification}</td>
    					<td>${p.postedbyusername}</td>
    					<td>${p.lastDate}</td>
    				<form action="getAppliedStudents">
					<input type="hidden" name="jobid" value="${p.jobid }">
     				<input type="hidden" name="uname" value="${p.postedbyusername}">    
    					<td><input type="submit" value="Applied"></td>
    				</form>
			    </tr>
		</c:if>
   		</c:forEach>
        </tbody>
	</table>
	</c:if>
</div>
</body>
</html>