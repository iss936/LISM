package beans;

import java.sql.Date;

public class CoursSession {

	private int idCoursSession;
	private Date dateDebut;
	private Date dateFin;
	private int idCoursSessionItem;
	
	public CoursSession(int idCoursSession, Date dateDebut, Date dateFin, int idCoursSessionItem) {
		this.setIdCoursSession(idCoursSession);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
		this.setIdCoursSessionItem(idCoursSessionItem);
	}
	
	public CoursSession() {
		
	}

	/**
	 * @return the idCoursSession
	 */
	public int getIdCoursSession() {
		return idCoursSession;
	}

	/**
	 * @param idCoursSession the idCoursSession to set
	 */
	public void setIdCoursSession(int idCoursSession) {
		this.idCoursSession = idCoursSession;
	}

	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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
}
