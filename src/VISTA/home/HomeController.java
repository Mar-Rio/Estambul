package VISTA.home;

import VISTA.dormir.*;
import VISTA.inicio.*;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Clase para la creacion de metodos para comunicar la GUI con la lógica del
 * programa
 *
 * @author Adrian Pardo
 * @version 1.0
 *
 */
public class HomeController implements Initializable{

    private Pane panelCarga;
    @FXML
    private Label texto;
    @FXML
    private Label titulo;
    @FXML
    private Label titulo1;
    @FXML
    private Button botonCarro;

   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    @FXML
    private void alCarro(ActionEvent event) {
    }


  
    
    

}
