package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cours;
import beans.CoursSession;
import beans.Etudiant;
import beans.InscriptionSession;

/**
 * Servlet implementation class InscriptionCours
 */

public class InscriptionCours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionCours() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				HttpSession session = request.getSession();
				CoursSession cs = (CoursSession) session.getAttribute("courssession");
				int idcs = cs.getIdCoursSession();
				Etudiant e = (Etudiant) session.getAttribute("etudiant");
				int ide = e.getIdEtudiant();
				InscriptionSession.addInscriptionSession(ide, idcs);				
				response.sendRedirect("confirmMsgInscription.jsp");
			
			
	}

}
