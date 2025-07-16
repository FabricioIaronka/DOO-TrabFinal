package dao;

import model.ItemVenda;
import model.Venda;
import util.Connection;

import java.sql.*;
import java.util.*;

public class VendaDAO {

    public List<Venda> getAll() throws SQLException {
        String sql = "SELECT * FROM venda ORDER BY id";
        Map<Integer, Venda> vendaMap = new LinkedHashMap<>();

        try (java.sql.Connection conn = Connection.conector(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int vendaId = rs.getInt("id");

                // Se ainda não existe a venda no mapa, cria
                if (!vendaMap.containsKey(vendaId)) {
                    Venda venda = new Venda(
                            vendaId,
                            rs.getInt("id_cliente"),
                            rs.getInt("id_usuario"),
                            rs.getTimestamp("data"),
                            0.0
                    );
                    vendaMap.put(vendaId, venda);
                }

                // Cria item da venda
                ItemVenda item = new ItemVenda(
                        rs.getInt("id_produto"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco_unitario")
                );

                // Adiciona o item na venda
                Venda venda = vendaMap.get(vendaId);
                venda.getItens().add(item);

                // Soma ao total
                double subtotal = item.getQuantidade() * item.getPrecoUnitario();
                venda.setTotal(venda.getTotal() + subtotal);
            }
        }

        // Retorna todas as vendas com seus itens
        return new ArrayList<>(vendaMap.values());
    }

    public List<Venda> getByUsuarioId(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM venda WHERE id_usuario = ? ORDER BY id";
        Map<Integer, Venda> vendaMap = new LinkedHashMap<>();

        try (java.sql.Connection conn = Connection.conector(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int vendaId = rs.getInt("id");

                // Se ainda não existe a venda no mapa, cria
                if (!vendaMap.containsKey(vendaId)) {
                    Venda venda = new Venda(
                            vendaId,
                            rs.getInt("id_cliente"),
                            rs.getInt("id_usuario"),
                            rs.getTimestamp("data"),
                            0.0
                    );
                    vendaMap.put(vendaId, venda);
                }

                // Cria o item de venda
                ItemVenda item = new ItemVenda(
                        rs.getInt("id_produto"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco_unitario")
                );

                // Adiciona item à venda
                Venda venda = vendaMap.get(vendaId);
                venda.getItens().add(item);

                // Soma ao total
                double subtotal = item.getQuantidade() * item.getPrecoUnitario();
                venda.setTotal(venda.getTotal() + subtotal);
            }
        }

        return new ArrayList<>(vendaMap.values());
    }
    
    public void create(Venda venda) throws SQLException {
    String getMaxIdSQL = "SELECT MAX(id) AS max_id FROM venda";
    String insertSQL = "INSERT INTO venda (id, id_cliente, id_usuario, id_produto, quantidade, preco_unitario, data) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (java.sql.Connection conn = Connection.conector()) {
        conn.setAutoCommit(false); // Transação

        int nextId;

        // Obtém o próximo ID de venda
        try (PreparedStatement stmtMax = conn.prepareStatement(getMaxIdSQL);
             ResultSet rs = stmtMax.executeQuery()) {

            nextId = (rs.next()) ? rs.getInt("max_id") + 1 : 1;
        }

        // Insere os itens da venda
        try (PreparedStatement stmtInsert = conn.prepareStatement(insertSQL)) {
            for (ItemVenda item : venda.getItens()) {
                stmtInsert.setInt(1, nextId);
                stmtInsert.setInt(3, venda.getIdUsuario());
                stmtInsert.setInt(4, item.getProdutoId());
                stmtInsert.setInt(5, item.getQuantidade());
                stmtInsert.setDouble(6, item.getPrecoUnitario());
                stmtInsert.setTimestamp(7, new Timestamp(venda.getData().getTime()));
                
                if (venda.getIdCliente() == -1){
                    stmtInsert.setString(2, null);
                }
                else{
                    stmtInsert.setInt(2, venda.getIdCliente());
                }

                stmtInsert.addBatch();
            }

            stmtInsert.executeBatch();
        }

        conn.commit();
        venda.setId(nextId); // Atualiza o ID da venda após inserir
    }
}


}
