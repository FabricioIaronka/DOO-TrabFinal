/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alunolages
 */
public class Venda {
    private int id;
    private int idCliente;
    private int idUsuario;
    private Date data;
    private double total;
    private List<ItemVenda> itens;

    public Venda(int id, int idUsuario, int idCliente, Date data, double total) {
        this.id = id;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.data = data;
        this.total = total;
        this.itens = new ArrayList<>();
        
        calcTotal();
    }

    public Venda(int idCliente, int idUsuario, double total, List<ItemVenda> itens) {
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.data = new Date();
        this.total = total;
        this.itens = itens;
    }

    private void calcTotal(){
        double sum = 0;
        for(ItemVenda iv : this.itens){
            sum += iv.getPrecoUnitario()*iv.getQuantidade();
        }
        
        this.total = sum;
    }

    public Venda(int idUsuario) {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
   
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
    
    
}
