package poo2.login.model.dao;

import java.util.Calendar;

public class UsuarioDAO {

	/**
	 * Este metodo tiene como propósito validar las credenciales
	 * ingresadas por el usuario.
	 * @param usuario
	 * @param passwd
	 * @return
	 */
	public UsuarioDTO validarCredenciales(String usuario, String passwd, String horaIngreso) {
		UsuarioDTO dto =  null;
		
		if(usuario.equals("poo2") && passwd.equals("poo2")) {
			dto = new UsuarioDTO();
			dto.setNombres("Boris");
			dto.setApellidos("Perez");
			dto.setHoraIngreso(horaIngreso);
		}else if(usuario.equals("poo1") && passwd.equals("poo1")) {
			dto = new UsuarioDTO();
			dto.setNombres("Franco");
			dto.setApellidos("Velandia");
			dto.setHoraIngreso(horaIngreso);
			//un easter egg ;)
		}else if(usuario.equals("AnorakTeam") && passwd.equals("anorakteam")){
			dto = new UsuarioDTO();
			dto.setNombres("Anorak");
			dto.setApellidos("Team");
			dto.setHoraIngreso(horaIngreso);
		}
			
		return dto;
	}
	
	/**
	 * Este metodo tiene como propósito validar las credenciales
	 * ingresadas por el usuario.
	 * @param horaIngreso: el tiempo (horas y minutos en formato 24h) que ingresa el usuario.
	 * @return
	 */
	public static boolean validarHoraIngreso(String horaIngreso){
		
		horaIngreso = horaIngreso.strip();
		//verificamos si tiene 4 o 5 caracteres, ejemplo 5:23 o 09:44 o 16:10 etc
		if(horaIngreso.length() != 4 && horaIngreso.length() != 5) {
			return false;
		}
		
		try {
			Calendar calendar = Calendar.getInstance();
			String [] separados = horaIngreso.split(":");
			int horas = Integer.parseInt(separados[0]);
			int minutos = Integer.parseInt(separados[1]);
			if(horas > 12) horas -= 12;
			
			//simplemente verificamos que la hora y minuto de ingreso sean iguales a las actuales
			return calendar.get(Calendar.HOUR) == horas && calendar.get(Calendar.MINUTE) == minutos;
		
		} catch (Exception e) {
			//algun error, significa que es hora inválida
			return false;
		} 
	}
	
}
