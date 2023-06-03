<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./styles/view-exams.css"/>
<meta charset="ISO-8859-1">
<title>View Exams</title>
</head>
<body>
	<c:if test="${not empty exams}">
	<table>
	<tr>
	<th>Exam ID</th>
	<th>Exam name</th>
	</tr>
	<c:forEach var="p" items="${exams}">
	<tr>
	<td>${p.examID}</td>
	<td>${p.examName}</td>  
	<form action="editExam">
	<input type="hidden" name="examID" value="${p.examID }">
	<input type="hidden" name="examName" value="${p.examName}">
	<td><input type="submit"></td>
	</form>
	</tr>
	</c:forEach>
	</table>
	 </c:if>
	 <div class="table-wrapper">
	<c:if test="${not empty exams}">
	<table class="fl-table">
		<thead>
        <tr>
			<th>Exam ID</th>
			<th>Exam Name</th>
        </tr>
        </thead>
        <tbody>
        	<c:forEach var="p" items="${exams}">
				<tr>
				    <td>${p.userID}</td>
				    <td>${p.collegeID}</td>
				    <td>${p.gender}</td>
			    </tr>
		   </c:forEach>
        </tbody>
	</table>
	</c:if>
</div>
</body>
</html>