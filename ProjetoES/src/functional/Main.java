package functional;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        File excelFile = new File("C:\\Users\\fredf\\git\\ES1-2019-EIC1-44\\ProjetoES\\long-method");
        getHostServices().showDocument(excelFile.toURI().toURL().toExternalForm());
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}