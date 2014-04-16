package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CoursSession;
import beans.CoursSessionItem;
import beans.Enseignant;
import beans.Salle;

public class FicheCoursSessionItem extends HttpServlet {
	
	private static final long serialVersionUID = 6008827943681255329L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
				HttpSession session = request.getSession();
				int idCoursSession = Integer.parseInt(request.getParameter("idCoursSession"));
				CoursSession courssession = CoursSession.getUnCoursSession(idCoursSession);
				int idSalle = CoursSessionItem.getCoursSessionItem(idCoursSession).getIdSalle();
				int idCours = courssession.getIdCours();
				int idEnseignant = CoursSessionItem.getCoursSessionItem(idCoursSession).getIdEnseignant();
				session.setAttribute("unenseignant", Enseignant.getUnEnseignant(idEnseignant));
				session.setAttribute("lasalle", Salle.getLaSalle(idSalle));
				session.setAttribute("courssession", courssession);
				session.setAttribute("lesCoursSession", CoursSession.getLesCoursSession(idCours));
				session.setAttribute("lesCoursSessionItem", CoursSessionItem.getLesCoursSessionItem(idCoursSession));
				response.sendRedirect("coursDetailInscription.jsp");
				
	}	
			
}
