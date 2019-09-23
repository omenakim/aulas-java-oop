package com.fksoft.folha.pagamento.application.domain;

public class Salario {

    private Double salarioBruto;
    private Double salarioLiquido;

    public Salario(Double salarioBruto) {
        if (salarioBruto == null || salarioBruto.equals(0.))
            throw new IllegalArgumentException("Salario não pode ser nulo e nem igual a zero.");
        this.salarioBruto = salarioBruto;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public Double getSalarioLiquido() {
        return (double) Math.round(salarioLiquido * 100) / 100;
    }

    void setSalarioLiquido(Double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }
}

