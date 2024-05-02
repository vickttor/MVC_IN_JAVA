/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerClientPet;
import padraomvc.model.bean.ClientPet;
import padraomvc.util.internal.View;

/**
 *
 * @author Vickttor
 */
public class ClientPetView implements View {

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
        int idU = Integer.parseInt(JOptionPane.showInputDialog("ID do Cliente"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("ID do Pet"));
        String obs = JOptionPane.showInputDialog("OBS");
        
        ClientPet petUsu = new ClientPet(idU, idP, obs);
        
        ControllerClientPet controller = new ControllerClientPet();
        ClientPet createdPet = (ClientPet) controller.insert(petUsu);
        
        JOptionPane.showMessageDialog(null, createdPet.toString());
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idC = Integer.parseInt(JOptionPane.showInputDialog("ID do Cliente"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("ID do Pet"));
        String obs = JOptionPane.showInputDialog("Observação");
        
        ClientPet clientPet = new ClientPet(id,idC, idP, obs);
        ControllerClientPet controller = new ControllerClientPet();
        ClientPet updatedClientPet = (ClientPet) controller.update(clientPet);
        
        JOptionPane.showMessageDialog(null, updatedClientPet.toString());
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        
        ClientPet clientPet = new ClientPet(id);
        
        ControllerClientPet controller = new ControllerClientPet();
        
        controller.delete(clientPet);
        
        JOptionPane.showMessageDialog(null, "Relação removida!");
    }

    @Override
    public void fetch() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        
        ClientPet petUsu = new ClientPet(id);
        ControllerClientPet controller = new ControllerClientPet();
        ClientPet fetchedClientPet = (ClientPet) controller.fetch(petUsu);
        
        JOptionPane.showMessageDialog(null,fetchedClientPet.toString());
        JOptionPane.showMessageDialog(null,fetchedClientPet.getClient().toString());
        JOptionPane.showMessageDialog(null,fetchedClientPet.getPet().toString());
    }

    @Override
    public void list() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("Observação");
        ClientPet clientPet = new ClientPet(obs);
        ControllerClientPet controller = new ControllerClientPet();
        List<Object> clientPetList = controller.list(clientPet);
        
        for (Object item : clientPetList) {
            ClientPet iterationClietPet = (ClientPet) item;
            
            JOptionPane.showMessageDialog(null,iterationClietPet.toString());
            JOptionPane.showMessageDialog(null,iterationClietPet.getClient().toString());
            JOptionPane.showMessageDialog(null,iterationClietPet.getPet().toString());
        }
    }
    
}
