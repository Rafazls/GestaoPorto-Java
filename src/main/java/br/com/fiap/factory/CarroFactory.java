package br.com.fiap.factory;
import br.com.fiap.model.entites.Carro;
public class CarroFactory {
    public static Carro criarCarro(Long id, String modelo, String marca, int ano, String placa) {
        return new Carro(id, modelo, marca, ano, placa);
    }
}
