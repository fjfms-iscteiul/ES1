package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MyController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private Button button_import;
	
	public void import_file(ActionEvent event) {
		System.out.println("importa");
		String defaultCurrentDirectoryPath = "C:\\users\\Authentic\\Desktop";
		JFileChooser excelFile = new JFileChooser(defaultCurrentDirectoryPath);
		excelFile.showOpenDialog(null);
	}
}
