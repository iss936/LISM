package beans;

public class Inscriptionsession {
	
	public Inscriptionsession(int idEtudiant, int idCoursSession) {
		this.idEtudiant = idEtudiant;
		this.idCoursSession = idCoursSession;
	}
	public Inscriptionsession()
	{
		
	}
	private int idEtudiant;
	private int idCoursSession;
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
	

	
	

}
