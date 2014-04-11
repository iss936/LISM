package beans;

import java.sql.Date;

public class CoursSessionItem {

	private int idCoursSessionItem;
	private Date dateHeureCours;
	private int idEnseignant;
	private int idSalle;
	
	public CoursSessionItem(int idCoursSessionItem, Date dateHeureCours, int idEnseignant, int idSalle) {
		this.setIdCoursSessionItem(idCoursSessionItem);
		this.setDateHeureCours(dateHeureCours);
		this.setIdEnseignant(idEnseignant);
		this.setIdSalle(idSalle);
	}
	
	public CoursSessionItem() {
		
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
	 * @return the dateHeureCours
	 */
	public Date getDateHeureCours() {
		return dateHeureCours;
	}

	/**
	 * @param dateHeureCours the dateHeureCours to set
	 */
	public void setDateHeureCours(Date dateHeureCours) {
		this.dateHeureCours = dateHeureCours;
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
}
