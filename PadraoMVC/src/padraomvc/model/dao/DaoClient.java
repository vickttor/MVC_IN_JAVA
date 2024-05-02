/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Client;
import padraomvc.util.connectDB;
import padraomvc.util.internal.Dao;

/**
 *
 * @author Vickttor
 */
public class DaoClient implements Dao {
    
    private final Connection c;
    
    public DaoClient() throws SQLException, ClassNotFoundException{
        this.c = connectDB.getConexaoMySQL();
    }
    
    @Override
    public Object insert(Object obj) throws SQLException {
        Client client = (Client) obj;
        String sql = "INSERT INTO clients" + " (name, cpf, tel, address)" + " VALUES (?,?,?,?)";
    
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1,client.getName());
        stmt.setString(2,client.getCpf());
        stmt.setString(3,client.getTel());
        stmt.setString(4,client.getAddress());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        
        if (rs.next()) {
            int id = rs.getInt(1);
            client.setId(id);
        }
        
        stmt.close();
        return client;
    }
    
    @Override
    public Object update(Object obj) throws SQLException {
        Client client = (Client) obj;
        String sql = "UPDATE clients SET name = ?, cpf = ?, tel = ?, address = ? WHERE id = ?";
        
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setString(1,client.getName());
        stmt.setString(2,client.getCpf());
        stmt.setString(3,client.getTel());
        stmt.setString(4,client.getAddress());
        stmt.setInt(5,client.getId());
      
        stmt.execute();
        stmt.close();
        return client;
    }

    @Override
    public Object delete(Object obj) throws SQLException {
        Client client = (Client) obj;
        String sql = "DELETE FROM clients WHERE id = ?";
        
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setInt(1,client.getId());
        
        stmt.execute();
        stmt.close();
        c.close();
        return client;
    }

    @Override
    public Object fetch(Object obj) throws SQLException {
        Client client = (Client) obj;
        
        String sql = "SELECT * FROM clients WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            
        stmt.setInt(1,client.getId());
            
        ResultSet rs = stmt.executeQuery();
        Client oneClient = null;
        
        while (rs.next()) {
            oneClient = new Client(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
        }
        
        stmt.close();
        return oneClient;
    }
    
    
    @Override
    public List<Object> list(Object obj) throws SQLException  {
        Client client = (Client) obj;

        List<Object> clientList = new ArrayList<>();
        
        String sql = "SELECT * FROM clients WHERE name LIKE ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);

        stmt.setString(1,"%" + client.getName() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Client oneClient = new Client(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
  
            clientList.add(oneClient);
        }
        
        rs.close();
        stmt.close();
        
        return clientList;
    }
    
}
