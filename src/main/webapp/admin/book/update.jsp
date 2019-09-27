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
	<center><h1>Modification du livre : ${livre.id} !</h1></center>

    <form action="/bibliotheque_tp/admin/book/update" method="POST">
        <input hidden type="text" name="id" value="${livre.id}"/>
        <label>Titre : </label><input type="text" name="titre" value="${livre.titre}"/>
        </br>
        <label>Auteur : </label><input type="text" name="auteur" value="${livre.auteur}"/>
        </br>
        <label>Prix : </label><input type="text" name="prix" value="${livre.prix}"/>
        </br>
        <label>Annee : </label><input type="text" name="annee" value="${livre.annee}"/>
        </br>
        <label>Image : </label><input type="text" name="img" value="${livre.img}"/>
        <br>
        <input type="submit" value="Modifier"/>
    </form>

    
    <p><a href="/bibliotheque_tp/admin/index">Retour arrière</a></p>
</body>
</html>
