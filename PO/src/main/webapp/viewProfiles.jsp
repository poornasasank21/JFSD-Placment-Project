<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="stylesheet" href="./styles/view-profile.css"/>
	<title>PO - View Profiles</title>
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
    <div class="table-wrapper">
	<c:if test="${not empty student}">
	<table class="fl-table">
		<thead>
        <tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Student Gender</th>
        </tr>
        </thead>
        <tbody>
        	<c:forEach var="p" items="${student}">
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