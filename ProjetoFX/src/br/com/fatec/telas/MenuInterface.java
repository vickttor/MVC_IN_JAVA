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
 * @author Vickttor
 */
public class MenuInterface implements Initializable {

    @FXML
    private MenuItem insertUserMenuItem;

    @FXML
    private MenuItem listUserMenuItem;

    
    @FXML
    private MenuItem insertClientMenuItem;

    @FXML
    private MenuItem listClientMenuItem;


    @FXML
    private MenuItem insertPetMenuItem;

    @FXML
    private MenuItem listPetMenuItem;
    
    
    @FXML
    private MenuItem insertClientPetMenuItem;

    @FXML
    private MenuItem listClientPetMenuItem;
    
    private void navigateHandler(ActionEvent event, String resource) {
        FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource(resource));
        Parent screen;
        
        try {
            screen = loader.load();
            Stage stg = ProjetoFX.getStage();
            stg.setScene(new Scene(screen));
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void initComponentes () {
        
        insertUserMenuItem.setOnAction((ActionEvent event) -> 
                this.navigateHandler(event, "/br/com/fatec/xmls/user/InsertUserInterface.fxml"));
        
        listUserMenuItem.setOnAction((ActionEvent event) -> 
               this.navigateHandler(event, "/br/com/fatec/xmls/user/FetchUserInterface.fxml"));

        insertClientMenuItem.setOnAction((ActionEvent event) -> 
               this.navigateHandler(event, "/br/com/fatec/xmls/client/InsertClientInterface.fxml"));
        
        listClientMenuItem.setOnAction((ActionEvent event) -> 
               this.navigateHandler(event, "/br/com/fatec/xmls/client/FetchClientInterface.fxml"));
        
        insertPetMenuItem.setOnAction((ActionEvent event) -> 
               this.navigateHandler(event, "/br/com/fatec/xmls/pet/InsertPetInterface.fxml"));
        
        listPetMenuItem.setOnAction((ActionEvent event) -> 
               this.navigateHandler(event, "/br/com/fatec/xmls/pet/FetchPetInterface.fxml"));
        
        insertClientPetMenuItem.setOnAction((ActionEvent event) -> 
               this.navigateHandler(event, "/br/com/fatec/xmls/clientPet/InsertClientPetInterface.fxml"));
        
        listClientPetMenuItem.setOnAction((ActionEvent event) -> 
               this.navigateHandler(event, "/br/com/fatec/xmls/clientPet/FetchClientPetInterface.fxml"));
        

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }    
    
}
