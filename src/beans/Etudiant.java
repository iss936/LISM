package beans;

import hibernate.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Etudiant {

	private int idEtudiant;
	private String prenomEtudiant;
	private String nomEtudiant;
	private String login;
	private String mdp;
	
	public Etudiant(int idEtudiant, String prenomEtudiant, String nomEtudiant, String login, String mdp) {
		this.setIdEtudiant(idEtudiant);
		this.setPrenomEtudiant(prenomEtudiant);
		this.setNomEtudiant(nomEtudiant);
	}
	
	public Etudiant() {
		
	}

	/**
	 * @return the idEtudiant
	 */
	public int getIdEtudiant() {
		return idEtudiant;
	}

	/**
	 * @param idEtudiant the idEtudiant to set
	 */
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	/**
	 * @return the prenomEtudiant
	 */
	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}

	/**
	 * @param prenomEtudiant the prenomEtudiant to set
	 */
	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}

	/**
	 * @return the nomEtudiant
	 */
	public String getNomEtudiant() {
		return nomEtudiant;
	}

	/**
	 * @param nomEtudiant the nomEtudiant to set
	 */
	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
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

	public static Etudiant getUnEtudiant(String login, String mdp) {
		Etudiant e = null;
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			Query query = sess.createQuery("from Etudiant where login='" + login + "' and mdp='" + mdp + "'");
			e = (Etudiant)query.list().get(0);
			tx.commit();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			sess.close();
		}
		return e;
	}
}
