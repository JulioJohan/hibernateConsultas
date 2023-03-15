package practicauno.sda.dto;

public class AreaAcademica {

	private Integer idArea;
	
	private String nombreArea;
	
	private Byte esActiva;
	
	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public Byte getEsActiva() {
		return esActiva;
	}

	public void setEsActiva(Byte esActiva) {
		this.esActiva = esActiva;
	}
}
