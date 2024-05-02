/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas.client;

import br.com.fatec.telas.LoginInterface;
import padraomvc.model.bean.Client;
import padraomvc.controller.ControllerClient;
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
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Vickttor
 */
public class FetchClientInterface implements Initializable {


    @FXML
    private TextField txtName;

    @FXML
    private TableView<Client> clientList;

    @FXML
    private TableColumn<Client,String> tId;

    @FXML
    private TableColumn<Client,String> tName;

    @FXML
    private TableColumn<Client,String> tCpf;

    @FXML
    private TableColumn<Client,String> tTel;

    @FXML
    private TableColumn<Client,String> tAddress;
    
    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnGoBack;
    
    @FXML
    private Button btnFetch;

    ControllerClient controller = null;
    
    ObservableList<Client> oList = null;

    List<Client> list = null;
    
    public static Client clientOutput = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }       
    
    private void initComponentes (){

        controller = new ControllerClient();

        btnFetch.setOnAction((ActionEvent event) -> {
            Client usu = new Client(txtName.getText());
            try {
                createList(usu);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
        });

        btnUpdate.setOnAction((ActionEvent event) -> {
            TablePosition pos = clientList.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            setClient(clientList.getItems().get(row));
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/client/UpdateClientInterface.fxml"));
            Parent screen = null;
            try {
                screen = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(screen));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(FetchClientInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnDelete.setOnAction((ActionEvent event) -> {
            TablePosition pos = clientList.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Client usu = clientList.getItems().get(row);
            try {
                controller.delete(usu);
                clientList.getItems().remove(row);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FetchClientInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = No delete");

            }
        });

        btnGoBack.setOnAction((ActionEvent event) -> {
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent screen = null;
            try {
                screen = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(screen));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(FetchClientInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
    public void createList(Client usu) throws SQLException, ClassNotFoundException {
        List<Object> listObj = controller.list(usu);
        list = new ArrayList<>();

        for (Object objLista : listObj) {
            list.add((Client) objLista);
        }

        oList = FXCollections.observableArrayList(list);
        tId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clientList.setItems(oList);
    }
    
    
    public void setClient(Client usuP) {
        FetchClientInterface.clientOutput = usuP;
    }
    
    public Client getClient() {
        return FetchClientInterface.clientOutput;
    }


}
