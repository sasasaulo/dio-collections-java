package com.saulo.sets;

/*
* Crie uma classe LinguagemFavorita que possua os atributos
nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
3 linguagens e faça um programa que ordene esse conjunto
por:

Ordem de Inserção
Ordem Natural (nome)
IDE
Ano de criação e nome
Nome, ano de criacao e IDE

Ao final, exiba as linguagens no console, um abaixo da outra.
* */


import java.util.*;

public class LinguagemFavoritaExercicio {
    public static void main(String[] args) {
        Set<LinguagemFavorita> linguagens = new HashSet<>();
        linguagens.add(new LinguagemFavorita("Java", 1991, "Eclipse"));
        linguagens.add(new LinguagemFavorita("PHP", 1994, "Eclipse"));
        linguagens.add(new LinguagemFavorita("Javascript", 1995, "VSCode"));

        System.out.println("Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e ide.\n" +
                "Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:\n");

        System.out.println("\n1 - Ordem de Inserção");
        Set<LinguagemFavorita> auxiliar = new LinkedHashSet<>();
        auxiliar.add(new LinguagemFavorita("Java", 1991, "Eclipse"));
        auxiliar.add(new LinguagemFavorita("PHP", 1994, "Eclipse"));
        auxiliar.add(new LinguagemFavorita("Javascript", 1995, "VSCode"));
        System.out.println(auxiliar);

        System.out.println("\n2 - Ordem Natural (nome)");
        auxiliar = new TreeSet<>(linguagens);
        System.out.println(auxiliar);

        System.out.println("\n3 -IDE");
        auxiliar = new TreeSet<>(new CompareToIde());
        auxiliar.addAll(linguagens);
        System.out.println(auxiliar);

        System.out.println("\n4 -Ano de criação e nome");
        auxiliar = new TreeSet<>(new CompareToAnoNome());
        auxiliar.addAll(linguagens);
        System.out.println(auxiliar);

        System.out.println("\n5 -Nome, Ano de criação e ide");
        auxiliar = new TreeSet<>(new CompareToNomeAnoIde());
        auxiliar.addAll(linguagens);
        System.out.println(auxiliar);

    }

}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{

    private String nome;
    private Integer anoCriacao;
    private String ide;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(Integer anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }


    @Override
    public int compareTo(LinguagemFavorita linguagem) {
        int nome = this.getNome().compareTo(linguagem.getNome());

        return nome;
    }

    public LinguagemFavorita(String nome, Integer anoCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.ide = ide;
    }

    @Override
    public String toString() {
        return "\n{" +
                "nome='" + nome + '\'' +
                ", anoCriacao=" + anoCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }
}

class CompareToIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {

        int ide = l1.getIde().compareTo(l2.getIde());
        if (ide != 0) return ide;

        int nome = l1.getNome().compareTo(l2.getNome());
        if (nome != 0) return nome;

        return Integer.compare(l1.getAnoCriacao(),l2.getAnoCriacao());
    }
}

class CompareToAnoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {

        int ano = Integer.compare(l1.getAnoCriacao(),l2.getAnoCriacao());
        if (ano != 0) return ano;

        int nome = l1.getNome().compareTo(l2.getNome());
        if (nome != 0) return nome;

        return l1.getIde().compareTo(l2.getIde());
    }
}

class CompareToNomeAnoIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {

        int nome = l1.getNome().compareTo(l2.getNome());
        if (nome != 0) return nome;

        int ano = Integer.compare(l1.getAnoCriacao(),l2.getAnoCriacao());
        if (ano != 0) return ano;

        return l1.getIde().compareTo(l2.getIde());
    }
}