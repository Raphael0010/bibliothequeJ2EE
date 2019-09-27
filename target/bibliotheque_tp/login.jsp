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
	<center><h1>Connexion!</h1></center>
    <form action="/bibliotheque_tp/login" method="POST">
        <label>Nom d'utilisateur : </label><input type="text" name="user"/>
        </br>
        <label>Mot de passe : </label><input type="password" name="pass"/>
        <br>
        <input type="submit"/>
    </form>
         <p><a href="/bibliotheque_tp/index">Retour arrière</a></p>

</body>
</html>
