<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>file upload test</title>
</head>
<body>
	
	<form method="post" action="uploader" enctype="multipart/form-data">
		<input type="text" name="name" />
		<input type="file" name="file" />
		<input type="submit" />
	</form>
</body>
</html>