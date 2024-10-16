package br.com.fiap.dao;
import java.util.List;
import br.com.fiap.entites.Carro;

public interface CarroDao {
    void create(Carro carro);
    List<Carro> readAll();
    void update(Carro carro);
    void delete(Long id);
}
