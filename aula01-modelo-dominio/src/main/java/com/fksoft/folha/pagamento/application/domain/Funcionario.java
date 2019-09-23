package com.fksoft.folha.pagamento.application.domain;

public class Funcionario {

    private String nome;
    private String sobrenome;
    private String cargo;

    public Funcionario(String nome, String sobrenome, String cargo) {
        if(nome == null || "".equals(nome.trim()))
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        if(sobrenome == null || "".equals(sobrenome.trim()))
            throw new IllegalArgumentException("Sobrenome não pode ser nulo ou vazio.");
        if(cargo == null || "".equals(cargo.trim()))
            throw new IllegalArgumentException("Cargo não pode ser nulo ou vazio.");
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCargo() {
        return cargo;
    }
}
