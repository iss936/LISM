package beans;

import java.io.Serializable;

public class EtudiantCoursEval implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEtudiant;
	private int idCoursSession;
	private int idEvalSession;
	private float note;
	private String status;
	
	public EtudiantCoursEval(int idEtudiant, int idCoursSession, int idEvalSession, float note, String status) {
		this.setIdEtudiant(idEtudiant);
		this.setIdCoursSession(idCoursSession);
		this.setIdEvalSession(idEvalSession);
		this.setNote(note);
		this.setStatus(status);
	}
	
	public EtudiantCoursEval() {
		
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
	 * @return the note
	 */
	public float getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(float note) {
		this.note = note;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
}
