package VISTA.inicio;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Clase para la creacion de metodos para comunicar la GUI con la lógica del
 * programa
 *
 * @author Adrian Pardo
 * @version 1.0
 *
 */
public class ControllerInicio implements Initializable{

    @FXML
    private ImageView logoEstambul;
    @FXML
    private JFXButton botonHome;
    @FXML
    private JFXButton botonComer;
    @FXML
    private JFXButton botonDormir;
    @FXML
    private JFXButton botonHacer;

   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logoEstambul.setImage(new Image ("/IMAGENES/EstambulSilueta.png"));
    }
}
