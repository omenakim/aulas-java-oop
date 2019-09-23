package com.fksoft.folha.pagamento.application.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SalarioTest {

    @Test
    public void deveCriarSalario() {
        Salario salario = new Salario(5000.);
        assertNotNull(salario);
        assertEquals(new Double(5000.), salario.getSalarioBruto());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCriarSalario_salarioBrutoEstaNulo() {
        new Salario(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCriarSalario_salarioBrutoIgualAZero() {
        new Salario(0.);
    }
}
