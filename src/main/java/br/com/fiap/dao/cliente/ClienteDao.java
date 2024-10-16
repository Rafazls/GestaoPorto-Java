package br.com.fiap.dao.cliente;
import br.com.fiap.model.entites.Cliente;

import java.util.List;

public interface ClienteDao {
    void create(Cliente cliente);
    List<Cliente> readAll();
    void update(Cliente cliente);
    void delete(Long id);
}
