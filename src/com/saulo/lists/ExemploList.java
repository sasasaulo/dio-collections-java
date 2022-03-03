package com.saulo.lists;

import java.util.*;

public class ExemploList {

    public static void main(String[] args) {
        //Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

        //List notas = new ArrayList(); //Essa forma era feita antes do java 5
        //List<Double> notas = new ArrayList<>(); //Generics (jdk5 ou superior) - jdk - diamond operator (não precisa repetir o tipo)
        //ArrayList<Double> notas = new ArrayList<>(); //não é recomendado pois devemos programar de acordo com a interface e não com a implementação
        //List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        //List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); // Dessa forma não é possível adicionar ou retirar elementos - Outros métodos são permitidos
        //List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); //mesma situação de cima (não é possível adicionar ou remover) - Outros métodos são permitidos

        System.out.println("Crie uma lista e adicione as sete notas:");
        List<Double> notas = new ArrayList<>();
        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);
        System.out.println(notas);
        System.out.println(notas.toString());

        System.out.println("\nExiba a posição da nota 5.0");
        System.out.println(notas.indexOf(5.0));

        System.out.println("\nAdicione na lista a nota 8.0 na posição 4");
        notas.add(4, 8.0);
        System.out.println(notas);

        System.out.println("\nSubstitua a nota 5.0 pela nota 6.0");
        notas.set(notas.indexOf(5.0), 6.0);
        System.out.println(notas);

        System.out.println("\nConfira se a nota 5 está na lista.");
        System.out.println(notas.contains(5.0));

        System.out.println("\nExiba todas as notas na ordem em que foram informadas");
        System.out.println(notas);
        for (Double nota : notas) System.out.print(nota + ", ");

        System.out.println("\nExiba a terceira nota adicionada");
        System.out.println(notas.get(2));

        System.out.println("\nExiba a menor nota");
        System.out.println(Collections.min(notas));

        System.out.println("\nExiba a maior nota");
        System.out.println(Collections.max(notas));

        System.out.println("\nExiba a soma dos valores:");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println(soma);

        System.out.println("\nExiba a média das notas:");
        System.out.println(soma / notas.size());

        System.out.println("\nRemova a nota 0:");
        notas.remove(0.0); //caso o obj for do tipo inteiro, colocar o "d" na frente do número (assim difere do index)
        System.out.println(notas);

        System.out.println("\nRemova a nota da posição 0:");
        notas.remove(0);
        System.out.println(notas);

        System.out.println("\nRemova as notas menores do que 7:");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("\nApague toda a lista:");
        notas.clear();
        if (notas.isEmpty())
            System.out.println("Está vazia");
        else
            System.out.println("Está limpa");

        //Resolva esses exercícios utilizando os métodos da implementação LinkedList:

        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);

        System.out.println("\nCrie uma lista notas2 e coloque todos os elementos da Arraylist nessa nova lista");
        List<Double> notas2 = new LinkedList<>();
        notas2 = notas;
        System.out.println(notas2);

        System.out.println("\nMostre a primeira nota de notas2 sem removê-la");
        System.out.println(notas2.get(0));

        System.out.println("\nMostre a primeira nota de notas2  removendo-a");
        System.out.println(notas2.remove(0));
        System.out.println(notas2);


    }



}
