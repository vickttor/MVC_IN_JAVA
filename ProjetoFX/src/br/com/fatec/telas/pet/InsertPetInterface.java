/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas.pet;

import br.com.fatec.telas.LoginInterface;
import padraomvc.model.bean.Pet;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerPet;
import padraomvc.enums.Gender;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Vickttor
 */
public class InsertPetInterface implements Initializable {
  
    
    @FXML
    private TextField txtName;

    @FXML
    private ToggleGroup petGenderGroup;
    
    @FXML
    private RadioButton maleRadio;

    @FXML
    private TextField txtAge;

    
    @FXML
    private Button btnGoBack;
    @FXML
    private Button btnSend;

    ControllerPet controller = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
        maleRadio.setSelected(true);
    }    
    
    private void initComponentes () {
        btnSend.setOnAction((ActionEvent event) -> {
            controller = new ControllerPet();
            
            Gender gender  = getSelectedGender();
            
            if(gender != null) {
                 Pet pet = new Pet(txtName.getText(), gender, Integer.parseInt(txtAge.getText()));
                try {
                    pet = (Pet) controller.insert(pet);

                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, pet.getName());
            }else{
                JOptionPane.showMessageDialog(null, "Selecione o sexo do Pet");
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
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
