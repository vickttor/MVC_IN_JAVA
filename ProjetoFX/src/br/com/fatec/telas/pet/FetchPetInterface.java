/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas.pet;

import br.com.fatec.telas.LoginInterface;
import padraomvc.model.bean.Pet;
import padraomvc.controller.ControllerPet;
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
public class FetchPetInterface implements Initializable {


    @FXML
    private TextField txtName;

    @FXML
    private TableView<Pet> petList;

    @FXML
    private TableColumn<Pet,String> tId;

    @FXML
    private TableColumn<Pet,String> tName;

    @FXML
    private TableColumn<Pet,String> tGender;

    @FXML
    private TableColumn<Pet,String> tAge;

    
    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnGoBack;
    
    @FXML
    private Button btnFetch;

    ControllerPet controller = null;
    
    ObservableList<Pet> oList = null;

    List<Pet> list = null;
    
    public static Pet petOutput = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }       
    
    private void initComponentes (){

        controller = new ControllerPet();

        btnFetch.setOnAction((ActionEvent event) -> {
            Pet usu = new Pet(txtName.getText());
            try {
                createList(usu);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
        });

        btnUpdate.setOnAction((ActionEvent event) -> {
            TablePosition pos = petList.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            setPet(petList.getItems().get(row));
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/pet/UpdatePetInterface.fxml"));
            Parent screen;
            try {
                screen = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(screen));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(FetchPetInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnDelete.setOnAction((ActionEvent event) -> {
            TablePosition pos = petList.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Pet usu = petList.getItems().get(row);
            try {
                controller.delete(usu);
                petList.getItems().remove(row);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FetchPetInterface.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(FetchPetInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
    public void createList(Pet pet) throws SQLException, ClassNotFoundException {
        List<Object> listObj = controller.list(pet);
        list = new ArrayList<>();

        for (Object objLista : listObj) {
            list.add((Pet) objLista);
        }

        oList = FXCollections.observableArrayList(list);
        tId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        petList.setItems(oList);
    }
    
    
    public void setPet(Pet pet) {
        FetchPetInterface.petOutput = pet;
    }
    
    public Pet getPet() {
        return FetchPetInterface.petOutput;
    }


}
