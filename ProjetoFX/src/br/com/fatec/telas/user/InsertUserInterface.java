/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas.user;

import br.com.fatec.telas.LoginInterface;
import padraomvc.model.bean.User;
import padraomvc.controller.ControllerUser;
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
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Vickttor
 */
public class InsertUserInterface implements Initializable {

    
    @FXML
    private Button btSalvar;


    @FXML
    private TextField txtLogin;


    @FXML
    private TextField txtSenha;


    @FXML
    private TextField txtStatus;


    @FXML
    private TextField txtTipo;
    
    @FXML
    private Button btVoltar;

    ControllerUser controller = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }    
    
    private void initComponentes () {
        btSalvar.setOnAction((ActionEvent event) -> {
            controller = new ControllerUser();
            User usu = new User(txtLogin.getText(),txtSenha.getText(),txtStatus.getText(),txtTipo.getText());
            try {
                usu = (User) controller.insert(usu);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, usu.getLogin());
        });
        
        
        btVoltar.setOnAction((ActionEvent event) -> {
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
