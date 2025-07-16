/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import exceptions.ProductInvalid;

/**
 *
 * @author alunolages
 */
public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;

    public Produto(int id, String nome, String descricao, double preco, int quantidade) throws ProductInvalid{
        prodValidacao(nome, descricao, preco, quantidade);
        
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(String nome, String descricao, double preco, int quantidade) throws ProductInvalid{
        prodValidacao(nome, descricao, preco, quantidade);
        
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    private void prodValidacao(String nome, String descricao, double valor, int quant) throws ProductInvalid {
        if (nome == null || nome.length() > 100) throw new ProductInvalid("Tamanho do nome excede o valor máximo(100)");
        if (descricao == null || descricao.length() > 255) throw new ProductInvalid("Tamanho da descrição excede o valor máximo(255)");
        if (valor <= 0) throw new ProductInvalid("Valor do produto não pode ser <= 0");
        if (quant < 0) throw new ProductInvalid("Quantidade do produto não pode ser < 0");
        
    }
    
    public Produto() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
