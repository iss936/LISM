package beans;

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
	
	
}
