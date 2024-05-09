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
	@FXML // fx:id="logInTimeField"
    private TextField logInTimeField; // Value injected by FXMLLoader
	
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
			String nombreCompleto = null;
			String horaIngreso = null;
			if(fachada.validarHoraIngreso(logInTimeField.getText())) {
				nombreCompleto = fachada.validarCredenciales(userField.getText(), 
														 passwordField.getText(),
														 logInTimeField.getText());
				horaIngreso = logInTimeField.getText();
			}
			
			// Enviar a la siguiente pantalla
			
			Stage stage = Utilidades.obtenerStage(event);
			stage.close();
			
			try {
				DataTransfer d = DataTransfer.getInstance();
				d.setNombreCompleto(nombreCompleto);
				d.setHoraIngreso(horaIngreso);
				
				FXMLLoader loader = new FXMLLoader(getClass().
						getResource("/poo2/login/views/WelcomeScreenView.fxml"));
				
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
		logInTimeField.setText("");
	}
	
	@FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert logInTimeField != null : "fx:id=\"logInTimeField\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert mensajeText != null : "fx:id=\"mensajeText\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert userField != null : "fx:id=\"userField\" was not injected: check your FXML file 'LoginView.fxml'.";
    }

	
}
