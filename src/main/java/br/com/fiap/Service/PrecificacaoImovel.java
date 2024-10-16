package br.com.fiap.Service;

public interface PrecificacaoImovel {
    void definirPrecoPorTipo(ImovelEnum imovel);
    double valorSeguroPorImovel(ImovelEnum imovel);
}
