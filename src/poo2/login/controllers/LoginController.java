package poo2.login.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import poo2.login.model.Fachada;
import poo2.login.util.DataTransfer;
import poo2.login.util.Utilidades;

public class LoginController {
	
	private Fachada fachada;
	
	@FXML
	private TextField userField;
	@FXML
	private TextField passwordField;
	@FXML
	private Text mensajeText;
	
	/**
	 * Importante tener presente que los objetos de la GUI
	 * deben inicializarse sobreescribiendo el método initialize
	 * de la interfaz Initializable.
	 */
	public LoginController() {
		fachada = Fachada.getInstance();
	}

	/**
	 * Este método valida las credenciales de autenticación del usuario.
	 * Se usa en la vista iniciosesion.fxml.
	 * @param event
	 */
	@FXML
	protected void handleStartButtonAction(ActionEvent event) {
		
		try {
			String nombreCompleto = fachada.validarCredenciales(userField.getText(), 
					passwordField.getText());
			
			// Enviar a la siguiente pantalla
			
			Stage stage = Utilidades.obtenerStage(event);
			stage.close();
			
			try {

				DataTransfer.getInstance().setNombreCompleto(nombreCompleto);
				
				FXMLLoader loader = new FXMLLoader(getClass().
						getResource("/poo2/login/views/WelcomeScreen.fxml"));
				
				Pane root = loader.load();			
				
				Scene scene = new Scene(root);
			    stage.setScene(scene);
			    
			    stage.show();		    		    

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}catch(Exception e) {
			mensajeText.setText(e.getMessage());
		}
	}
	
	@FXML
	protected void handleCleanButtonAction(ActionEvent event) {
		userField.setText("");
		passwordField.setText("");
		mensajeText.setText("");
	}
	
}
