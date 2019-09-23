package com.fksoft.folha.pagamento.application.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlanoDeSaudeTest {

   @Test
    public void deveCalcularPlanoDeSaude_valorMenorOuIgualA_1000() {
       PlanoDeSaude planoDeSaude = new PlanoDeSaude();
       planoDeSaude.calcular(900.);
       assertEquals(new Double(80.), planoDeSaude.getValorDoDesconto());

   }

   @Test
   public void deveCalcularPlanoDeSaude_valorMaiorOuIgualA_1001_e_valorMenorOuIgualA_3000() {
       PlanoDeSaude planoDeSaude = new PlanoDeSaude();
       planoDeSaude.calcular(2000.);
       assertEquals(new Double(250.), planoDeSaude.getValorDoDesconto());

   }

    @Test
    public void deveCalcularPlanoDeSaude_valorMaiorOuIgualA_3001() {
        PlanoDeSaude planoDeSaude = new PlanoDeSaude();
        planoDeSaude.calcular(4000.);
        assertEquals(new Double(500.), planoDeSaude.getValorDoDesconto());

    }

}
