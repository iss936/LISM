package beans;

public class Etudiant {

	private int idEtudiant;
	private String prenomEtudiant;
	private String nomEtudiant;
	
	public Etudiant(int idEtudiant, String prenomEtudiant, String nomEtudiant) {
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
	
	
}
