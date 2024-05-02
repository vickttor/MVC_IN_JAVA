/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Pet;
import padraomvc.model.bean.ClientPet;
import padraomvc.model.bean.Client;
import padraomvc.model.dao.DaoClientPet;
import padraomvc.util.internal.Controller;

/**
 *
 * @author vickttor
 */
public class ControllerClientPet implements Controller {
    
    DaoClientPet dao;
    ControllerClient controllerClient;
    ControllerPet controllerPet;

    @Override
    public Object insert(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoClientPet();
        return dao.insert(obj);
    }

    @Override
    public Object update(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoClientPet();
        return dao.update(obj);
    }

    @Override
    public Object delete(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoClientPet();
        return dao.delete(obj);
    }

    @Override
    public Object fetch(Object obj) throws SQLException, ClassNotFoundException {
       
        dao = new DaoClientPet();
        
        ClientPet objOutput = (ClientPet) dao.fetch(obj);
        
        Object client = new Client(objOutput.getIdC());
        Object pet = new Pet(objOutput.getIdP());
        
        controllerClient = new ControllerClient();
        controllerPet = new ControllerPet();
        
        objOutput.setClient(controllerClient.fetch(client));
        objOutput.setPet(controllerPet.fetch(pet));
        
        return objOutput;
    }

    @Override
    public List<Object> list(Object obj) throws SQLException, ClassNotFoundException {
        
        dao = new DaoClientPet();
        
        List<Object> listAux = dao.list(obj);
        List<Object> list = new ArrayList<>();
        
        for(Object item : listAux) {
            list.add(fetch(item));
        }
        
        return list;
    }
    
    
}
