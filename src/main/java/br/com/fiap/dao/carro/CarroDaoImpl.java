package br.com.fiap.dao.carro;

import br.com.fiap.model.entites.Carro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDaoImpl implements CarroDao {
    private final Connection connection;

    public CarroDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Carro carro) {
        String sql = "INSERT INTO carro(chassi, nome, cor, ano, marca) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, carro.getChassi());
            pstmt.setString(2, carro.getnome());
            pstmt.setString(3, carro.getCor());
            pstmt.setInt(4, carro.getAno());
            pstmt.setString(5, carro.getMarca());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar carro");
        }
    }

    @Override
    public List<Carro> readAll() {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM carro";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                int ano = rs.getInt("ano");
                String placa = rs.getString("placa");
                carros.add(new Carro(id, modelo, marca, ano, placa));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carros;
    }

    @Override
    public void update(Carro carro) {
        String sql = "UPDATE carro SET nome=?, cor=?, ano=?, marca=? WHERE chassi=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, carro.getnome());
            pstmt.setString(2, carro.getnome());
            pstmt.setInt(3, carro.getAno());
            pstmt.setString(4, carro.getMarca());
            pstmt.setLong(5, carro.getChassi());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM carro WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
