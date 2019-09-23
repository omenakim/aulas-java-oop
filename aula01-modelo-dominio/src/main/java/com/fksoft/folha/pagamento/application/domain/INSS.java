package com.fksoft.folha.pagamento.application.domain;

public class INSS extends Desconto {

    private Double aliquota;

    private final Double TETO = 5839.45;

    public void calcular(Double valor) {
        if (valor <= 1751.81) {
            aliquota = 0.08;
            valorDoDesconto = valor * aliquota;
        } else if (valor >= 1751.82 && valor <= 2919.72) {
            aliquota = 0.09;
            valorDoDesconto = valor * aliquota;
        } else if (valor >= 2919.73 && valor <= TETO) {
            aliquota = 0.11;
            valorDoDesconto = valor * aliquota;
        } else {
            aliquota = 0.11;
            valorDoDesconto = TETO * aliquota;
        }
    }

    public Double getAliquota() {
        return aliquota * 100;
    }

}
