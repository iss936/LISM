package beans;

import java.util.List;

import hibernate.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Cours {

	private int idCours;
	private String libelleCours;
	
	public Cours(int idCours, String libelle) {
		this.setIdCours(idCours);
		this.setLibelleCours(libelle);
	}
	
	public Cours(String libelle) {
		this.setLibelleCours(libelle);
	}
	
	public Cours() {
		
	}

	/**
	 * @return the idCours
	 */
	public int getIdCours() {
		return idCours;
	}

	/**
	 * @param idCours the idCours to set
	 */
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelleCours() {
		return libelleCours;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelleCours(String libelle) {
		this.libelleCours = libelle;
	}
	
	public static void createCours(String libelle) {
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			Cours c = new Cours(libelle);
			sess.save(c);
			tx.commit();
			}
		catch(Exception e){
			System.out.println("Insertion échouée: " + e.getMessage());
		}
		finally{
			sess.close();
		}
	}
	
	public static Cours getUnCours(int idCours) {
		Cours c = new Cours();
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			c = (Cours) sess.createQuery(" from Cours where idCours=" + idCours).list().get(0);
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			sess.close();
		}
		return c;
	}
	
	public static List<Cours> getLesCours() {
		List<Cours> lesCours = null;
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			lesCours = sess.createQuery(" from Cours").list();
		    tx.commit();
		}
		catch(Exception ex){
		      ex.printStackTrace();
		      System.out.println("Lecture échouée " + ex.getMessage());
		}
		finally{
			sess.close();
		}
		return lesCours;
	}
	
	public static void updateCours(int idCours, String libelle) {
		Session sess = null;
		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			Cours c = (Cours)sess.createQuery(" from Cours where idCours=" + idCours).list().get(0);
			c.setLibelleCours(libelle);
			sess.save(c);
			tx.commit();
		}
		catch (Exception ex) {
			System.out.println("Erreur insertion" + ex.getMessage());
		}
		finally {
			sess.close();
		}
	}
	
	public static void deleteCours(int idCours) {
		Session sess = null;
		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			sess.delete((Cours)sess.createQuery(" from Cours where idCours=" + idCours).list().get(0));
			tx.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			sess.close();
		}
	}
}
