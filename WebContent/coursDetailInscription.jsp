<%@page import="javax.swing.JTextField"%>
<%@page import="java.util.List"%>
<%@page import="beans.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% List<CoursSession> lesCoursSession = (List<CoursSession>)session.getAttribute("lesCoursSession"); %>
<% List<CoursSessionItem> lesCoursSessionItem = (List<CoursSessionItem>)session.getAttribute("lesCoursSessionItem"); %>
<% CoursSession cs = (CoursSession)session.getAttribute("coursession"); %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" >
	<head>
		<title>Titre du site</title>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<link rel="stylesheet" media="screen" type="text/css" title="Design" href="${pageContext.request.contextPath}/inc/style.css" />
		<!--[if IE 6]><link rel="stylesheet" media="screen" type="text/css" title="Design" href="${pageContext.request.contextPath}/inc/ie6.css" /> <![endif]-->
		<!--[if IE 7]> <style type="text/css">
			.groupe_lien_MH{display : inline;margin-left:0px;}
			.sublien_MH{height : 37px;width : 120px;}
		</style> <![endif]-->
		<script src="${pageContext.request.contextPath}/inc/jquery-1.7.1.min.js" type="text/javascript"></script>
		<!--[if IE 6]>
			<script type="text/javascript">
				$(function()
				{
					$('.groupe_lien_MH').hover
					(
						function()
						{
							$(this).addClass('groupe_lien_MH_hover');
						},
						function()
						{
							$(this).removeClass('groupe_lien_MH_hover');
						}
					);
				}
				);
			</script>
		<![endif]-->
		<script type="text/javascript">
			animation_complete=function(){jQuery(this).hide();}
			jquery_MH_deroulant=function()
			{ 
				$(".groupe_lien_MH").mouseenter
				(
					function () 
					{
						$groupe_sublien=jQuery(this).find(".groupe_sublien_MH");
						$sublien=jQuery(this).find(".sublien_MH a");
						$bottom=jQuery(this).find(".MH_deroulant_bottom");
						$top=jQuery(this).find(".MH_deroulant_top");
						if ($groupe_sublien.is(":hidden") || $sublien.is(":hidden") )
						{
							$sublien.hide();
							$bottom.hide();
							$top.hide();
							$groupe_sublien.css({'height':'0px','width':$sublien.innerWidth()}).show();
							//IE8 does not support fadind to 100% and on imbricated div
							//therefore each element must be faded individually to 99%
							$sublien.fadeTo(400,0.99);
							$bottom.fadeTo(400,0.99);
							$top.fadeTo(400,0.99);
							$groupe_sublien.animate({height: $sublien.size()*$sublien.innerHeight() + $bottom.innerHeight() + $top.innerHeight()}, 400);
						} 
					}
				);
				$(".groupe_lien_MH").mouseleave
				(
					function ()
					{
						$sublien=jQuery(this).find(".sublien_MH a");
						$groupe_sublien=jQuery(this).find(".groupe_sublien_MH");
						if (!$groupe_sublien.is(":hidden"))
						{
							jQuery(this).find(".groupe_sublien_MH").animate({height:'0px'},{duration : 400, complete : animation_complete});
							$sublien.animate({opacity:'hide'},{duration : 400});
							$bottom.animate({opacity:'hide'},{duration : 400});
							$top.animate({opacity:'hide'},{duration : 400});
						}
					}
				);
			}
		</script>
	</head>

	<body onload="jquery_MH_deroulant();">

		<div id="conteneur">

			<div id="CHG"></div><div id="CHD"></div><div id="BH"></div>
			<div id="BG"><div id="BD">

				<div id="corps">
					<div id="marge_interieure">

						<div id="banniere"><div id="logo"></div></div>

						<!-- Début du menu horizontal -->
						<div id="MH">
							<div class="groupe_lien_MH">
								<a class="menu_MH" href="Connexion">Accueil</a>
								<!-- <div class="groupe_sublien_MH">
									<div class="sublien_MH">
										<a href="#">Sous-menu 1</a>
									</div>
									<div class="sublien_MH">
										<a href="#">Sous-menu 2</a>
									</div>
									<div class="sublien_MH">
										<a href="#">Sous-menu 3</a>
									</div>
									<div class="MH_deroulant_bottom"></div>
								</div> -->
							</div>
							<div class="groupe_lien_MH">
								<a class="menu_MH" href="#">Mes cours</a>
								<div class="groupe_sublien_MH">
									<div class="sublien_MH">
										<a href="#">Sous-menu 1</a>
									</div>
									<div class="sublien_MH">
										<a href="#">Sous-menu 2</a>
									</div>
									<div class="sublien_MH">
										<a href="#">Sous-menu 3</a>
									</div>
									<div class="MH_deroulant_bottom"></div>
								</div>
							</div>
							<div class="groupe_lien_MH">
								<a class="menu_MH" href="#">Mes évaluations</a>
								<div class="groupe_sublien_MH">
									<div class="sublien_MH">
										<a href="#">Sous-menu 1</a>
									</div>
									<div class="sublien_MH">
										<a href="#">Sous-menu 2</a>
									</div>
									<div class="sublien_MH">
										<a href="#">Sous-menu 3</a>
									</div>
									<div class="MH_deroulant_bottom"></div>
								</div>
							</div>
							<div class="groupe_lien_MH">
								<a class="menu_MH" href="#">Menu 4</a>
								<div class="groupe_sublien_MH">
									<div class="sublien_MH">
										<a href="#">Sous-menu 1</a>
									</div>
									<div class="sublien_MH">
										<a href="#">Sous-menu 2</a>
									</div>
									<div class="sublien_MH">
										<a href="#">Sous-menu 3</a>
									</div>
									<div class="MH_deroulant_bottom"></div>
								</div>
							</div>
						</div>
						<!-- Fin du menu horizontal -->

						<div id="texte"><div id="overflow">
							<div class="cadre"><div class="titre"> Détails et Inscription pour le cours suivant : <% out.print(cs.getDescription()); %></div><div class="marge_interne">

								<!-- Début de la zone de texte -->
								
								<table>
									<tr>
									<td>Intitulé</td>
									<td>Date</td>
									<td>Type de Cours</td>
									<td>Detail</td>
									</tr>
									<% for(int i = 0; i < lesCoursSessionItem.size(); i++) { %>
									<tr>
										<td><% out.print(lesCoursSession.get(i).getDescription()); %></td>
										<td><% out.print(lesCoursSession.get(i).getDateDebut()); %></td>
										<td><% out.print(lesCoursSession.get(i).getTypeCoursSession()); %></td>
										<td><% out.print(lesCoursSessionItem.get(i).getDescriptionDetail()); %></td>
									</tr>
									<% } %>
								</table>
								
								<!-- Fin de la zone de texte -->

							</div></div>
						</div></div>

						<div id="pied_de_page">
							<a href="#">E-Learning : LISM</a>
						</div>

					</div>
				</div>

			</div></div>
			<div id="CBG"></div><div id="CBD"></div><div id="BB"></div>

		</div>

	</body>
</html>