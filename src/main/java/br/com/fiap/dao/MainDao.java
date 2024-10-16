package br.com.fiap.dao;

import br.com.fiap.config.DatabaseConfig;
import br.com.fiap.dao.cliente.ClienteDao;
import br.com.fiap.dao.cliente.ClienteDaoImpl;
import br.com.fiap.dao.Seguro.SeguroDaoImpl;
import br.com.fiap.dao.Seguro.SeguroDao;
import br.com.fiap.factory.ClienteFactory;
import br.com.fiap.factory.SegurosFactory;
import br.com.fiap.model.entites.Cliente;
import br.com.fiap.model.entites.Seguros;

import java.sql.Connection;
import java.sql.SQLException;

public class MainDao {
    public static void main(String[] args) {
        DatabaseConfig config = new DatabaseConfig(
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "RMXXXXXX",
                "suaSenha"
        );

        try (Connection connection = config.getConnection()) {

            // Cliente
            ClienteDao clienteDao = new ClienteDaoImpl(connection);
            Cliente cliente1 = ClienteFactory.criarCliente(1L, "João Silva", "12345678900", 30);
            clienteDao.create(cliente1);

            // Seguro
            SeguroDao seguroDao = new SeguroDaoImpl(connection);
            Seguros seguro1 = SegurosFactory.criarSeguro("Carro", 1500.00, cliente1.getId());
            seguroDao.create(seguro1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
