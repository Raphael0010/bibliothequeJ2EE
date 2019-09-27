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
	<center><h1>Ajout d'un livre!</h1></center>

    <form action="/bibliotheque_tp/admin/book/create" method="POST">
        <label>Titre : </label><input type="text" name="titre"/>
        </br>
        <label>Auteur : </label><input type="text" name="auteur"/>
        </br>
        <label>Prix : </label><input type="text" name="prix"/>
        </br>
        <label>Annee : </label><input type="text" name="annee"/>
        </br>
        <label>Image : </label><input type="text" name="img"/>
        <br>
        <input type="submit" value="Ajouter"/>
    </form>

    
    <p><a href="/bibliotheque_tp/admin/index">Retour arrière</a></p>
</body>
</html>
