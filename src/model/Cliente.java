/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import exceptions.ClientInvalid;

/**
 *
 * @author alunolages
 */
public class Cliente {
    private int id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String endereco;
    private String cpf;

    public Cliente(int id, String nome, String sobrenome, String telefone, String endereco, String cpf) throws ClientInvalid {
        validaCliente(nome, sobrenome, telefone, endereco, cpf);
        
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public Cliente(String nome, String sobrenome, String telefone, String endereco, String cpf) throws ClientInvalid {
        validaCliente(nome, sobrenome, telefone, endereco, cpf);
        
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }
    
    private void validaCliente(String nome, String sobrenome, String telefone, String endereco, String cpf) throws ClientInvalid{
        if (nome == null || nome.length() > 100) throw new ClientInvalid("Tamanho do nome excede o valor máximo(100)");
        if (sobrenome == null || sobrenome.length() > 100) throw new ClientInvalid("Tamanho do sobrenome excede o valor máximo(100)");
        if (telefone == null || telefone.length() > 20) throw new ClientInvalid("Tamanho do telefone excede o valor máximo(20)");
        if (endereco == null || endereco.length() > 200) throw new ClientInvalid("Tamanho do endereco excede o valor máximo(200)");
        if (cpf == null || cpf.length() > 14) throw new ClientInvalid("Tamanho do cpf excede o valor máximo(14)");
        
    }
    
    public Cliente() {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + ", endereco=" + endereco + ", cpf=" + cpf + '}';
    }

    
    
    
    
}
