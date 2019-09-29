package br.com.fksoft.heranca;

public class Microondas extends Eletrodomestico {

    public String getVoltagem() {
        return getClass().getSimpleName() + " 220 V";
    }

    public void assar() {
        System.out.println("Estou assando um delicioso prato de comida");
    }
}
