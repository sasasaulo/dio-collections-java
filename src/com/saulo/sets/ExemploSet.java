package com.saulo.sets;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        //Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

        //Set notas = new HashSet(); //Antes do java 5
        //HashSet<Double> notas = new HashSet<>();
        //Set<Double> notas = new HashSet<>(); //Generics(jdk5) - Diamont Operator (jdk 7)
        /*Set<Double> notas = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        notas.add(1d);
        notas.remove(5d);
        System.out.println(notas);*/

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);

        //System.out.println("Exiba a posição da nota 5.0: ");
        System.out.println("não existe o método get para isso.\n");

        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
        System.out.println("não existe o método add ou set para isso.\n");

        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        System.out.println("Também não é possível fazer isso.\n");

        System.out.println("Confira se a nota 5.0 está no conjunto: ");
        System.out.println(notas.contains(5.0));

        System.out.println("Exiba a terceira nota adicionada:");
        System.out.println("Não é possível pois não possui método get.\n");

        System.out.println("Exiba a menor nota:");
        Collections.min(notas);

        System.out.println("Exiba a maior nota:");
        Collections.max(notas);

        System.out.println("Exiba a soma dos valores:");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.printf("%.2f", soma);

        System.out.println("Exiba a média das notas:");
        System.out.println("\n\n" + soma/notas.size());

        System.out.println("Remova a nota 0: ");
        notas.remove(0.0);
        System.out.println(notas);

        System.out.println("Remova a nota da posição 0: ");
        System.out.println("Não é possível pegar a posição");

        System.out.println("Remova as notas menores do que 7 e exiba a lista.");
        iterator = notas.iterator();
        Double nota = 0.0;
        while (iterator.hasNext()) {
            nota = iterator.next();
            if (nota < 7) {
                iterator.remove();
            }
        }
        System.out.println(notas);

        System.out.println("\nExiba todas as notas na ordem em que foram informadas");
        System.out.println("Não é possível fazer com HashSet mas sim com LinkedHashSet");
        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas2 + "     -> ele não aceita valores repetidos.");

        System.out.println("Imprima todas as notas na ordem crescente");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto e confira se está vazio:");
        notas.clear();

        if (notas.isEmpty()) System.out.println("primeiro notas.clear() e com isso ficou vazio.");

    }
}
