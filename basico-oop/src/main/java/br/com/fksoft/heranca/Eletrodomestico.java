package br.com.fksoft.heranca;

public abstract class Eletrodomestico implements Eletronico {

    private Boolean ligado;

    public Eletrodomestico () {
        this.desligar();
    }

    public void ligar() {
        this.ligado = true;
        System.out.println(getClass().getSimpleName() + " Ligou");
    }

    public void desligar() {
        this.ligado = false;
        System.out.println(getClass().getSimpleName() + " Desligou");
    }

}
