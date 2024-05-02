/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.util.internal;

import java.sql.SQLException;

/**
 *
 * @author Vickttor
 */
public interface View {
    
    public void menu() throws SQLException, ClassNotFoundException;
    public void insert() throws SQLException , ClassNotFoundException;
    public void update() throws SQLException , ClassNotFoundException;
    public void delete() throws SQLException , ClassNotFoundException;
    public void fetch() throws SQLException , ClassNotFoundException;
    public void list() throws SQLException , ClassNotFoundException;
    
}
