package com.saulo.lists;

import java.util.*;

/*
* Faça um programa que receba a temperatura média dos 6 primeiros
* meses do ano e as armazene em uma lista.
* Então, calcule a média semestral das temperaturas e mostre todas
* as temperaturas acima desta média e em que mês elas ocorreram (mostrar o mês
* por extenso: 1 - Janeiro, 2 - Fevereiro...)
* */

public class TemperaturaMedia {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> meses = new ArrayList<>();
        meses.add("Janeiro");
        meses.add("Fevereiro");
        meses.add("Março");
        meses.add("Abril");
        meses.add("Maio");
        meses.add("Junho");

        int i = 1;
        List<Integer> temperaturas = new ArrayList<>();

        System.out.println("Digite as temperaturas: ");

        while (i <= 6) {
            System.out.println(meses.get(i - 1) + ": ");
            temperaturas.add(scan.nextInt());
            i++;
        }

        Iterator<Integer> iterator = temperaturas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            soma += next;
        }
        Double media = soma / temperaturas.size();
        System.out.printf("Temperatura média: %.2f", media);

        iterator = temperaturas.iterator();
        i = 0;

        System.out.println("\n\nTemperaturas maiores que a média: ");
        boolean temperaturasIguais = true;

        while(iterator.hasNext()) {
            Integer next = iterator.next();
            if(next > media) {
                System.out.println((i + 1) + " - " + meses.get(i) + " - " + next);
                temperaturasIguais = false;
            }
            i++;
        }

        if(temperaturasIguais) {
            System.out.println("Os meses tiveram a mesma temperatura: " + media);
        }
    }

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        List<Double> temperaturas = new ArrayList<Double>();
//
//        //Adicionando as temperaturas na lista:
//        int count = 0;
//        while (true) {
//            if (count == 6) break;
//
//            System.out.print("Digite a temperatura: ");
//            double temp = scan.nextDouble();
//            temperaturas.add(temp);
//            count++;
//        }
//        System.out.println("-----------------");
//
//        //exibindo todas as temperaturas:
//        System.out.print("Todas as temperaturas: ");
//        temperaturas.forEach(t -> System.out.print(t + " "));
//
//        //calculando e exibindo a média das temperaturas:
//        double media = temperaturas.stream()
//                .mapToDouble(Double::doubleValue)
//                .average()
//                .orElse(0d);
//        System.out.printf("\nMédia das temperaturas: %.1f\n", media);
//
//        //exibindo as temperaturas acima da média
//        System.out.print("Temperaturas acima da média: ");
//        temperaturas.stream()
//                .filter(t -> t > media)
//                .forEach(t -> System.out.printf("%.1f ", t));
//
//        //exibindo o mês das temperaturas acima da média por extenso:
//        System.out.println("\n\nMeses das temperaturas acima da média: ");
//        Iterator<Double> iterator = temperaturas.iterator();
//
//        count = 0;
//        while (iterator.hasNext()) {
//            Double temp = iterator.next();
//            if (temp > media) {
//                switch (count) {
//                    case (0):
//                        System.out.printf("1 - janeiro: %.1f\n ", temp);
//                        break;
//                    case (1):
//                        System.out.printf("2 - fevereiro: %.1f\n", temp);
//                        break;
//                    case (2):
//                        System.out.printf("3 - março: %.1f\n", temp);
//                        break;
//                    case (3):
//                        System.out.printf("4 - abril: %.1f\n", temp);
//                        break;
//                    case (4):
//                        System.out.printf("5 - maio: %.1f\n", temp);
//                        break;
//                    case (5):
//                        System.out.printf("6 - junho: %.1f\n", temp);
//                        break;
//                    default:
//                        System.out.println("Não houve temperatura acima da média.");
//                }
//            }
//            count++;
//        }
//    }
}
