package com.fksoft.folha.pagamento.application.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FolhaDepagamentoTest {

    @Test
    public void deveCriarFolhaDePagamento() {

        Long id = 1L;
        Funcionario infoFuncionario = new Funcionario("João", "de Deus", "Papa");
        Salario salario = new Salario(5800.);

        FolhaDePagamento folha = new FolhaDePagamento(id, infoFuncionario, salario);

        assertNotNull(folha);
        assertEquals(id, folha.getId());
        assertEquals(infoFuncionario, folha.getInfoFuncionario());
        assertEquals(salario.getSalarioBruto(), folha.getSalario().getSalarioBruto());
        assertEquals(new Double(4111.81), folha.getSalario().getSalarioLiquido());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCriarFolhaDePagamento_idEstaNulo() {
        Long id = null;
        Funcionario infoFuncionario = new Funcionario("João", "de Deus", "Papa");
        Salario salario = new Salario(5000.);

        new FolhaDePagamento(id, infoFuncionario, salario);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCriarFolhaDePagamento_funcionarioEstaNulo() {
        Long id = 1L;
        Funcionario infoFuncionario = null;
        Salario salario = new Salario(5000.);

        new FolhaDePagamento(id, infoFuncionario, salario);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCriarFolhaDePagamento_salarioEstaNulo() {
        Long id = 1L;
        Funcionario infoFuncionario = new Funcionario("João", "de Deus", "Papa");
        Salario salario = null;

        new FolhaDePagamento(id, infoFuncionario, salario);
    }

}
