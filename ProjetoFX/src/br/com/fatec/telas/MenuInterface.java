/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author ProfAlexandre
 */
public class MenuInterface implements Initializable {
    

     @FXML
    private Menu manterUsuario;

    @FXML
    private MenuItem inserirU;

    @FXML
    private MenuItem listarU;

    @FXML
    private Menu manterPessoa;

    @FXML
    private MenuItem inserirP;

    @FXML
    private MenuItem listarP;

    @FXML
    private Menu manterUP;

    @FXML
    private MenuItem inserirUP;

    @FXML
    private MenuItem listarUP;
    
    private void initComponentes () {
        
        inserirU.setOnAction((ActionEvent event) -> {
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/InserirUsuarioInterface.fxml"));
            Parent novatela = null;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(MenuInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        listarU.setOnAction((ActionEvent event) -> {
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/ConsultarUsuarioInterface.fxml"));
            Parent novatela = null;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(MenuInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });


    }

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initComponentes();
    }    
    
}
