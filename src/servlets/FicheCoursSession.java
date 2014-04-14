package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;

public class FicheCoursSession extends HttpServlet{
	
	private static final long serialVersionUID = 6008827943681255329L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
					HttpSession session = request.getSession();
					int idCours = Integer.parseInt(request.getParameter("idCours"));
					Cours c = Cours.getUnCours(idCours);
					session.setAttribute("c", c);
					session.setAttribute("lesCoursSession", CoursSession.getLesCoursSession(idCours));
					response.sendRedirect("listeCours.jsp");
				}
}

