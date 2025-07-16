/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.VendaDAO;
import exceptions.SaleInvalid;
import java.sql.SQLException;
import java.util.List;
import model.ItemVenda;
import model.Venda;

/**
 *
 * @author fabri
 */
public class VendaController {
    private VendaDAO vendaDAO;

    public VendaController() {
        this.vendaDAO = new VendaDAO();
    }
         
    public void create(int idUsuario, int idCliente, double total, List<ItemVenda> carrinho) throws SaleInvalid, SQLException{
        if (total > 0) {
            Venda venda = new Venda(idCliente, idUsuario, total, carrinho);
            this.vendaDAO.create(venda);
        }
        else {
            throw new SaleInvalid("Soma total deve ser maior que 0");
        }
    }
    
    public List<Venda> getAll() throws SQLException{
        return this.vendaDAO.getAll();
    }
}
