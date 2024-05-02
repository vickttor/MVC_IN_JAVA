/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas.pet;

import padraomvc.model.bean.Pet;
import padraomvc.controller.ControllerPet;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import padraomvc.enums.Gender;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Vickttor
 */
public class UpdatePetInterface implements Initializable {

    @FXML
    private TextField txtName;

    @FXML
    private ToggleGroup petGenderGroup;
    
    @FXML
    private RadioButton maleRadio;
    
    @FXML
    private RadioButton femaleRadio;

    @FXML
    private TextField txtAge;
    
    @FXML
    private Button btnGoBack;
    
    @FXML
    private Button btnSend;
    
    @FXML
    private Label lbIdT;


    ControllerPet controller = null;
    
    Pet pet = null;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes(); 
    }    

    private void initComponentes (){

        controller = new ControllerPet();
        FetchPetInterface previousScreen = new FetchPetInterface();
        setPet(previousScreen.getPet());

        btnGoBack.setOnAction((ActionEvent event) -> {
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent screen;
            try {
                screen = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(screen));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(UpdatePetInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btnSend.setOnAction((ActionEvent event) -> {
            Gender gender  = getSelectedGender();
            
            if(gender != null) {
               pet = new Pet(Integer.parseInt(lbIdT.getText()), txtName.getText(), gender, Integer.parseInt(txtAge.getText()));
               
               System.out.println(pet);
               
                try {
                    controller.update(pet);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(UpdatePetInterface.class.getName()).log(Level.SEVERE, null, ex);
                }

                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
                Parent screen;
                
                try {
                    screen = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(screen));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(UpdatePetInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
               JOptionPane.showMessageDialog(null, "Selecione o sexo do Pet");
            }
            
        });

    }
    
      public Gender getSelectedGender() {
        RadioButton selectedRadioButton = (RadioButton) petGenderGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
          return selectedRadioButton.getText().equals("Macho") ? Gender.Male : Gender.Female;
        } else {
          return null; // Handle case where no radio button is selected
        }
    }
    
    public void setPet(Pet pet) {
        this.lbIdT.setText(Integer.toString(pet.getId()));
        this.txtName.setText(pet.getName());
        this.petGenderGroup.selectToggle(pet.getGender().equals(Gender.Male) ? maleRadio : femaleRadio);
        this.txtAge.setText(Integer.toString(pet.getAge()));
    }
    
}
    
