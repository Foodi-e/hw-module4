package org.example.client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
public class ClientService {
    private PreparedStatement createSt;
    private PreparedStatement maxIdSt;
    private PreparedStatement getByIdSt;
    private PreparedStatement setNameSt;
    private PreparedStatement deleteByIdSt;
    private PreparedStatement listAllSt;

    public ClientService(Connection connection) throws SQLException {
        createSt = connection.prepareStatement(
                "INSERT INTO client (name) VALUES (?)"
        );

        maxIdSt = connection.prepareStatement(
                "SELECT MAX(id) AS maxId FROM client"
        );

        getByIdSt = connection.prepareStatement(
                "SELECT name FROM client WHERE id = ?"
        );

        setNameSt = connection.prepareStatement(
                "UPDATE client SET name = ? WHERE id = ?"
        );

        deleteByIdSt = connection.prepareStatement(
                "DELETE FROM client WHERE id = ?"
        );

        listAllSt = connection.prepareStatement(
                "SELECT * FROM client"
        );
    }

    public long create(String name) throws SQLException {
        createSt.setString(1, name);
        createSt.executeUpdate();

        long id;
        try(ResultSet rs = maxIdSt.executeQuery()) {
            rs.next();
            id = rs.getLong("maxId");
        }
        return id;
    }

    public String getById(long id) throws SQLException {
        getByIdSt.setLong(1, id);
        try(ResultSet rs = getByIdSt.executeQuery()) {
            if (!rs.next()) {
                return null;
            }

            return rs.getString("name");
        }
    }

    public void setName(long id, String name) throws SQLException {
        setNameSt.setLong(2, id);
        setNameSt.setString(1, name);
        setNameSt.executeUpdate();
    }

    public void deleteById(long id) throws SQLException {
        deleteByIdSt.setLong(1, id);
        deleteByIdSt.executeUpdate();
    }

    public List<ClientEntity> listAll(){
        List<ClientEntity> list = new ArrayList<>();

        try(ResultSet rs = listAllSt.executeQuery()){
            while(rs.next()){
                ClientEntity client = new ClientEntity();
                client.setId(rs.getLong("id"));
                client.setName(rs.getString("name"));
                list.add(client);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return list;
    }
}
