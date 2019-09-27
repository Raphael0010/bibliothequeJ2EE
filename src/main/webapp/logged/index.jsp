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
	<center><h1>Vous êtes connecté!</h1></center>
	<p>
    Vous pouvez consulter la liste des oeuvres ci dessous
    </p><br>

    <table border="1">
        <thead>
            <tr>
                <th>Titre</th>
                <th>Auteur</th>
                <th>Annee</th>
                <th>Prix</th>
                <th>Image</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${livres}" var="livre">
                <tr>      
                    <td>${livre.titre}</td>
                    <td>${livre.auteur}</td>
                    <td>${livre.annee}</td>
                    <td>${livre.prix}</td>
                    <td><img src="${livre.img}"  width="50" height="80"/></td>  
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="/bibliotheque_tp/logged/logout">Déconnexion</a></p>
</body>
</html>
