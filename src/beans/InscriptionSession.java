package beans;

import hibernate.HibernateUtil;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InscriptionSession implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEtudiant;
	private int idCoursSession;
	
	public InscriptionSession(int idEtudiant, int idCoursSession) {
		this.idEtudiant = idEtudiant;
		this.idCoursSession = idCoursSession;
	}
	public InscriptionSession()
	{
		
	}
	
	public int getIdEtudiant() {
		return idEtudiant;
	}
	
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	
	public int getIdCoursSession() {
		return idCoursSession;
	}
	
	public void setIdCoursSession(int idCoursSession) {
		this.idCoursSession = idCoursSession;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCoursSession;
		result = prime * result + idEtudiant;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InscriptionSession other = (InscriptionSession) obj;
		if (idCoursSession != other.idCoursSession)
			return false;
		if (idEtudiant != other.idEtudiant)
			return false;
		return true;
	}
	
	public List<Cours> getMatiereSession(int idStudent)
	{
		List<Cours> mesCours= null;
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			mesCours = sess.createQuery(" select {Cours.*} from InscriptionSession is, Etudiant e,CoursSession cs, Cours c,"
					+ "where InscriptionSession.idEtudiant= Etudiant.idEtudiant "
					+ "and InscriptionSession.idCoursSession=Courssession.idCoursSession"
					+ "and CoursSession.idCours=Cours.idCours"
					+ "and Etudiant.idStudent="+idStudent).list();
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			sess.close();
		}
		return mesCours;
	}
	
	
}
