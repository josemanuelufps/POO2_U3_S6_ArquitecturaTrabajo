package poo2.login.util;

public class DataTransfer {

	private String nombreCompleto;
	private String horaIngreso;
	
	/*
	 * Inicio
	 * Bloque creación singleton
	 */
	private static DataTransfer instance;
	
	private DataTransfer() {		
	}
	
	public static DataTransfer getInstance() {
		if(instance==null) {
			instance = new DataTransfer();
		}
		
		return instance;
	}
	
	/*
	 * Fin
	 * Bloque creación singleton
	 */
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	
	
}
