/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import exceptions.LoginInvalid;
import model.Usuario;
import util.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alunolages
 */
public class UsuarioDAO {

    public Usuario login(String nomeUsuario, String senha) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE nome_usuario = ? AND senha = ?";

        try (java.sql.Connection conn = Connection.conector(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomeUsuario);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNivel(rs.getString("nivel"));
                return usuario;
            }
        }
        return null;
    }

    public void create(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome_usuario, senha, nivel) VALUES (?, ?, ?)";

        try (java.sql.Connection conn = Connection.conector(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getNivel());

            stmt.executeUpdate();
        }
    }
    
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (java.sql.Connection conn = Connection.conector(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
