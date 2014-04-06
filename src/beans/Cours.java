package beans;

public class Cours {

	private int idCours;
	private String libelle;
	
	public Cours(int idCours, String libelle) {
		this.setIdCours(idCours);
		this.setLibelle(libelle);
	}
	
	public Cours() {
		
	}

	/**
	 * @return the idCours
	 */
	public int getIdCours() {
		return idCours;
	}

	/**
	 * @param idCours the idCours to set
	 */
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
