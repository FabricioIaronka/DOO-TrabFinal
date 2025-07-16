/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.ProdutoDAO;
import exceptions.ProductInvalid;
import java.sql.SQLException;
import java.util.List;
import model.Produto;

/**
 *
 * @author fabri
 */
public class ProdutoController {
    private ProdutoDAO prodDAO;

    public ProdutoController() {
        this.prodDAO = new ProdutoDAO();
    }
    
    public List<Produto> getAll() throws SQLException {
        return this.prodDAO.getAll();
    }
    
    public void addProduto(String nome, String descricao, double valor, int quant) throws SQLException, ProductInvalid {
        Produto prod = new Produto(nome, descricao, valor, quant);
        this.prodDAO.create(prod);    
    }
    
    public void updateProduto(int id, String nome, String descricao, double valor, int quant) throws SQLException, ProductInvalid {
        Produto prod = new Produto(id, nome, descricao, valor, quant);
        this.prodDAO.update(prod);
    }
    
    public void deleteProduto(int id) throws SQLException {
        this.prodDAO.delete(id);
    }
    
    public List<Produto> searchByName(String nome) throws SQLException{
        return this.prodDAO.searchByName(nome);
    }
}
