/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas.client;

import padraomvc.model.bean.Client;
import padraomvc.controller.ControllerClient;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Vickttor
 */
public class UpdateClientInterface implements Initializable {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtTel;


    @FXML
    private TextField txtAddress;
    
    @FXML
    private Button btnGoBack;
    
    @FXML
    private Button btnSend;
    
    @FXML
    private Label lbIdT;


    ControllerClient controller = null;
    
    Client client = null;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initComponentes(); 
    }    

    private void initComponentes (){

        controller = new ControllerClient();
        FetchClientInterface previousScreen = new FetchClientInterface();
        setClient(previousScreen.getClient());

        btnGoBack.setOnAction((ActionEvent event) -> {
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent screen;
            try {
                screen = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(screen));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(UpdateClientInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btnSend.setOnAction((ActionEvent event) -> {
            client = new Client(Integer.parseInt(lbIdT.getText()),
                    txtName.getText(),
                    txtCpf.getText(),
                    txtTel.getText(),
                    txtAddress.getText());
            
            try {
                controller.update(client);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UpdateClientInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent screen;
            try {
                screen = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(screen));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(UpdateClientInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
    
    public void setClient(Client client) {
        JOptionPane.showMessageDialog(null, client.getName());
        this.lbIdT.setText(""+client.getId());
        this.txtName.setText(client.getName());
        this.txtCpf.setText(client.getCpf());
        this.txtTel.setText(client.getTel());
        this.txtAddress.setText(client.getAddress());
    }
    
}
    
