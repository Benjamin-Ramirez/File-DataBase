<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN PRUEBAS</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form:form action="/crear/img" method="post" modelAttribute="admin" enctype="multipart/form-data">
			<div class="form-group">
				<form:label path="nombre">Nombre: </form:label>
				<form:input path="nombre" class="form-control"/>
				<form:errors path="nombre" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="ingredientes">Ingredientes: </form:label>
				<form:input path="ingredientes" class="form-control"/>
				<form:errors path="ingredientes" class="text-danger"/>
			</div>
			<div class="form-group">
     		<label class="form-label">Imagenes:</label> 
		     <input class="form-control" name="file" type="file">
			</div>
			<input type="submit" value="Guardar" class="btn btn-info"/>
		</form:form>
	</div>
</body>
</html>