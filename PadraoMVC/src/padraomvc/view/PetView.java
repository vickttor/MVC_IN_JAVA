/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerPet;
import padraomvc.enums.Gender;
import padraomvc.model.bean.Pet;
import padraomvc.util.internal.View;
/**
 *
 * @author vickttor
 */
public class PetView implements View {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - INSERIR\n 2 - ALTERAR \n 3 - BUSCAR \n 4 - DELETAR \n 5 - LISTAR ";
        
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        
        switch(num) {
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
       
        String[] options = {"Macho", "Fêmea"};
        
        String name = JOptionPane.showInputDialog("Nome");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
        Gender gender = null;
        
        int choice = JOptionPane.showOptionDialog(null, 
            "Escolha o gênero: ", 
            "Sua escolha: ", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options, 
            options[0]
        ); 

       
        if (choice == JOptionPane.YES_OPTION) {
            gender = Gender.Male;
        } else if (choice == JOptionPane.NO_OPTION) {
            gender = Gender.Female;
        }
        
        Pet pet = new Pet(name, gender, age);
            
        ControllerPet controller = new ControllerPet();
        
        Pet createdPet = (Pet) controller.insert(pet);
        
        JOptionPane.showMessageDialog(null, createdPet.toString());        
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        
        String[] options = {"Macho", "Fêmea"};
        
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String name = JOptionPane.showInputDialog("Nome");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
        Gender gender = null;
        
        int choice = JOptionPane.showOptionDialog(null,
            "Escolha o gênero: ",
            "Sua escolha: ",
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options,
            options[0]
        ); 

    
        if (choice == JOptionPane.YES_OPTION) {
            gender = Gender.Male;
        } else if (choice == JOptionPane.NO_OPTION) {
            gender = Gender.Female;
        }
        
        Pet pet = new Pet(id, name, gender, age);
         
        ControllerPet controller = new ControllerPet();
        
        Pet updatedPet = (Pet) controller.update(pet);
        
        JOptionPane.showMessageDialog(null, updatedPet.toString());  
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pet pet = new Pet(id);
        ControllerPet controller = new ControllerPet();
        
        controller.delete(pet);
        
        JOptionPane.showMessageDialog(null, "Pet deletado!");
    }

    @Override
    public void fetch() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pet pet = new Pet(id);
        
        ControllerPet controller = new ControllerPet();
        Pet petOutput = (Pet) controller.fetch(pet);
        JOptionPane.showMessageDialog(null, petOutput.toString());
    }

    @Override
    public void list() throws SQLException, ClassNotFoundException {
        String name = JOptionPane.showInputDialog("Nome");
        Pet pet = new Pet(name);
        ControllerPet controller = new ControllerPet();
        
        List<Object> petList = controller.list(pet);
        
        for (Object Obj : petList) {
            Pet petItem = (Pet) Obj;
            JOptionPane.showMessageDialog(null,petItem.toString());
        }
    }
    
}
