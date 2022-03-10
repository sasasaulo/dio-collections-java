package com.saulo.sets;
/*

Crie um conjunto contendo as cores do arco-íris e:

Exiba todas as cores uma abaixo da outra
A quantidade de cores que o arco-íris tem
Exiba as cores em ordem alfabética
Exiba as cores na ordem inversa da que foi informada
Exiba todas as cores que começam com a letra ”v”
Remova todas as cores que não começam com a letra “v”
Limpe o conjunto
Confira se o conjunto está vazio

*/

import java.util.*;

public class ArcoIris {
    public static void main(String[] args) {
        Set<String> arcoiris = new HashSet<>(Arrays.asList("Vermelho", "Laranja", "Amarela", "Verde", "Azul", "Azul-escuro", "Violeta"));

        System.out.println("\nCrie um conjunto contendo as cores do arco-íris e: ");
        System.out.println(arcoiris);

        System.out.println("\nExiba todas as cores uma abaixo da outra");
        for (String cor : arcoiris) {
            System.out.println(cor);
        }

        System.out.println("\nA quantidade de cores que o arco-íris tem");
        System.out.println(arcoiris.size());

        System.out.println("\nExiba as cores em ordem alfabética");
        Set<String> auxiliar = new TreeSet<>(arcoiris);
        System.out.println(auxiliar);

        System.out.println("\nExiba as cores na ordem inversa da que foi informada");
        auxiliar = arcoiris;
        System.out.println(auxiliar);
        List<String> listaArcoIris = new ArrayList<>(auxiliar);
        Collections.reverse(listaArcoIris);
        System.out.println(listaArcoIris);

        System.out.println("\nExiba todas as cores que começam com a letra ”v”");
        for (String cor : arcoiris) {
            System.out.println(cor);
        }

        System.out.println("\nRemova todas as cores que não começam com a letra “v” - Não funciona com for");
        Iterator<String> iterator = arcoiris.iterator();
        while (iterator.hasNext()) {
            if(!iterator.next().substring(0,1).equals("V")) iterator.remove();
        }
        System.out.println(arcoiris);

        System.out.println("\nLimpe o conjunto e verifique se está vazio");
        arcoiris.clear();
        if (arcoiris.isEmpty()) System.out.println("Vazio agora");
    }
}
