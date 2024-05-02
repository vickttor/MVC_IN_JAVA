/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerUser;
import padraomvc.model.bean.User;
import padraomvc.util.internal.View;

/**
 *
 * @author Vickttor
 */
public class UserView implements View {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - INSERIR \n 2 - ALTERAR \n 3 - BUSCAR \n 4 - DELETE \n 5 - LISTAR " ;
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
        String login = JOptionPane.showInputDialog("LOGIN");
        String password = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String type = JOptionPane.showInputDialog("TIPO");
        
        User user = new User(login, password, status, type);
        ControllerUser controller = new ControllerUser();
        
        User createdUser = (User) controller.insert(user);
        JOptionPane.showMessageDialog(null, createdUser.toString());
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String login = JOptionPane.showInputDialog("LOGIN");
        String password = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String type = JOptionPane.showInputDialog("TIPO");
        
        User usuEnt = new User(id, login, password, status, type);
        
        ControllerUser controller = new ControllerUser();
        User updatedUser = (User) controller.update(usuEnt);
        
        JOptionPane.showMessageDialog(null, updatedUser.toString());
    }

    @Override
    public void fetch() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        User user = new User(id);
        
        ControllerUser controller = new ControllerUser();
        User fetchedUser = (User) controller.fetch(user);
        JOptionPane.showMessageDialog(null, fetchedUser.toString());
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        User user = new User(id);
        
        ControllerUser controller = new ControllerUser();
        
        controller.delete(user);
        
        JOptionPane.showMessageDialog(null, "Usuário deletado!");
    }

    @Override
    public void list() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        User user = new User(login);
        ControllerUser controller = new ControllerUser();
        List<Object> userList = controller.list(user);
        
        for (Object obj : userList) {
            User userItem = (User) obj;
            JOptionPane.showMessageDialog(null, userItem.toString());
        }
    }

    public static boolean validar() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        String password = JOptionPane.showInputDialog("SENHA");
        User user = new User(login, password);
        ControllerUser controller = new ControllerUser();
        
        return controller.validate(user);
    }

    
}
