package com.fksoft.folha.pagamento.application.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FuncionarioTest {

    @Test
    public void deveCriarFuncionario() {
        Funcionario funcionario = new Funcionario("Joao", "De Deus", "Papa");
        assertNotNull(funcionario);
        assertEquals("Joao", funcionario.getNome());
        assertEquals("De Deus", funcionario.getSobrenome());
        assertEquals("Papa", funcionario.getCargo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCriarFuncionario_nomeEstaNulo() {
        new Funcionario(null, "de Deus", "Papa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCriarFuncionario_nomeEstaVazio() {
        new Funcionario("", "de Deus", "Papa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCriarFuncionario_sobrenomeEstaNulo() {
        new Funcionario("Joao", null, "Papa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCriarFuncionario_sobrenomeEstaVazio() {
        new Funcionario("Joao", " ", "Papa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCriarFuncionario_cargoEstaNulo() {
        new Funcionario("Joao", "De Deus", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCriarFuncionario_cargoEstaVazio() {
        new Funcionario("Joao", "De Deus", "");
    }

}
