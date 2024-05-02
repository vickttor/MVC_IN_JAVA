package padraomvc;

import padraomvc.view.ClientView;
import padraomvc.view.UserView;

import javax.swing.*;
import java.sql.SQLException;
import padraomvc.view.PetView;
import padraomvc.view.ClientPetView;

/**
 *
 * @author Vickttor
 */
public class PadraoMVC {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(UserView.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Usuário \n 2 - Cliente \n 3 - Pet \n 4 - Pet do Cliente";

        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        
        switch (num) {
            case 0: {
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");

                if (sair > 0) { 
                    menu();
                } else {
                    JOptionPane.showMessageDialog(null, "Até breve!"); 
                }
                
                break;
            }
            case 1: {
                UserView userView = new UserView();
                userView.menu();
                break;
            }
            case 2: {
                ClientView clientView = new ClientView();
                clientView.menu();
                break;
            }
            case 3: {
                PetView petView = new PetView();
                petView.menu();
                break;
            }
            case 4: {
                ClientPetView clientPetView = new ClientPetView();
                clientPetView.menu();
                break;
            }
            
            default: System.out.println("Opção inválido");
        }
    }
    
}
