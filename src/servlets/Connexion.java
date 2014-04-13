package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.*;

public class Connexion extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6008827943681255329L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        Etudiant e = Etudiant.getUnEtudiant(login, mdp);
        if(e == null){
        	session.setAttribute("erreurs", true);
        	response.sendRedirect("index.jsp");
        }
        else
        {
        	session.setAttribute("etudiant", e);
        	session.setAttribute("lesCours", Cours.getLesCours());
        	response.sendRedirect("accueil.jsp");
        }
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("lesCours", Cours.getLesCours());
		response.sendRedirect("accueil.jsp");
	}
}
