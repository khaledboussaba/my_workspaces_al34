<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

	<h5 style="margin-left: 85em;">${ login.getName() }</h5>

	<form class="container" action="AjouterArticle" method="post">
		<div class="form-group">
			<label for="exampleInputNomAritcle">Nom article</label> <input type="text"
				class="form-control" id="exampleInputLogin1"
				placeholder="Enter name" name="nom">
		</div>
		<div class="form-group">
			<label for="exampleInputPrix">Prix</label> <input
				type="number" class="form-control" id="exampleInputPrix"
				placeholder=" Enter price" name="prix">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>