package beans;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Enseignant {

	private int idEnseignant;
	private String prenomEnseignant;
	private String nomEnseignant;
	private String login;
	private String mdp;
	
	public Enseignant(int idEnseignant, String prenomEnseignant, String nomEnseignant, String login, String mdp) {
		this.setIdEnseignant(idEnseignant);
		this.setPrenomEnseignant(prenomEnseignant);
		this.setNomEnseignant(nomEnseignant);
		this.setLogin(login);
		this.setMdp(mdp);
	}
	
	public Enseignant(String prenomEnseignant, String nomEnseignant, String login, String mdp) {
		this.setPrenomEnseignant(prenomEnseignant);
		this.setNomEnseignant(nomEnseignant);
		this.setLogin(login);
		this.setMdp(mdp);
	}
	
	public Enseignant() {
		
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
	 * @return the prenomEnseignant
	 */
	public String getPrenomEnseignant() {
		return prenomEnseignant;
	}

	/**
	 * @param prenomEnseignant the prenomEnseignant to set
	 */
	public void setPrenomEnseignant(String prenomEnseignant) {
		this.prenomEnseignant = prenomEnseignant;
	}

	/**
	 * @return the nomEnseignant
	 */
	public String getNomEnseignant() {
		return nomEnseignant;
	}

	/**
	 * @param nomEnseignant the nomEnseignant to set
	 */
	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public static void createEnseignant(String prenomEnseignant, String nomEnseignant, String login, String mdp) {
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			Enseignant e = new Enseignant(nomEnseignant, prenomEnseignant, login, mdp);
			sess.save(e);
			tx.commit();
			}
		catch(Exception e){
			System.out.println("Insertion échouée: " + e.getMessage());
		}
		finally{
			sess.close();
		}
	}
	
	public static Enseignant getUnEnseignant(int idEnseignant) {
		Enseignant e = new Enseignant();
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			e = (Enseignant) sess.createQuery(" from Enseignant where idEnseignant=" + idEnseignant).list().get(0);
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			sess.close();
		}
		return e;
	}
	
	public static List<Enseignant> getLesEnseignants() {
		List<Enseignant> lesEnseignants = null;
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			lesEnseignants = sess.createQuery(" from Enseignant").list();
		    tx.commit();
		}
		catch(Exception ex){
		      ex.printStackTrace();
		      System.out.println("Lecture échouée " + ex.getMessage());
		}
		finally{
			sess.close();
		}
		return lesEnseignants;
	}
	
	public static void updateEnseignant(int idEnseignant, String prenomEnseignant, String nomEnseignant, String login, String mdp) {
		Session sess = null;
		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			Enseignant e = (Enseignant)sess.createQuery(" from Enseignant where idEnseignant=" + idEnseignant).list().get(0);
			e.setPrenomEnseignant(prenomEnseignant);
			e.setNomEnseignant(nomEnseignant);
			e.setLogin(login);
			e.setMdp(mdp);
			sess.save(e);
			tx.commit();
		}
		catch (Exception ex) {
			System.out.println("Erreur insertion" + ex.getMessage());
		}
		finally {
			sess.close();
		}
	}
	
	public static void deleteEnseignant(int idEnseignant) {
		Session sess = null;
		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			sess.delete((Enseignant)sess.createQuery(" from Enseignant where idEnseignant=" + idEnseignant).list().get(0));
			tx.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			sess.close();
		}
	}
}
