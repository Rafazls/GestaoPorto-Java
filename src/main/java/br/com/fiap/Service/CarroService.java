package br.com.fiap.Service;

import br.com.fiap.entites.Carro;
import br.com.fiap.dao.carro.CarroDao;

import java.util.List;

public class CarroService {
    private static CarroService instance;
    private final CarroDao carroDao;

    private CarroService(CarroDao carroDao) {
        this.carroDao = carroDao;
    }

    public static CarroService getInstance(CarroDao carroDao) {
        if (instance == null) {
            instance = new CarroService(carroDao);
        }
        return instance;
    }

    public void cadastrarCarro(Carro carro) {
        carroDao.create(carro);
    }

    public List<Carro> listarCarros() {
        return carroDao.readAll();
    }

    public void atualizarCarro(Carro carro) {
        carroDao.update(carro);
    }

    public void removerCarro(Long id) {
        carroDao.delete(id);
    }
}
