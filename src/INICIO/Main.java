package INICIO;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Clase en la que se ejecuta el programa
 * 
 * @author Adrian Pardo
 * @version 1.0
 * 
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../VISTA/inicio/Inicio.fxml"));
        primaryStage.setTitle("ESTAMBUL  TURISMO");
        primaryStage.getIcons().add(new Image("/IMAGENES/pnglogo.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}