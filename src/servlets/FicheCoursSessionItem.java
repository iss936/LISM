package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CoursSession;
import beans.CoursSessionItem;

public class FicheCoursSessionItem extends HttpServlet {
	
	private static final long serialVersionUID = 6008827943681255329L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
				HttpSession session = request.getSession();
				int idCours = Integer.parseInt(request.getParameter("idCours"));
				int idCoursSession = Integer.parseInt(request.getParameter("idCoursSession"));
				CoursSession coursession = CoursSession.getUnCoursSession(idCoursSession);
				session.setAttribute("cs", coursession);
				session.setAttribute("lesCoursSession", CoursSession.getLesCoursSession(idCours));
				session.setAttribute("lesCoursSessionItems", CoursSessionItem.getLesCoursSessionItem(idCoursSession));
				response.sendRedirect("coursDetailInscription.jsp");
				
	}	
			
}
