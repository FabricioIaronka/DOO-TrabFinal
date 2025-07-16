package DAO;

import model.Cliente;
import util.Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public Cliente getById(int id) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id = ?";

        try (java.sql.Connection conn = Connection.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToCliente(rs);
            } else {
                return null;
            }
        }
    }
    
    public void create(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, sobrenome, telefone, endereco, cpf) Values (?,?,?,?,?)";
        
        try (java.sql.Connection conn = Connection.conector(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getCpf());

            stmt.executeUpdate();
        }
    }

    public void update(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nome = ?, sobrenome = ?, telefone = ?, endereco = ?, cpf = ? WHERE id = ?";

        try (java.sql.Connection conn = Connection.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getCpf());
            stmt.setInt(6, cliente.getId());

            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try (java.sql.Connection conn = Connection.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    public List<Cliente> getAll() throws SQLException {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<>();

        try (java.sql.Connection conn = Connection.conector();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                clientes.add(mapResultSetToCliente(rs));
            }
        }

        return clientes;
    }
    
    public List<Cliente> searchByName(String nome) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        List<Cliente> cliente = new ArrayList<>();

        try (java.sql.Connection conn = Connection.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cliente.add(mapResultSetToCliente(rs));
            }
        }

        return cliente;
    }

    //Retorna objeto cliente a partir de ResultSet
    private Cliente mapResultSetToCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setSobrenome(rs.getString("sobrenome"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setEndereco(rs.getString("endereco"));
        cliente.setCpf(rs.getString("cpf"));
        return cliente;
    }
}
