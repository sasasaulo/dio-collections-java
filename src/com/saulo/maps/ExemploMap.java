package com.saulo.maps;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        /*
 Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
 modelo = gol - consumo = 14,4km/l
 modelo = uno - consumo = 15,6 km/l
 modelo = mobi - consumo = 16,1 km/l
 modelo = hb20 - consumo = 14,5 km/l
 modelo = kwid - consumo = 15,6 km/l
 */

//        Map carrosPopulares2020 = new HashMap(); //antes do java 5
//        Map<String, Double> carrosPopulares = new HashMap<>(); //Generics(jdk 5) - Diamont Operator(jdk 7)
//        HashMap<String, Double> carrosPopulares = new HashMap<>();
//        Map<String, Double> carrosPopulares2020 = Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1, "hb20", 14.5, "kwid", 15.6)

        System.out.println("\nCrie um dicionário que relacione os modelos e seus respectivos consumos: ");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.1);
            put("uno", 15.6);
            put("mobi", 14.1);
            put("hb20", 14.1);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares);

        Map<String, Double> auxiliar = new TreeMap<>(carrosPopulares);
        
        System.out.println("\nSubstitua o consumo do gol por 15,2 km/l: ");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);
        
        System.out.println("\nConfira se o modelo tucson está no dicionário: ");
        System.out.println(carrosPopulares.containsKey("tucson"));

        System.out.println("\nExiba o consumo do uno: ");
        System.out.println(carrosPopulares.get("uno"));

        System.out.println("\nExiba o terceiro modelo adicionado: ");
        System.out.println("Com HashMap não é possível");

        System.out.println("\nExiba os modelos: ");
        System.out.println(carrosPopulares.keySet());

        System.out.println("\nExiba os consumos dos carros: ");
        System.out.println(carrosPopulares.values());

        System.out.println("\nExiba o modelo mais econômico e seu consumo: ");
        Double consumo = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modelo = null;

        for (Map.Entry<String, Double> entry : entries){
            if (entry.getValue().equals(consumo)) {
                modelo = entry.getKey();
                System.out.println("Modelo Mais eficiente: " + modelo + " - Consumo: " + consumo);
            }
        }

        System.out.println("\nExiba o modelo menos econômico e seu consumo: ");
        consumo = Collections.min(carrosPopulares.values());
        for (Map.Entry<String, Double> entry : entries){
            if (entry.getValue().equals(consumo)) {
                modelo = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modelo + " - Consumo: " + consumo);
            }
        }


        System.out.println("\nExiba a soma dos consumos: ");
        Double soma = 0.0;
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println("\nExiba a média dos consumos deste dicionário de carros: ");
        System.out.printf("%.2f", soma/carrosPopulares.size());

        System.out.println("\n\nRemova os modelos com o consumo igual a 15,6 km/l: ");
        System.out.println(carrosPopulares);
        iterator = carrosPopulares.values().iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 15.6) iterator.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("\nExiba todos os carros na ordem em que foram informados: ");
        System.out.println("Não é possível com HashMap. Apenas transformar para LinkedHashMap");
        
        System.out.println("\nExiba o dicionário ordenado pelo modelo: ");
        System.out.println(auxiliar);
        
        System.out.println("\nApague o dicionario de carros: ");
        carrosPopulares.clear();
        
        System.out.println("\nConfira se o dicionário está vazio: ");
        System.out.println(carrosPopulares.isEmpty());

    }
}
