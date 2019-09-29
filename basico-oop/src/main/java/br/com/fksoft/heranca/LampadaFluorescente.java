package br.com.fksoft.heranca;

public class LampadaFluorescente extends Lampada {

    public String getCor() {
        return getClass().getSimpleName() +  " branca";
    }

    public String getVoltagem() {
        return getClass().getSimpleName() + " 110 V";
    }

}
