package com.fksoft.folha.pagamento.application.domain;

public abstract class Desconto {

    protected Double valorDoDesconto;

    public abstract void calcular(Double valor);

    public Double getValorDoDesconto() {
        return (double) Math.round(valorDoDesconto * 100) /100;
    }
}
