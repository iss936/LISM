package beans;

public class Enseignant {

	private int idEnseignant;
	private String prenomEnseignant;
	private String nomEnseignant;
	
	public Enseignant(int idEnseignant, String prenomEnseignant, String nomEnseignant) {
		this.setIdEnseignant(idEnseignant);
		this.setPrenomEnseignant(prenomEnseignant);
		this.setNomEnseignant(nomEnseignant);
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
	
	
}
