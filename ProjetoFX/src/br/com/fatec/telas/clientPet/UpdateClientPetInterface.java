package br.com.fatec.telas.clientPet;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerClient;
import padraomvc.controller.ControllerClientPet;
import padraomvc.controller.ControllerPet;
import padraomvc.model.bean.Client;
import padraomvc.model.bean.ClientPet;
import padraomvc.model.bean.Pet;
import projetofx.ProjetoFX;

public class UpdateClientPetInterface implements Initializable {

    @FXML
    private ComboBox<Pet> comboBoxPets;


    @FXML
    private ComboBox<Client> comboBoxClients;


    @FXML
    private TextField txtObservation;
    
    @FXML
    private Button btnGoBack;
    
    @FXML
    private Label lbIdT;

    private final ControllerPet petController = new ControllerPet();
    private final ControllerClient clientController = new ControllerClient();
    private ControllerClientPet clientPetController = new ControllerClientPet(); 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Object> listaPets = petController.list(new Pet(""));
            ObservableList<Pet> pets = FXCollections.observableArrayList();
            for (Object obj : listaPets) {
                Pet pet = (Pet) obj;
                pets.add(pet);
            }
            System.out.println(pets);
            comboBoxPets.setItems(pets);
            

            List<Object> listaClients = clientController.list(new Client(""));
            ObservableList<Client> clients = FXCollections.observableArrayList();
            for (Object obj : listaClients) {
                Client client = (Client) obj;
                clients.add(client);
            }
            comboBoxClients.setItems(clients);
            
            clientPetController = new ControllerClientPet();
            FetchClientPetInterface previousScreen = new FetchClientPetInterface();
            setObservation(previousScreen.getObservation());
        
        } catch (ClassNotFoundException | SQLException e) {
        }
        

        comboBoxPets.setConverter(new NomePetConverter());
        comboBoxClients.setConverter(new NomeClientConverter());
        
         btnGoBack.setOnAction((ActionEvent event) -> {
             FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
             Parent screen;
             try {
                 screen = loader.load();
                 Stage stg = ProjetoFX.getStage();
                 stg.setScene(new Scene(screen));
                 stg.show();
             } catch (IOException ex) {
                 Logger.getLogger(UpdateClientPetInterface.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
         
    }

    @FXML
    private void saveRelation() throws SQLException {
        Pet petSelecionado = comboBoxPets.getValue();
        Client clientSelecionado = comboBoxClients.getValue();
        String relacao = txtObservation.getText();

        if (petSelecionado == null || clientSelecionado == null || relacao.isEmpty()) {
            System.out.println("Por favor, preencha todos os campos.");
            return;
        }

        ClientPet clientPet = new ClientPet(Integer.parseInt(lbIdT.getText()),clientSelecionado.getId(), petSelecionado.getId(), relacao);
        
        try {
            clientPetController.update(clientPet);
            
            JOptionPane.showMessageDialog(null, "Relação entre cliente e pet foi alterada!");
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateClientPetInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent screen;
            
            try {
                screen = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(screen));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(UpdateClientPetInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }

    private static class NomePetConverter extends javafx.util.StringConverter<Pet> {
        @Override
        public String toString(Pet pet) {
            return pet.getName();
        }

        @Override
        public Pet fromString(String nome) {
            return null;
        }
    }

    private static class NomeClientConverter extends javafx.util.StringConverter<Client> {
        @Override
        public String toString(Client client) {
            return client.getName();
        }

        @Override
        public Client fromString(String nome) {
            return null;
        }
    }
    
    public void setObservation(ClientPetTable clientPet) {
        if (clientPet != null) {
       
            this.lbIdT.setText(""+clientPet.getId());
            ObservableList<Pet> pets = comboBoxPets.getItems();
            ObservableList<Client> clients = comboBoxClients.getItems();

       
        for (Pet pet : pets) {
            if (pet.getId() == clientPet.getIdP()) {
                comboBoxPets.getSelectionModel().select(pet);
                break;
            }
        }

        for (Client client : clients) {
            if (client.getId() == clientPet.getIdC()) {
                comboBoxClients.getSelectionModel().select(client);
                break;
            }
        }

        txtObservation.setText(clientPet.getObs());
    }}
}
