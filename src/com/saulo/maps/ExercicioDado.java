package com.saulo.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ExercicioDado {
    public static void main(String[] args) {

        Random random = new Random();
        int quantidadeLancamentos = 100;
        int numeroDado = 1;
        int soma = 0;
        //Número do dado e quantidade
        Map<Integer, Integer> lancamento = new HashMap<>();
        lancamento.put(1, 0);
        lancamento.put(2, 0);
        lancamento.put(3, 0);
        lancamento.put(4, 0);
        lancamento.put(5, 0);
        lancamento.put(6, 0);

        for (int i = 0; i < quantidadeLancamentos; i++) {
            numeroDado = (random.nextInt(6) + 1);
            System.out.println(numeroDado);
            soma = lancamento.get(numeroDado) + 1;

            lancamento.put(numeroDado, soma);
        }

        System.out.println(lancamento);
    }
}
