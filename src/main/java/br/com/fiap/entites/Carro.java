package br.com.fiap.entites;

public class Carro {

    private Long chassi;
    private String nome;
    private String cor;
    private int ano;
    private String marca;


    public Carro(Long chassi, String nome, String cor, int ano, String marca) {
        this.chassi = chassi;
        this.nome = nome;
        this.cor = cor;
        this.ano = ano;
        this.marca = marca;
    }

    public Long getChassi() {
        return chassi;
    }

    public void setChassi(Long chassi) {
        this.chassi = chassi;
    }

    public String getnome() {
        return nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "chassi=" + chassi +
                ", nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", ano=" + ano +
                ", marca='" + marca + '\'' +
                '}';
    }


}
