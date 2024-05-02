package br.com.fatec.telas.clientPet;

import br.com.fatec.telas.pet.InsertPetInterface;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerClient;
import padraomvc.controller.ControllerClientPet;
import padraomvc.controller.ControllerPet;
import padraomvc.model.bean.Client;
import padraomvc.model.bean.ClientPet;
import padraomvc.model.bean.Pet;
import projetofx.ProjetoFX;

public class InsertClientPetInterface implements Initializable {

    @FXML
    private ComboBox<Pet> comboBoxPets;

    @FXML
    private ComboBox<Client> comboBoxClients;


    @FXML
    private TextField txtObservation;
    
    @FXML
    private Button btnGoBack;

    private final ControllerPet petController = new ControllerPet();
    private final ControllerClient clientController = new ControllerClient();
    private final ControllerClientPet clientPetController = new ControllerClientPet();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Object> listaPets = petController.list(new Pet(""));
            ObservableList<Pet> pets = FXCollections.observableArrayList();
            for (Object obj : listaPets) {
                Pet pet = (Pet) obj;
                pets.add(pet);
            }
            comboBoxPets.setItems(pets);

            List<Object> listaClients = clientController.list(new Client(""));
            ObservableList<Client> clients = FXCollections.observableArrayList();
            for (Object obj : listaClients) {
                Client client = (Client) obj;
                clients.add(client);
            }
            comboBoxClients.setItems(clients);
        } catch (ClassNotFoundException | SQLException e) {
            
        }
        
        // Define os conversores personalizados para exibir apenas o nome do pet e do usuário
        comboBoxPets.setConverter(new NamePetConverter());
        comboBoxClients.setConverter(new NameClientConverter());
        
         btnGoBack.setOnAction((ActionEvent event) -> {
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent novatela;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(InsertPetInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    
    }

  
    @FXML
    private void saveRelation() {
        Pet petSelecionado = comboBoxPets.getValue();
        Client clientSelecionado = comboBoxClients.getValue();
        String relacao = txtObservation.getText();

        if (petSelecionado == null || clientSelecionado == null || relacao.isEmpty()) {
            System.out.println("Por favor, preencha todos os campos.");
            return;
        }


        ClientPet clientPet = new ClientPet(clientSelecionado.getId(), petSelecionado.getId(), relacao);
        try {
            clientPetController.insert(clientPet);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(InsertClientPetInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showMessageDialog(null, "Relação entre Cliente e pet registrada!");
        
    }
    

    private static class NamePetConverter extends javafx.util.StringConverter<Pet> {
        @Override
        public String toString(Pet pet) {
            return pet.getName();
        }

        @Override
        public Pet fromString(String nome) {
            return null; 
        }
    }
    
    private static class NameClientConverter extends javafx.util.StringConverter<Client> {
        @Override
        public String toString(Client client) {
            return client.getName();
        }

        @Override
        public Client fromString(String nome) {
            return null;
        }
    }
    
}
