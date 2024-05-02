package padraomvc.model.dao;

import padraomvc.model.bean.ClientPet;
import padraomvc.util.connectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import padraomvc.util.internal.Dao;

public class DaoClientPet implements Dao {

    private final Connection c;

    public DaoClientPet() throws SQLException, ClassNotFoundException {
        this.c = connectDB.getConexaoMySQL();
    }

    @Override
    public Object insert(Object obj) throws SQLException {
        ClientPet clientPet = (ClientPet) obj;
        String sql = "INSERT INTO clients_pets" + " (idC, idP, obs)" + " VALUES (?,?,?)";

        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, clientPet.getIdC());
        stmt.setInt(2, clientPet.getIdP());
        stmt.setString(3, clientPet.getObs());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();

        if (rs.next()) {
            int id = rs.getInt(1);
            clientPet.setId(id);
        }

        stmt.close();
        return clientPet;
    }

    @Override
    public Object update(Object obj) throws SQLException {
        ClientPet clientPet = (ClientPet) obj;
        String sql = "UPDATE clients_pets SET idC = ?, idP = ?, obs = ? WHERE id = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setInt(1, clientPet.getIdC());
        stmt.setInt(2, clientPet.getIdP());
        stmt.setString(3, clientPet.getObs());
        stmt.setInt(4, clientPet.getId());

        stmt.execute();
        stmt.close();
        return clientPet;
    }

    @Override
    public Object delete(Object obj) throws SQLException {
        ClientPet clientPet = (ClientPet) obj;

        String sql = "DELETE FROM clients_pets WHERE id = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setInt(1, clientPet.getId());

        stmt.execute();
        stmt.close();
        c.close();

        return clientPet;
    }

    @Override
    public Object fetch(Object obj) throws SQLException {
        ClientPet clientPet = (ClientPet) obj;

        String sql = "SELECT * FROM clients_pets WHERE id = ?";

        PreparedStatement stmt = this.c.prepareStatement(sql);

        stmt.setInt(1, clientPet.getId());

        ResultSet rs = stmt.executeQuery();
        ClientPet clientPetOutput = null;

        while (rs.next()) {
            clientPetOutput = new ClientPet(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4)
            );
        }

        stmt.close();

        return clientPetOutput;
    }

    @Override
    public List<Object> list(Object obj) throws SQLException {
        ClientPet clientPet = (ClientPet) obj;
        List<Object> clientPets = new ArrayList<>();

        String sql = "SELECT * FROM clients_pets WHERE obs LIKE ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1, "%" + clientPet.getObs() + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ClientPet clientPetItem = new ClientPet(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4)
            );

            clientPets.add(clientPetItem);
        }

        rs.close();
        stmt.close();
        return clientPets;
    }
}
