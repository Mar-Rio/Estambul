/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA.carro;

import DATOS.BDA.PacksDAO;
import MODELO.Actividades;
import MODELO.Packs;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author cosca
 */
public class CarroController implements Initializable {

    private PacksDAO gestionPack = new PacksDAO();
    @FXML
    private TableView<Packs> tablaActividades;
    @FXML
    private TableColumn<Packs, String> nombre;
    @FXML
    private TableColumn<Packs, LocalDate> inicio;
    @FXML
    private TableColumn<Packs, LocalDate> fin;
    @FXML
    private TableColumn<Packs, Integer> plazas;
    @FXML
    private TableColumn<Packs, Integer> precioUnitario;
    @FXML
    private TableColumn<Packs, Integer> precioTotal;
    @FXML
    private Button confirmarPack;
    ObservableList<Packs> actividadesGuardadas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!gestionPack.getActividadesEnPack().isEmpty()) {
            actividadesGuardadas = FXCollections.observableArrayList(gestionPack.getActividadesEnPack());
            tablaActividades.setItems(actividadesGuardadas);
            nombre.setCellValueFactory(new PropertyValueFactory<>("nombreActividad"));
            inicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
            fin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
            precioUnitario.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
            precioTotal.setCellValueFactory(new PropertyValueFactory<>("precioTotal"));

        } else {
            tablaActividades.setPlaceholder(new Label("No hay ninguna actividad seleccionada."));
        }
        tablaActividades.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    private void eliminarActividad(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("¿Vas a eliminar la siguiente actividad?");
            dialogoAlerta.setContentText(tablaActividades.getSelectionModel().getSelectedItem().toString());

            Optional<ButtonType> confirmacion = dialogoAlerta.showAndWait();
            if (confirmacion.get() == ButtonType.OK) {
                int indice = tablaActividades.getSelectionModel().getSelectedIndex();
                gestionPack.borrarActividad(indice);
                actividadesGuardadas.remove(indice);
                tablaActividades.setItems(actividadesGuardadas);
            }
        }

    }
}
