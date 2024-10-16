package br.com.fiap.factory;

import br.com.fiap.model.entites.Cliente;

public class ClienteFactory {

    public static Cliente criarCliente(Long id, String nome, String cpf, int idade) {
        return new Cliente(id, nome, cpf, idade);
    }
}
