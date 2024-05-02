package br.com.fatec.telas.clientPet;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerClientPet;
import padraomvc.model.bean.ClientPet;
import projetofx.ProjetoFX;

public class FetchClientPetInterface implements Initializable {

    @FXML
    private TextField txtObservation;

    @FXML
    private TableView<ClientPet> listClientPet;

    @FXML
    private TableColumn<ClientPet,String> tId;

    @FXML
    private TableColumn<ClientPet,String> tIdP;
    
    @FXML
    private TableColumn<ClientPet,String> tIdC;
    
    @FXML
    private TableColumn<ClientPet,String> tObservation;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnGoBack;
    
    @FXML
    private Button btnFetch;

    ControllerClientPet clientPetController = null;
    
    ObservableList<ClientPet> oList = null;

    List<ClientPet> lista = null;
    
    public static ClientPet clientPetOutput;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }       
    
    private void initComponentes (){

        clientPetController = new ControllerClientPet();

        btnFetch.setOnAction((ActionEvent event) -> {
            ClientPet usugrupo = new ClientPet(txtObservation.getText());
            try {
                montaLista(usugrupo);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FetchClientPetInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
        });

        btnUpdate.setOnAction((ActionEvent event) -> {
            TablePosition pos = listClientPet.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            setObservation(listClientPet.getItems().get(row));
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/clientPet/UpdateClientPetInterface.fxml"));
            Parent screen;
            try {
                screen = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(screen));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(FetchClientPetInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnDelete.setOnAction((ActionEvent event) -> {
            TablePosition pos = listClientPet.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            ClientPet grupo = listClientPet.getItems().get(row);
            try {
                clientPetController.delete(grupo);
                listClientPet.getItems().remove(row);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FetchClientPetInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = No delete");

            }
        });

        btnGoBack.setOnAction((ActionEvent event) -> {
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent screen;
            try {
                screen = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(screen));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(FetchClientPetInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
    public void montaLista(ClientPet clientPet) throws SQLException, ClassNotFoundException {
        List<Object> listaObj = clientPetController.list(clientPet);
        lista = new ArrayList<>();

        for (Object objLista : listaObj) {
            lista.add((ClientPet) objLista);
        }

        oList = FXCollections.observableArrayList(lista);
        tId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tIdP.setCellValueFactory(new PropertyValueFactory<>("idP"));
        tIdC.setCellValueFactory(new PropertyValueFactory<>("idC"));
        tObservation.setCellValueFactory(new PropertyValueFactory<>("obs"));
        listClientPet.setItems(oList);
    }
    
    

    public void setObservation(ClientPet clientPet) {
        FetchClientPetInterface.clientPetOutput = clientPet;
    }
    
    public ClientPet getObservation() {
        return FetchClientPetInterface.clientPetOutput;
    }


}
