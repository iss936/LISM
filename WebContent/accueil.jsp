<%@page import="java.util.List"%>
<%@page import="beans.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% List<Cours> lesCours = (List<Cours>)session.getAttribute("lesCours"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISM</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/inc/style.css" />
</head>
<body>

	<ul>
 		<li><a href="#">Accueil</a></li>
 		<li><a href="#">Mes cours</a></li>
 		<li><a href="#">Mes évaluations</a></li>
	</ul>
	<br><br><br><br>
	
	<fieldset>
		<legend>Matières</legend>
	<table>
		<% for(int i = 0; i < lesCours.size(); i++) { %>
		<tr>
			<td><a href="FicheCoursSession?idCours=<% out.print(lesCours.get(i).getIdCours()); %>"><% out.print(lesCours.get(i).getLibelleCours()); %></a></td>
		</tr>
		<% } %>
	</table>
	</fieldset>
	
</body>
</html>