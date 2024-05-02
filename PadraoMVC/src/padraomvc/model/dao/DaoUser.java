/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.dao;

import padraomvc.model.bean.User;
import padraomvc.util.connectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import padraomvc.util.internal.Dao;

/**
 * @author Vickttor
 */
public class DaoUser implements Dao {

    private final Connection c;

    public DaoUser() throws SQLException, ClassNotFoundException {
        this.c = connectDB.getConexaoMySQL();
    }

    public User validate(User user) throws SQLException {
        String sql = "SELECt * FROM users WHERE login = ? AND password = ?";

        PreparedStatement stmt = this.c.prepareStatement(sql);

        stmt.setString(1, user.getLogin());
        stmt.setString(2, user.getPassword());

        ResultSet rs = stmt.executeQuery();

        User validatedUser = null;

        while (rs.next()) {
            validatedUser = new User(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
        }

        stmt.close();
        System.out.println(validatedUser);
        return validatedUser;
    }


    @Override
    public Object insert(Object obj) throws SQLException {
        User user = (User) obj;
        String sql = "INSERT INTO users" + " (login, password, status, type)" + " VALUES (?,?,?,?)";

      
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

     
        stmt.setString(1, user.getLogin());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getStatus());
        stmt.setString(4, user.getType());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            user.setId(id);
        }
        stmt.close();
        return user;
    }

    @Override
    public Object update(Object obj) throws SQLException {
        User user = (User) obj;
        String sql = "UPDATE users SET login = ?, password = ?, status = ?, type = ? WHERE id = ?";
   
        PreparedStatement stmt = this.c.prepareStatement(sql);

        stmt.setString(1, user.getLogin());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getStatus());
        stmt.setString(4, user.getType());
        stmt.setInt(5, user.getId());

        stmt.execute();
        stmt.close();
        return user;
    }

    @Override
    public Object delete(Object obj) throws SQLException {
        User user = (User) obj;
        String sql = "DELETE FROM users WHERE id = ?";
        
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setInt(1, user.getId());
        
        stmt.execute();
        stmt.close();
        c.close();
        return user;
    }

    @Override
    public Object fetch(Object obj) throws SQLException {
        User user = (User) obj;
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, user.getId());

        ResultSet rs = stmt.executeQuery();
        User validatedUser = null;
        while (rs.next()) {
            validatedUser = new User(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5));

        }
        stmt.close();
        return validatedUser;
    }


    @Override
    public List<Object> list(Object obj) throws SQLException {
        User user = (User) obj;
        
        List<Object> usus = new ArrayList<>();

        String sql = "SELECt * FROM users WHERE login LIKE ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1, "%" + user.getLogin() + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            User usu = new User(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            usus.add(usu);
        }

        rs.close();
        stmt.close();
        return usus;
    }

}
