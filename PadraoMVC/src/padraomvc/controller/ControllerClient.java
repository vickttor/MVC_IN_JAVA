/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.List;
import padraomvc.model.dao.DaoClient;
import padraomvc.util.internal.Controller;

/**
 *
 * @author Vickttor
 */
public class ControllerClient implements Controller {
    
    DaoClient dao;

    @Override
    public Object insert(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoClient();
        return dao.insert(obj);
    }

    @Override
    public Object update(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoClient();
        return dao.update(obj);
    }

    @Override
    public Object fetch(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoClient();
        return dao.fetch(obj);
    }

    @Override
    public Object delete(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoClient();
        return dao.delete(obj);
    }

    @Override
    public List<Object> list(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoClient();
        return dao.list(obj);
     }
    
}
