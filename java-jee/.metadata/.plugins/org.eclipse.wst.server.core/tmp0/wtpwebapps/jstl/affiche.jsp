<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affiche</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

	<form action="deAffiche.toto" method="post">
	
		<div class="form-group">
			<label>Nom : </label> 
			<c:out value="${ param.nom }"/> <br>
			<label>Prénom : </label>
			<c:out value="${ param.prenom }" />
		</div>
			
		<div class="form-group">
			<label>Cours suivis : </label><br>
			<c:forEach var="unCours" items="${ paramValues.coursSuivis }">
				-><c:out value="${ unCours }" /><br>
			</c:forEach>
		</div>
		
		<c:if test="${ !empty param.autreCours }">
			<label>Et aimerait suivre les cours suivants : </label><br>
			<c:forTokens var="c" items="${ param.autreCours }" delims=",">
				-><c:out value="${ c }" /><br>
			</c:forTokens>
		</c:if>
		
		<input type="submit" value="Valider" class="btn btn-success">
	
	</form>

</body>
</html>