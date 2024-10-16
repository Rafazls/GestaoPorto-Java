package br.com.fiap.dao;

import br.com.fiap.Config.DatabaseConfig;
import br.com.fiap.dao.carro.CarroDao;
import br.com.fiap.dao.carro.CarroDaoImpl;
import br.com.fiap.dao.cliente.ClienteDao;
import br.com.fiap.dao.cliente.ClienteDaoImpl;
import br.com.fiap.entites.Carro;
import br.com.fiap.entites.Cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MainDao {
    public static void main(String[] args) {
        // Configuração do banco de dados
        DatabaseConfig config = new DatabaseConfig(
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "RMXXXXXX",  // substitua pelo seu RM
                "suaSenha"   // substitua pela sua senha
        );

        try (Connection connection = config.getConnection()) {

            // Instanciando DAO de Cliente
            ClienteDao clienteDao = new ClienteDaoImpl(connection);
            // Criando Cliente
            Cliente cliente1 = new Cliente(1L, "João Silva", "12345678900", 30);
            clienteDao.create(cliente1);

            // Lendo todos os Clientes
            List<Cliente> listaClientes = clienteDao.readAll();
            for (Cliente cliente : listaClientes) {
                System.out.println(cliente.toString());
            }

            // Atualizando um Cliente
            cliente1.setNome("Maria Silva");
            clienteDao.update(cliente1);

            // Verificando a atualização
            listaClientes = clienteDao.readAll();
            for (Cliente cliente : listaClientes) {
                System.out.println(cliente.toString());
            }

            // Deletando um Cliente
            clienteDao.delete(cliente1.getId());

            // Instanciando DAO de Carro
            CarroDao carroDao = new CarroDaoImpl(connection);
            // Criando Carro
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

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro na conexão com o banco de dados.");
        }
    }
}
