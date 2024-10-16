package br.com.fiap.dao.Seguro;

import br.com.fiap.model.entites.Seguros;

import java.util.List;

public interface SeguroDao {
    void create(Seguros seguro);
    List<Seguros> readAll();
    void update(Seguros seguro);
    void delete(Long id);
}

