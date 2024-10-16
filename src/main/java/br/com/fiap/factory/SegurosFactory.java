package br.com.fiap.factory;

import br.com.fiap.Service.ImovelEnum;
import br.com.fiap.model.entites.Seguros;
import br.com.fiap.model.entites.SegurosImovel;

public class SegurosFactory {

    public static Seguros criarSeguro(String tipo, double valor, Long idCliente) {
        return new Seguros(tipo, valor, idCliente);
    }

    public static SegurosImovel criarSeguroImovel(String tipo, double valor, Long idCliente, ImovelEnum imovel) {
        return new SegurosImovel(tipo, valor, idCliente, imovel);
    }
}