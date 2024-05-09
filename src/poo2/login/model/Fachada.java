package poo2.login.model;

import poo2.login.model.dao.UsuarioDAO;
import poo2.login.model.dao.UsuarioDTO;

public class Fachada {

	private static Fachada instance;
	
	// Patrón Singleton
	
	private Fachada() {}
	
	public static Fachada getInstance() {
		if(instance==null)
			instance = new Fachada();
		
		return instance;
	}
	
	public String getWelcomeText() {
		return "Sistema de información personal y de gestión";
	}
	
	public String validarCredenciales(String usuario, String passwd, String horaIngreso) throws Exception {
		String nombreCompleto = "";
		
		UsuarioDTO dto = (new UsuarioDAO()).validarCredenciales(usuario, passwd, horaIngreso);
		if(dto!=null)
			nombreCompleto = dto.getNombreCompleto();
		else
			throw new Exception("No se encontró usuario con esas credenciales");
		
		return nombreCompleto;
	}
	
	public boolean validarHoraIngreso(String horaIngreso) throws Exception {
		if( UsuarioDAO.validarHoraIngreso(horaIngreso)) {
			return true;
		} else {
			throw new Exception("La hora de ingreso es incorrecta, debe ser formato 24HH,"
					+ " en el momento del ingreso y válido.");
		}
	}
	
}
