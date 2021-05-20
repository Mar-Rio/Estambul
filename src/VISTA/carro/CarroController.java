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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
        if(!gestionPack.getActividadesEnPack().isEmpty()) {
        actividadesGuardadas =  FXCollections.observableArrayList(gestionPack.getActividadesEnPack());
        tablaActividades.setItems(actividadesGuardadas);
        
        Actividades actividad = new Actividades();
        
        //nombre.setCellValueFactory(new PropertyValueFactory<>());
        
    }  else {
            tablaActividades.setPlaceholder(new Label("No hay ninguna actividad seleccionada."));
            }
        TableViewSelectionModel selectionModel = tablaActividades.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        
        
        
        //actividadesGuardadas.getSelectionModel().getSelectedItems();

    }


    @FXML
    private void eliminarActividad(MouseEvent event) {
    }

    @FXML
    private void guardarPack(ActionEvent event) {
    }
    
}
