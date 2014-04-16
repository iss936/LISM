package beans;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CoursSessionItem {

	private int idCoursSessionItem;
	private int idEnseignant;
	private int idSalle;
	private int idCoursSession;
	private String descriptionDetail;
	
	public CoursSessionItem(int idCoursSessionItem, int idEnseignant, int idSalle, int idCoursSession, String descriptionDetail) {
		this.setIdCoursSessionItem(idCoursSessionItem);
		this.setIdEnseignant(idEnseignant);
		this.setIdSalle(idSalle);
		this.setIdSalle(idSalle);
		this.setIdCoursSession(idCoursSession);
		
	}

	public CoursSessionItem() {
		
	}
	
	public int getIdCoursSession() {
		return idCoursSession;
	}

	public void setIdCoursSession(int idCoursSession) {
		this.idCoursSession = idCoursSession;
	}

	public String getDescriptionDetail() {
		return descriptionDetail;
	}

	public void setDescriptionDetail(String descriptionDetail) {
		this.descriptionDetail = descriptionDetail;
	}

	/**
	 * @return the idCoursSessionItem
	 */
	public int getIdCoursSessionItem() {
		return idCoursSessionItem;
	}

	/**
	 * @param idCoursSessionItem the idCoursSessionItem to set
	 */
	public void setIdCoursSessionItem(int idCoursSessionItem) {
		this.idCoursSessionItem = idCoursSessionItem;
	}

	/**
	 * @return the idEnseignant
	 */
	public int getIdEnseignant() {
		return idEnseignant;
	}

	/**
	 * @param idEnseignant the idEnseignant to set
	 */
	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	/**
	 * @return the idSalle
	 */
	public int getIdSalle() {
		return idSalle;
	}

	/**
	 * @param idSalle the idSalle to set
	 */
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}
	
	public static List<CoursSessionItem> getLesCoursSessionItem(int idCoursSession) {
		int coursSession = idCoursSession;
		List<CoursSessionItem> lesCoursSessionItem = null;
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			lesCoursSessionItem = sess.createQuery(" from CoursSessionItem where idCoursSession=" + coursSession).list();
		    tx.commit();
		}
		catch(Exception ex){
		      ex.printStackTrace();
		      System.out.println("Lecture échouée " + ex.getMessage());
		}
		finally{
			sess.close();
		}
		return lesCoursSessionItem;
	}
	
	public static CoursSessionItem getCoursSessionItem(int idSession) {
		CoursSessionItem csi = new CoursSessionItem();
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			csi = (CoursSessionItem) sess.createQuery(" from CoursSessionItem where idSession=" + idSession).list().get(0);
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			sess.close();
		}
		return csi;
	}
}
