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
	<center><h1>Vous êtes connecté en tant qu'ADMIN!</h1></center>

        <p><a href="/bibliotheque_tp/admin/book/create">Ajouter un livre</a></p>
        
        <p>Liste des livres : </p>
        <table border="1">
            <thead>
                <tr>
                    <th>Titre</th>
                    <th>Auteur</th>
                    <th>Annee</th>
                    <th>Prix</th>
                    <th>Image</th>
                    <th>Modifier</th>
                    <th>Supprimer</th>
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
                        <td><center><a href="/bibliotheque_tp/admin/book/update?id=${livre.id}"><img src="https://cdn1.iconfinder.com/data/icons/hawcons/32/698873-icon-136-document-edit-512.png"  width="30" height="30"/></a></center></td>  
                        <td><center><a href="/bibliotheque_tp/admin/book/delete?id=${livre.id}"><img src="https://cdn4.iconfinder.com/data/icons/icocentre-free-icons/114/f-cross_256-512.png"  width="30" height="30"/></a></center></td>  
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    
    <p><a href="/bibliotheque_tp/admin/logout">Déconnexion</a></p>
</body>
</html>
