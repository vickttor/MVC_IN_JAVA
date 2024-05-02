/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.List;
import padraomvc.model.bean.User;
import padraomvc.model.dao.DaoUser;
import padraomvc.util.internal.Controller;

/**
 *
 * @author Vickttor
 */
public class ControllerUser implements Controller {
    
    DaoUser dao;

    @Override
    public Object insert(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUser();
        return dao.insert(obj);
    }

    @Override
    public Object update(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUser();
        return dao.update(obj);
    }

    @Override
    public Object fetch(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUser();
        return dao.fetch(obj);
    }

    @Override
    public Object delete(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUser();
        return dao.delete(obj);
    }

    @Override
    public List<Object> list(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUser();
        return dao.list(obj);
    }

    public boolean validate(User usuEnt) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        dao = new DaoUser();
        User usuSaida = dao.validate(usuEnt);
        if(usuSaida != null) {
            retorno = true;
        }
        return retorno;
    }
    
    
    public User validateWeb(User usuEnt) throws SQLException, ClassNotFoundException {
        dao = new DaoUser();
        User usuSaida = dao.validate(usuEnt);
        return usuSaida;
    }
}
