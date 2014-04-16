package beans;

import hibernate.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Salle {

	private int idSalle;
	private String libelleSalle;
	
	public Salle(int idSalle, String libelleSalle) {
		this.setIdSalle(idSalle);
		this.setLibelleSalle(libelleSalle);
	}
	
	public Salle() {
		
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

	/**
	 * @return the libelleSalle
	 */
	public String getLibelleSalle() {
		return libelleSalle;
	}

	/**
	 * @param libelleSalle the libelleSalle to set
	 */
	public void setLibelleSalle(String libelleSalle) {
		this.libelleSalle = libelleSalle;
	}
	
	public static Salle getLaSalle(int idSalle) {
		Salle salle = new Salle();
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			salle = (Salle) sess.createQuery(" from Salle where idSalle=" + idSalle).list().get(0);
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			sess.close();
		}
		return salle;
	}
	
	
}
