package Testes;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.poi.ss.formula.functions.Choose;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import functional.*;
import functional.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.Assert.*;

class MyControllerTestFX extends ApplicationTest {

	@FXML
	private Button importButton;
	final String importButton_id = "#importButton";
//	
//	@Before
//	public void setClass() throws Exception {
//		ApplicationTest.launch(Main.class);
//	}

//	@Override
//	public void start(Stage stage) {
//		stage.show();
//	}
//	
//	@After
//	public void afterTest() throws TimeoutException {
//		FxToolkit.hideStage();
//	}

//	@SuppressWarnings({ "hiding", "unchecked" })
//	public <T extends Node> T find(final String q) {
//		return (T) lookup(q).queryAll().iterator().next();
//	}
	private Stage primaryStage;

	@Test
	public void TestMain() throws Exception {
		Main main = new Main();
		assertNotNull(main);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	     Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
	}



	@Test
	void importButton() {
		clickOn("#importButton");
		MyController mc = new MyController();
		
	}
	
	

}
