package br.com.fiap.dao.Seguro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SeguroDaoImpl {

    private Connection connection;

    public SeguroDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public void create(String tipo, float valor, int idCliente) {
        String sql = "INSERT INTO seguro(ID, TIPO, VALOR, ID_CLIENTE) VALUES(seguro_id_seq.NEXTVAL, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            stmt.setFloat(2, valor);
            stmt.setInt(3, idCliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar seguro", e);
        }
    }
}