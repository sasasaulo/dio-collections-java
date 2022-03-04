package com.saulo.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
* Faça um programa que receba a temperatura média dos 6 primeiros
* meses do ano e as armazene em uma lista.
* Então, calcule a média semestral das temperaturas e mostre todas
* as temperaturas acima desta média e em que mês elas ocorreram (mostrar o mês
* por extenso: 1 - Janeiro, 2 - Fevereiro...)
* */

public class TemperaturaMedia {
    public static void main(String[] args) {
        List<Integer> temperaturas = new ArrayList<>();
        temperaturas.add(20);
        temperaturas.add(25);
        temperaturas.add(18);
        temperaturas.add(10);
        temperaturas.add(05);
        temperaturas.add(35);

        Iterator<Integer> iterator = temperaturas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            soma += next;
        }
        Double media = soma / temperaturas.size();
        System.out.printf("Temperatura média: %.2f", media);




    }
}
