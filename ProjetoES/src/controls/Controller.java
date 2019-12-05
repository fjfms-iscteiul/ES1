package controls;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private Button importBu;
	
	public void importa(ActionEvent event) {
		System.out.println("importa");
		String defaultCurrentDirectoryPath = "C:\\users\\Authentic\\Desktop";
		JFileChooser excelFile = new JFileChooser(defaultCurrentDirectoryPath);
		excelFile.showOpenDialog(null);
	}
}
