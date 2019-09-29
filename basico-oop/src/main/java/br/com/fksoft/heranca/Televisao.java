package br.com.fksoft.heranca;

public class Televisao extends Eletrodomestico {

    public String getVoltagem() {
        return getClass().getSimpleName() + " 110 V";
    }

    public void trocarCanal() {
        System.out.println("Canal trocado");
    }

}
