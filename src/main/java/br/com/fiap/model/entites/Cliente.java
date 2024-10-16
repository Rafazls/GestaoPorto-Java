package br.com.fiap.model.entites;

public class Cliente {

    private Long id;
    private String name;
    private String CPF;
    private int idade;

    public Cliente(Long id, String name,String CPF, int idade) {
        this.id = id;
        this.name = name;
        setIdade(idade);
        setCPF(CPF);
    }

    private boolean isMaiorIdade(int idade) {
        return idade >= 18;
    }

    public boolean isCPFValido(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        return calcularDigitoVerificador(cpf);
    }

    private boolean calcularDigitoVerificador(String cpf) {
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) {
            digito2 = 0;
        }

        return digito1 == Character.getNumericValue(cpf.charAt(9)) &&
                digito2 == Character.getNumericValue(cpf.charAt(10));
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(isMaiorIdade(idade)){
            this.idade = idade;
        } else {
            throw new RuntimeException();
        }
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        if(isCPFValido(CPF)){
            this.CPF = CPF;
        } else {
            throw new RuntimeException();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idade=" + idade +
                '}';
    }


    public void setNome(String mariaSilva) {
    }
}