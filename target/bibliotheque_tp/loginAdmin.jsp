<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Gestion de la bibliothèque</title>
</head>
<body>
	<center><h1>Admin!</h1></center>
	<form action="/bibliotheque_tp/loginAdmin" method="POST">
		<label>Nom d'utilisateur admin : </label><input type="text" name="userAdmin"/>
		</br>
		<label>Mot de passe admin : </label><input type="password" name="passAdmin"/>
		<br>
        <input type="submit"/>
	</form>
	<p><a href="/bibliotheque_tp/index">Retour arrière</a></p>

</body>
</html>
