<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page 2 jsp</title>
</head>
<body>
	<h3>
		<%			
			String l = request.getParameter("leLogin");
		%>
		Bienvenue sur votre compte
		<% 
		out.print(l); 
		%>
	</h3>
</body>
</html>