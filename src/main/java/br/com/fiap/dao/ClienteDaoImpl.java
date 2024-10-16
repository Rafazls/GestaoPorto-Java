package br.com.fiap.dao;
import br.com.fiap.entites.Cliente;

import java.sql.*;
        import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {
    private final Connection connection;

    public ClienteDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Cliente cliente) {
        String sql = "INSERT INTO cliente(id, nome, cpf, idade) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cliente.getId());
            pstmt.setString(2, cliente.getName());
            pstmt.setString(3, cliente.getCPF());
            pstmt.setInt(4, cliente.getIdade());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar cliente");
        }
    }

    @Override
    public List<Cliente> readAll() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                int idade = rs.getInt("idade");
                clientes.add(new Cliente(id, nome, cpf, idade));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void update(Cliente cliente) {
        String sql = "UPDATE cliente SET nome=?, cpf=?, idade=? WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cliente.getName());
            pstmt.setString(2, cliente.getCPF());
            pstmt.setInt(3, cliente.getIdade());
            pstmt.setLong(4, cliente.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM cliente WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
