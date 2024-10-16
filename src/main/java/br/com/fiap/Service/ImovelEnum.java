package br.com.fiap.Service;

public enum ImovelEnum {
    APARTAMENTO(300000),
    CASA(500000),
    CHACARA(700000);

    private double valorMercado;

    ImovelEnum(double valorMercado) {
        this.valorMercado = valorMercado;
    }

    public double getValorMercado() {
        return valorMercado;
    }
}
