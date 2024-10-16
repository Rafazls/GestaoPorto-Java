package br.com.fiap.model.entites;

public class Seguros {
    protected String tipo;
    protected double valor;
    protected Long idCliente;
    protected Long id;

    public Seguros() {
    }

    public Seguros(String tipo, double valor, Long idCliente) {
        this.tipo = tipo;
        this.valor = valor;
        this.idCliente = idCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long id_cliente) {
        this.idCliente = id_cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Seguro{" +
                "tipo='" + tipo + '\'' +
                ", valor=" + valor +
                ", idCliente=" + idCliente +
                '}';
    }
}
