package br.com.fiap.dao;
import br.com.fiap.entites.Cliente;

import java.util.List;

public interface ClienteDao {
    void create(Cliente cliente);
    List<Cliente> readAll();
    void update(Cliente cliente);
    void delete(Long id);
}
