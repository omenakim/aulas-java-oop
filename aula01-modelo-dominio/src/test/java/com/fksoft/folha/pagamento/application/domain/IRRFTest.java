package com.fksoft.folha.pagamento.application.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IRRFTest {

    @Test
    public void deveCalcularIRRF_valorMenorOuIgualA_1903_98() {
        IRRF irrf = new IRRF();
        irrf.calcular(1000.);
        assertEquals(new Double(0.), irrf.getParcelaDedutivel());
        assertEquals(new Double(0.), irrf.getAliquota());
        assertEquals(new Double(0.), irrf.getValorDoDesconto());
    }

    @Test
    public void deveCalcularIRRF_valorMaiorOuIgualA_1903_99_e_valorMenorOuIgualA_2826_65() {
        IRRF irrf = new IRRF();
        irrf.calcular(2000.);
        assertEquals(new Double(142.80), irrf.getParcelaDedutivel());
        assertEquals(new Double(7.5), irrf.getAliquota());
        assertEquals(new Double(7.2), irrf.getValorDoDesconto());
    }

    @Test
    public void deveCalcularIRRF_valorMaiorOuIgualA_2826_66_e_valorMenorOuIgualA_3751_05() {
        IRRF irrf = new IRRF();
        irrf.calcular(3000.);
        assertEquals(new Double(354.80), irrf.getParcelaDedutivel());
        assertEquals(new Double(15), irrf.getAliquota());
        assertEquals(new Double(95.2), irrf.getValorDoDesconto());
    }

    @Test
    public void deveCalcularIRRF_valorMaiorOuIgualA_3751_06_e_valorMenorOuIgualA_4664_68() {
        IRRF irrf = new IRRF();
        irrf.calcular(4000.);
        assertEquals(new Double(636.13), irrf.getParcelaDedutivel());
        assertEquals(new Double(22.5), irrf.getAliquota());
        assertEquals(new Double(263.87), irrf.getValorDoDesconto());
    }

    @Test
    public void deveCalcularIRRF_valorMaiQue_4664_68() {
        IRRF irrf = new IRRF();
        irrf.calcular(5000.);
        assertEquals(new Double(869.36), irrf.getParcelaDedutivel());
        assertEquals(new Double(27.5), irrf.getAliquota());
        assertEquals(new Double(505.64), irrf.getValorDoDesconto());
    }
}
