package padraomvc.model.dao;

import padraomvc.enums.Gender;
import padraomvc.model.bean.Pet;
import padraomvc.util.connectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import padraomvc.util.internal.Dao;

public class DaoPet implements Dao {

    public final Connection c;

    public DaoPet() throws SQLException, ClassNotFoundException {
        this.c = connectDB.getConexaoMySQL();
    }

    @Override
    public Object insert(Object obj) throws SQLException {
        Pet pet = (Pet) obj;

        String sql = "INSERT INTO pets" + " (name, gender, age)" + " VALUES (?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, pet.getName());
        stmt.setString(2, pet.getGender().name());
        stmt.setInt(3, pet.getAge());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();

        if (rs.next()) {
            int id = rs.getInt(1);
            pet.setId(id);
        }

        stmt.close();

        return pet;
    }

    @Override
    public Object update(Object obj) throws SQLException {
        Pet pet = (Pet) obj;

        String sql = "UPDATE pets SET name = ?, gender = ?, age = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setString(1, pet.getName());
        stmt.setString(2, pet.getGender().name());
        stmt.setInt(3, pet.getAge());
        stmt.setInt(4, pet.getId());

        stmt.execute();
        stmt.close();

        return pet;
    }

    @Override
    public Object delete(Object obj) throws SQLException {
        Pet pet = (Pet) obj;

        String sql = "DELETE FROM pets WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setInt(1, pet.getId());

        stmt.execute();
        stmt.close();
        c.close();

        return pet;
    }

    @Override
    public Object fetch(Object obj) throws SQLException {
        Pet pet = (Pet) obj;

        String sql = "SELECt * FROM pets WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setInt(1, pet.getId());
        ResultSet rs = stmt.executeQuery();
        Pet petOutput = null;

        while (rs.next()) {
            petOutput = new Pet(
                rs.getInt(1),
                rs.getString(2),
                Gender.valueOf(rs.getString(3)),
                rs.getInt(4)
            );

        }

        stmt.close();

        return petOutput;
    }

    @Override
    public List<Object> list(Object obj) throws SQLException {

        Pet pet = (Pet) obj;

        List<Object> pets = new ArrayList<>();

        String sql = "SELECT * FROM pets WHERE name LIKE ?";
        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setString(1, "%" + pet.getName() + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Pet petOutput = new Pet(
                    rs.getInt(1),
                    rs.getString(2),
                    Gender.valueOf(rs.getString(3)),
                    rs.getInt(4)
            );

            pets.add(petOutput);
        }

        rs.close();
        stmt.close();
        return pets;
    }
}
