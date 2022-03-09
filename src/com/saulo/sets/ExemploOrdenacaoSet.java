package com.saulo.sets;

/*Dadas as seguintes informações sobre minhas séries favoritas, crie um
conjunto e ordene este conjunto exibindo:
(nome - gênero - tempo de episódio);
Serie 1 = nome: got, gênero: Fantasia, tempoEpisodio: 60
Serie 2 = nome: dark, gênero: Drama, tempoEpisodio: 60
Serie 3 = nome: walking Dead, gênero: Comédia, tempoEpisodio: 45
*/

import java.util.*;

public class ExemploOrdenacaoSet {

    public static void main(String[] args) {

        System.out.println("\n--\tOrdem Aleatória\t---");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("Got", "Fantasia", 60));
            add(new Serie("Dark", "Drama", 60));
            add(new Serie("Walking Dead", "Comédia", 45));
        }};
        for (Serie serie: minhasSeries) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());


        System.out.println("\n--\tOrdem de Inserção\t---");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("Got", "Fantasia", 60));
            add(new Serie("Dark", "Drama", 60));
            add(new Serie("Walking Dead", "Comédia", 45));
        }};
        for (Serie serie: minhasSeries) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("\n--\tOrdem pelo Tempo de episódio\t---");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie : minhasSeries2) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("\n--\tOrdem por nome, gênero e Tempo de episódio\t---");
        Set<Serie> minhasSeries3 = new TreeSet<>(new CompareToNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie : minhasSeries3) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("\n--\tOrdem por gênero\t---");
        Set<Serie> minhasSeries4 = new TreeSet<>(new CompareToGenero());
        minhasSeries4.addAll(minhasSeries);
        for (Serie serie : minhasSeries4) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("\n--\tOrdem por tempo de episódio\t---");
        Set<Serie> minhasSeries5 = new TreeSet<>(new CompareToTempoEpisodio());
        minhasSeries5.addAll(minhasSeries);
        for (Serie serie : minhasSeries5) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

    }

}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public Serie() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "\n{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {

        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());

        if(tempoEpisodio != 0)
            return tempoEpisodio;

        int genero = this.getGenero().compareTo(serie.getGenero());
        return genero;
    }
}

class CompareToNomeGeneroTempoEpisodio implements Comparator<Serie> {


    @Override
    public int compare(Serie s1, Serie s2) {

        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        int tempoEpisodio = Integer.compare(s1.getTempoEpisodio(),s2.getTempoEpisodio());
        return tempoEpisodio;
    }
}

class CompareToGenero implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        return Integer.compare(s1.getTempoEpisodio(),s2.getTempoEpisodio());

    }

}

class CompareToTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {

        int tempoEpisodio = Integer.compare(s1.getTempoEpisodio(),s2.getTempoEpisodio());
        if (tempoEpisodio != 0) return tempoEpisodio;

        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        return s1.getGenero().compareTo(s2.getGenero());

    }

}