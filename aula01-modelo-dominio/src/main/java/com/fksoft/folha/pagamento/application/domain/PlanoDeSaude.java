package com.fksoft.folha.pagamento.application.domain;

public class PlanoDeSaude extends Desconto {

    /**
     * Se valor <= 1000. o valorDoDesconto é igual a 80. reais
     * Se valor >= 1001 e valor <= 3000 o valorDoDesconto é igual a 250. reais
     * Senão desconto é igual a 500 reais
     */
    public void calcular(Double valor) {
        if (valor <= 1000.) {
            valorDoDesconto = 80.;
        } else if (valor >= 1001. && valor <= 3000.) {
            valorDoDesconto = 250.;
        } else {
            valorDoDesconto = 500.;
        }
    }

}
