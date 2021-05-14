package VISTA.inicio;

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
public class InicioController implements Initializable {

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
    @FXML
    private Pane panelCarga;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Parent root = cargarOtraEscena("/VISTA/home/Home.fxml");
        panelCarga.getChildren().setAll(root);
    }

    @FXML
    private void alPulsarHome(ActionEvent event) {
        Parent root = cargarOtraEscena("/VISTA/home/Home.fxml");
        panelCarga.getChildren().setAll(root);

    }

    @FXML
    private void alPulsarComer(ActionEvent event) {
        Parent root = cargarOtraEscena("/VISTA/comer/Comer.fxml");
        panelCarga.getChildren().setAll(root);

    }

    @FXML
    private void alPulsarDormir(ActionEvent event) {
        Parent root = cargarOtraEscena("/VISTA/dormir/Dormir.fxml");
        panelCarga.getChildren().setAll(root);

    }

    @FXML
    private void alPulsarHacer(ActionEvent event) {
        Parent root = cargarOtraEscena("/VISTA/actividades/Actividades.fxml");
        panelCarga.getChildren().setAll(root);
    }

    private Parent cargarOtraEscena(String rutaFXML) {
        FXMLLoader loader;
        Parent root = null;

        try {
            loader = new FXMLLoader();
            //CARGAMOS OTRO FXML
            loader.setLocation(getClass().getResource(rutaFXML));
            root = loader.load(); // el metodo initialize() se ejecuta
        } catch (IOException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("ERROR " + ex.getMessage());
            alerta.showAndWait();
        }
        return root;
    }
}
