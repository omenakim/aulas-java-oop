package br.com.fksoft.heranca;

public class LampadaLed extends Lampada {

    public String getCor() {
        return getClass().getSimpleName() + " azul";
    }

    public String getVoltagem() {
        return getClass().getSimpleName() + " 220 V";
    }


}
