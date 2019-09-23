package com.fksoft.folha.pagamento.application.domain;

public class IRRF extends Desconto {

    private Double aliquota;
    private Double parcelaDedutivel;


    public void calcular(Double valor) {
        if (valor <= 1903.98) {
            aliquota = 0.;
            parcelaDedutivel = 0.;
            valorDoDesconto = 0.;

        } else if (valor >= 1903.99 && valor <= 2826.65) {
            aliquota = 0.075;
            parcelaDedutivel = 142.80;
            aplicarDeducao(valor);

        } else if (valor >= 2826.66 && valor <= 3751.05) {
            aliquota = 0.15;
            parcelaDedutivel = 354.80;
            aplicarDeducao(valor);

        } else if (valor >= 3751.06 && valor <= 4664.68) {
            aliquota = 0.225;
            parcelaDedutivel = 636.13;
            aplicarDeducao(valor);

        } else {
            aliquota = 0.275;
            parcelaDedutivel = 869.36;
            aplicarDeducao(valor);
        }
    }

    private void aplicarDeducao(Double valor) {
        valorDoDesconto = (valor * aliquota) - parcelaDedutivel;
    }

    public Double getAliquota() {
        return (double) Math.round((aliquota * 100) * 100) / 100;
    }

    public Double getParcelaDedutivel() {
        return parcelaDedutivel;
    }


}
