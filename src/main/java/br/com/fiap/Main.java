package br.com.fiap;

import br.com.fiap.model.entites.Cliente;

public class Main {
    public static void main(String[] args) {
        try {
            Cliente cliente = new Cliente(1L, "João Silva", "123.456.789-09", 25);
            System.out.println(cliente);
        } catch (RuntimeException e) {
            System.err.println("Erro ao criar cliente: " + e.getMessage());
        }
    }
}
