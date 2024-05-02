/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;
import java.sql.SQLException;
import java.util.List;
import padraomvc.model.dao.DaoPet;
import padraomvc.util.internal.Controller;

/**
 *
 * @author vickttor
 */
public class ControllerPet implements Controller {
    
    DaoPet dao;

    @Override
    public Object insert(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPet();
        return dao.insert(obj);
    }

    @Override
    public Object update(Object obj) throws SQLException, ClassNotFoundException {
       dao = new DaoPet();
        return dao.update(obj);
    }

    @Override
    public Object delete(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPet();
        return dao.delete(obj);
    }

    @Override
    public Object fetch(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPet();
        return dao.fetch(obj);
    }

    @Override
    public List<Object> list(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoPet();
        return dao.list(obj);
    }
        
    
}
