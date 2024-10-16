package br.com.fiap.Service;


import br.com.fiap.dao.cliente.ClienteDao;
import br.com.fiap.entites.Cliente;

import java.util.List;

public class ClienteService {
    private static ClienteService instance;
    private final ClienteDao clienteDao;

    private ClienteService(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public static ClienteService getInstance(ClienteDao clienteDao) {
        if (instance == null) {
            instance = new ClienteService(clienteDao);
        }
        return instance;
    }

    public void cadastrarCliente(Cliente cliente) {
        clienteDao.create(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDao.readAll();
    }

    public void atualizarCliente(Cliente cliente) {
        clienteDao.update(cliente);
    }

    public void removerCliente(Long id) {
        clienteDao.delete(id);
    }
}