/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.DriverManager;

/**
 *
 * @author fabri
 */
public class Connection {
    public static java.sql.Connection conector(){
        java.sql.Connection conexao;
        //chama o driver para conectar
        
        //informações referentes ao banco de dados
        String url = "jdbc:mysql://127.0.0.1:3306/estoque_vendas";
        String user = "root";
        String password = "$ListOrganizer6587";
        
        //estabelecendo a conexao com o banco de dados
        try {
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
