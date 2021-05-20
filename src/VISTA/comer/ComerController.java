package VISTA.comer;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Clase para la creacion de metodos para comunicar la GUI con la lógica del
 * programa
 *
 * @author Adrian Pardo
 * @version 1.0
 *
 */
public class ComerController implements Initializable {

    private Pane panelCarga;
    @FXML
    private TableView<?> tablaActividades;
    @FXML
    private TableColumn<?, ?> nombre;
    @FXML
    private TableColumn<?, ?> inicio;
    @FXML
    private TableColumn<?, ?> fin;
    @FXML
    private TableColumn<?, ?> plazas;
    @FXML
    private TableColumn<?, ?> precioUnitario;
    @FXML
    private TableColumn<?, ?> precioTotal;
    @FXML
    private Button confirmarPack;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablaActividades.setPlaceholder(new Label("Ninguna actividad seleccionada."));
    }

    @FXML
    private void eliminarActividad(MouseEvent event) {
    }

    @FXML
    private void guardarPack(ActionEvent event) {
    }

}
