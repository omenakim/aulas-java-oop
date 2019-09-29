package br.com.fksoft.heranca;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        Eletrodomestico televisao = new Televisao();
        Lampada lampada = new LampadaLed();

        televisao.ligar();
        System.out.println(lampada.getCor());;

    }

    public static void testeDeAbstracao() {
        List<Eletronico> listaDeEletronico = new ArrayList<Eletronico>();

        Eletronico mihaTV = new Televisao();
        Eletronico meuMicroondas = new Microondas();
        Eletronico minhaLampadaFluorecente = new LampadaFluorescente();
        Eletronico minhaLampadaLed = new LampadaLed();

        listaDeEletronico.add(mihaTV);
        listaDeEletronico.add(meuMicroondas);
        listaDeEletronico.add(minhaLampadaFluorecente);
        listaDeEletronico.add(minhaLampadaLed);

        for (Eletronico eletronico : listaDeEletronico) {
            System.out.println(eletronico.getVoltagem());
            ;
        }
    }

    public static void testeDeConcretizacao() {
        Microondas microondas = new Microondas();
        Televisao televisao = new Televisao();

        televisao.ligar();
        microondas.ligar();

        televisao.trocarCanal();
        microondas.assar();
    }
}
