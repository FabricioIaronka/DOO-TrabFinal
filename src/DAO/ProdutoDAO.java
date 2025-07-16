package DAO;

import model.Produto;
import util.Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public Produto getById(int id) throws SQLException {
        String sql = "SELECT * FROM produto WHERE id = ?";

        try (java.sql.Connection conn = Connection.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToProduto(rs);
            } else {
                return null;
            }
        }
    }

    public List<Produto> getAll() throws SQLException {
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<>();

        try (java.sql.Connection conn = Connection.conector();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                produtos.add(mapResultSetToProduto(rs));
            }
        }

        return produtos;
    }
    
    public void create(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome, descricao_curta, preco, quantidade) Values (?,?,?,?)";
        
        try (java.sql.Connection conn = Connection.conector(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());

            stmt.executeUpdate();
        }
    }
    
    public void update(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET nome = ?, descricao_curta = ?, preco = ?, quantidade = ? WHERE id = ?";

        try (java.sql.Connection conn = Connection.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setInt(5, produto.getId());

            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (java.sql.Connection conn = Connection.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Produto> searchByName(String nome) throws SQLException {
        String sql = "SELECT * FROM produto WHERE nome LIKE ?";
        List<Produto> produtos = new ArrayList<>();

        try (java.sql.Connection conn = Connection.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                produtos.add(mapResultSetToProduto(rs));
            }
        }

        return produtos;
    }

    //Retorna objeto produto a partir de ResultSet
    private Produto mapResultSetToProduto(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        
        produto.setId(rs.getInt("id"));
        produto.setNome(rs.getString("nome"));
        produto.setDescricao(rs.getString("descricao_curta"));
        produto.setPreco(rs.getDouble("preco"));
        produto.setQuantidade(rs.getInt("quantidade"));
        
        return produto;
    }
}
