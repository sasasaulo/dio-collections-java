package com.saulo.lists;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Detetive {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> respostasNegativas = new ArrayList<>();
        List<String> respostasPositivas = new ArrayList<>();
        List<String> perguntas = new ArrayList<>();
        List<Boolean> respostas = new ArrayList<>();
        int countRespostasPositivas = 0;


        respostasNegativas.add("não");
        respostasNegativas.add("n");
        respostasNegativas.add("no");
        respostasNegativas.add("0");

        respostasPositivas.add("sim");
        respostasPositivas.add("s");
        respostasPositivas.add("yes");
        respostasPositivas.add("1");
        respostasPositivas.add("y");

        perguntas.add("Telefonou para a vítima?");
        perguntas.add("Esteve no local do crime?");
        perguntas.add("Mora perto da vítima?");
        perguntas.add("Devia para a vítima?");
        perguntas.add("Já trabalhou com a vítima?");

        Iterator<String> iterator = perguntas.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if(respostasNegativas.contains(scan.nextLine().toLowerCase()))
                respostas.add(false);
            else {
                respostas.add(true);
                countRespostasPositivas++;
            }
        }

        System.out.println("\n\nVocê é: ");

        if(countRespostasPositivas == 5) {
            System.out.println("Assassino");
        } else if (countRespostasPositivas == 3 || countRespostasPositivas == 4) {
            System.out.println("Cúmplice");
        } else if (countRespostasPositivas == 2) {
            System.out.println("Suspeito");
        } else {
            System.out.println("Inocente");
        }
    }
}


/*
* public static void main(String[] args) {
        List<String> respostas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Perguntas: ");
        System.out.print("\nTelefonou para vítima? ");
        String resposta = scanner.next();
        respostas.add(resposta.toLowerCase());
        System.out.print("Esteve no local do crime? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());
        System.out.print("Mora perto da vítima? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());
        System.out.print("Devia para vítima? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());
        System.out.print("Já trabalhou com a vítima? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());

        System.out.println(respostas);

        int count = 0;
        Iterator<String> contador = respostas.iterator();
        while(contador.hasNext()){
            String resp = contador.next();
            if(resp.contains("s")) {
                count ++;
            }
        }

        switch(count) {
            case 2:
                System.out.println(">> SUSPEITA <<"); break;
            case 3:
            case 4:
                System.out.println(">> CÚMPLICE <<"); break;
            case 5:
                System.out.println(">> ASSASSINO <<"); break;
            default:
                System.out.println(">> INOCENTE <<"); break;
        }
    }
* */