/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas;

import padraomvc.model.bean.User;
import padraomvc.controller.ControllerUser;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
 * @author ProfAlexandre
 */
public class ConsultarUsuarioInterface implements Initializable {

    @FXML
    private Label lbLogin;

    @FXML
    private TextField txtLogin;

    @FXML
    private TableView<User> listaUsuario;

    @FXML
    private TableColumn<User,String> tid;

    @FXML
    private TableColumn<User,String> tlogin;

    @FXML
    private TableColumn<User,String> tsenha;

    @FXML
    private TableColumn<User,String> tstatus;

    @FXML
    private TableColumn<User,String> ttipo;
    
    @FXML
    private Button btAlterar;

    @FXML
    private Button btdelete;

    @FXML
    private Button btVoltar;
    
    @FXML
    private Button btConsultar;

    ControllerUser usuCont = null;
    
    ObservableList<User> oList = null;

    List<User> lista = null;
    
    public static User usuSaidaTela = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }       
    
    private void initComponentes (){

        usuCont = new ControllerUser();

        btConsultar.setOnAction((ActionEvent event) -> {
            User usu = new User(txtLogin.getText());
            try {
                montaLista(usu);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
        });

        btAlterar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TablePosition pos = listaUsuario.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                setUsuario(listaUsuario.getItems().get(row));
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/AlterarUsuarioInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultarUsuarioInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btdelete.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaUsuario.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            User usu = listaUsuario.getItems().get(row);
            try {
                usuCont.delete(usu);
                listaUsuario.getItems().remove(row);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultarUsuarioInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = No delete");

            }
        });

        btVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultarUsuarioInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
    public void montaLista(User usu) throws SQLException, ClassNotFoundException {
        List<Object> listaObj = usuCont.list(usu);
        lista = new ArrayList<>();

        for (Object objLista : listaObj) {
            lista.add((User) objLista);
        }

        oList = FXCollections.observableArrayList(lista);
        tid.setCellValueFactory(new PropertyValueFactory<User,String>("id"));
        tlogin.setCellValueFactory(new PropertyValueFactory<User,String>("login"));
        tsenha.setCellValueFactory(new PropertyValueFactory<User,String>("senha"));
        tstatus.setCellValueFactory(new PropertyValueFactory<User,String>("status"));
        ttipo.setCellValueFactory(new PropertyValueFactory<User,String>("tipo"));
        listaUsuario.setItems(oList);
    }
    
    

    public void setUsuario(User usuP) {
        this.usuSaidaTela = usuP;
    }
    
    public User getUsuario() {
        return this.usuSaidaTela;
    }


}
