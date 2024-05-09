package poo2.login.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import poo2.login.util.DataTransfer;

public class WelcomeScreenController implements Initializable{

	@FXML
	private Text nombreCompletoField;
	
	@FXML // fx:id="horaIngresoField"
    private Text horaIngresoField; // Value injected by FXMLLoader
	
	public WelcomeScreenController() {
		System.out.println("Iniciando WelcomeScreenController");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert horaIngresoField != null : "fx:id=\"horaIngresoField\" was not injected: check your FXML file 'WelcomeScreenView.fxml'.";
        assert nombreCompletoField != null : "fx:id=\"nombreCompletoField\" was not injected: check your FXML file 'WelcomeScreenView.fxml'.";
		
		DataTransfer dt = DataTransfer.getInstance();
		
		nombreCompletoField.setText(dt.getNombreCompleto());
		horaIngresoField.setText(dt.getHoraIngreso());
	}
	

}









