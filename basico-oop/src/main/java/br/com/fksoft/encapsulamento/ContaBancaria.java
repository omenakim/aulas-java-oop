package br.com.fksoft.encapsulamento;

import java.math.BigDecimal;

public class ContaBancaria {

    private String cliente;
    private BigDecimal saldo;
    private TipoDeConta tipo;

    public ContaBancaria(String cliente, TipoDeConta tipo) {
        this.cliente = cliente;
        this.saldo = new BigDecimal(0);
        this.tipo = tipo;
    }

    public void sacar(BigDecimal valor) {
        if (this.tipo.equals(TipoDeConta.CONTA_POUPANCA)) {
            if (this.saldo.compareTo(new BigDecimal(50)) <= 0)
                throw new IllegalStateException("Não pode sacar se conta poupança tiver saldo menor ou igual a 50");
        }
        if (this.saldo.compareTo(new BigDecimal(0)) <= 0)
            throw new IllegalStateException("Saldo insuficiente");
        this.saldo = this.saldo.subtract(valor);
    }

    public void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    public String getCliente() {
        return cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
