package br.com.fksoft.encapsulamento;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ContaBancariaTest {

    @Test
    public void deveCriarContaBancariaComSaldoZero() {
        ContaBancaria contaDaKim = new ContaBancaria("Kim", TipoDeConta.CONTA_CORENTE);
        assertEquals("Kim", contaDaKim.getCliente());
        assertEquals(new BigDecimal(0), contaDaKim.getSaldo());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveSacarSeSaldoForZero() {
        ContaBancaria contaDaKim = new ContaBancaria("Kim", TipoDeConta.CONTA_CORENTE);
        contaDaKim.sacar(new BigDecimal(50));
    }

    @Test (expected = IllegalStateException.class)
    public void naoDeveSacarSeForPoupancaESaldoMenorQue50() {
        ContaBancaria contaDaKim = new ContaBancaria("Kim", TipoDeConta.CONTA_POUPANCA);
        contaDaKim.sacar(new BigDecimal(49));
    }
}
