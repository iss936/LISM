<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<c:set scope="session" var="erreurs" value="${sessionScope['erreurs']}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISM</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/inc/style.css" />
</head>
<body>
	<form method="POST" action="Connexion">
		<label for="login">Login</label><input id="login" name="login" type="text"> <br>
		<label for="mdp">Mot de passe</label><input id="mdp" name="mdp" type="password"> <br>
		<label>Validation :</label><input name="ok" type="submit" value="Ok"/>
		<c:if test="${erreurs}">
			<br>
			<span class='error'>Login ou mot de passe incorrect !</span>  
		</c:if>
	</form>
</body>
</html>