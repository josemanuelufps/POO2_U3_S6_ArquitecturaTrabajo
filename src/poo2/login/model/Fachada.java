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
	
	public String validarCredenciales(String usuario, String passwd) throws Exception {
		String nombreCompleto = "";
		
		UsuarioDTO dto = (new UsuarioDAO()).validarCredenciales(usuario, passwd);
		if(dto!=null)
			nombreCompleto = dto.getNombreCompleto();
		else
			throw new Exception("No se encontró usuario con esas credenciales");
		
		return nombreCompleto;
	}
	
}
