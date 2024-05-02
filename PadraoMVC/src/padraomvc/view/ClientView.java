/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerClient;
import padraomvc.model.bean.Client;
import padraomvc.util.internal.View;

/**
 *
 * @author Vickttor
 */
public class ClientView implements View {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - INSERIR \n 2 - ALTERAR \n 3 - BUSCAR \n 4 - DELETAR \n 5 - LISTAR " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
             case 1: {
                insert();
                break;
            }
            case 2: {
                update();
                break;
            }
            case 3: {
                fetch();
                break;
            }
            case 4: {
                delete();
                break;
            }
            case 5: {
                list();
                break;
            }
            default: System.out.println("Opção inválida");
        }
    }

    @Override
    public void insert() throws SQLException, ClassNotFoundException {
        String name = JOptionPane.showInputDialog("NOME");
        String cpf = JOptionPane.showInputDialog("CPF");
        String tel = JOptionPane.showInputDialog("TEL");
        String address = JOptionPane.showInputDialog("ENDEREÇO");
        
        Client client = new Client(name, cpf, tel, address);
        ControllerClient controller = new ControllerClient();
        Client createdClient = (Client) controller.insert(client);
        JOptionPane.showMessageDialog(null,createdClient.toString());
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String name = JOptionPane.showInputDialog("NOME");
        String cpf = JOptionPane.showInputDialog("CPF");
        String tel = JOptionPane.showInputDialog("TEL");
        String address = JOptionPane.showInputDialog("ENDEREÇO");
        
        Client sisEnt = new Client(id, name, cpf, tel, address);
        
        ControllerClient controller = new ControllerClient();
        Client updatedClient = (Client) controller.update(sisEnt);
        JOptionPane.showMessageDialog(null, updatedClient.toString());
    }

    @Override
    public void fetch() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Client clientEnt = new Client(id);
        ControllerClient controller = new ControllerClient();
        Client sisSaida = (Client) controller.fetch(clientEnt);
        JOptionPane.showMessageDialog(null,sisSaida.toString());
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Client clientEnt = new Client(id);
        
        ControllerClient controller = new ControllerClient();
        
        controller.delete(clientEnt);
        
        JOptionPane.showMessageDialog(null,"Cliente deletado!");
    }

    @Override
    public void list() throws SQLException, ClassNotFoundException {
        String name = JOptionPane.showInputDialog("NOME");
        Client clientEnt = new Client(name);
        ControllerClient controller = new ControllerClient();
        List<Object> clientList = controller.list(clientEnt);
        
        for (Object Obj : clientList) {
            Client client = (Client) Obj;
            JOptionPane.showMessageDialog(null, client.toString());
        }
    }
    
}
