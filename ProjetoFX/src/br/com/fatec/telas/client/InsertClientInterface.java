/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas.client;

import br.com.fatec.telas.LoginInterface;
import padraomvc.model.bean.Client;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerClient;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Vickttor
 */
public class InsertClientInterface implements Initializable {
  
    
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

    ControllerClient controller = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }    
    
    private void initComponentes () {
        btnSend.setOnAction((ActionEvent event) -> {
            controller = new ControllerClient();
            Client client = new Client(txtName.getText(),txtCpf.getText(),txtTel.getText(), txtAddress.getText());
            try {
                client = (Client) controller.insert(client);
                
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, client.getName() + " | " + client.getCpf());
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
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    
}
