package Testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.poi.ss.formula.functions.T;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobotException;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import com.sun.javafx.robot.FXRobot;

import functional.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

class MyControllerTestFX  extends ApplicationTest{

	final String importButton = "#importButton";
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
	

}
