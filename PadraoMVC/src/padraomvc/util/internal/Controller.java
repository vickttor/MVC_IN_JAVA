/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.util.internal;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Vickttor
 */
public interface Controller {
    
    public Object insert(Object obj) throws SQLException , ClassNotFoundException;
    public Object update(Object obj) throws SQLException , ClassNotFoundException;
    public Object delete(Object obj) throws SQLException , ClassNotFoundException;
    public Object fetch(Object obj) throws SQLException , ClassNotFoundException;
    public List<Object> list(Object obj) throws SQLException , ClassNotFoundException;

}
