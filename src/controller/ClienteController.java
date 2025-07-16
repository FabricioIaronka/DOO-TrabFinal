/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.ClienteDAO;
import exceptions.ClientInvalid;
import java.sql.SQLException;
import java.util.List;
import model.Cliente;

/**
 *
 * @author fabri
 */
public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }
    
    public List<Cliente> getAll() throws SQLException {
        return this.clienteDAO.getAll();
    }
    
    public List<Cliente> searchByName(String nome) throws SQLException{
        return this.clienteDAO.searchByName(nome);
    }
    
    public void addProduto(String nome, String sobrenome, String telefone, String endereco, String cpf) throws SQLException, ClientInvalid {
        Cliente cliente = new Cliente(nome, sobrenome, telefone, endereco, cpf);
        this.clienteDAO.create(cliente);    
    }
    
    public void updateProduto(int id, String nome, String sobrenome, String telefone, String endereco, String cpf) throws SQLException, ClientInvalid {
        Cliente cliente = new Cliente(id, nome, sobrenome, telefone, endereco, cpf);
        this.clienteDAO.update(cliente);
    }
    
    public void deleteProduto(int id) throws SQLException {
        this.clienteDAO.delete(id);
    }
}
