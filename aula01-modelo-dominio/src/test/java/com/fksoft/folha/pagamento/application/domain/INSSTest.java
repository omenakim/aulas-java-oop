package com.fksoft.folha.pagamento.application.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class INSSTest {

    @Test
    public void deveCalcularINSS_valorMenorOuIgualQue_1751_81() {
        INSS inss = new INSS();
        inss.calcular(1000.);
        assertEquals(new Double(80.), inss.getValorDoDesconto());
        assertEquals(new Double(8.), inss.getAliquota());
    }

    @Test
    public void deveCalcularINSS_valorMaiorOuIgual_1751_82_e_valorMenorOuIgual_2919_72() {
        INSS inss = new INSS();
        inss.calcular(2000.);
        assertEquals(new Double(180.), inss.getValorDoDesconto());
        assertEquals(new Double(9.), inss.getAliquota());
    }

    @Test
    public void deveCalcularINSS_valorMaiorOuIgual_2919_73_e_valorMenorOuIgual_TETO() {
        INSS inss = new INSS();
        inss.calcular(3000.);
        assertEquals(new Double(330.), inss.getValorDoDesconto());
        assertEquals(new Double(11.), inss.getAliquota());
    }

    @Test
    public void deveCalcularINSS_valorMaiorQue_TETO() {
        INSS inss = new INSS();
        inss.calcular(6000.);
        assertEquals(new Double(642.34), inss.getValorDoDesconto());
        assertEquals(new Double(11.), inss.getAliquota());
    }
}
