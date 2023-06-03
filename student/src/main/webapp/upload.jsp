<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/upload123" method="post" enctype="multipart/form-data">
    <p>
        <input type="file" name="file" required />
    </p>
    <div class="d-grid gap-2">
  <button class="btn btn btn-primary" type="submit">Upload to AWS</button>
</div>
</form>
</body>
</html>