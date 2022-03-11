package com.saulo.maps;

/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265
 */

import java.sql.SQLOutput;
import java.util.*;

public class ExercicioEstado {
    public static void main(String[] args) {
        Map<String, Integer> estados = new HashMap<>();
        estados.put("PE", 9616621);
        estados.put("AL", 3351543);
        estados.put("CE", 9187103);
        estados.put("RN", 3534265);

        System.out.println("\nCrie um dicionário e relacione os estado com as populações");
        System.out.println(estados);

        System.out.println("\nSubstitua a população do RN por 3534165");
        estados.put("RN", 3534165);
        System.out.println(estados);

        System.out.println("\nConfira se o estado PB está no dicionário, caso não, adicione: PB - 4039277");
        if (!estados.containsKey("PB")) estados.put("PB", 4039277);
        System.out.println(estados);

        System.out.println("\nExiba a população de PE");
        System.out.println(estados.get("PE"));

        System.out.println("\nExiba os estados e suas populações na ordem em que foram informados");
        Map<String, Integer> estadosOrdenados = new LinkedHashMap<>();
        estadosOrdenados.put("PE", 9616621);
        estadosOrdenados.put("AL", 3351543);
        estadosOrdenados.put("CE", 9187103);
        estadosOrdenados.put("RN", 3534265);

        System.out.println(estadosOrdenados);

        System.out.println("\nExiba os estados e suas populações em ordem alfabética");
        Map<String, Integer> estadosOrdenadosAlfabeticamente = new TreeMap<>(estadosOrdenados);
        System.out.println(estadosOrdenadosAlfabeticamente);

        System.out.println("\nExiba o estado com a menor população e sua quantidade");
        Collection<Integer> populacao = estados.values();
        String estadoMaisPopuloso = "";
        String estadoMenosPopuloso = "";
        int soma = 0;

        for (Map.Entry<String, Integer> entry : estados.entrySet()) {
            if (entry.getValue().equals(Collections.max(populacao))) estadoMaisPopuloso = entry.getKey();
            if (entry.getValue().equals(Collections.min(populacao))) estadoMenosPopuloso = entry.getKey();
            soma += entry.getValue();
        }

        System.out.println(estadoMenosPopuloso + " = " + estados.get(estadoMenosPopuloso));

        System.out.println("\nExiba o estado com a maior população e sua quantidade");
        System.out.println(estadoMaisPopuloso + " - " + estados.get(estadoMaisPopuloso));

        System.out.println("\nExiba a soma das populações");
        System.out.println(soma);

        System.out.println("\nExiba a media das populações");
        System.out.println(soma/estados.size());

        System.out.println("\nRemova os estados com a população menor que 4000000");
        Iterator<Integer> iterator = estados.values().iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 4000000) iterator.remove();
        }
        System.out.println(estados);

        System.out.println("\nApague o dicionário e verifique se está vazio");
        estados.clear();
        System.out.println(estados.isEmpty());

    }
}
