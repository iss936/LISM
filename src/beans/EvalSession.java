package beans;

import java.sql.Date;

public class EvalSession {

	private int idEvalSession;
	private Date dateDebut;
	private Date dateFin;
	private int idCoursSession;
	
	
	public EvalSession(int idEvalSession, Date dateDebut, Date dateFin,
			int idCoursSession) {
		super();
		this.idEvalSession = idEvalSession;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idCoursSession = idCoursSession;
	}
	
	public EvalSession() {
		
	}
	
	/**
	 * @return the idEvalSession
	 */
	public int getIdEvalSession() {
		return idEvalSession;
	}
	/**
	 * @param idEvalSession the idEvalSession to set
	 */
	public void setIdEvalSession(int idEvalSession) {
		this.idEvalSession = idEvalSession;
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
	
	
}
