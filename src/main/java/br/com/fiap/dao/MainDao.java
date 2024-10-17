package br.com.fiap.dao;

import br.com.fiap.config.DatabaseConfig;
import br.com.fiap.dao.carro.CarroDao;
import br.com.fiap.dao.carro.CarroDaoImpl;
import br.com.fiap.dao.cliente.ClienteDao;
import br.com.fiap.dao.cliente.ClienteDaoImpl;
import br.com.fiap.dao.Seguro.SeguroDaoImpl;
import br.com.fiap.dao.Seguro.SeguroDao;
import br.com.fiap.factory.ClienteFactory;
import br.com.fiap.factory.SegurosFactory;
import br.com.fiap.model.entites.Carro;
import br.com.fiap.model.entites.Cliente;
import br.com.fiap.model.entites.Seguros;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MainDao {
    public static void main(String[] args) {
        DatabaseConfig config = new DatabaseConfig(
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "RM554733",
                "251003"
        );

        try (Connection connection = config.getConnection()) {

            // Cliente
            ClienteDao clienteDao = new ClienteDaoImpl(connection);
            Cliente cliente1 = ClienteFactory.criarCliente(1L, "João Silva", "123.456.789-09", 30);
            clienteDao.create(cliente1);

            // Criando e Inicializando CarroDao
            CarroDao carroDao = new CarroDaoImpl(connection);
            Carro carro1 = new Carro(123456L, "Fusca", "Branco", 1980, "Volkswagen");
            carroDao.create(carro1);

            // Lendo todos os Carros
            List<Carro> listaCarros = carroDao.readAll();
            for (Carro carro : listaCarros) {
                System.out.println(carro.toString());
            }

            // Atualizando um Carro
            carro1.setNome("Gol");
            carroDao.update(carro1);

            // Verificando a atualização
            listaCarros = carroDao.readAll();
            for (Carro carro : listaCarros) {
                System.out.println(carro.toString());
            }

            // Deletando um Carro
            carroDao.delete(carro1.getChassi());
            
            // Seguro
            SeguroDaoImpl seguroDao = new SeguroDaoImpl(connection);
            seguroDao.create("Tipo1", 1000.00f, 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
