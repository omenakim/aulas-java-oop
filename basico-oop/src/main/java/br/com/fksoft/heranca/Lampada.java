package br.com.fksoft.heranca;

public abstract class Lampada implements Eletronico {

    private Boolean aceso;

    public Lampada () {
        this.apagar();
    }

    public void acender() {
        this.aceso = true;
        System.out.println(getClass().getSimpleName() + " Acendeu");
    }

    public void apagar() {
        this.aceso = false;
        System.out.println(getClass().getSimpleName() + " Apagou");
    }

    public abstract String getCor();

}
