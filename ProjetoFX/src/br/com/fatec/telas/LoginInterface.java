/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas;

import padraomvc.model.bean.User;
import padraomvc.controller.ControllerUser;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Vickttor
 */
public class LoginInterface implements Initializable {

    @FXML
        private TextField loginTxtField;

    @FXML
    private PasswordField passwordTxtField;

    @FXML
    private Button sendButton;
    
    ControllerUser controller = null;

    private void initComponentes () {
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller = new ControllerUser();
                User user = new User(loginTxtField.getText(),passwordTxtField.getText(),"","");
                
                try {
                    Boolean validatedUser = controller.validate(user);
                    
                    if(validatedUser) {
                        try {
                            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
                            Parent screen  = loader.load();
                            Stage stg = ProjetoFX.getStage();
                            stg.setScene(new Scene(screen));
                            stg.show();
                        } catch(Exception e) {
                            System.out.println(e.getMessage());
                        } catch (Throwable ex) {                    
                            Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                        }               
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuário Inválido");
                    }
                         
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }    
    
}
