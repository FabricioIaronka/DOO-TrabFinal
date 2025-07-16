/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.UsuarioDAO;
import exceptions.LoginInvalid;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author fabri
 */
public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public Usuario login(String user, String senha) throws SQLException, LoginInvalid{
        Usuario usuario = this.usuarioDAO.login(user, senha);
        if (usuario != null) return usuario;
        else throw new LoginInvalid("Usuario ou Senha inválidos");
    }
}
