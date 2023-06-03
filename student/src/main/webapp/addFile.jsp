<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Boot File Upload to S3</title>
</head>
<body>
    <div align="center">
        <div><h2>Spring Boot File Upload to S3</h2></div>
        <div>
            <form action="uploadFiles" method="post" enctype="multipart/form-data">
                <p>
                    Description:
                    <input type="text" name="description" size="30" required />
                </p>
                 
                <p>
                    <input type="file" name="file" required />
                </p>
                 
                <p>
                    <button type="submit">Submit</button>
                </p>
            </form>
        </div>
    </div>
</body>
</html>