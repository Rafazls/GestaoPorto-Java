package br.com.fiap.dao.Seguro;
import br.com.fiap.model.entites.Seguros;
import br.com.fiap.factory.SegurosFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeguroDaoImpl implements SeguroDao {
    private final Connection connection;

    public SeguroDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Seguros seguro) {
        String sql = "INSERT INTO seguro(tipo, valor, id_cliente) VALUES(?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, seguro.getTipo());
            pstmt.setDouble(2, seguro.getValor());
            pstmt.setLong(3, seguro.getIdCliente());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar seguro");
        }
    }

    @Override
    public List<Seguros> readAll() {
        List<Seguros> seguros = new ArrayList<>();
        String sql = "SELECT * FROM seguro";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String tipo = rs.getString("tipo");
                double valor = rs.getDouble("valor");
                Long idCliente = rs.getLong("id_cliente");
                Seguros seguro = SegurosFactory.criarSeguro(tipo, valor, idCliente);
                seguro.setId(id);
                seguros.add(seguro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seguros;
    }

    @Override
    public void update(Seguros seguro) {
        String sql = "UPDATE seguro SET tipo=?, valor=?, id_cliente=? WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, seguro.getTipo());
            pstmt.setDouble(2, seguro.getValor());
            pstmt.setLong(3, seguro.getIdCliente());
            pstmt.setLong(4, seguro.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM seguro WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
